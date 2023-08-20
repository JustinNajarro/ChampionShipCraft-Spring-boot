const openModals = document.querySelectorAll('.btn-action-delete');
const modal = document.querySelector('.torneoModal');
const closeModal = document.querySelector('.btn-secondary');

openModals.forEach((openModal) => {
  openModal.addEventListener('click', (e) => {
    e.preventDefault();
    modal.classList.add('modal-show');
  });
});
closeModal.addEventListener('click', (e) => {
  e.preventDefault();
  modal.classList.remove('modal-show');
});

$(document).ready(function() {
  var deleteButtons = $('.btn-action-delete');

  deleteButtons.on('click', function() {
    var id = $(this).closest('tr').find('input[name="id"]').val(); // Get the 'id' value from the hidden input field
    $('#torneoId').val(id); // Set the 'id' value to the hidden input field in the modal form
    $('#torneoModal').modal('show');
  });
});


