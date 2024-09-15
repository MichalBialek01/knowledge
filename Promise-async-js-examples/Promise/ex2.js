
const promise1 = new Promise((resolve, reject) => {
    resolve('Michal')
})

promise1.then((result) => {
    console.log(result)
})


const promise2 = new Promise((resolve, reject) => {
    reject(new Error('Some error occurred'))
})


promise2.then(
    (result) => {
        console.log(result)
    },
    (reason) => {
        console.log(reason)
    },
);

const promise3 = new Promise((resolve, reject) => {
    reject(new Error('Some error occurred'))
})


promise3.then(
    (result) => {
        console.log(result)
    }).catch(reason => console.log(reason))
