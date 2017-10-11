var express = require('express');
var app = express();
var mongoose = require('mongoose');
var bodyParser = require('body-parser');
var path = require('path');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static(path.join(__dirname, './static')));
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

mongoose.connect('mongodb://localhost/message_board');
mongoose.Promise = global.Promise;

var Schema = mongoose.Schema;
// define Post Schema
var PostSchema = new mongoose.Schema({
  name: {type:String, required: true},
  post: {type: String, required: true },
  comments: [{type: Schema.Types.ObjectId, ref: 'Comment'}]
}, {timestamps: true });

PostSchema.path('name').required(true, 'Name cannot be blank');
PostSchema.path('post').required(true, 'Post cannot be blank');
mongoose.model('Post', PostSchema);
// define Comment Schema
var CommentSchema = new mongoose.Schema({
   _post: {type: Schema.Types.ObjectId, ref: 'Post'},
   name: {type:String, required: true},
   comment: {type: String, required: true }
}, {timestamps: true });
// set our models by passing them their respective Schemas
CommentSchema.path('name').required(true, 'Name cannot be blank');
CommentSchema.path('comment').required(true, 'Comment cannot be blank');
mongoose.model('Comment', CommentSchema);
// store our models in variables
var Post = mongoose.model('Post');
var Comment = mongoose.model('Comment');
// route for getting a particular post and comments


app.get('/', function (req, res){
  Post.find({})
 .populate('comments')
 .exec(function(err, post) {
   console.log(post);
   res.render('index', {post: post});
    });
});

app.post('/post', function(req, res){
  var post = new Post({name: req.body.name, post: req.body.post});
  post.save(function(err){
    if(err){
      console.log(err);
      res.render('index', {errors: post.errors});
    } else {
      console.log("success");
      res.redirect('/');
    }
  });
});
// route for creating one comment with the parent post id
app.post('/comment/:id', function (req, res){
  var post_id = req.params.id;
  Post.findOne({_id: post_id}, function(err, post){
         var comment = new Comment(req.body);
         comment._post = post._id;
        //  post.comments.push(comment);
         comment.save(function(err){
                 if(err){
                   console.log(err);
                   res.render('index', {errors: comment.errors});
                 }else{
                   console.log("new comment added");
                   Post.update({_id: post._id}, {$push: {"comments": comment}}, function(err){
                   });
                   res.redirect("/");
                 }
        });
       });
 });
 app.listen(8000,function(){
 console.log("listening on port 8000");
 })
