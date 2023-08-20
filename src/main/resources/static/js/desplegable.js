// Agrega evento de clic al botón de navegación "Torneos"
document.getElementById("torneos-btn").addEventListener("click", function(e) {
  e.preventDefault(); // Evita la acción predeterminada del enlace
  var dropdown = document.getElementById("torneos-dropdown");
  var equiposDropdown = document.getElementById("equipos-dropdown");
  if (dropdown.style.display === "block") {
    dropdown.style.display = "none";
  } else {
    dropdown.style.display = "block";
    equiposDropdown.style.display = "none";
  }
});

// Agrega evento de clic al botón de navegación "Equipos"
document.getElementById("equipos-btn").addEventListener("click", function(e) {
  e.preventDefault(); // Evita la acción predeterminada del enlace
  var dropdown = document.getElementById("equipos-dropdown");
  var torneosDropdown = document.getElementById("torneos-dropdown");
  if (dropdown.style.display === "block") {
    dropdown.style.display = "none";
  } else {
    dropdown.style.display = "block";
    torneosDropdown.style.display = "none";
  }
});

