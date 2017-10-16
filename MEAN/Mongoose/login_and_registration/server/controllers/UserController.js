// require mongoose
var mongoose = require('mongoose');
var User = mongoose.model('User');
let bcrypt   = require('bcrypt');

module.exports = {

  register: function(req, res) {
    var user = new User(req.body);
    console.log(user);
    //check if user already exists in db
    user.save(function (err) {
      if(err) {
        console.log(err);
        res.render("index", {regErrors: user.errors})
      }else{
        console.log("user created");
        res.redirect('/')
      }
    });
  },

  login: function(req, res){

    console.log(req.body);

    //validations
    let loginErrors = []
    if (req.body.login_email.length < 1){
      loginErrors.push("Email cannot be blank");
    }
    if (req.body.login_password.length < 1){
      loginErrors.push("Password must not be blank");
    }

    //make sure user exists in db by checking email
    User.findOne({email:req.body.login_email},function(err,user){
        if(user){
            console.log(user);
            //check if passwords match
            if(!bcrypt.compareSync(req.body.login_password,user.password)){
                res.render("index",{loginErrors:["Invalid Credentials."]});
            }else{
                console.log("got to dashboard");
                req.session.user_id = user._id;
                console.log(user._id);
                res.redirect("/dashboard");
            };
        }else{
            res.render("index",{loginErrs:["User Does Not Exist"]});
        }
    });

  },

  dashboard: function(req,res){
    User.findOne({ _id: req.session.user_id }, function(err,user){
      res.render('dashboard', { user: user});
    })
  }

}
