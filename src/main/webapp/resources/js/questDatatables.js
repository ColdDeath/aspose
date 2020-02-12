var ajaxUrl = "rest/admin/quests/";
var ajaxDeleteUrl = ajaxUrl + "entire/"
var datatableApi;

$(document).ready(function() {
    $(window).keydown(function(event){
        if(event.keyCode == 13) {
            event.preventDefault();
            return false;
        }
    });
});

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function enable(chkbox, id) {
    var enabled = chkbox.is(":checked");
    $.ajax({
        url: ajaxUrl + id,
        type: 'POST',
        data: 'isActive=' + enabled,
        success: function () {
            successNoty(enabled ? 'common.enabled' : 'common.disabled');
        },
        error: function () {
            chkbox.prop('checked',false)
        }
    });
}

$.ajaxSetup({
    converters: {
        "text json": function (stringData) {
            var json = JSON.parse(stringData);
            $(json).each(function () {
                this.createDate = this.createDate.replace('T', ' ').substr(0, 16);
            });
            return json;
        }
    }
});

function renderEditBtnWithLink(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-primary" onclick="location.href=\'admin/quest?id=' + row.id + '\'">' +
            '<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>';
    }
}

// $(document).ready(function () {
$(function () {
    datatableApi = $('#datatable').DataTable(extendsOpts({
        "columns": [
            {
                "data": "name"
            },
            {
                "data": "isActive",
                "render": function (data, type, row) {
                    if (type == 'display') {
                        return '<div class="pretty p-default"><input type="checkbox" ' + (data ? 'checked' : '') + ' onclick="enable($(this),' + row.id + ');"/><div class="state p-success"><label>&nbsp</label></div></div>';
                    }
                    return data;
                }
            },
            {
                "data": "createDate"
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderEditBtnWithLink
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderDeleteBtn
            }
        ],
        "order": [
            [
                1,
                "desc"
            ],
            [
                2,
                "desc"
            ]
        ]
    }));
});