from flask import Flask, render_template, request, redirect

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')


@app.route('/ninjas')
def ninjas():
    return render_template('ninja.html')


@app.route('/dojos/new')
def dojos():
    return render_template('dojos.html')

@app.route('/users', methods=['POST'])
def create_user():
   print "Got Post Info"
   name = request.form['name']
   email = request.form['email']
   return redirect('/')

app.run(debug=True)
