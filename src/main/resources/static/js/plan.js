// Obtenemos las referencias a los elementos de opciones de navegación
const opcionesNavegacion = document.querySelectorAll('.barra-navegacion-planes a');

// Agregamos un evento de clic a cada opción
opcionesNavegacion.forEach(opcion => {
  opcion.addEventListener('click', () => {
    const periodoSeleccionado = opcion.getAttribute('href').substring(1); // Obtenemos el período seleccionado (e.g., "mensual", "trimestral", "semestral")

    // Actualizamos los precios y los períodos de los planes según el período seleccionado
    actualizarPrecioPeriodo('pequeno', periodoSeleccionado);
    actualizarPrecioPeriodo('intermedio', periodoSeleccionado);
    actualizarPrecioPeriodo('premium', periodoSeleccionado);
  });
});

// Función para actualizar los precios y los períodos de un plan específico
function actualizarPrecioPeriodo(plan, periodo) {
  const precioElement = document.getElementById(`plan-${plan}-precio`);
  const periodoElement = document.getElementById(`plan-${plan}-periodo`);

  switch (periodo) {
    case 'mensual':
      precioElement.textContent = obtenerPrecio(plan, 'mensual');
      periodoElement.textContent = '/mes';
      break;
    case 'trimestral':
      precioElement.textContent = obtenerPrecio(plan, 'trimestral');
      periodoElement.textContent = '/3 meses';
      break;
    case 'semestral':
      precioElement.textContent = obtenerPrecio(plan, 'semestral');
      periodoElement.textContent = '/6 meses';
      break;
  }
}

// Función para obtener el precio según el plan y el período
function obtenerPrecio(plan, periodo) {
  // Define los precios según el plan y el período seleccionado
  const precios = {
    pequeno: {
      mensual: '2.90',
      trimestral: '7.90',
      semestral: '15.90'
    },
    intermedio: {
      mensual: '5.90',
      trimestral: '10.00',
      semestral: '18.90'
    },
    premium: {
      mensual: '7.90',
      trimestral: '12.90',
      semestral: '20.00'
    }
  };

  return precios[plan][periodo];
}
