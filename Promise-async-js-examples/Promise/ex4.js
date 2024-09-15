
const promise = new Promise((resolve, reject) => {
    resolve(5)
})


promise.then(result => result * 2)
    .then(result => console.log(result))
    .catch(reason => console.error(reason))
    .finally(()=> console.log("Finished"))
