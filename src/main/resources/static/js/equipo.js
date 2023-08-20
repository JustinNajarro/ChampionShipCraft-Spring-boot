let equipoIdToDelete = null;

function submitForm(idEquipo) {
    equipoIdToDelete = idEquipo;
    console.log('Equipo ID a eliminar:', equipoIdToDelete);
    $('#confirmDeleteModal').modal('show');
}

function confirmAndDelete() {
    console.log('Equipo ID a eliminar (desde confirmAndDelete):', equipoIdToDelete);
    if (equipoIdToDelete !== null) {
        const formId = 'deleteForm-' + equipoIdToDelete;
        document.getElementById(formId).submit();
    }
}