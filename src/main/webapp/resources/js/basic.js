$(function() {
    "use strict";
    // Эффекты MDB при появлении
    new WOW().init();

    // Боковая панель меню
    $(".button-collapse").sideNav();

    // Привязка к верхнему краю документа
    /*$(".sticky-content").sticky({
      topSpacing: 0,
      minWidth: 992,
      stopper: "#footer",
    });*/

    // Получаем данные для отображения слева в меню
    getMenuPils('rest/profile/docs/inwork', '.inWorkSum');
    getMenuPils('rest/profile/docs/agreement', '.agreementSum');
    getMenuPils('rest/profile/docs/distribution', '.distributionSum');

    // Крутой селект
    //$('.mdb-select').materialSelect();
    $(".chosen-select").chosen({
        width: "100%",
        no_results_text: "Ничего не найдено!"
    });

    // Всплывающие подсказки
    //$('[data-toggle="tooltip"]').tooltip();

    // Добавить блок
    /*$(document).on("click", ".addGroup", function() {
        var linksOld = parseInt($("#newBlockGroup [data-block='1']").length);
        linksOld = linksOld + 1;
        var links = $(".blockGroup:last").attr('id');
        links = parseInt(links.substr(10));
        var links1 = links + 1;
        var asd = $("#selectType").val();
        var newField = getDownFields("rest/profile/doctypes/" + asd + "/fields", '', links1, '', linksOld);
        $('#newBlockGroup').append(newField);
        //window.location.hash = 'blockGroup'+links1;
        //window.location.href;
    });*/

    $(document).on("click", ".addBlock", function() {
        var id = $(this).attr('data-group');
        var idBlock = '#blockDiv'+id+' .blockField';
        //alert(idBlock);
        var linksOld = parseInt($(idBlock+" .blockGroup [data-block='1']").length);
        var pole = $(this).attr('data-value');
        linksOld = linksOld + 1;
        // Найдем максимальное значение атрибута
        var links = null;
        $(idBlock+" .blockGroup").each(function() {
            var value = parseInt($(this).attr('data-move'));
            links = (value > links) ? value : links;
        });
        links = links+1;
        //alert(links);
        //var links = $(idBlock+" .blockGroup:last").attr('data-field');
        //links = parseInt(links);
        //var links1 = links + 1;
        //var newBlock = '#blockDiv'+id+'_'+links1+' .blockField';
        var asd = $("#selectType").val();
        groupNewFields(idBlock, id, links, '', linksOld, '');
        var docId = getId();
        if(docId > 0) {
            getStack ('rest/profile/docs/'+docId, pole, links, '', docId);
        } else {
            getStack ('rest/profile/doctypes/'+asd+'/fields', pole, links, '', '');
            console.log('rest/profile/doctypes/'+asd+'/fields', pole, links, '', '');
        }
        //window.location.hash = 'blockGroup'+links1;
        //window.location.href;
    });

    $(document).on("click", ".addBlockNew", function() {
        var id = $(this).attr('data-group');
        var idBlock = '#blockDivNew'+id+' .blockField';
        //alert(idBlock);
        var linksOld = parseInt($(idBlock+" .blockGroupNew [data-block='2']").length);
        var pole = $(this).attr('data-value');
        linksOld = linksOld + 1;
        // Найдем максимальное значение атрибута
        var links = null;
        $(idBlock+" .blockGroupNew").each(function() {
            var value = parseInt($(this).attr('data-move'));
            links = (value > links) ? value : links;
        });
        links = links+1;
        //alert(links);
        var asd = $("#selectTypeNew").val();
        //console.log(idBlock, id, links, '', linksOld, 1);
        groupNewFields(idBlock, id, links, '', linksOld, 1);
        getStack ("rest/profile/doctypes/" + asd + "/fields", pole, links, 1);
    });

    // Добавить пользователя
    $(document).on("click", ".addUser", function() {
        //var links = $('[data-user="1"]').length;
        var links = $(".blockUser:last").attr('id');
        links = parseInt(links.substr(9));
        var links1 = links + 1;
        var fieldUser = '#userList'+links1;
        $('#userListBlock').append('' +
            '<div class="col-12 blockUser" id="blockUser'+links1+'">' +
            '   <div class="row d-flex align-items-center justify-content-center fontSmall userListBlock" data-user="1">' +
            '       <div class="col-md-1">'+links1+'</div>' +
            '       <div class="col-md-1"><i class="fas fa-user"></i></div>' +
            '       <div class="col-md-8 selectUser">' +
            '           <select data-placeholder="Выберите из справочника" class="chosen-select userList" data-spisok="'+links1+'" id="userList'+links1+'" name="userList[]" required>' +
            '               <option value="">Выбрать</option>' +
            '           </select>' +
            '           <div class="fontSmall text-left" id="userListPost'+links1+'"></div>' +
            '       </div>' +
            '       <div class="col-md-2">' +
            '           <div id="delUser'+links1+'" class="btn btn-danger btn-sm pointer delUser rounded px-3" title="Удалить пользователя">' +
            '               <i class="fas fa-trash"></i>' +
            '           </div>' +
            '       </div>' +
            '    </div>' +
            '</div>');
        $('#blockUser'+links1+' select').chosen({
            width: "100%",
            no_results_text: "Ничего не найдено!"
        });
        var newField = createOptions ('rest/profile/users/', fieldUser, '', 'id', '', 'usersList');
        $('#userList'+links1).append(newField);
    });

    $(document).on("click", ".addUserNew", function() {
        //var links = $('[data-user="1"]').length;
        var links = $(".blockUserNew:last").attr('id');
        links = parseInt(links.substr(12));
        var links1 = links + 1;
        var fieldUser = '#userListNew'+links1;
        $('#userListBlockNew').append('' +
            '<div class="col-12 blockUserNew" id="blockUserNew'+links1+'">' +
            '   <div class="row d-flex align-items-center justify-content-center fontSmall userListBlockNew" data-user="1">' +
            '     <div class="col-md-1">'+links1+'</div>' +
            '     <div class="col-md-1"><i class="fas fa-user"></i></div>' +
            '     <div class="col-md-8 selectUser">' +
            '         <select data-placeholder="Выберите из справочника" class="chosen-select userListNew" data-spisok="'+links1+'" id="userListNew'+links1+'" name="userListNew[]" required>' +
            '             <option value="">Выбрать</option>' +
            '         </select>' +
            '         <div class="fontSmall text-left" id="userListPostNew'+links1+'"></div>' +
            '     </div>' +
            '     <div class="col-md-2">' +
            '         <div id="delUserNew'+links1+'" class="btn btn-danger btn-sm pointer delUser rounded px-3" title="Удалить пользователя">' +
            '             <i class="fas fa-trash"></i>' +
            '         </div>' +
            '     </div>' +
            '   </div>' +
            '</div>');
        $('#blockUserNew'+links1+' select').chosen({
            width: "100%",
            no_results_text: "Ничего не найдено!"
        });
        var newField = createOptions ('rest/profile/users/', fieldUser, '', 'id', '', 'usersList');
        $('#userListNew'+links1).append(newField);
    });

    // Дублировать блок
    $(document).on("click", ".cloneGroup", function() {
        var linksOld = parseInt($("[data-block='1']").length);
        linksOld = linksOld + 1;
        var id = $(this).attr("id");
        id = id.substr(10);
        var links = $(".blockGroup:last").attr('id');
        links = parseInt(links.substr(10));
        var links1 = links + 1;
        var newField = $('#blockGroup'+id).clone(true);
        //var asd = $("#selectType").val();
        //var newField = getDownFields("rest/profile/doctypes/" + asd + "/fields", '', links1);
        $('#newBlockGroup').append(newField);
        $(".blockGroup:last").attr('id','blockGroup'+links1);
        $('#blockGroup'+links1+' .nameGroup').html('Блок '+linksOld);
        $('#blockGroup'+links1+' .cloneGroup').attr('id', 'cloneGroup'+links1);
        $('#blockGroup'+links1+' .delGroup').attr('id', 'delGroup'+links1);
        $('#blockGroup'+links1).attr('data-field',links1);
        window.location.hash = 'blockGroup'+links1;
        window.location.href;
        // Переписываем INPUTS
        var newInput = $('#blockGroup'+links1).find('input.form-control');
        newInput.each(function() {
            var oldId = $(this).attr('id');
            var oldIdNumber = oldId.substr(10).split( "_", 1);
            var newId = oldId.replace("_"+oldIdNumber+"_","_"+links1+"_");
            $(this).attr({
                'id': newId,
                'name': newId
            });
        });
        // Переписываем поля SELECT
        var newSelect = $('#blockGroup'+links1).find('select');
        newSelect.each(function() {
            var oldId = $(this).attr('id');
            var oldIdNumber = oldId.substr(12).split( "_", 1);
            var newId = oldId.replace("selectField_"+oldIdNumber+"_","selectField_"+links1+"_");
            $(this).attr({
                'id': newId,
                'name': newId
            });
            $('#'+newId).trigger("chosen:updated");
        });
        // Переписываем поля CHOSEN
        var newChosen = $('#blockGroup'+links1).find('div.chosen-container');
        newChosen.each(function() {
            var oldId = $(this).attr('id');
            var oldIdNumber = oldId.substr(12).split( "_", 1);
            var newId = oldId.replace("selectField_"+oldIdNumber+"_","selectField_"+links1+"_");
            $(this).attr('id', newId);
            $('#'+newId).trigger("chosen:updated");
        });
    });

    // Удалить блок
    $(document).on("click", ".delGroup", function() {
        var id = $(this).attr("id");
        id = id.substr(8);
        var blockId = $(this).attr('data-parent');
        $('#btnDeleteBlock').attr({
            'data-delete':'blockGroup'+id,
            'data-block': 'blockDiv'+blockId,
            'block-id': 0
        });
    });

    $(document).on("click", ".delGroupNew", function() {
        var id = $(this).attr("id");
        id = id.substr(11);
        var blockId = $(this).attr('data-parent');
        $('#btnDeleteBlock').attr({
            'data-delete':'blockGroupNew'+id,
            'data-block': 'blockDivNew'+blockId,
            'block-id': 1
        });
    });

    // Удаление блока при нажатии OK в модальном окне
    $(document).on('click', '#btnDeleteBlock', function() {
        var id = $(this).attr('data-delete');
        var blockId = $(this).attr('data-block');
        var idBlock = $(this).attr('block-id');
        $('#deleteBlock').modal('hide');
        // Удаляем нужный блок
        $('#'+blockId+' '+'#'+id).remove();
        // Переименовываем название блоков и атрибуты data-field
        var i = 1;
        if(idBlock == 0) {
            $('#'+blockId+' .blockField .blockGroup').each(function() {
                $(this).attr('data-field', i);
                $('.nameGroup', this).html('Блок '+i);
                i = i+1;
            });
        } else if(idBlock == 1) {
            $('#'+blockId+' .blockField .blockGroupNew').each(function() {
                $(this).attr('data-field', i);
                $('.nameGroupNew', this).html('Блок '+i);
                i = i+1;
            });
        }

    });

    // Удалить пользователя
    $(document).on("click", ".delUser", function() {
        var id = $(this).attr("id");
        id = id.substr(7);
        $('#blockUser' + id).remove();
    });

    $(document).on("click", ".delUserNew", function() {
        var id = $(this).attr("id");
        id = id.substr(9);
        $('#blockUserNew' + id).remove();
    });

    // Отправка файла на сервер
    $(document).on("change", "#inputFile", function() {
        //var filename = $('#inputFile').val();
        //var data = $(this).val();
        var data = new FormData($('.registrationForm')[0]);
        $.ajax({
            type: "POST",
            url: "rest/profile/docs/uploadfile",
            enctype: 'multipart/form-data',
            processData: false, //prevent jQuery from automatically transforming the data into a query string
            contentType: false,
            cache: false,
            timeout: 600000,
            data: data,
            success: function (data) {

            },
            error: function () {
                toastr["error"]("Ошибка сохранения файла!");
            }
        });
    });

    $('#btnLoadPDF').on("click", function(e) {
        e.preventDefault();
        $(".bigLoader").removeClass("d-none").fadeIn(500);
        var data = new FormData($('.registrationForm')[0]);
        $.ajax({
            type: "POST",
            url: "rest/profile/docs/uploadfile",
            enctype: 'multipart/form-data',
            processData: false, //prevent jQuery from automatically transforming the data into a query string
            contentType: false,
            cache: false,
            timeout: 600000,
            data: data,
            success: function (data) {
                var dataFile =  data.fileUrl +".pdf";
                $(".bigLoader").addClass("d-none").fadeOut(1000);
                $('.pdfSRC').attr('src', dataFile);
            },
            error: function () {
                toastr["error"]("Ошибка переформирования файла!");
            }
        });
    });

    // Заполнение данных организации
    $('#btnEgrul').click(function() {
        var searchValue = $('.addElementForm #searchValue').val();
        searchValue = $.trim(searchValue);
        return getValueOrganisation ('rest/profile/organizations/getEGRULData?INN='+searchValue, '.addElementForm');
    });

    // Добавление номера поля в кнопку добавлению организации
    $('#addElement').on('shown.bs.modal', function(event) {
        var catalogNumber = $(event.relatedTarget).attr('data-catalog');
        $('.btnAddElement').attr('data-catalog', catalogNumber);
    });

    // Добавление элемента в список организаций
    $('.btnAddElement').click(function(event) {
        var number = $(this).attr('data-catalog');
        event.preventDefault();
        var forms = $('.addElementForm');
        var formsValue = $('.addElementForm input,.addElementForm textarea,.addElementForm select').filter('[required]');
        var checkField = checkValidation(formsValue);
        if(checkField === false) {
            toastr["error"]("Заполните обязательные поля!");
            event.stopPropagation();
        } else {
            $('.bigFormLoader').removeClass("d-none").fadeIn();
            $('.addElementForm').addClass('d-none');
            // Формируем JSON из полей
            var dataField = {
                "id": null,
                "shortNameLf": $('#shortNameLf').val(),
                "fullNameLf": $('#fullNameLf').val(),
                "shortName": $('#shortName').val(),
                "fullName": $('#fullName').val(),
                "shortLegalForm": $('#shortLegalForm').val(),
                "fullLegalForm": $('#fullLegalForm').val(),
                "normalizedName": $('#normalizedName').val(),
                "ogrn": $('#ogrn').val(),
                "inn": $('#inn').val(),
                "kpp": $('#kpp').val(),
                "address": $('#address').val(),
                "fioManager": $('#fioManager').val(),
                "positionManager": $('#positionManager').val()
            };
            var data = JSON.stringify(dataField);
            //console.log("number - " + number);
            $.ajax({
                type: "POST",
                url: "rest/profile/organizations",
                data: data,
                contentType: 'application/json; charset=utf-8',
                success: function (data) {
                    $(".bigFormLoader, .btnBlock, .addElementForm").addClass("d-none").fadeOut();
                    $('#addElement .modal-body').append('<div class="alert alert-success alertBlock"><i class="fas fa-thumbs-up mr-2 text-success"></i>Успешно! Организация добавлена!</div>');
                    // Получаем id добавленной организации
                    var numberField = data.id;
                    $(number + ' option .active').remove();
                    // Обновляем опции списка организаций
                    createOptions ("rest/profile/organizations/", number, "shortNameLf", "id", numberField, 'organisations');
                    setTimeout(function() {
                        $('#addElement').modal('hide');
                    }, 1000);
                },
                error: function () {
                    $(".bigFormLoader, .btnBlock, .addElementForm").addClass("d-none").fadeOut();
                    $('#addElement .modal-body').append('<div class="alert alert-danger alertBlock"><i class="fas fa-exclamation-triangle mr-2 text-danger"></i>Ошибка! Организация не добавлена!</div>');
                }
            });
        }
    });

    // Очищаем форму при закрытии модального окна
    $('#addElement').on('hidden.bs.modal', function() {
        $('.addElementForm, .btnBlock').removeClass('d-none');
        $('.alertBlock').addClass('d-none');
        $('.addElementForm input, .addElementForm textarea').val('');
    });

    // Отправление запроса в поддержку
    $('#btnHelpBlock').click(function(event) {
        event.preventDefault();
        var forms = $('.addHelpForm');
        var formsValue = $('.addHelpForm input,.addHelpForm textarea,.addHelpForm select').filter('[required]');
        var checkField = checkValidation(formsValue);
        if(checkField === false) {
            toastr["error"]("Заполните обязательные поля!");
            event.stopPropagation();
        } else {
            $('.bigFormLoader').removeClass("d-none").fadeIn();
            $('.addHelpForm, .bigIcon, .btnBlock').addClass('d-none');
            // Формируем JSON из полей
            var dataField = {
                "project": {"id":"0-4"},
                "summary": $('#helpTheme').val(),
                "description": $('#helpDescription').val(),
                "customFields": [
                    {
                        "name":"IP",
                        "$type": "SimpleIssueCustomField",
                        "value": $('#helpIPAddress').val()
                    },
                    {
                        "name":"Логин",
                        "$type": "SimpleIssueCustomField",
                        "value": $('#helpLogin').val()
                    },
                    {
                        "name":"ФИО",
                        "$type": "SimpleIssueCustomField",
                        "value": $('#helpFIO').val()
                    },
                    {
                        "name":"Телефон",
                        "$type": "SimpleIssueCustomField",
                        "value": $('#helpPhone').val()
                    },
                    {
                        "name":"All related emails",
                        "$type": "SimpleIssueCustomField",
                        "value": $('#helpEmail').val()
                    }
                ]
            };
            var data = JSON.stringify(dataField);
            //console.log(data);
            $.ajax({
                type: 'POST',
                url: 'http://neurosystems.net:8080/api/issues',
                headers: {
                    'Authorization' : 'Bearer perm:YWRtaW4=.NDgtMQ==.Q709SlfGBgKLoQEei6wCmpPgtiVime',
                    'Accept' : 'application/json'
                },
                data: data,
                contentType: 'application/json; charset=utf-8',
                success: function () {
                    $(".bigFormLoader, .btnBlock, .addHelpForm").addClass("d-none").fadeOut();
                    $('#helpBlock .modal-body').append('<div class="alert alert-success alertBlock"><i class="fas fa-thumbs-up mr-2 text-success"></i>Успешно! Ваше обращение отправлено!</div>');
                    setTimeout(function() {
                        $('#helpBlock').modal('hide');
                    }, 1500);
                },
                error: function () {
                    $(".bigFormLoader, .btnBlock, .addHelpForm").addClass("d-none").fadeOut();
                    $('#helpBlock .modal-body').append('<div class="alert alert-danger alertBlock"><i class="fas fa-exclamation-triangle mr-2 text-danger"></i>Ошибка! Ваше обращение не отправлено!</div>');
                    setTimeout(function() {
                        $('#helpBlock').modal('hide');
                    }, 3500);
                }
            });
        }
    });

    // Раскрытие и сокрытие полей основного документа
    $(document).on('click', '.btnView', function() {
        $(this).removeClass('btnView').addClass('btnClose');
        $(this).html('<i class="fas fa-minus mr-2"></i>Свернуть');
        $('.blockDocument').removeClass('d-none');
    });
    $(document).on('click', '.btnClose', function() {
        $(this).removeClass('btnClose').addClass('btnView');
        $(this).html('<i class="fas fa-plus mr-2"></i>Развернуть');
        $('.blockDocument').addClass('d-none');
    });

    // Раскрытие и сокрытие полей вторичного документа
    $(document).on('click', '.btnViewNew', function() {
        $(this).removeClass('btnViewNew').addClass('btnCloseNew');
        $(this).html('<i class="fas fa-minus mr-2"></i>Свернуть');
        $('.newDocumentForm').removeClass('d-none');
    });
    $(document).on('click', '.btnCloseNew', function() {
        $(this).removeClass('btnCloseNew').addClass('btnViewNew');
        $(this).html('<i class="fas fa-plus mr-2"></i>Развернуть');
        $('.newDocumentForm').addClass('d-none');
    });

    // Список макетов таблиц
    $(document).on("click", '.tableTemplates',  function(event) {
        event.preventDefault();
        var newEdit = $(this).attr('data-click');
        var tabId = $(this).attr('data-table');
        if(newEdit && newEdit == 1) {
            $('.addTableVal').append('' +
                '<div class="col-12 mt-2 dangerVoid">' +
                '   <div class="alert alert-danger">' +
                '       Внимание! При изменении макета таблицы все введенные данные будут удалены' +
                '   </div>' +
                '</div>');
        }
        $('#addTableSave').attr('data-table', tabId);
        $('#btnAddTable').modal('show');
        createOptions ('rest/profile/htmltables/', '#addTable1001', 'name', 'id', '', '');
    });

    // Превью таблиц по выбору опции
    $('#addTable1001').change(function() {
        $('#tableTemplateView').empty();
        var tableId = $('#addTable1001').val();
        if(tableId > 0) {
            getTablesFields('rest/profile/htmltables/'+tableId, '#tableTemplateView');
            $('#tableTemplateView table').addClass('table table-sm table-bordered').attr('width', '100%');
            $('#tableTemplateView table th').css({
                'text-align': 'center',
                'vertical-align': 'middle',
                'font-weight': 'bold'
            });
            $('#tableTemplateView table tbody tr:first td').css('text-align', 'center');
            $('#tableTemplateView table tbody tr').each(function() {
                $('td:first', this).css('text-align', 'center');
            });
        }
    });

    // Убираем превью макета таблицы при закрытии модального окна
    $('#btnAddTable').on('hidden.bs.modal', function () {
        $('#tableTemplateView, .dangerVoid').empty();
        $('#addTable1001').val('').empty().html('' +
            '<div class="col-12 mb-3">' +
            '   <select data-placeholder="Выберите из справочника" class="chosen-select addTable1001" id="addTable1001" name="addTable1001" required>' +
            '       <option value="">Выберите из справочника</option>' +
            '   </select>' +
            '</div>');
    });

    // Добавляем таблицу
    $('#addTableSave').click(function(event) {
        event.preventDefault();
        var tabId = $(this).attr('data-table');
        var newTabField = '#catalogTables'+tabId;
        $('#tableTemplateView, .dangerVoid').empty();
        $(newTabField+' .newTable .editTable').remove();
        $(newTabField+' .newTable .addTableRow').remove();
        var tableId = $('#addTable1001').val();
        $(newTabField).attr('data-value', tableId);
        $('#addTable1001').empty().html('' +
            '<div class="col-12 mb-3">' +
            '   <select data-placeholder="Выберите из справочника" class="chosen-select addTable1001" id="addTable1001" name="addTable1001" required>' +
            '       <option value="">Выберите из справочника</option>' +
            '   </select>' +
            '</div>');
        $('#btnAddTable').modal('hide');
        $(newTabField+' .tableTemplates').html('Изменить макет таблицы').attr('data-click', 1);
        if(tableId > 0) {
            $(newTabField+' .col-md-3').remove();
            $(newTabField+' .newTable').removeClass('col-md-9').addClass('col-md-12');
            getTablesFields('rest/profile/htmltables/' + tableId, newTabField+' .newTable');
            $(newTabField+' .newTable table').addClass('table table-sm table-bordered table-editable table-hover').attr('width', '100%');
            var sumTop = parseInt($(newTabField+' .newTable table tbody tr:first td:last').html());
            sumTop = sumTop+1;
            if($(newTabField+' .newTable table thead').hasClass('noNumber')) {
                $(newTabField+' .newTable table tbody tr:first').append(
                    '<td class="deleteElem">' +
                    '   <div class="btn btn-sm btn-danger table-remove rounded px-3 my-0">' +
                    '       <i class="fas fa-trash"></i>' +
                    '   </div>' +
                    '</td>'
                );
            } else {
                $(newTabField+' .newTable table tbody tr:first').append('<td class="text-center deleteElem">'+sumTop+'</td>');
                $(newTabField+' .newTable table tbody tr:first td').css('text-align', 'center');
            }
            $(newTabField+' .newTable table thead tr:first').append('<th class="text-center deleteElem" rowspan="2">Удалить</th>');
            $(newTabField+' .newTable table tbody tr:not(:first)').append(
                '<td class="deleteElem">' +
                '   <div class="btn btn-sm btn-danger table-remove rounded px-3 my-0">' +
                '       <i class="fas fa-trash"></i>' +
                '   </div>' +
                '</td>'
            );
            $(newTabField+' .newTable').append('' +
                '<div class="row addTableRow">' +
                '   <div class="col-12 text-right">' +
                '       <div class="btn btn-primary btn-sm rounded addTableRow" data-table="'+tabId+'">' +
                '           <i class="fas fa-plus white-text mr-2"></i>Добавить строку' +
                '       </div>' +
                '   </div>' +
                '</div>'
            );
        }
        // Делаем столбцы редактируемыми
        $(newTabField+' .newTable table th').css({
            'text-align': 'center',
            'vertical-align': 'middle',
            'font-weight': 'bold'
        });
        $(newTabField+' .newTable table td').attr('contenteditable', true);
        //$(newTabField+' .newTable table tbody tr:first td').css('text-align', 'center');
        $(newTabField+' .newTable table tbody tr').each(function() {
            $('td:first', this).css('text-align', 'center');
        });
    });

    // Добавляем строку
    $(document).on('click', '.addTableRow', function() {
        var tabId = $(this).attr('data-table');
        $('#catalogTables'+tabId+' .newTable table').find('tbody tr:last').clone().appendTo('#catalogTables'+tabId+' .newTable table').find('td:not(:last)').html('&nbsp;');
    });

    // Удаляем строку
    $(document).on('click', '.table-remove', function() {
        $(this).parents('tr').detach();
    });

});