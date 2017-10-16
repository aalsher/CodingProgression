let mongoose = require("mongoose");
let Schema   = mongoose.Schema;
let bcrypt   = require('bcrypt');
// SALT_WORK_FACTOR= 10;
var uniqueValidator = require('mongoose-unique-validator');

let UserSchema = new Schema({
    email:{
        type:String,
        required:[true,"Email is required."],
        unique: [true, "User already exists in DB"],
        minlength:[6,"Email must be greater than 6 chars"],
        maxlength:[40,"Email must be shorter than 40 chars"],
        validate:{
            validator:function(value){
                return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(value);
            },
            message:"Invalid E-mail format."
        }
    },

    first_name:{
        type:String,
        required:[true,"Must have first name"],
        minlength:[1,"First Name must be greater than 1 char"],
        maxlength:[50,"First Name must be less than 50 chars"],
    },

    last_name:{
        type:String,
        required:[true,"Last Name is required."],
        minlength:[1,"Last Name must be greater than 1 char"],
        maxlength:[50,"Last Name must be less than 50 chars"],
    },

    password:{
        type:String,
        required:[true,"Password is required."],
        minlength:[8,"Password must be greater than 8 chars."],
        maxlength:[255],
        validate:{
            validator:function(value){
                return /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d$@$!%*?&]{8,32}/.test( value );
            },
            message: "Must have 1 number, uppercase and special character"
        }
    },

    password_confirm:{
        type:String,
        required:[true,"Password is required."],
        minlength:[8,"Password must be greater than 8 chars."],
        maxlength:[255],
        validate:{
            validator:function(value){
                return value == this.password;
            },
            message:"Password and Password Confirmation must match."
        }
    },

    birth_date:{
        type:Date,
        required:[true,"Birth date is required."],
        validate:{
            validator:function(value){
                let years = new Date().getFullYear()-value.getFullYear();
                return years >= 18;
            },
            message:"You must be 18 or older."
        }
    }
},{timestamps:true});

//METHODS
UserSchema.pre('save', function(done){
  this.password = bcrypt.hashSync(this.password, bcrypt.genSaltSync(8));
  done();
})
  // let user = this;
// only hash the password if it has been modified (or is new)
  // if (!user.isModified('password')) return next();

// generate a salt
// bcrypt.genSalt(SALT_WORK_FACTOR, function(err, salt) {
//     if (err) return next(err);
//
//     // hash the password along with our new salt
//     bcrypt.hash(user.password, salt, function(err, hash) {
//         if (err) return next(err);
//
//         // override the cleartext password with the hashed one
//         user.password = hash;
//         next();
//     });

//validate password
// UserSchema.methods.comparePassword = function(candidatePassword, cb) {
//     bcrypt.compare(candidatePassword, this.password, function(err, isMatch) {
//         if (err) return cb(err);
//         cb(null, isMatch);
//     });


UserSchema.plugin(uniqueValidator);
let User = mongoose.model("User",UserSchema);
