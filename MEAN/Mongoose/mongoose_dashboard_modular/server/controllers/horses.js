// require mongoose
var mongoose = require('mongoose');
var Horse = mongoose.model('Horse');
module.exports = {
  index: function(req,res){
    Horse.find({}, function(err, results){
      if(err) { console.log(err);}
      res.render('index', { horses:results});
    })
  },
  show: function(req, res){
    Horse.create(req.body, function(err, result){
      if (err) { console.log(err); }
      res.redirect('/')
    })
  },
  create: function(req, res) {
      console.log("POST DATA", req.body);
      var horse = new Horse(req.body);
      horse.save(function(err) {
        if(err) {
          console.log('something went wrong');
          res.render('index', {errors: quote.errors})
        } else {
          console.log('successfully added a horse!');
          res.redirect("/");
        }
      })
    },

    showOne: function(req,res){
      Horse.find({ _id: req.params.id }, function(err, response) {
        if (err) { console.log(err); }
        res.render('showhorses', { horse: response[0] });
      })
    },

    update: function(req,res){
      Horse.update({ _id: req.params.id }, req.body, function(err, result){
        if (err) { console.log(err); }
        res.redirect('/');
      })
    },

    find: function(req,res){
      Horse.find({ _id: req.params.id }, function(err, response) {
        if (err) { console.log(err); }
        res.render('edit', { horse: response[0] });
      })
    },

    delete: function(req,res){
      Horse.remove({ _id: req.params.id }, function(err, result){
        if (err) { console.log(err); }
        res.redirect('/');
      })
    }
}
