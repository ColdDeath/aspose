var error = getUrlVar("error");

function errorNoty(key) {
    new Noty({
        text: "<span class='fa fa-lg fa-exclamation-circle'></span> &nbsp;" + key,
        type: 'error',
        layout: 'bottomRight',
        timeout: 4000
    }).show();
}

if (error) {
    errorNoty('Неверные логин и пароль');
}
