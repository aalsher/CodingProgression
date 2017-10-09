// Require the Express Module
var express = require('express');
// Create an Express App
var app = express();
//Require Mongoose
var mongoose = require('mongoose');
//Connect Mongoose to MongoDB
// This is how we connect to the mongodb database using mongoose -- "basic_mongoose" is the name of
//   our db in mongodb -- this should match the name of the db you are going to use for your project.

var moment = require('moment');
exports.index = function(req, res) {
    res.render('index', { moment: moment });
}

mongoose.connect('mongodb://localhost/basic_mongoose');

var QuoteSchema = new mongoose.Schema({
    name: { type: String, required: true},
    quote: { type: String, required: true}
}, { timestamps: true });
mongoose.model('Quote', QuoteSchema);
var Quote = mongoose.model('Quote')
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
app.set('views', path.join(__dirname, './views'));
// Setting our View Engine set to EJS
app.set('view engine', 'ejs');
// Routes
// Root Request
app.get('/', function(req, res) {
  res.render('index');
})
// Add Quotes Request
app.post('/quotes', function(req, res) {
    console.log("POST DATA", req.body);
    // create a new User with the name and age corresponding to those from req.body
    var quote = new Quote(req.body);
    // Try to save that new user to the database (this is the method that actually inserts into the db) and run a callback function with an error (if any) from the operation.
    quote.save(function(err) {
      // if there is an error console.log that something went wrong!
      if(err) {
        console.log('something went wrong');
        res.render('index', {errors: quote.errors})
      } else { // else console.log that we did well and then redirect to the root route
        console.log('successfully added a quote!');
        res.redirect("/quotes");
      }
    })
  })
  app.get('/quotes', function (req, res) {
    Quote.find({}).
        sort({ createdAt: -1 }).
        exec(function (err, quotes) {
        res.render('quotes', { quotes: quotes,moment:moment });
    });
})
  app.listen(8000,function(){
  console.log("listening on port 8000");
})
