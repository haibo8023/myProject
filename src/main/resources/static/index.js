axios.get('/api/getInfo').then(res => res.data.data).then(json => {
  document.getElementById('a').value = js_beautify(JSON.stringify(json), 4, ' ')
})

axios.get('/api/getRank').then(res => res.data.data).then(json => {
  document.getElementById('b').value = js_beautify(JSON.stringify(json), 4, ' ')
})
