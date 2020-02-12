var failedNote;

function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function warningNoty(key) {
    new Noty({
        text: "<span class='fa fa-lg fa-exclamation-triangle'></span> &nbsp;" + i18n[key],
        type: 'warning',
        layout: 'bottomRight',
        timeout: 4000
    }).show();
}

function successNoty(key) {
    new Noty({
        text: "<span class='fa fa-lg fa-check'></span> &nbsp;" + i18n[key],
        type: 'success',
        layout: 'bottomRight',
        timeout: 4000
    }).show();
}

function errorNoty(key) {
    new Noty({
        text: "<span class='fa fa-lg fa-exclamation-circle'></span> &nbsp;" + i18n[key],
        type: 'error',
        layout: 'bottomRight',
        timeout: 4000
    }).show();
}

function failNoty(jqXHR) {
    closeNoty();
    // https://stackoverflow.com/questions/48229776
    var errorInfo = JSON.parse(jqXHR.responseText);
    failedNote = new Noty({
        text: "<span class='fa fa-lg fa-exclamation-circle'></span> &nbsp;" + errorInfo.typeMessage + "<br>" + errorInfo.details.join("<br>"),
        type: "error",
        layout: "bottomRight",
        timeout: 4000
    }).show();
}