// A navigációs sáv tárolójának átméretezése,optimalizálása
const resizeNavParent = () => {
    var _navbar = document.getElementById('topNavigation') // Navigációs sáv tárolója
    console.log(_navbar) 
    var _height = _navbar.clientHeight 
    var _clearFixEl = document.createElement('div') // Egy tiszító elem, mely a navigációs sáv alá kerül, hogy a tartalom ne takarja el a navigációs sávot.
    _clearFixEl.style.marginBottom = `${_height}px` 
    _navbar.after(_clearFixEl) 
}

/**
 * Galéria kategória szűrő, mely a kategóriákra kattintva szűri a galériában található elemeket.
 */
const filterCategory = () =>{ // Galéria kategória szűrő
    var cats = document.querySelectorAll('#gallery #gallery-categories .btn') 
    cats.forEach(cat=>{ // Minden kategóriára kattintás eseményt adunk
        cat.addEventListener('click', e=>{
            e.preventDefault()
            if(cat.parentElement.querySelector('.active') != undefined){ // Ha van aktív elem, akkor azt inaktívvá tesszük
                cat.parentElement.querySelector('.active').classList.remove('active')
            }
            cat.classList.add('active') // Az aktuális elemet aktívvá tesszük
            var catName = cat.dataset.category || 'all'
            var catItems = document.querySelectorAll('#gallery-container .gallery-item')
            catItems.forEach(el => { // Minden elemen végigmegyünk és a kategóriának megfelelő elemeket megjelenítjük, a többit elrejtjük.
                if(el.dataset.category == catName || catName == 'all'){
                    if(el.classList.contains('hide'))
                    el.classList.remove('hide')
                }else{
                    if(!el.classList.contains('hide'))
                    el.classList.add('hide')
                }
            })
        })
    })
}
// Beszámoló konténer magasság leképezése. Az egyes quote elemek közül a legmagasabb elem magasságát veszi figyelembe.
const testimonialHeight = () => { 
    var containerHeight = 0;     
    var testimonialItems = document.querySelectorAll('#testimonials .testimony-item') 
    testimonialItems.forEach(el => { // Minden beszámoló elemen végigmegyünk és a legmagasabb elem magasságát vesszük figyelembe.
        if(el.clientHeight > containerHeight)
        containerHeight = el.clientHeight
    })
    document.querySelector('#testimonials .testimonies-inner').style.height = `${containerHeight}px` // A konténer magasságát beállítjuk a legmagasabb elem magasságára.
}
/** Tanúságtétel/beszámoló csúszka leképezése. A következő illetve visszalépést előidéző beszámolók nyil alapú mozgatása. */
const testimonySlider = () =>{ // Tanúságtétel/beszámoló csúszka leképezése
    var _prev =  document.querySelector('#testimonials .testimony-item-prev-btn') 
    var _next =  document.querySelector('#testimonials .testimony-item-next-btn')
    console.log(_next)
    _next.addEventListener('click', e=>{ // Következő beszámoló
        e.preventDefault()
        var currentActive = document.querySelector('#testimonials .testimony-item.active')
        if(currentActive != null){ // Ha van aktív elem
            var nextSibling = currentActive.nextElementSibling || document.querySelector('#testimonials .testimony-item:nth-child(1)')
            if(nextSibling != null){  // Ha van következő elem
                _prev.setAttribute('disabled',true)
                _next.setAttribute('disabled',true)
                currentActive.classList.remove('active')
                nextSibling.classList.add('active')
                currentActive.classList.add('slide-next','slide-start')
                nextSibling.classList.add('slide-next','slide-end')
                setTimeout(()=>{ // A késleltetés azért szükséges, hogy a CSS átmenetek lefussanak.
                    currentActive.classList.remove('slide-next','slide-start')
                    nextSibling.classList.remove('slide-next','slide-end')
                    _prev.removeAttribute('disabled')
                    _next.removeAttribute('disabled')
                },300)
            }
        }
    })
    _prev.addEventListener('click', e=>{ // Visszalépés az előző beszámolóra
        e.preventDefault()
        var currentActive = document.querySelector('#testimonials .testimony-item.active') 
        if(currentActive != null){ // Ha van aktív elem
            var prevSibling = currentActive.previousElementSibling || document.querySelector('#testimonials .testimony-item:nth-last-child(1)')
            if(prevSibling != null){ // Ha van előző elem
                _prev.setAttribute('disabled',true)
                _next.setAttribute('disabled',true)
                currentActive.classList.remove('active')
                prevSibling.classList.add('active')
                currentActive.classList.add('slide-prev','slide-start')
                prevSibling.classList.add('slide-prev','slide-end')
                setTimeout(()=>{ // A késleltetés azért szükséges, hogy a CSS átmenetek lefussanak.
                    currentActive.classList.remove('slide-prev','slide-start')
                    prevSibling.classList.remove('slide-prev','slide-end')
                    _prev.removeAttribute('disabled')
                    _next.removeAttribute('disabled')
                },300)
            }
        }
    })
}

setTimeout(()=>{  // A késleltetés azért szükséges, mert a DOM betöltése után kell az elemeket manipulálni.
    resizeNavParent()  // Navigációs sáv átméretezése
    window.onresize = () =>{ // Ablak átméretezésekor újra kell méretezni a navigációs sáv tárolóját.
        resizeNavParent() // Navigációs sáv átméretezése
        testimonialHeight() // Beszámoló konténer magasság leképezése
    }
    filterCategory() // Galéria kategória szűrő
    testimonialHeight() //Beszámoló konténer magasság leképezése
    testimonySlider() // Tanúságtétel/beszámoló csúszka leképezése
},300)

// copyright-year
const cry = document.getElementById('copyright-year') 
var _now = new Date()
cry.innerText = _now.getFullYear()