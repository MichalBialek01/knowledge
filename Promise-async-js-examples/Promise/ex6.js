// Statyczne metody Prmise

// Otrzmujemy od razu rozwiązaną wartość - wyjątek: przekazanie odrzuconej obietnicy lub obiekt thenable
const promise = Promise.resolve(42);
console.log(promise);

// Case 1 - Żeby dało się użyć then - w tym przypadku, gdyby był czysty obiekt user, to nie zawsze były zwracany promise

function fetchUser(id) {
    const user = localStorage.getItem(id).getItem(`user-{$id}`);

    return user
        ? Promise.resolve(user)
        : User.find(user => {
            localStorage.setItem(`user-{id}`, user)
            return user;
        });
}

fetchUser()
    .then(user => {})





















