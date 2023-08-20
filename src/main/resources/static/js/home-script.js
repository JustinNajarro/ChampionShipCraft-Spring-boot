// Obtén referencias a los botones de navegación
const btnIzquierda = document.getElementById('btn-izquierda');
const btnDerecha = document.getElementById('btn-derecha');

// Obtén referencias a las secciones
const secciones = document.querySelectorAll('main section');
let seccionActual = 0;

// Oculta todas las secciones excepto la primera
secciones.forEach((seccion, index) => {
  if (index !== 0) {
    seccion.style.display = 'none';
  }
});

// Función para mostrar la siguiente sección con animación
function mostrarSiguienteSeccion() {
  if (seccionActual < secciones.length - 1) {
    secciones[seccionActual].style.animation = 'slideOut 0.5s ease-out';
    setTimeout(() => {
      secciones[seccionActual].style.display = 'none';
      seccionActual++;
      secciones[seccionActual].style.animation = 'slideIn 0.5s ease-out';
      secciones[seccionActual].style.display = 'block';
    }, 500);
  }
}

// Función para mostrar la sección anterior con animación
function mostrarSeccionAnterior() {
  if (seccionActual > 0) {
    secciones[seccionActual].style.animation = 'slideOut 0.5s ease-out';
    setTimeout(() => {
      secciones[seccionActual].style.display = 'none';
      seccionActual--;
      secciones[seccionActual].style.animation = 'slideIn 0.5s ease-out';
      secciones[seccionActual].style.display = 'block';
    }, 500);
  }
}

// Agrega eventos de clic a los botones de navegación "Siguiente" y "Anterior"
btnDerecha.addEventListener('click', mostrarSiguienteSeccion);
btnIzquierda.addEventListener('click', mostrarSeccionAnterior);
