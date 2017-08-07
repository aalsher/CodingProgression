from flask import Flask, render_template, redirect, request, session, flash
import re
app = Flask(__name__)
app.secret_key = "ThisIsSecret!"
@app.route('/')
def index():
  return render_template("index.html")

@app.route('/result', methods=['POST'])
def submit():
  print "Got Post Info"
  EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
  Email = request.form['email']
  first_name = request.form['first_name']
  last_name = request.form['last_name']
  password = request.form['password']
  confirm_password = request.form['confirm_password']

  if len(request.form['email']) == 0:
    flash("email cannot be blank!")
  if len(request.form['first_name']) == 0:
    flash("Name cannot be blank!")
  if request.form['first_name'] is int:
    flash("Name cannot contain numbers!")
  if len(request.form['last_name']) == 0:
    flash("Name cannot be blank!")
  if request.form['last_name'] is int:
    flash("Name cannot contain numbers!")
  if len(request.form['password']) == 0:
    flash("Password cannot be blank!")
  if len(request.form['password']) < 8:
    flash("Password must be at least 8 characters!")
  if len(request.form['confirm_password']) == 0:
    flash("Password cannot be blank!")
  if len(request.form['confirm_password']) < 8:
    flash("Password must be at least 8 characters!")
  if not EMAIL_REGEX.match(request.form['email']):
    flash("Invalid Email Address!")
  if request.form['confirm_password'] is not request.form['password']:
    flash("Passwords must match!")
  else:
    flash("Success!")
  return redirect('/')
  return render_template("result.html", name= name,location=location, language=language, textarea=textarea)


app.run(debug=True) # run our server
