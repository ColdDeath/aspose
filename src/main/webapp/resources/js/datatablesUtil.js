var form;

function makeEditable() {
    form = $('#detailsForm');
    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(jqXHR);
    });

    // solve problem with cache in IE: https://stackoverflow.com/a/4303862/548473
    $.ajaxSetup({cache: false});

    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });

}

// https://api.jquery.com/jquery.extend/#jQuery-extend-deep-target-object1-objectN
function extendsOpts(opts) {
    $.extend(true, opts,
        {
            "ajax": {
                "url": ajaxUrl,
                "dataSrc": ""
            },
            "paging": true,
            "displayLength": 25,
            "info": true,
            "language": {
                "search": i18n["common.search"],
                "info": i18n["common.searchInfo"],
                "paginate": {
                    "first": i18n["common.searchFirst"],
                    "next": i18n["common.searchNext"],
                    "previous": i18n["common.searchPrevious"],
                    "last": i18n["common.searchLast"]
                },
                "infoFiltered": i18n["common.searchInfoFiltered"],
                "zeroRecords": i18n["common.searchZeroRecords"],
                "infoEmpty": i18n["common.searchInfoEmpty"],
                "lengthMenu": i18n["common.searchLengthMenu"]
            },
            "initComplete": makeEditable
        }
    );
    return opts;
}

function add(title) {
    $('#modalTitle').html("<span class='fa fa-lg fa-plus'></span> &nbsp;" + title);
    form.find(":input").val("");
    $('#editRow').modal();
}

function updateRow(id) {
    $("#modalTitle").html(i18n["editTitle"]);
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}


function formatDate(date) {
    return date.replace('T', ' ').substr(0, 16);
}

function showConfirmDialog(title, text, okFunction) {
    $('#modalTitleDialog').html("<span class='fa fa-lg fa-exclamation-triangle'></span> &nbsp;" + title);
    $('#dialog p').text(text)
    $('#dialog .btn.btn-primary')[0].setAttribute("onclick", okFunction);
    $('#dialog').modal();
}

function deleteRow(id) {
    var func = "deleteRowConfirmed(" + id + ")";
    showConfirmDialog(i18n['common.deletingConfirm'], i18n['common.confirmDelete'], func);
}

function deleteRowConfirmed(id) {
    $.ajax({
        url: ajaxDeleteUrl + id,
        type: 'DELETE',
        success: function () {
            $("#dialog").modal("hide");
            updateTable();
            successNoty('common.deleted');
        }
    });
}

function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}

function save() {
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: JSON.stringify(form.serializeObject()),
        contentType: "application/json; charset=utf-8"
    }).done(function () {
        $("#editRow").modal("hide");
        updateTable();
        successNoty("common.saved");
    });
}

function renderEditBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-primary" onclick="updateRow(' + row.id + ');">' +
            '<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>';
    }
}

function renderDeleteBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-danger" onclick="deleteRow(' + row.id + ');">'+
            '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>';
    }
}
