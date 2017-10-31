from flask import Flask, render_template, request, redirect # Import Flask to allow us to create our app.
app = Flask(__name__) # Global variable __name__ tells Flask whether or not we are running the file
                        # render_template to allow us to render index.html.
                         # directly, or importing it as a module.
@app.route('/')# The "@" symbol designates a "decorator" which attaches the following
                        # function to the '/' route. This means that whenever we send a request to
                         # localhost:5000/ we will run the following "hello_world" function.

def index():
    return render_template('index.html', phrase='Hello', times=5, bees="BEES")# Return the string 'Die in a Fire' as a response.







# @app.route('/users', methods=['POST'])
# def create_user():
#     print "Got Post Info"

#     name = request.form['name']
#     email = request.form['email']
#     return redirect('/')

# @app.route('/users/<username>')
# def show_user_profile(username):
#     print username
#     return render_template("users.html", name={{name}})


app.run(debug=True)  # Run the app in debug mode.