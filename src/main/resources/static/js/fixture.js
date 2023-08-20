function obtenerEncuentrosPorJornada(jornadaId, callback) {
        fetch('/encuentros?idJornada=' + jornadaId)
            .then(response => response.json())
            .then(encuentros => callback(encuentros))
            .catch(error => console.error('Error al obtener los encuentros:', error));
    }
function actualizarVistaEncuentros(jornadaId) {
        obtenerEncuentrosPorJornada(jornadaId, function(encuentros) {
            var encuentrosBody = document.getElementById('encuentrosBody');
            encuentrosBody.innerHTML = '';

            // Mostrar los encuentros en la tabla
            encuentros.forEach(function(encuentro) {
                var row = document.createElement('tr');
                var equipoLocalCell = document.createElement('td');
                var equipoVisitaCell = document.createElement('td');
                var estadoCell = document.createElement('td');
                var golesLocalCell = document.createElement('td');
                var golesVisitaCell = document.createElement('td');
                var golesLocaldata = document.createElement('input');
                var golesVisitadata = document.createElement('input');
                var fechaCell = document.createElement('td');
                var fechaData = document.createElement('input');
                var guardarResultado = document.createElement('td');
                var guardarResultadodata = document.createElement('button');
                var guardarFecha = document.createElement('td');
                var guardarFechaData = document.createElement('button');

                equipoLocalCell.textContent = encuentro.equipoLocal;
                equipoVisitaCell.textContent = encuentro.equipoVisita;
                estadoCell.textContent = encuentro.estado;
                golesLocalCell.appendChild(golesLocaldata);
                golesVisitaCell.appendChild(golesVisitadata);

                
             // Agregar la clase text-center a las celdas
                equipoLocalCell.classList.add('text-center');
                equipoVisitaCell.classList.add('text-center');
                estadoCell.classList.add('text-center'); // Agrega la clase para centrar el contenido
                golesLocalCell.classList.add('text-center'); // Agrega la clase para centrar el contenido
                golesVisitaCell.classList.add('text-center'); // Agrega la clase para centrar el contenido
                guardarResultado.classList.add('text-center'); // Agrega la clase para centrar el contenido
                guardarFecha.classList.add('text-center');
                fechaCell.classList.add('text-center');


                golesLocaldata.type = "number";
                golesVisitadata.type = "number";
                fechaData.type = "datetime-local";

                var fechaEncuentroFormateada = encuentro.fechaEncuentro;

                golesLocaldata.min = "0";
                golesVisitadata.min = "0";

                golesLocaldata.value = encuentro.golesLocal;
                golesVisitadata.value = encuentro.golesVisita;
                fechaData.value = fechaEncuentroFormateada;

                fechaCell.appendChild(fechaData);


                guardarResultadodata.textContent = "Guardar Encuentro";
                guardarResultadodata.classList.add("guardar-resultado"); // Agrega la clase para el evento click
                guardarResultadodata.setAttribute("data-id", encuentro.idEncuentro);

                guardarFechaData.textContent = "Modificar Fecha";
                guardarFechaData.classList.add("modificar-fecha");
                guardarFechaData.setAttribute("data-id", encuentro.idEncuentro);



                guardarResultadodata.addEventListener('click', function() {
                    var encuentroId = this.getAttribute('data-id');
                    var golesLocal = golesLocaldata.value;
                    var golesVisita = golesVisitadata.value;

                    var data = {
                        idEncuentro: encuentroId,
                        golesLocal: golesLocal,
                        golesVisita: golesVisita
                    };

                    fetch('/actualizar-goles-y-estado', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(data)
                    })
                    .then(response => {
                        if (response.ok) {
                            // Actualizar la vista después de guardar los resultados
                            actualizarVistaEncuentros(jornadaId);
                        } else {
                            console.error('Error al guardar el resultado');
                        }
                    })
                    .catch(error => console.error('Error en la solicitud:', error));
                });

                guardarFechaData.addEventListener('click', function() {
                    var encuentroId = this.getAttribute('data-id');
                    var fechaEncuentro = fechaData.value;


                    var data = {
                        idEncuentro: encuentroId,
                        fechaEncuentro : fechaEncuentro
                    };

                    fetch('/actualizar-fecha', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(data)
                    })
                    .then(response => {
                        if (response.ok) {

                            actualizarVistaEncuentros(jornadaId);
                        } else {
                            console.error('Error al guardar el resultado');
                        }
                    })
                    .catch(error => console.error('Error en la solicitud:', error));
                });

                row.appendChild(equipoLocalCell);
                row.appendChild(equipoVisitaCell);
                row.appendChild(golesLocalCell);
                row.appendChild(golesVisitaCell);
                guardarResultado.appendChild(guardarResultadodata);
                guardarFecha.appendChild(guardarFechaData);
                row.appendChild(fechaCell);
                row.appendChild(estadoCell);
                row.appendChild(guardarResultado);
                row.appendChild(guardarFecha);

                encuentrosBody.appendChild(row);
            });
        });
    }
    document.getElementById('jornadaSelect').addEventListener('change', function() {
        var jornadaId = this.value;
        actualizarVistaEncuentros(jornadaId);
    });