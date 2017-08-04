from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = 'ThisIsSecret'

@app.route('/')
def index():
    if 'counter' in session:
        session['counter'] += 1
    else:
        session['counter']s = 0
    return render_template("index.html", counter=session['counter'])
  
# def counter():
#   counter = 0
#   session['counter'] = counter +1
#   return render_template("index.html", counter=session['counter'])
app.run(debug=True)