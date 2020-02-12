<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--Добавление организации--%>
<div class="modal fade" id="addElement" tabindex="-1" role="dialog" aria-labelledby="addElement" aria-hidden="true">
    <div class="modal-dialog modal-primary modal-dialog-centered modal-size-lg modal-notify" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <p class="heading lead">Добавление организации</p>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="white-text">&times;</span>
                </button>
            </div>
            <div class="modal-body fontSmall">
                <div class="progress md-progress primary-color-dark bigFormLoader d-none">
                    <div class="indeterminate"></div>
                </div>
                <form class="addElementForm needs-validation" novalidate>
                    <div class="row mb-2">
                        <div class="col-4">
                            <div class="text-muted">ИНН/ОГРН/Название<sup><i class="fas fa-star-of-life ml-1 text-danger"></i></sup></div>
                        </div>
                        <div class="col-8">
                            <div class="input-group">
                                <input type="text" id="searchValue" class="form-control form-control-sm" required>
                                <div class="input-group-append">
                                    <button class="btn btn-sm btn-primary m-0 px-3" type="button" id="btnEgrul">Заполнить из ЕГРЮЛ</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-4">
                            <div class="text-muted">Короткое название<sup><i class="fas fa-star-of-life ml-1 text-danger"></i></sup></div>
                        </div>
                        <div class="col-8">
                            <textarea id="shortNameLf" class="form-control form-control-sm" required disabled></textarea>
                            <%--<input type="text" id="shortNameLf" class="form-control form-control-sm" required disabled>--%>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-4">
                            <div class="text-muted">Полное название<sup><i class="fas fa-star-of-life ml-1 text-danger"></i></sup></div>
                        </div>
                        <div class="col-8">
                            <textarea id="fullNameLf" class="form-control form-control-sm" required disabled></textarea>
                            <%--<input type="text" id="fullNameLf" class="form-control form-control-sm" required disabled>--%>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-12">
                            <div class="row">
                                <div class="col-4">
                                    <div class="text-muted">ИНН<sup><i class="fas fa-star-of-life ml-1 text-danger"></i></sup></div>
                                </div>
                                <div class="col-8">
                                    <input type="text" id="inn" class="form-control form-control-sm" required disabled>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-12">
                            <div class="row">
                                <div class="col-4">
                                    <div class="text-muted">ОГРН<sup><i class="fas fa-star-of-life ml-1 text-danger"></i></sup></div>
                                </div>
                                <div class="col-8">
                                    <input type="text" id="ogrn" class="form-control form-control-sm" required disabled>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-12">
                            <div class="row">
                                <div class="col-4">
                                    <div class="text-muted">КПП<sup><i class="fas fa-star-of-life ml-1 text-danger"></i></sup></div>
                                </div>
                                <div class="col-8">
                                    <input type="text" id="kpp" class="form-control form-control-sm" required disabled>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-4">
                            <div class="text-muted">Адрес<sup><i class="fas fa-star-of-life ml-1 text-danger"></i></sup></div>
                        </div>
                        <div class="col-8">
                            <textarea id="address" class="form-control form-control-sm" required disabled></textarea>
                            <%--<input type="text" id="address" class="form-control form-control-sm" required disabled>--%>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-4">
                            <span class="text-muted">Должность<%--<sup><i class="fas fa-star-of-life ml-1 text-danger"></i></sup>--%></span>
                        </div>
                        <div class="col-8">
                            <input type="text" id="positionManager" class="form-control form-control-sm" disabled>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-4">
                            <span class="text-muted">ФИО<%--<sup><i class="fas fa-star-of-life ml-1 text-danger"></i></sup>--%></span>
                        </div>
                        <div class="col-8">
                            <input type="text" id="fioManager" class="form-control form-control-sm" disabled>
                        </div>
                    </div>
                    <input type="hidden" id="shortName">
                    <input type="hidden" id="fullName">
                    <input type="hidden" id="shortLegalForm">
                    <input type="hidden" id="fullLegalForm">
                    <input type="hidden" id="normalizedName">
                </form>
            </div>
            <div class="btnBlock">
                <div class="d-flex align-items-center justify-content-center pb-2">
                    <a href="#" type="button" class="btn btn-md btn-primary rounded btnAddElement">Добавить</a>
                    <a href="#" type="button" class="btn btn-md btn-danger rounded" data-dismiss="modal">Отмена</a>
                </div>
            </div>
        </div>
    </div>
</div>

<%--Подтверждение удаления--%>
<div class="modal fade" id="deleteBlock" tabindex="-1" role="dialog" aria-labelledby="deleteBlock" aria-hidden="t`rue">
    <div class="modal-dialog modal-notify modal-danger modal-size-sm modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <p class="heading">Вы уверены что хотите удалить блок?</p>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="white-text">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="text-center my-4">
                    <i class="fas fa-times fa-4x animated rotateIn"></i>
                </div>
            </div>
            <div class="modal-footer justify-content-center">
                <a type="button" class="btn btn-danger" data-delete="" id="btnDeleteBlock">Удалить</a>
                <a type="button" class="btn btn-outline-danger waves-effect" data-dismiss="modal">Отменить</a>
            </div>
        </div>
    </div>
</div>

