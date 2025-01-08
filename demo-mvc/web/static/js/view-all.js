$(document).ready(function () {
    $.ajax({
        url: '/service/clients',
        type: "GET",
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            let table = $('#clients-table').DataTable();
            for (let i = 0; i < data.length; i++) {
                table.row.add([
                    data[i].name,
                    data[i].email,
                    '<a href="/view.html?clientId=' + data[i].id + '">View</a>'
                ]).draw(false);
            }
        },
        error: function(xhr, status, error) {
            alert(xhr.responseText);
        }
    });
});
