var net = require('net');
var client  = new net.Socket();

client.connect('1111', 'localhost', function() {
    console.log('client-> connected to server');
    var array = new Uint8Array(100);
    array.fill(10,0,array.length);
    client.write(Buffer.from(array, array.length));
});

client.on('data', function(data) {
    console.log('client-> ' + data);
});

client.on('close', function() {
    console.log('client -> connection is closed');
});

