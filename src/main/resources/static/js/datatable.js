$(document).ready( function () {
    var table = $('#employeesTable').DataTable({
        "sAjaxSource": "/users",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "id"},
            { "mData": "name" },
            { "mData": "lastName" },
            { "mData": "email" },
            { "mData": "balans" },
            { "mData": "active" }
        ]
    })
});