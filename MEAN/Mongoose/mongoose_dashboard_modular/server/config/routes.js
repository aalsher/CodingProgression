var horses = require('../controllers/horses.js');
module.exports = function(app) {
  app.get('/', horses.index)

  app.post('/', horses.show)

  app.get('/horse/new', function(req,res){
      res.render('newhorse')
  })
  app.post('/horses', horses.create)

  app.get('/horse/:id', horses.showOne)

  app.post('/horse/:id', horses.update)

  app.get('/edit/:id', horses.find)

  app.post('/delete/:id', horses.delete)
}
