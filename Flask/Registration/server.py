from flask import Flask, render_template, request, redirect, session, flash
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

app = Flask(__name__)
app.secret_key = "This is so secret"


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/user', methods=['POST'])
def create_user():

    if len(request.form['fname']) < 1:  #----------------------fname
        flash("First Name cannot be empty!")
    elif str.isalpha(str(request.form['fname'])) == False:
        flash("First Name cannot have numbers wtf is wrong with you?")
 

    elif len(request.form['lname']) < 1: #--------------------------lname
        flash("Last Name cannot be empty!")
    elif str.isalpha(str(request.form['lname'])) == False:
        flash("Last Name cannot have numbers wtf is wrong with you?")

    
    elif len(request.form['password']) > 8: #-------------password/cpassword
        flash("Password cannot be longer 8 characters")
    elif request.form['password'] != request.form['cpassword']:
        flash("Password and Confirm password must match.  Get your shit together!")

    elif not EMAIL_REGEX.match(request.form['email']): #-----------------email
        flash("Invalid Email Address!")
    elif len(request.form['email']) < 1:
        flash("Email cannot be blank!")
    else:
        flash("SUCCESS!")



    return redirect('/')

    
 



app.run(debug=True)
