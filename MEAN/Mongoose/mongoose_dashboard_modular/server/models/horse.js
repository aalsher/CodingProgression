// require mongoose
var mongoose = require('mongoose');

var HorseSchema = new mongoose.Schema({
    name: { type: String, required: true},
    age: { type: Number, required: true},
    color: { type: String, required: true},
}, { timestamps: true });

var Horse = mongoose.model('Horse', HorseSchema);