<%--Запрос в поддержку--%>
<div class="modal fade" id="helpBlock" tabindex="-1" role="dialog" aria-labelledby="deleteBlock" aria-hidden="t`rue">
    <div class="modal-dialog modal-notify modal-info modal-size-lg modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <p class="heading">Запрос в техподдержку</p>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="white-text">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="progress md-progress primary-color-dark bigFormLoader d-none">
                    <div class="indeterminate"></div>
                </div>
                <div class="text-center mb-4 bigIcon">
                    <i class="fas fa-question-circle fa-4x animated rotateIn"></i>
                </div>
                <form class="addHelpForm needs-validation" novalidate>
                    <div class="row mb-2">
                        <div class="col-12">
                            <div class="text-muted">Тема<sup><i class="fas fa-star-of-life ml-1 text-danger"></i></sup></div>
                        </div>
                        <div class="col-12">
                            <div class="input-group">
                                <input type="text" id="helpTheme" class="form-control form-control-sm" required>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-12">
                            <div class="text-muted">Описание проблемы<sup><i class="fas fa-star-of-life ml-1 text-danger"></i></sup></div>
                        </div>
                        <div class="col-12">
                            <textarea rows="10" id="helpDescription" class="form-control form-control-sm" required></textarea>
                        </div>
                    </div>
                    <div id="hiddenUserBlock1"></div>
                    <div id="hiddenUserBlock2"></div>
                </form>
            </div>
            <div class="modal-footer justify-content-center btnBlock">
                <a type="button" class="btn btn-info" data-delete="" id="btnHelpBlock">Отправить</a>
                <a type="button" class="btn btn-outline-info waves-effect" data-dismiss="modal">Отменить</a>
            </div>
        </div>
    </div>
</div>

<%--Выбор пользователя секретарём--%>
<div class="modal fade" id="choiseUser" tabindex="-1" role="dialog" aria-labelledby="choiseUser" aria-hidden="t`rue">
    <div class="modal-dialog modal-notify modal-info modal-size-md modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <p class="heading">Делегирование полномочий</p>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="white-text">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="text-center mb-4 bigIcon">
                    <i class="fas fa-users fa-4x animated flash"></i>
                </div>
                <div class="row mb-2">
                    <div class="col-12 text-center mb-3">
                        <h5>Выберите пользователя, за которого вы будете работать с документами:</h5>
                    </div>
                </div>
                <form class="choiseUser" method="post" action="#">
                    <div class="row mb-2">
                        <div class="col-12">
                            <div class="row mb-2 d-flex align-items-center" id="choiseUserBlock"></div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer justify-content-center btnBlock">
                <button type="submit" class="btn btn-info" id="btnChoiseUser" disabled>OK
                </button>
                <a type="button" class="btn btn-outline-info waves-effect" data-dismiss="modal">Отменить</a>
            </div>
        </div>
    </div>
</div>

<%--Выбор макета таблицы--%>
<div class="modal fade" id="btnAddTable" tabindex="-1" role="dialog" aria-labelledby="btnAddTable" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-notify modal-primary modal-size-big" role="document">
        <div class="modal-content btnAddTable">
            <div class="modal-header headerAddTable">
                <p class="heading lead">Выберите макет таблицы</p>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="white-text">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row addTableVal w-100">
                    <div class="col-12">
                        <select data-placeholder="Выберите из справочника" class="chosen-select addTable1001" id="addTable1001" name="addTable1001" required>
                            <option value="">Выберите из справочника</option>
                        </select>
                    </div>
                </div>
                <div id="tableTemplateView"></div>
                <%--<div class="preloader-wrapper active big active crazy loaderUndo d-none">
                    <div class="spinner-layer spinner-blue">
                        <div class="circle-clipper left">
                            <div class="circle"></div>
                        </div>
                        <div class="gap-patch">
                            <div class="circle"></div>
                        </div>
                        <div class="circle-clipper right">
                            <div class="circle"></div>
                        </div>
                    </div>
                    <div class="spinner-layer spinner-red">
                        <div class="circle-clipper left">
                            <div class="circle"></div>
                        </div>
                        <div class="gap-patch">
                            <div class="circle"></div>
                        </div>
                        <div class="circle-clipper right">
                            <div class="circle"></div>
                        </div>
                    </div>
                    <div class="spinner-layer spinner-yellow">
                        <div class="circle-clipper left">
                            <div class="circle"></div>
                        </div>
                        <div class="gap-patch">
                            <div class="circle"></div>
                        </div>
                        <div class="circle-clipper right">
                            <div class="circle"></div>
                        </div>
                    </div>
                    <div class="spinner-layer spinner-green">
                        <div class="circle-clipper left">
                            <div class="circle"></div>
                        </div>
                        <div class="gap-patch">
                            <div class="circle"></div>
                        </div>
                        <div class="circle-clipper right">
                            <div class="circle"></div>
                        </div>
                    </div>
                </div>
                <div class="text-center bodyAddTable d-none">
                    <i class="fas fa-check fa-4x mb-3 animated rotateIn"></i>
                    <h6>Перенаправление документа выполнено!</h6>
                </div>--%>
            </div>
            <div class="modal-footer justify-content-center footerAddTable">
                <a type="button" id="addTableSave" class="btn btn-primary rounded">Создать</a>
                <a type="button" class="btn btn-outline-primary rounded" data-dismiss="modal">Отмена</a>
            </div>
        </div>
    </div>
</div>