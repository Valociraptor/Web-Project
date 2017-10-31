from flask import Flask, render_template, request, redirect, session
import random
app = Flask(__name__)
app.secret_key = "This is so secret"




@app.route('/',)
def index():
    if not 'numguess' in session:
        session['numguess'] = 0
    if not 'correctanswer' in session:
        session['correctanswer'] = random.randint(1,100)

    return render_template('index.html')


@app.route('/guess', methods=['POST'])
def guess():
    session['numguess'] = request.form['numguess']
    session['numguess'] = int(session['numguess'])
    return redirect('/')



app.run(debug=True)

