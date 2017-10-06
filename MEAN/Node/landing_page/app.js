// NOTES:
// If you're using jQuery, or Twitter Bootstrap or anything stored somewhere other than your computer, you don't need to write a route for it on your server.  The routes we write in our servers are only for content stored on our servers.  Remote stuff is someone else's server's responsibility. Yay!
// Any file written in plain text will be served with utf-8 encoding.  Images won't be served with utf-8; omit that argument in the fs.readFile() method when serving images.

// get the http module:
var http = require('http');
// fs module allows us to read and write content for responses!!
var fs = require('fs');
// creating a server using http module:
var server = http.createServer(function (request, response){
    // see what URL the clients are requesting:
    console.log('client request URL: ', request.url);
    // this is how we do routing:
    if(request.url === '/') {
        fs.readFile('index.html', 'utf8', function (errors, contents){
            response.writeHead(200, {'Content-Type': 'text/html'});
            response.write(contents);
            response.end();
        });

    }
    else if (request.url === "/ninjas") {
         fs.readFile('ninjas.html', 'utf8', function (errors, contents){
             response.writeHead(200, {'Content-type': 'text/html'});
             response.write(contents);
             response.end();
         });
    }
    else if (request.url === "/dojos/new") {
         fs.readFile('dojos.html', 'utf8', function (errors, contents){
             response.writeHead(200, {'Content-type': 'text/html'});
             response.write(contents);
             response.end();
         });
    }
    // request didn't match anything:
    else {
        response.end('URL requested not available');
    }
});
// tell your server which port to run on
server.listen(6789);
// print to terminal window
console.log("Running in localhost at port 6789");
