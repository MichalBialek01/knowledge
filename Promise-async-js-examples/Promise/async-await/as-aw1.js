async function foo(){
    return 1;
}
// Async causes that this function always return Promise, so we can use .then().catch.finally() chain


async function foo2(){
    const promise = await new Promise((resolve, reject) => {
        setTimeout(()=> resolve('finished'), 1000);
    })

    console.log(promise);
}
foo2();
// await powoduje, że promise zwraca wartość zamiast promise - masło maślane
// działa to tak, że js zatrzymuje się w podanym momencie i czeka do czasu ustalenia obietnicy, i wtedy przypisywana jest bezpośrednio funkcja
// żeby ją wykorzystać, musi byc używana z słowem async - tylko

async function foo3(){
    const promise2 = await new Promise.all((resolve, reject) => {
        console.log(promise);
    })
}
// można również wykorzystać z 3