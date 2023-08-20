function mostrarSeccion() {
        var tipoSeleccion = document.getElementById("tipoSeleccion").value;
            var registrarJugadores = document.getElementById("registrarJugadores");
            var listarJugadores = document.getElementById("listarJugadores");

            if (tipoSeleccion === "jugadores") {
                registrarJugadores.style.display = "block";
                listarJugadores.style.display = "none";
            } else {
                registrarJugadores.style.display = "none";
                listarJugadores.style.display = "block";
            }
    }