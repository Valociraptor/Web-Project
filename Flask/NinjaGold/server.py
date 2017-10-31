from flask import Flask, render_template, request, redirect, session
import random
import datetime
app = Flask(__name__)
app.secret_key = "This is so secret"

@app.route('/',)
def index():
    if not 'money' in session:
        session['money'] = 0
    session['building'] = "None"
    #session['activity'] = ""

    return render_template('index.html')

@app.route('/process_money', methods = ['POST'])
def money():
    session['building'] = request.form['building']
    print session['building']

    if session['building'] == 'farm':
        session['money'] +=1
        blurb = "You got 1$ from the {}. ".format(session['building'])
        session['activity'] = time+session['activity']+blurb
        print session['activity']
        
    elif session['building'] == 'house':
        session['money'] +=5
        blurb = "You got 5$ from the {}. ".format(session['building'])
        session['activity'] = session['activity']+blurb

    elif session['building'] == 'cave':
        session['money'] +=10
        blurb = "You got 10$ from the {}. ".format(session['building'])
        session['activity'] = session['activity']+blurb

    elif session['building'] == 'casino':
        gamble = random.randint(0,1)
        if gamble == 0:
            session['money'] -=50
            blurb = "You lost 50$ at the {}. ".format(session['building'])
            session['activity'] = session['activity']+blurb
        else:
            session['money'] +=50
            blurb = "You won 50$ at the {}. ".format(session['building'])
            session['activity'] = session['activity']+blurb
        
    

    return redirect('/')

app.run(debug=True)
