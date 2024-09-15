// fetching provided github users

import axios from "axios";

const names = ["apple", "facebook"]
const requests = names.map(axios.get(`http://api.github.com/users/${name}`))

Promise.all(requests)
    .then(data => data.map(user => user.data))
    .then(users => users.forEach(user => console.log(user.login)))
    .catch(alert);

