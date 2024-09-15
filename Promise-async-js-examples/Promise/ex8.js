//Executes only the first resolved
Promise.race([
    new Promise((resolve, reject) => {setTimeout(()=> resolve('first'), 88000);}),
    new Promise((resolve, reject) => {setTimeout(()=> resolve('second'), 1000);}),
    new Promise((resolve, reject) => {setTimeout(()=> resolve('third'), 5000);}),
]).then(
    response => console.log(response)
).catch(console.error);