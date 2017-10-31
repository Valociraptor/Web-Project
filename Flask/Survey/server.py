from flask import Flask, render_template, request, redirect

app = Flask(__name__)



@app.route('/', methods=['POST'])
def create_user():
   name = request.form['name']
   language = request.form['language']
   location = request.form['location']
   comment = request.form['comment']
   print name
   return render_template('/process.html', name=name, language=language, location=location, comment=comment)

@app.route('/')
def index():
    return render_template('index.html')

app.run(debug=True)
