from flask import Flask, request, redirect, render_template, session, flash
from mysqlconnection import MySQLConnector
from datetime import datetime
import re

app = Flask(__name__)
app.secret_key = "ThisIsSecret!"
mysql = MySQLConnector(app,'mydb')

@app.route('/')
def index():                                    
    return render_template('index.html')

@app.route('/test', methods=['POST'])
def success():
    EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$') 
    email = request.form['email']
    now = str(datetime.today().strftime("%m/%d/%y %I:%M %p"))
    print now

    if not EMAIL_REGEX.match(request.form['email']):
        print "Error"
        flash("Email is not valid!")
        return redirect('/')

    if EMAIL_REGEX.match(request.form['email']):
        print "Success"
        flash(("The email address you entered {} is a VALID email address! Thank you!").format(request.form['email']))
        query = "INSERT INTO emails (email, created_at) VALUES (:email, NOW())"
        data = {'email': request.form['email'], 'created_at': now}
        emails = mysql.query_db(query,data)
        query = "SELECT * from emails"
        emails = mysql.query_db(query)

        
        return render_template('success.html', all_emails = emails)
    
app.run(debug=True)
