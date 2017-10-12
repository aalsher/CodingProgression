var tasks = require('../controllers/tasks.js');
module.exports = function(app) {
  app.get('/', tasks.index)

  app.post('/', tasks.show)

  app.get('/task/new', function(req,res){
      res.render('newtask')
  })
  app.post('/tasks', tasks.create)

  app.get('/taskl/:id', tasks.showOne)

  app.put('/task/:id', tasks.update)

  app.get('/task/:id', tasks.find)

  app.delete('/delete/:id', tasks.delete)
}
