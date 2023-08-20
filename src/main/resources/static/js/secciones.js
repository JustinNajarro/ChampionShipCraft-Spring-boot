// Obtener referencias a los elementos del menú de navegación
const menuNavegacion = document.querySelector('.menu-navegacion');
const enlacesMenu = menuNavegacion.getElementsByTagName('a');

// Obtener referencias a las secciones del contenido
const seccionRegistroEquipo = document.getElementById('registrarEquipo');
const seccionEquipos = document.getElementById('equipos');

// Mostrar la sección de registro de equipo y ocultar la sección de equipos
function mostrarRegistroEquipo() {
    seccionRegistroEquipo.style.display = 'block';
    seccionEquipos.style.display = 'none';
}

// Mostrar la sección de equipos y ocultar la sección de registro de equipo
function mostrarEquipos() {
    seccionEquipos.style.display = 'block';
    seccionRegistroEquipo.style.display = 'none';
}

// Asignar eventos de clic a los enlaces del menú de navegación
enlacesMenu[0].addEventListener('click', mostrarRegistroEquipo);
enlacesMenu[1].addEventListener('click', mostrarEquipos);
