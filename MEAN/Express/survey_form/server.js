var express= require("express");
var bodyParser = require('body-parser');
var app=express();

app.use(express.static(__dirname + "/static"));
console.log(__dirname);
app.use(bodyParser.urlencoded({extended:true}));
app.set('views'.__dirname + '/views');
app.set('view engine', 'ejs');
app.get('/', function(req,res){
  res.render('index', {title:"Survey Form"});
})
app.post('/result', function(req,res){
  console.log("Results posted \n\n", req.body)
  const data ={
      'name': req.body.name,
      'dojo_location': req.body.dojo_location,
      'favorite_lang': req.body.favorite_lang,
      'comment': req.body.comment
  };
  res.render("result", { data: data });
}).listen(8000,function(){
  console.log("listening on port 8000");
})
