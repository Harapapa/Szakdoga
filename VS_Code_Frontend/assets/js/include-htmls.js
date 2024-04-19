//Inlcude Element selector
const _incEl = document.querySelectorAll('.include-html') // A HTML elemek kiválasztása, amelyek tartalmazhatnak include fájlokat.

// Load Files
_incEl.forEach(el => { // Minden include-html elemen végigmegyünk és a tartalmazott fájlokat betöltjük.
    var _src = el.dataset.src
    var _type = el.dataset.type || 'div'
    var _id = el.dataset.id || ''
    if(_src != undefined || _src != ""){ // Ha van include fájl
        fetch(_src)
        .then(response=>{
            return response.text()
        })
        .then(data=>{ // A fájl tartalmának betöltése
            var newEl = document.createElement(_type)
                newEl.classList.add('included-file')
                if(_id != "") // Ha van ID
                newEl.id = _id
                newEl.innerHTML = data
            el.replaceWith(newEl) // A tartalmazó elemet kicseréljük a betöltött tartalomra.
            
        })
    } 
})