from flask import Flask, render_template, request, redirect, session, flash
import re

app = Flask(__name__)
app.secret_key = "This is so secret"


@app.route('/', methods=['POST'])
def create_user():
    name = request.form['name']
    language = request.form['language']
    location = request.form['location']
    comment = request.form['comment']
    if len(request.form['name']) < 1:
        flash("Name cannot be empty!")
    elif str.isalpha(str(request.form['name'])) == False:
        flash("Name cannot have numbers wtf is wrong with you?")
    elif len(request.form['name']) > 120:
        flash("Name cannot be longer than 120 characters you ass!")
    elif len(request.form['comment']) < 1:
        flash("Comment cannot be empty!")
    elif len(request.form['comment']) > 120:
        flash("Comment cannot be longer than 120 characters you ass!")
    else:
        return render_template('/process.html', name=name, language=language, location=location, comment=comment)
    return render_template('index.html')

    
 

@app.route('/')
def index():
    return render_template('index.html')

app.run(debug=True)
