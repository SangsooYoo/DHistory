const { SSL_OP_EPHEMERAL_RSA } = require('constants')
const express = require('express')
const app = express()
const port = 3000

app.get('/sleep', (req, res) => {
    var delay = 4000;
    console.log(req.originalUrl + " let's wait " + new Date().toLocaleTimeString());
    sleep(5000);
    console.log(req.originalUrl + " let's make a response " + new Date().toLocaleTimeString());
    res.send('Hello World!');
})

app.get('/timeout', (req, res) => {
    var delay = 4000;
    console.log(req.originalUrl + " let's wait " + new Date().toLocaleTimeString());
    setTimeout( () => {
        console.log(req.originalUrl + " let's make a response " + new Date().toLocaleTimeString());
        res.send('Hello World!');
    }, 5000);
})

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
})

function sleep(milliseconds) {
    const date = Date.now();
    let currentDate = null;
    do {
        currentDate = Date.now();
    } while (currentDate - date < milliseconds);
}

