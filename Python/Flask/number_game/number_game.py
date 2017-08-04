from flask import Flask, render_template, request, redirect, session
import random

app = Flask(__name__)
app.secret_key = 'ThisIsSecret'

@app.route('/')
def index():
    if session['randomnum'] not in session:
        session['randomnum'] = random.randrange(0,101)
    return render_template("index.html")
    
@app.route('/',methods=['POST'])

def randomnumbgame():
    guessed_num = request.form['guessed_num']
    feedback = 0
    print session['randomnum']
    print guessed_num

    if int(guessed_num) > session['randomnum']:
        feedback = 'Too High!'
    if int(guessed_num) < session['randomnum']:
        feedback = "Too Low!"
    if int(guessed_num) == session['randomnum']:
        feedback =  "{} was the number!".format(session['randomnum'])

    print feedback
    return render_template("index.html", feedback=feedback)
    return redirect('/')

app.run(debug=True)