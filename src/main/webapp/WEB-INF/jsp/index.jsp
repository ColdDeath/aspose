<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="fragments/headerIndex.jsp"/>
<c:set var = "main" />
<main>
    <div class="container-fluid mb-4 pt-4">
        <div class="card mt-5 white-text rgba-black-strong">
            <div class="card-body">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <section class="mb-5">
                                <div class="row mb-2">
                                    <div class="col-5">
                                        <h3><i class="fas fa-id-card white-text mr-2"></i>Мои документы</h3>
                                    </div>
                                    <div class="col-7">
                                        <h3 class="ml-n5 pl-2">Тарифное регулирование</h3>
                                    </div>
                                </div>
                                <div class="row my-2 text-center">
                                    <div class="col-lg-4 col-md-12 mb-lg-0 mb-4 wow bounceInDown" >
                                        <h4 class="my-2">На исполнении (<span class="inWorkSum"></span>)</h4>
                                        <div class="blockChart">
                                            <div class="myImg">
                                                <i class="fas fa-briefcase white-text fa-4x" id="iconMenu1"></i>
                                            </div>
                                            <div id="chartDiv1" class="chartDiv"></div>
                                        </div>
                                        <a href="in-work" class="chartLink" data-icon="1"></a>
                                    </div>
                                    <div class="col-lg-4 col-md-12 mb-lg-0 mb-4 wow bounceInDown" data-wow-delay="0.3s">
                                        <h4 class="my-2">На согласовании (<span class="agreementSum"></span>)</h4>
                                        <div class="blockChart">
                                            <div class="myImg">
                                                <i class="fas fa-edit white-text fa-4x" id="iconMenu2"></i>
                                            </div>
                                            <div id="chartDiv2" class="chartDiv"></div>
                                        </div>
                                        <a href="agreement" class="chartLink" data-icon="2"></a>
                                    </div>
                                    <div class="col-lg-4 col-md-12 mb-lg-0 mb-4 wow bounceInDown" data-wow-delay="0.6s">
                                        <h4 class="my-2">На распределении (<span class="distributionSum"></span>)</h4>
                                        <div class="blockChart">
                                            <div class="myImg">
                                                <i class="fas fa-user-plus white-text fa-4x" id="iconMenu3"></i>
                                            </div>
                                            <div id="chartDiv3" class="chartDiv"></div>
                                        </div>
                                        <a href="distribution" class="chartLink" data-icon="3"></a>
                                    </div>
                                </div>
                            </section>
                            <section>
                                <div class="row my-2 text-center">
                                    <div class="col-lg-4 col-md-12 mb-lg-0 mb-4 wow fadeInLeft">
                                        <h4 class="my-3">Документы управления</h4>
                                        <h6>На исполнении</h6>
                                        <div class="row d-flex align-items-center white-text">
                                            <div class="col-md-4 text-right">
                                                срок более 3 дней
                                            </div>
                                            <div class="col-md-6 text-left">
                                                <a href="temp-list?page=inworkMoreDeadlineByDepartment" class="fontBig btn btn-sm btn-default font-weight-bold px-1" id="inWorkSuccess"></a>
                                            </div>
                                        </div>
                                        <div class="row d-flex align-items-center white-text">
                                            <div class="col-md-4 text-right">
                                                срок 3 дня и меньше
                                            </div>
                                            <div class="col-md-6 text-left">
                                                <a href="temp-list?page=inworkLessDeadlineByDepartment" class="fontBig btn btn-sm btn-danger font-weight-bold px-1" id="inWorkDanger"></a>
                                            </div>
                                        </div>
                                        <h6>На согласовании</h6>
                                        <div class="row d-flex align-items-center white-text">
                                            <div class="col-md-4 text-right">
                                                срок более 3 дней
                                            </div>
                                            <div class="col-md-6 text-left">
                                                <a href="temp-list?page=agreementMoreDeadlineByDepartment" class="fontBig btn btn-sm btn-default font-weight-bold px-1" id="agreeSuccess"></a>
                                            </div>
                                        </div>
                                        <div class="row d-flex align-items-center white-text">
                                            <div class="col-md-4 text-right">
                                                срок 3 дня и меньше
                                            </div>
                                            <div class="col-md-6 text-left">
                                                <a href="temp-list?page=agreementLessDeadlineByDepartment" class="fontBig btn btn-sm btn-danger font-weight-bold px-1" id="agreeDanger"></a>
                                            </div>
                                        </div>
                                        <h6>На распределении</h6>
                                        <div class="row d-flex align-items-center white-text">
                                            <div class="col-md-4 text-right">
                                                срок более 3 дней
                                            </div>
                                            <div class="col-md-6 text-left">
                                                <a href="temp-list?page=distributionMoreDeadlineByDepartment" class="fontBig btn btn-sm btn-default font-weight-bold px-1" id="distSuccess"></a>
                                            </div>
                                        </div>
                                        <div class="row d-flex align-items-center white-text">
                                            <div class="col-md-4 text-right">
                                                срок 3 дня и меньше
                                            </div>
                                            <div class="col-md-6 text-left">
                                                <a href="temp-list?page=distributionLessDeadlineByDepartment" class="fontBig btn btn-sm btn-danger font-weight-bold px-1" id="distDanger"></a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-12 mb-lg-0 mb-4 wow fadeInUp">
                                        <h4 class="my-3">Регистрация документа</h4>
                                        <a href="new-document" title="Создать новый документ">
                                            <i class="fas fa-file-alt fa-6x white-text newDoc"></i>
                                        </a>
                                    </div>
                                    <div class="col-lg-4 col-md-12 mb-lg-0 mb-4 wow fadeInRight">
                                        <h4 class="my-3">Моя дисциплина за месяц</h4>
                                        <div class="row d-flex align-items-center justify-content-center white-text">
                                            <div class="col-md-4 text-right">Всего было на контроле</div>
                                            <div class="col-md-6 text-left">
                                                <a href="temp-list?page=atThisMounthOnControl" class="fontBig btn btn-sm btn-indigo font-weight-bold px-1" id="mySum" data-value="0"></a>
                                            </div>
                                        </div>
                                        <div class="row d-flex align-items-center justify-content-center white-text">
                                            <div class="col-md-4 text-right">Исполнено в срок</div>
                                            <div class="col-md-6 text-left">
                                                <a href="temp-list?page=atThisMounthOnControlCompletedInTime" class="fontBig btn btn-sm btn-default font-weight-bold px-1" id="mySuccess"></a>
                                            </div>
                                        </div>
                                        <div class="row d-flex align-items-center justify-content-center white-text">
                                            <div class="col-md-4 text-right">Исполнено с нарушением срока</div>
                                            <div class="col-md-6 text-left">
                                                <a href="temp-list?page=atThisMounthOnControlCompletedAfterTime" class="fontBig btn btn-sm btn-warning font-weight-bold px-1" id="myWarning"></a>
                                            </div>
                                        </div>
                                        <div class="row d-flex align-items-center justify-content-center white-text">
                                            <div class="col-md-4 text-right">Не исполнено (срок вышел)</div>
                                            <div class="col-md-6 text-left">
                                                <a href="temp-list?page=atThisMounthOnControlNotCompleted" class="fontBig btn btn-sm btn-danger font-weight-bold px-1" id="myDanger"></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="fragments/footerIndex.jsp"/>
