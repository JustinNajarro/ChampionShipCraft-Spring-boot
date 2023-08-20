document.addEventListener("DOMContentLoaded", function() {
  const hamburguer = document.querySelector('.hamburguer');
  const menu = document.querySelector('.menu-navegacion');

  console.log(menu);
  console.log(hamburguer);

  // Resto de tu código para manipular los elementos
  hamburguer.addEventListener('click', () => {
    menu.classList.toggle("spread");
  });

  window.addEventListener('click', (e) => {
    if (menu.classList.contains('spread') && e.target != menu && e.target != hamburguer) {
      menu.classList.toggle("spread");
    }
  });
});


