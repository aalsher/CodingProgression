from flask import Flask, render_template, redirect, request, session, flash
import re
app = Flask(__name__)
app.secret_key = "ThisIsSecret!"
# our index route will handle rendering our form
@app.route('/')
def index():
  return render_template("index.html")

# @app.route('/result', methods=['POST'])
# def create_user():
#   print "Got Post Info"
#   name = request.form['name']
#   location = request.form['location']
#   language = request.form['language']
#   textarea = request.form['textarea']

@app.route('/result', methods=['POST'])
def submit():
  print "Got Post Info"
  name = request.form['name']
  location = request.form['location']
  language = request.form['language']
  textarea = request.form['textarea']
  if len(request.form['name']) == 0:
    flash("Name cannot be blank!")
  if len(request.form['textarea']) == 0:
    flash("Comment cannot be blank!")
  if len(request.form['textarea']) > 120:
    flash("Comment section too long!")
  else:
    flash("Success!")
  return redirect('/')
  return render_template("result.html", name= name,location=location, language=language, textarea=textarea)


app.run(debug=True) # run our server
