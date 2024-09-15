const movies = [{id:1, category_id:1,title: "Titanic"}];
const categories = [{id:1,name:"Sci-fi"}];


function fetchMovie(id){
    return new Promise((resolve, reject) => {
        const movie = movies.find(movie => movie.id === id );
        movie ? resolve(movie) : reject(Error('Movie not found'));
    });
}

function populateCategory(movie){
    return new Promise((resolve, reject) => {
        const category = categories.find(category => category.id === movie.category_id);
        if(category){
            movie.category = category;
            resolve(movie);(movie);
        }
        reject(Error('Category not found'));
    })
}

fetchMovie(1)
    .then(movie => populateCategory(movie))
    .then(resoult => console.log(resoult))
    .catch(reason => console.error(reason))