const express = require('express');
const path = require('path');
const app = express();
const bodyParser = require('body-parser');
const session = require('express-session');

app.use(express.static(path.resolve(__dirname, 'static')));
app.use(session({ secret: 'counter' }));

app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.get('/', function (req, res) {
    if (!('counter' in req.session)){
        req.session.counter = 1;
    }
    else{
        req.session.counter++;
    }
    res.render("index", { counter: req.session.counter });
})

app.listen(8000,function(){
  console.log("listening on port 8000");
})
