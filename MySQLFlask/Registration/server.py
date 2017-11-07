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
    if not 'validate' in session:
        session['validate'] = 0
    return render_template('index.html')




@app.route('/registration', methods=['POST'])
def register():
    
    if len(request.form['first_name']) < 2:
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
        password = request.form['password']
        salt =  binascii.b2a_hex(os.urandom(15))
        hashed_pw = md5.new(password + salt).hexdigest()
        query = "INSERT INTO users(email, first_name, last_name, salt, password, created_at, updated_at) VALUES (:email, :first_name, :last_name, :salt, :password, NOW(), NOW())"
        data = {
                'email': request.form['email'],
                'first_name': request.form['first_name'],
                'last_name': request.form['first_name'],
                'salt' : salt,
                'password': hashed_pw
               }
        mysql.query_db(query, data)

        session['validate'] = 1 #fix this to be user-specific later?
        
        return redirect('/success')
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
            return redirect('/success')
        else:
            flash("YOUR PASSWORD IS WRONG.")
            return redirect('/')
    else:
        flash("YOUR EMAIL IS WRONG.")
    return redirect('/')



@app.route('/success')
def success():
    if session['validate'] == 1:
        return render_template('success.html')
    
    return redirect('/')


app.run(debug=True)
