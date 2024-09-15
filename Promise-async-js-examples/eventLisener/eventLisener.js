

const grantParent = document.querySelector('.grantParent');
const parent = document.querySelector('.parent');
const child = document.querySelector('.child');

grantParent.addEventListener('click', e=> {
    console.log('clicked');
})

// Zamias e=> {}, można dać funkcje

/*
 Pierwszy parametr - na jaką akcję ma być reakcja. Są dostępne następujące akcje:

    1.click - na kliknięcie
    2.mouseover - najechanie na element
    3.mouseout - gdy wyjedzie się poza obiekt
    4.submit - gdy folmularz jest wysyłany
    5.change - gdy wartość elementu się zmienia
    6.load /unload - gdy strona jest ładowana/opuszczana

  Drugi parametr - obiekt manipulowany, najczęściej nazywany "e" lub "element"
  i na nim wykonujemy arrow function - w której definiujemy, co robimy podczas podanej akcji

   Możemy definiować wiele eventLisnerów

   3 parametrem jest capturing lub bubbiling (domyslny) - oznacza, kolejnośc obsługi elementów.
   Bubbling jest domyślny, co oznacz, że od najbardziej zagniżdzonego elementy się

   w arrowFunction elementu eventLisener możemy dodać metodę e.stopPropagation(), która blokuje dalsze eventLisnery


   3 parameterm może być {once: true } - co oznacza, że daną funkcję, można wywołać raz

 */
