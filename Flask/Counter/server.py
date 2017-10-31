from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = "This is so secret"

plusTwo = False

@app.route('/')
def index():
    if not 'counter' in session:
        session['counter'] = 0
    session['counter'] += 1
    if plusTwo == True:
        session['counter'] += 2

    return render_template('index.html')



app.run(debug=True)

