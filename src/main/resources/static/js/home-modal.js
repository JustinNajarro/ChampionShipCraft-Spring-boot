const openModals = document.querySelectorAll('.plan-enlace');
const modal = document.querySelector('.modal');
const submit = document.querySelector('.modal-submit-btn');
const closeModal = document.querySelector('.modal-close-btn');

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

  


  function totalCalculate() {
    const selectedPlanTorneo = document.querySelector('input[name="plan-torneo"]:checked');
    const selectedPlanMes = document.querySelector('input[name="plan-mes"]:checked');
    var priceInput = document.getElementById("price");
   
    if (selectedPlanTorneo && selectedPlanMes) {
        const precios = {
            "pequeno-mensual": 2.90,
            "pequeno-trimestral": 5.90,
            "pequeno-semestral": 7.90,
            "intermedio-mensual": 7.90,
            "intermedio-trimestral": 10.00,
            "intermedio-semestral": 12.90,
            "premium-mensual": 15.90,
            "premium-trimestral": 18.90,
            "premium-semestral": 20.00,
        };

        const key = selectedPlanTorneo.value + "-" + selectedPlanMes.value;
        const total = precios[key] || 0;
		document.getElementById('total-price').textContent = '$ ' + total.toFixed(2);
		priceInput.value = total;
    }   
}


