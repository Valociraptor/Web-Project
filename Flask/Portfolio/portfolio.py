from flask import Flask, render_template, request # Import Flask to allow us to create our app.
app = Flask(__name__) # Global variable __name__ tells Flask whether or not we are running the file
                        # render_template to allow us to render index.html.
                         # directly, or importing it as a module.
@app.route('/')# The "@" symbol designates a "decorator" which attaches the following
                         # function to the '/' route. This means that whenever we send a request to
                         # localhost:5000/ we will run the following "hello_world" function.

def portfolio():
    return render_template('index.html')# Return the string 'Die in a Fire' as a response.

@app.route('/projects')
def success():
    return render_template('projects.html')

@app.route('/about')
def about():
    return render_template('about.html')

app.run(debug=True)  # Run the app in debug mode.