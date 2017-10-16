let mongoose = require("mongoose");
let UserController = require("../controllers/UserController.js");

module.exports = function(app){

    app.get("/",function(req,res){
        req.session.user_id = undefined;
        res.render("index");
    });

    app.post("/register",UserController.register);

    app.post("/login", UserController.login);

    app.get("/dashboard", UserController.dashboard);

}
