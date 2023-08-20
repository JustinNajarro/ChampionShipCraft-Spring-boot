// Obtener el modal
var modal = document.getElementById("myModal");

// Obtener el botón que abre el modal
var btnAbrirModal = document.getElementById("btnRegistrar");

// Obtener el botón de cierre del modal
var btnCerrarModal = document.getElementsByClassName("close")[0];

// Obtener el botón de confirmación dentro del modal
var btnConfirmarRegistro = document.getElementById("confirmarRegistro");

// Obtener el formulario
var form = document.querySelector("form");

// Cuando se haga clic en el botón de registro
btnAbrirModal.onclick = function(event) {
  // Verificar la validez del formulario
  if (form.checkValidity()) {
    // Mostrar el modal
    modal.style.display = "block";
  }
  // Evitar el envío automático del formulario
  event.preventDefault();
};

// Cuando se haga clic en el botón de cierre del modal, ocultarlo
btnCerrarModal.onclick = function() {
  modal.style.display = "none";
};

// Cuando se haga clic en el botón de confirmación dentro del modal, enviar el formulario
btnConfirmarRegistro.onclick = function() {
  // Enviar el formulario
  form.submit();
};

// Agregar un listener para detectar clics fuera del modal y cerrarlo si es necesario
window.addEventListener("click", function(event) {
  if (event.target === modal) {
    modal.style.display = "none";
  }
});

