from flask import Flask, render_template, redirect, request, session, flash
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
app = Flask(__name__)
app.secret_key = 'KeepItSecretKeepItSafe'

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/process', methods=['Post'])
def process():
    if len(request.form['name']) < 1:
        flash("Name cannot be empty!")
    elif str.isalpha(str(request.form['name'])) == False:
        flash("Name cannot have numbers wtf is wrong with you?")
    else:
        flash("Success! Your name is {}".format(request.form['name'])) 
    if len(request.form['email']) < 1:
        flash("Email cannot be blank!")
    elif not EMAIL_REGEX.match(request.form['email']):
        flash("Invalid Email Address!")
    # else if email doesn't match regular expression display an "invalid email address" message
    else:
        flash("Success!")
    return redirect('/')
app.run(debug=True)


#str.isalpha() -- Returns a boolean that shows whether a string contains only alphabetic characters.
#time.strptime(string, format) -- Changes a string to a time using the given format. 