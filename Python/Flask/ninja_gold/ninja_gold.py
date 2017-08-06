from flask import Flask, render_template, request, redirect, session
import random
from datetime import datetime

app = Flask(__name__)
app.secret_key = 'ThisIsSecret'

@app.route('/')
def index():
    
    session['your_gold'] = 0
    session['farm'] = 0
    session['cave'] = 0
    session['house'] = 0
    session['casino'] = 0
    session['activities'] = []
    return render_template("index.html")
    
@app.route('/process_money',methods=['POST'])

def getgold():
    now = str(datetime.today().strftime("%Y/%m/%d %I:%M %p"))

    if request.form['building'] == 'farm':
        session['farm'] = random.randrange(10,20)
        session['your_gold'] += session['farm']
        if session['farm'] >= 0:
            session['activities'].append("<p style='color:green'>" + "Earned {} gold from the {}!({})".format(session['farm'], request.form['building'], now)+ "</p>")

    if request.form['building'] == 'cave':
        session['cave'] = random.randrange(5,10)
        session['your_gold'] += session['cave']
        if session['cave'] >= 0:
            session['activities'].append("<p style='color:green'>" + "Earned {} gold from the {}!({})".format(session['cave'], request.form['building'], now)+ "</p>")

    if request.form['building'] == 'house':
        session['house'] = random.randrange(2,5)
        session['your_gold'] += session['house']
        if session['house'] >= 0:
            session['activities'].append("<p style='color:green'>" + "Earned {} gold from the {}!({})".format(session['house'], request.form['building'], now)+ "</p>")


    if request.form['building'] == 'casino':
        session['casino'] = random.randrange(-50,50)
        session['your_gold'] += session['casino']

        if session['casino'] >= 0:
            session['activities'].append("<p style='color:green'>" + "Earned {} gold from the {}!({})".format(session['casino'], request.form['building'], now)+ "</p>")

        if session['casino'] < 0:
            session['activities'].append("<p style='color:red'>" + "Entered a casino and lost {} golds... Ouch!({})".format(session['casino'], now)+ "</p>")

   
    return render_template("index.html")
    return redirect('/')
    
@app.route('/reset')
def reset():
    session['your_gold'] = 0
    session['activities'] = []
    return redirect('/')


app.run(debug=True)