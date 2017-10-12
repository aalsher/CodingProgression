// require mongoose
var mongoose = require('mongoose');

var TaskSchema = new mongoose.Schema({
    title: { type: String, required: true},
    description: { type: String, required: true},
    completed: { type: String, required: true},
}, { timestamps: true });

var Task = mongoose.model('Task', TaskSchema);
