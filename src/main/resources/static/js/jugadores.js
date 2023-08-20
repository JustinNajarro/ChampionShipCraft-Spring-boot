let equipoIdToDelete = null;
let jugadorIdToDelete = null;

function submitForm(equipoId, jugadorId) {
    equipoIdToDelete = equipoId;
    jugadorIdToDelete = jugadorId;
    console.log('Jugador ID a eliminar:', jugadorIdToDelete);
    $('#confirmDeleteModal').modal('show');
}

function confirmAndDelete() {
    console.log('Jugador ID a eliminar (desde confirmAndDelete):', jugadorIdToDelete);
    if (equipoIdToDelete !== null && jugadorIdToDelete !== null) {
        const form = document.getElementById('deleteForm');
        form.querySelector('#idEquipo').value = equipoIdToDelete;
        form.querySelector('[name="idJugador"]').value = jugadorIdToDelete;
        form.submit();
    }
}
$(document).ready(function() {
    $(".actualizar-jugador").click(function() {
        var idJugador = $(this).data("idjugador");
        var idEquipo = $(this).data("idequipo");
        $("#idJugador").val(idJugador);
        $("#idEquipo").val(idEquipo);
    });
});