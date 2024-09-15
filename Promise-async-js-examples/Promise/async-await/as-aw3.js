const items = [Promise.resolve(1),Promise.resolve(2),Promise.resolve(3)]


async function asyncLoop() {
    for (const item of await Promise.all(items)) {
        const result  = item;
        console.log(result);
    };
    console.log('Done');
}