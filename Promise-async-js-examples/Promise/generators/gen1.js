// Generators can return multiple responses, can be stopped and resumed

function* moviesSeqence() {
    console.log('Gone in 60 seconds');
    console.log('Gone in 30 seconds');
    console.log('Gone in 2 seconds');
    yield 'yield stopping generator '
    yield 'we will get next element, bu using next in method call'
    yield 'yield return boolean, that indicates ending of generator'
    yield 'last is undefined'

}

const movieGenerator = moviesSeqence();
console.log(movieGenerator.next());
console.log(movieGenerator.next());
console.log(movieGenerator.next());