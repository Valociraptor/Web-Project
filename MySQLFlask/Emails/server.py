from flask import Flask, request, redirect, render_template, session, flash
from mysqlconnection import MySQLConnector
import md5
import os, binascii # include this at the top of your file
import datetime
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
salt = binascii.b2a_hex(os.urandom(15))

app = Flask(__name__)
app.secret_key = 'KeepItSecretKeepItSafe'
mysql = MySQLConnector(app,'emails')

@app.route('/')
def index():

    return render_template('index.html')

@app.route('/addemail', methods=['POST'])
def create():
    if len(request.form['email']) < 1:
        flash("Email cannot be blank!")
    elif not EMAIL_REGEX.match(request.form['email']):
        flash("Invalid Email Address!")
    else: 
        query = "INSERT INTO emails (email, created_at, updated_at) VALUES( :email, NOW(), NOW())"
        data = {
                'email': request.form["email"],
                }
        mysql.query_db(query, data)
        return redirect('/success')
        
    return redirect('/')
@app.route('/success')
def success():
    emails = mysql.query_db("SELECT * FROM emails")
    
    return render_template('success.html', all_emails=emails)

# @app.route('/friends', methods=['POST'])
# def create():
#     print request.form['first_name']
#     print request.form['last_name']
#     print request.form['occupation']
#     query = "INSERT INTO friends (first_name, last_name, occupation, created_at, updated_at) VALUES (:first_name, :last_name, :occupation, NOW(), NOW())"
#     # We'll then create a dictionary of data from the POST data received.
#     data = {
#              'first_name': request.form['first_name'],
#              'last_name':  request.form['last_name'],
#              'occupation': request.form['occupation']
#            }
#     # Run query, with dictionary values injected into the query.
#     mysql.query_db(query, data)
#     return redirect('/')

# @app.route('/friends/<friend_id>')
# def show(friend_id):
#     # Write query to select specific user by id. At every point where
#     # we want to insert data, we write ":" and variable name.
#     query = "SELECT * FROM friends WHERE id = :specific_id"
#     # Then define a dictionary with key that matches :variable_name in query.
#     data = {'specific_id': friend_id}
#     # Run query with inserted data.
#     friends = mysql.query_db(query, data)
#     # Friends should be a list with a single object,
#     # so we pass the value at [0] to our template under alias one_friend.
#     return render_template('index.html', one_friend=friends[0])


# @app.route('/update_friend/<friend_id>', methods=['POST'])
# def update(friend_id):
#     query = "UPDATE friends SET first_name = :first_name, last_name = :last_name, occupation = :occupation WHERE id = :id"
#     data = {
#              'first_name': request.form['first_name'],
#              'last_name':  request.form['last_name'],
#              'occupation': request.form['occupation'],
#              'id': friend_id
#            }
#     mysql.query_db(query, data)
#     return redirect('/')

# @app.route('/remove_friend/<friend_id>', methods=['POST'])
# def delete(friend_id):
#     query = "DELETE FROM friends WHERE id = :id"
#     data = {'id': friend_id}
#     mysql.query_db(query, data)
#     return redirect('/')

app.run(debug=True)


# username = request.form['username']             #for hashing passwords with salt
# email = request.form['email']
# password = request.form['password']
# salt =  binascii.b2a_hex(os.urandom(15))
# hashed_pw = md5.new(password + salt).hexdigest()
# insert_query = "INSERT INTO users (username, email, password, salt, created_at, updated_at)
#      VALUES (:username, :email, :hashed_pw, :salt, NOW(), NOW())"
# query_data = { 'username': username, 'email': email, 'hashed_pw': hashed_pw, 'salt': salt}
# mysql.query_db(insert_query, query_data)


# email = request.form['email']        For authenticating passwords hashed with salt
# password = request.form['password']
# user_query = "SELECT * FROM users WHERE users.email = :email LIMIT 1"
# query_data = {'email': email}
# user = mysql.query_db(user_query, query_data)
# if len(user) != 0:
#  encrypted_password = md5.new(password + user[0]['salt']).hexdigest()
#  if user[0]['password'] == encrypted_password:
#   # this means we have a successful login!
#  else:
#      # invalid password!
# else:
#   # invalid email!