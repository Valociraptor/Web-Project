from flask import Flask, request, redirect, render_template, session, flash
from mysqlconnection import MySQLConnector
import md5
import os, binascii
import datetime
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
salt = binascii.b2a_hex(os.urandom(15))

app = Flask(__name__)
app.secret_key = 'KeepItSecretKeepItSafe'
mysql = MySQLConnector(app,'registration')


@app.route('/')
def index():
    if not 'userid' in session:
        session['userid'] = 0
    return render_template('index.html')




@app.route('/registration', methods=['POST'])
def register():
    
    if len(request.form['first_name']) < 2:                         #Validation
        flash("First Name must be AT LEAST 2 characters")
    elif len(request.form['last_name']) < 2:
        flash("Last Name must be AT LEAST 2 characters")
    elif len(request.form['email']) < 1:
        flash("Email cannot be blank!")
    elif not EMAIL_REGEX.match(request.form['email']):
        flash("Invalid Email Address!")
    elif len(request.form['password']) < 8:
        flash("Passwords gotta be at least 8 characters, you know the drill")
    elif request.form['password'] != request.form['cpassword']:
        flash("Passwords gotta match, this is why we can't have nice things.")
    else:
        password = request.form['password']                                                 #inserting validated info into DB
        salt =  binascii.b2a_hex(os.urandom(15))
        hashed_pw = md5.new(password + salt).hexdigest()
        query = "INSERT INTO users(email, first_name, last_name, salt, password, created_at, updated_at) VALUES (:email, :first_name, :last_name, :salt, :password, NOW(), NOW())"
        data = {
                'email': request.form['email'],
                'first_name': request.form['first_name'],
                'last_name': request.form['last_name'],
                'salt' : salt,
                'password': hashed_pw
               }       
        mysql.query_db(query, data)


        email = request.form['email']                           #storing the users.id as a session variable
        user_query = "SELECT * FROM users WHERE users.email = :email LIMIT 1"
        query_data = {'email': email}
        user = mysql.query_db(user_query, query_data)
        session['userid'] = user[0]['id']
        
        return redirect('/wall')
    return redirect('/')


@app.route('/login', methods=['POST'])
def login():
    
    email = request.form['lemail']        
    password = request.form['lpassword']
    user_query = "SELECT * FROM users WHERE users.email = :email LIMIT 1"
    query_data = {'email': email}
    user = mysql.query_db(user_query, query_data)
    if len(user) != 0:
        encrypted_password = md5.new(password + user[0]['salt']).hexdigest()
        if user[0]['password'] == encrypted_password:
            session['userid'] = user[0]['id']
            print user
            print session['userid']
            return redirect('/wall')
        else:
            flash("YOUR PASSWORD IS WRONG.")
            return redirect('/')
    else:
        flash("YOUR EMAIL IS WRONG.")
    return redirect('/')



@app.route('/wall')
def success():
    if session['userid'] != 0:
        query = "SELECT messages.id, messages.message, DATE_FORMAT(messages.created_at, '%M %d %Y, %H:%i') AS 'date', CONCAT(users.first_name, ' ', users.last_name) AS 'name' FROM messages JOIN users ON messages.user_id = users.id"
        messages = mysql.query_db(query)  #displaying messages on the page
        query2 = "SELECT comments.id, comments.message_id, comments.comment, CONCAT(users.first_name, ' ', users.last_name) AS commenter, comments.created_at FROM comments JOIN users ON comments.user_id = users.id"
        comments = mysql.query_db(query2) #displaying comments on the messages
        print comments
        return render_template('wall.html', userid=session['userid'], messages=messages, comments=comments)
    return redirect('/')






@app.route('/post', methods=['POST']) #inserting messages
def post():
    query = "INSERT INTO messages(user_id, message, created_at, updated_at) VALUES (:user_id, :message, NOW(), NOW())"
    data = {
            'user_id': session['userid'],
            'message': request.form['message']
            }
    mysql.query_db(query, data)

    return redirect('/wall')


@app.route('/comment', methods=['POST']) #inserting comments
def comment():
    query = "INSERT INTO comments(user_id, message_id, comment, created_at, updated_at) VALUES (:user_id, :message_id, :comment, NOW(), NOW())"
    data = {
            'user_id': session['userid'],
            'message_id': request.form['messageid'],
            'comment': request.form['comment']
            }
    mysql.query_db(query, data)

    return redirect('/wall')
app.run(debug=True)
