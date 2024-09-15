// Asynchroniczne wczytywanie obrazków

function loadImageAsync(url){
    return new Promise((resolve, reject) => {
        const img = new Image();
        img.addEventListener('load', event => resolve(img))
        img.addEventListener('error', reason => reject(new Error(`Some error occurred ${url}`)))
        img.src = url;
    })
}


loadImageAsync("http://thecatapi.com/api/images/get?format=src&type=jpg&size=small")
    .then(img => document.querySelectorAll('img').appendChild(img))
    .catch(reason => console.log(reason))
