var ajaxUrl = "rest/profile/quests/";
var ajaxDeleteUrl = ajaxUrl + "entire/"
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

$.ajaxSetup({
    converters: {
        "text json": function (stringData) {
            var json = JSON.parse(stringData);
            $(json).each(function () {
                if (this.answerStart != null) {
                    this.answerStart = this.answerStart.replace('T', ' ').substr(0, 16);
                }
                else
                {
                    this.answerStart = null;
                }
                if (this.answerModified != null) {
                    this.answerModified = this.answerModified.replace('T', ' ').substr(0, 16);

                }
                else
                {
                    this.answerModified = null;
                }
            });
            return json;
        }
    }
});

function renderEditBtnWithLink(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-success btn-circle btn-xl" onclick="location.href=\'my-quest?id=' + row.id + '\'">' +
            '<span class="fa fa-2x fa-pencil faa-horizontal animated" aria-hidden="true"></span></a>';
    }
}

// $(document).ready(function () {
$(function () {
    datatableApi = $('#datatable').DataTable(extendsOpts({
        "columns": [
            {
                "data": "status",
                "render": function (data, type, row) {
                    if (type == 'display') {
                        return '<span class="fa fa-lg ' + (data === 'COMPLETED' ? 'fa-check">&nbsp' + i18n["common.yes-small"] : (data === 'INPROCESS' ? 'fa-pause">&nbsp' + i18n["common.in-process-small"] : 'fa-question-circle">&nbsp' + i18n["common.no-small"])) + '</span>';
                    }
                    return data;
                }
            },
            {
                "data": "name"
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderEditBtnWithLink
            }
        ],
        "order": [
            [
                2,
                "desc"
            ],
            [
                0,
                "asc"
            ]
        ],
        "createdRow": function (row, data, dataIndex) {
            if (data.status === 'COMPLETED' || !data.isActive) {
                $(row).addClass("disactive");
                $(row).find('a').attr('disabled', true);
                $(row).find('a').removeAttr('onclick');
                $(row).find('span').removeClass("animated");
                $(row).find('span').removeClass("faa-tada");
            }
        }
    }));
});