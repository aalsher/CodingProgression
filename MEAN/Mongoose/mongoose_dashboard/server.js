// Require the Express Module
var express = require('express');
// Create an Express App
var app = express();
//Require Mongoose
var mongoose = require('mongoose');
//Connect Mongoose to MongoDB
// This is how we connect to the mongodb database using mongoose -- "basic_mongoose" is the name of
//   our db in mongodb -- this should match the name of the db you are going to use for your project.

exports.index = function(req, res) {
    res.render('index', { horses: horses});
}

mongoose.connect('mongodb://localhost/mongoose_dashboard');

var HorseSchema = new mongoose.Schema({
    name: { type: String, required: true},
    age: { type: Number, required: true},
    color: { type: String, required: true},
}, { timestamps: true });
mongoose.model('Horse', HorseSchema);
var Horse = mongoose.model('Horse')
mongoose.Promise = global.Promise;

// Require body-parser (to receive post data from clients)
var bodyParser = require('body-parser');
// Integrate body-parser with our App
app.use(bodyParser.urlencoded({ extended: true }));
// Require path
var path = require('path');
// Setting our Static Folder Directory
app.use(express.static(path.join(__dirname, './static')));
// Setting our Views Folder Directory
app.set('views', path.join(__dirname, 'views'));
// Setting our View Engine set to EJS
app.set('view engine', 'ejs');

// Routes

//GET '/' Displays all of the mongooses.
app.get('/', function(req, res) {
  Horse.find({}, function(err, results){
    if(err) { console.log(err);}
    res.render('index', { horses:results});
  });
});

app.post('/', function(req, res){
  Horse.create(req.body, function(err, result){
    if (err) { console.log(err); }
    res.redirect('/')
  });
});

//GET '/mongooses/new' Displays a form for making a new mongoose.
app.get('/horse/new', function(req, res) {
  res.render('newhorse');
});

app.get('/horse/:id', function(req, res){
  Horse.find({ _id: req.params.id }, function(err, response) {
    if (err) { console.log(err); }
    res.render('showhorses', { horse: response[0] });
  });
});

app.post('/horse/:id', function(req, res){
  Horse.update({ _id: req.params.id }, req.body, function(err, result){
    if (err) { console.log(err); }
    res.redirect('/');
  });
});

app.get('/edit/:id', function(req, res){
  Horse.find({ _id: req.params.id }, function(err, response) {
    if (err) { console.log(err); }
    res.render('edit', { horse: response[0] });
  });
});

//POST '/mongooses' Should be the action attribute for the form in the above route (GET '/mongooses/new').
app.post('/horses', function(req, res) {
    console.log("POST DATA", req.body);
    // create a new User with the name and age corresponding to those from req.body
    var horse = new Horse(req.body);
    // Try to save that new user to the database (this is the method that actually inserts into the db) and run a callback function with an error (if any) from the operation.
    horse.save(function(err) {
      // if there is an error console.log that something went wrong!
      if(err) {
        console.log('something went wrong');
        res.render('index', {errors: quote.errors})
      } else { // else console.log that we did well and then redirect to the root route
        console.log('successfully added a horse!');
        res.redirect("/");
      }
    })
  })

// Update
app.post('/horse/:id', function(req, res){
  Horse.update({ _id: req.params.id }, req.body, function(err, result){
    if (err) { console.log(err); }
    res.redirect('/');
  });
});

// Delete
app.post('/delete/:id', function(req, res){
  Horse.remove({ _id: req.params.id }, function(err, result){
    if (err) { console.log(err); }
    res.redirect('/');
  });
});
  app.listen(8000,function(){
  console.log("listening on port 8000");
})
