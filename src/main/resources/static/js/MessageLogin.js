document.addEventListener('DOMContentLoaded', function() {
    var errorMessage = document.getElementById('error-message');
    var logoutMessage = document.getElementById('logout-message');

    if (errorMessage && errorMessage.dataset.show === "true") {
        document.getElementById('popup-message').style.display = 'block';
    }

    if (logoutMessage && logoutMessage.dataset.show === "true") {
        document.getElementById('popup-message').style.display = 'block';
    }
});

function closePopup(messageId) {
    var message = document.getElementById(messageId);

    if (message) {
        message.style.display = 'none';
    }
}
