from flask import Flask, render_template, redirect, request, session, flash
from mysqlconnection import MySQLConnector
import re
import md5

app = Flask(__name__)
app.secret_key = "ThisIsSecret!"
mysql = MySQLConnector(app,'mydb')
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')


@app.route('/')
def index():
  return render_template("index.html")

@app.route('/register', methods=['POST'])
def register():
    print "Got Post Info"
    flag = False

    if request.form['first_name'] is int:
        flash("Name cannot contain numbers!")
        flag = True
    if len(request.form['first_name']) < 2:
        flash("First name cannot be blank!")
        flag = True

    if request.form['last_name'] is int:
        flash("Name cannot contain numbers!")
        flag = True
    if len(request.form['last_name']) < 2:
        flash("Last name cannot be blank!")
        flag = True


    if len(request.form['email']) == 0:
        flash("email cannot be blank!")
        flag = True
    if not EMAIL_REGEX.match(request.form['email']):
        flash("Email is not valid!")
        flag = True

    if len(request.form['password']) == 0:
        flash("Password cannot be blank!")
        flag = True
    if len(request.form['password']) < 8:
        flash("Password must be at least 8 characters!")
        flag = True
    if len(request.form['confirm_password']) == 0:
        flash("Please enter password")
        flag = True
    if request.form['confirm_password'] != request.form['password']:
        flash("Passwords must match!")
        flag = True

    if flag is True:
        print "Error in Registration"
        return redirect('/')
    else:
        print "Successfully registered"
        flash("Successfully Registered! Please Log In.")
        password = md5.new(request.form['password']).hexdigest()
        insert_query = "INSERT INTO users (first_name, last_name, email, password, created_at) VALUES (:first_name, :last_name, :email, :password, NOW())"
        query_data = {
            'first_name': request.form['first_name'],
            'last_name': request.form['last_name'],
            'email': request.form['email'],
            'password': password, #might have to change back to request.form['password']
            'confirm_password' : request.form['confirm_password']
        }
        mysql.query_db(insert_query,query_data)
        return redirect('/')

@app.route('/login', methods=['POST'])
def login():
    password = md5.new(request.form['login_password']).hexdigest()
    user_query = "SELECT idusers FROM users WHERE users.email = :email AND users.password = :password"
    query_data = {'email': request.form['login_email'], 'password': password}
    user = mysql.query_db(user_query,query_data)
    print user[0]
    if len(user) != 0:
        print "user exists"
        flash("You have successfully logged in!")
        session['idusers'] = user[0]
        return render_template("login.html")
    else:
        flash("Login credentials are incorrect, please try again")
        return redirect('/')

app.run(debug=True)
