import axios from 'axios';

const iTunesPromise = await axios.get('https://itunes.apple.com/search?term=alita%20battle%20angel&media=music');
console.log(iTunesPromise.data);

iTunesPromise.then(
    response => console.log(response.data),
    reason => console.log(reason)
)

console.log('Finished');