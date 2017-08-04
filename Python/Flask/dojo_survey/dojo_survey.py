from flask import Flask, render_template, request, redirect
app = Flask(__name__)
# our index route will handle rendering our form
@app.route('/')
def index():
  return render_template("index.html")


@app.route('/result', methods=['POST'])
def create_user():
  print "Got Post Info"
  name = request.form['name']
  location = request.form['location']
  language = request.form['language']
  textarea = request.form['textarea']


  return render_template("result.html", name= name,location=location, language=language, textarea=textarea)
  
  # redirects back to the '/' route
  # @app.route('/')
  # def redirect():
  #   return redirect('/')

app.run(debug=True) # run our server