<jsp:include page="fragments/modals/newDocumentModal.jsp"/>
<jsp:include page="fragments/modals/viewDocumentModal.jsp"/>
<jsp:include page="fragments/footerScript.jsp"/>
<script>
    $(function() {
        $('header, main, footer').css('padding-left',0);

        $('.chartLink').hover(
            function() {
                var id = $(this).attr('data-icon');
                $('#iconMenu'+id).addClass('animated rotateIn');
            },
            function() {
                var id = $(this).attr('data-icon');
                $('#iconMenu'+id).removeClass('animated rotateIn');
            });

        $('.newDoc').hover(
            function() {
                $(this).addClass('animated heartBeat');
            },
            function() {
                $(this).removeClass('animated heartBeat');
            });

        // Показ цифр в блоке: Моя дисциплина за месяц
        countElemJSON('rest/profile/docs/counters', 1); // Список всех моих документов
        // Показ цифр в блоке: Документы управления
        countElemJSON('rest/profile/docs/counters', 2); // Список документов на исполнении
        countElemJSON('rest/profile/docs/counters', 3); // Список документов на согласовании
        countElemJSON('rest/profile/docs/counters', 4); // Список документов на регистрации

        // Показ модального окна для секретаря - данные
        $.getJSON('rest/profile/users/getDelegationUsers', function(data) {
            var currentUser = $('#currentUser').attr('data-current');
            if(data.length !== 0 && currentUser == 1) {
                setTimeout(function() {
                    $('#choiseUser').modal('show');
                    $('.choiseUserName').removeClass('alert alert-info mb-0 active');
                    $('#btnChoiseUser').attr('disabled', true);
                }, 1500);
                for(var i in data) {
                    var fulName = data[i].lastname+' '+data[i].firstname+' '+data[i].patronym;
                    $('#choiseUserBlock').append('<div class="col-12 border border-info rounded py-2 px-4 pointer choiseUserName mb-2" data-value="'+data[i].name+'">'+fulName+'<small class="text-muted ml-2">'+data[i].position+'</small></div>');
                }
            }
        });

        // Показ модального окна для секретаря - выбрать пользователя
        $(document).on('click', '.choiseUserName', function() {
            $('.choiseUserName').removeClass('alert alert-info mb-0 active');
            $('#btnChoiseUser').attr('disabled', false);
            $(this).toggleClass('alert alert-info mb-0 active');
        });
        $('#choiseUser').on('hidden.bs.modal', function() {
            $('.choiseUserName').removeClass('alert alert-info mb-0 active');
            $('#btnChoiseUser').attr('disabled', true);
        });

        // Показ модального окна для секретаря - отправка запроса
        $('#btnChoiseUser').click(function(event) {
            event.preventDefault();
            var userId = $('.choiseUserName.active').attr('data-value');
            var serverGetUserName = $.ajax({
                type: 'POST',
                url: 'rest/profile/users/setDelegatedUser?name='+userId,
                contentType: 'application/json; charset=utf-8'
            });
            serverGetUserName.done(function(data) {
                toastr["success"]("Успешно!");
                setTimeout(function() {
                    $('#choiseUser').modal('hide');
                    $('.choiseUserName').removeClass('alert alert-info mb-0 active');
                    $('#btnChoiseUser').attr('disabled', true);
                    $('#currentUser').attr('data-current', 0);
                    //console.log(data);
                    if(data.length !== 0) {
                        var newFirstname = data.firstname.substr(0,1)+'.';
                        var newPatronym = data.patronym.substr(0,1)+'.';
                        var currentName = data.lastname+' '+newFirstname+' '+newPatronym;
                        $('#currentUser').html('полномочия пользователя: '+currentName);
                    }
                    //window.location.reload();
                }, 1000);
            });
            serverGetUserName.fail(function() {
                toastr["error"]("Ошибка отправки запроса!");
            });
        });

    });
</script>
<jsp:include page="fragments/footerBasement.jsp"/>