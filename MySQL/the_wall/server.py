from flask import Flask, render_template, redirect, request, session, flash
from mysqlconnection import MySQLConnector
from datetime import datetime
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
    flag = False
    if len(request.form['login_email']) == 0:
        flash("email cannot be blank!")
        flag = True
    if not EMAIL_REGEX.match(request.form['login_email']):
        flash("Email is not valid!")
        flag = True
    
    if flag is True:
        print "Login Error"
        return redirect('/')

    else: 
        password = md5.new(request.form['login_password']).hexdigest()
        user_query = "SELECT idusers, first_name FROM users WHERE users.email = :email AND users.password = :password"
        query_data = {'email': request.form['login_email'], 'password': password}
        user = mysql.query_db(user_query,query_data)
        if len(user) != 0:
            print "user exists"
            session['idusers'] = user[0] #change this later
            return redirect('/the_wall')
            
        else:
            flash("Login credentials are incorrect, please try again")
            return redirect('/')

@app.route('/the_wall')
def render_wall():
    messages_query = "SELECT users.first_name, users.last_name, messages.*, users.idusers FROM messages JOIN users ON users.idusers = messages.users_idusers"
    messages = mysql.query_db(messages_query)
    comments_query = "SELECT users.first_name, users.last_name, comments.*, users.idusers FROM comments JOIN users ON users.idusers = comments.users_idusers"
    comments = mysql.query_db(comments_query)
    return render_template("the_wall.html", all_messages = messages, all_comments = comments)

@app.route('/the_wall/messages', methods=['POST'])
def post_message():
    message= request.form['post_message']
    now = str(datetime.today().strftime("%m/%d/%y %I:%M %p"))
    insert_message = "INSERT INTO messages(message, created_at, users_idusers) VALUES (:message, NOW(), :users_idusers)"
    message_data = {'message': message, 'created_at': now, 'users_idusers': session['idusers']['idusers']}
    messages = mysql.query_db(insert_message, message_data)
    return redirect('/the_wall')

@app.route('/the_wall/<idmessages>/comment', methods=['POST'])
def post_comments(idmessages):
    comment= request.form['post_comment']
    now = str(datetime.today().strftime("%m/%d/%y %I:%M %p"))
    insert_comment = "INSERT INTO comments(comment, created_at, messages_idmessages, users_idusers) VALUES (:comment, NOW(),:messages_idmessages,:users_idusers)"
    comment_data = {'comment': comment, 'created_at': now, 'messages_idmessages': idmessages,'users_idusers': session['idusers']['idusers']}
    comments = mysql.query_db(insert_comment, comment_data)
    return redirect('/the_wall')

app.run(debug=True)
