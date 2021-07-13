var net = require('net');
var clients = [];
require('net').createServer(function(socket) {

    socket.on("connect", function() {
        clients.push(socket);
    });

    socket.on("close", function() {
        clients.splice(clients.indexOf(socket), 1);
    });

    socket.on("data", function(data) {
        console.log(`client-> server = ${JSON.stringify(data)}`);
    });
    clients.push(socket);
}).listen(7006,"localhost");