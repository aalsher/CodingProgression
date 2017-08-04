from flask import Flask, render_template, request, redirect
app = Flask(__name__)
# our index route will handle rendering our form

@app.route('/')
def index():
  return render_template("index.html")
# this route will handle our form submission
# notice how we defined which HTTP methods are allowed by this route

@app.route('/ninja/<color>')
def show_ninja_turtle(color):
    print color
    if color == 'blue':
      return render_template("/ninja/blue.html")
    if color == 'red':
      return render_template("/ninja/red.html")
    if color == 'orange':
      return render_template("/ninja/orange.html")
    if color == 'purple':
      return render_template("/ninja/purple.html")
    else:
      return render_template('notapril.html')

@app.route('/ninja')
def ninja():
  return render_template('ninja.html')

@app.route('/ninja/red')
def ninja_red():
  return render_template('ninja_red.html')

@app.route('/ninja/blue')
def ninja_blue():
  return render_template('ninja_blue.html')

@app.route('/ninja/orange')
def ninja_orange():
  return render_template('ninja_orange.html')

@app.route('/ninja/purple')
def ninja_purple():
  return render_template('ninja_purple.html')

app.run(debug=True) # run our server

