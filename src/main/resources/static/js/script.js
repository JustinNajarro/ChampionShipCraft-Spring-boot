function mostrarRegistroFormulario() {
	var loginContent = document.getElementById("loginContent");
    var registroContent = document.getElementById("registroContent");
    loginContent.style.display = "none";
    registroContent.style.display = "block";
}

function mostrarLoginFormulario() {
    var loginContent = document.getElementById("loginContent");
    var registroContent = document.getElementById("registroContent");
    loginContent.style.display = "block";
    registroContent.style.display = "none";
}