// require mongoose
var mongoose = require('mongoose');
var task = mongoose.model('Task');
module.exports = {
  index: function(req,res){
    Task.find({}, function(err, results){
      if(err) { console.log(err);}
      res.render('index', { tasks:results});
    })
  },
  show: function(req, res){
    Task.create(req.body, function(err, result){
      if (err) { console.log(err); }
      res.redirect('/')
    })
  },
  create: function(req, res) {
      console.log("POST DATA", req.body);
      var task = new Task(req.body);
      task.save(function(err) {
        if(err) {
          console.log('something went wrong');
          res.render('index', {errors: task.errors})
        } else {
          console.log('successfully added a task!');
          res.redirect("/");
        }
      })
    },

    showOne: function(req,res){
      Task.find({ _id: req.params.id }, function(err, response) {
        if (err) { console.log(err); }
        res.render('showtasks', { task: response[0] });
      })
    },

    update: function(req,res){
      Task.update({ _id: req.params.id }, req.body, function(err, result){
        if (err) { console.log(err); }
        res.redirect('/');
      })
    },

    find: function(req,res){
      Task.find({ _id: req.params.id }, function(err, response) {
        if (err) { console.log(err); }
        res.render('edit', { task: response[0] });
      })
    },

    delete: function(req,res){
      Task.remove({ _id: req.params.id }, function(err, result){
        if (err) { console.log(err); }
        res.redirect('/');
      })
    }
}
