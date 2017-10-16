let mongoose = require("mongoose");
let UserController = require("../controllers/UserController.js");

module.exports = function(app){

    app.get("/",function(req,res){
      if(req.session){
        req.session.destroy();
      }else{
        res.render("index");
      }
    });

    app.post("/register",UserController.register);

    app.post("/login", UserController.login);

    app.post("/dashboard", UserController.dashboard);

}
