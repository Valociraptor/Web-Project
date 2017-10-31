from flask import Flask, render_template, request, redirect

app = Flask(__name__)




 

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/ninja')
def ninja():
    return render_template('ninja.html')

@app.route('/ninja/<image>')
def showNinjas(image):
    image = image
    print image
    return render_template('/ninja.html', image=image)

app.run(debug=True)
