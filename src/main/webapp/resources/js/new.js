$(function() {
  "use strict";
  // Эффекты MDB при появлении
  new WOW().init();

  // Боковая панель меню
  $(".button-collapse").sideNav();

  // Добавление полей формы
  $('.mdb-select').materialSelect();
  
  // Привязка к верхнему краю документа
  $(".sticky-content").sticky({
    topSpacing: 0,
    minWidth: 992,
    stopper: "#footer",
  });

  // Добавить вопрос, получателя
  $('.addQuestion').click(function(){
    var links = $("[req='true']").length;
    var links1 = links + 1;
    $('#blockQuestion').clone(true).attr('id', 'blockQuestion' + links).appendTo('.marginBlock');
    // Узнаем и изменим название атрибута у старого поля SELECT для создаваемых полей
    var newSelect = $('#blockQuestion .mdb-select ul').attr('id');
    var newSelect1 = newSelect + links1;
    // Заменим id и атрибуты полей создаваемых SELECT, удалим у них активные классы
    $('#blockQuestion' + links + ' .mdb-select ul').attr('id', newSelect1).removeClass('active');
    $('#blockQuestion' + links + ' .mdb-select .select-dropdown').attr('data-activates', newSelect1).removeClass('active');
    // Добавляем к id полей номер добавляемого вопроса
    $('#blockQuestion' + links + ' #nameQuestion').attr('id', 'nameQuestion' + links);
    $('#blockQuestion' + links + ' #delQuestion').attr('id', 'delQuestion' + links);
    $('#blockQuestion' + links + ' #selectTheme').attr('id', 'selectTheme' + links);
    $('#blockQuestion' + links + ' #selectOrganisation').attr('id', 'selectOrganisation' + links);
    $('#blockQuestion' + links + ' #selectCrucial').attr('id', 'selectCrucial' + links);
    $('#blockQuestion' + links + ' select option').prop('selected', false);
    $('#nameQuestion' + links).html("Вопрос " + links1);
    $('#delQuestion' + links).removeClass('d-none');
  });
  $('.addRecipient').click(function(){
    var links = $("[req='true']").length;
    var links1 = links + 1;
    $('#blockRecipient').clone(true).attr('id', 'blockRecipient' + links).appendTo('.marginBlock');
    $('#blockRecipient' + links + ' #nameRecipient').attr('id', 'nameRecipient' + links);
    $('#blockRecipient' + links + ' #delRecipient').attr('id', 'delRecipient' + links);
    $('#nameRecipient' + links).html("Получатель " + links1);
    $('#delRecipient' + links).removeClass('d-none');
  });

  // Удалить вопрос, получателя
  $('.delQuestion').click(function(){
    var id = $(this).attr("id");
    id = id.substr(11);
    $('#blockQuestion' + id).remove();
  });
  $('.delRecipient').click(function(){
    var id = $(this).attr("id");
    id = id.substr(12);
    $('#blockRecipient' + id).remove();
  });

  // Показываем или прячем поля
  $("#selectType").change(function(){
    var asd = $("#selectType").val();
    if(asd == 0) {
      $('#formField').css('display','none').fadeOut(1000);
    } else {
      $('#formField').css('display','block').fadeIn(1000);
    }
  });
  
  // Отмена закрытия полей
  $("#editDocument").click(function(e){
    e.preventDefault();
    $(this).addClass("d-none");
    $("#saveDocument").removeClass("d-none");
    $("#closeDocument").addClass("d-none");
    $("option, #inputDate, #inputTime, .addQuestion").attr("disabled",false);
    $(".mdb-select li").removeClass("disabled");
  });

  $("#saveDocument").click(function(e){
    e.preventDefault();
    $(this).addClass("d-none");
    $("#editDocument").removeClass("d-none");
    $("#closeDocument").removeClass("d-none");
    $("option, #inputDate, #inputTime, .addQuestion").attr("disabled",true);
    $(".mdb-select li").addClass("disabled");
  });

  // Кнопка отправки
  $('.submitBtn').click(function(event){
    event.preventDefault();
    $('#formField').css('display','none').fadeOut(1000);
    //$('#blockQuestion' + links + ' select option').prop('selected', false);
  });
  
  // Кнока наверх
  $(window).scroll(function(){
    if ($(this).scrollTop() > 100) {
      $('.scrollup').fadeIn();
    } else {
      $('.scrollup').fadeOut();
    }
  }); 
  $('.scrollup').click(function(){
    $("html, body").animate({ scrollTop: 0 }, 600);
    return false;
  });
});