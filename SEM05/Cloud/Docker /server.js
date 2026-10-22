const express = require('express')
const app = express()

app.get('/', (req, res) => {
    res.send("hello world")
})

app.listen(3000, () => {
    console.log('listening at : localhost:3000')
})