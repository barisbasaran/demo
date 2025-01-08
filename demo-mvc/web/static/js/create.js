$(document).ready(function(){
    $("#submit").on('click', function(){
        $.ajax({
            url: '/service/clients',
            type : "POST",
            dataType : 'json',
            data: JSON.stringify({
                name: $("#name").val(),
                email: $("#email").val()
            }),
            contentType: 'application/json;charset=UTF-8',
            success: function(data) {
                window.location.href = "/";
            },
            error: function(xhr, status, error) {
                alert(xhr.responseText);
            }
        })
    });
});
