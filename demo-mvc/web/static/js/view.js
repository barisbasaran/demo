let clientId = new URLSearchParams(window.location.search).get('clientId');
$(document).ready(function () {
    $.ajax({
        url: '/service/clients/' + clientId,
        type: "GET",
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            $('#client-name').html(data.name);
            $('#client-email').html(data.email);
        },
        error: function(xhr, status, error) {
            alert(xhr.responseText);
        }
    });
});
