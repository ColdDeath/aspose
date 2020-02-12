<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<div class="modal fade right" id="listAgree" tabindex="-1" role="dialog" aria-labelledby="listAgree"
     aria-hidden="true" data-backdrop="true">
    <div class="modal-dialog modal-size-lg modal-side modal-top-right modal-notify" role="document">
        <div class="modal-content">
            <div class="modal-header alert alert-secondary">
                <h6>Список согласования</h6>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
            </div>
            <div class="modal-footer text-center">
                <button type="button" class="btn btn-primary btn-sm rounded" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>--%>
<%--Согласование документа--%>
<div class="modal fade" id="btnSuccess" tabindex="-1" role="dialog" aria-labelledby="btnSuccess" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-notify modal-success" role="document">
        <div class="modal-content btnSuccess">
            <div class="modal-header headerAddTemplate">
                <p class="heading mx-auto">Внимание! Процесс согласования документа!</p>
            </div>
            <div class="modal-header headerSuccess d-none">
                <p class="heading lead">Согласование документа</p>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="white-text">&times;</span>
                </button>
            </div>
            <div class="modal-body d-flex align-items-center justify-content-center">
                <div class="preloader-wrapper active big active crazy loaderSuccess">
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
                <div class="text-center bodySuccess d-none">
                    <i class="fas fa-check fa-4x mb-3 animated rotateIn"></i>
                    <h6>Документ успешно согласован!</h6>
                    <h6 id="regName"></h6>
                    <h3 id="regNum"></h3>
                </div>
            </div>
            <div class="modal-footer justify-content-center footerSuccess d-none">
                <a type="button" class="btn btn-success rounded" data-dismiss="modal">Продолжить работу</a>
            </div>
        </div>
    </div>
</div>

<%--Отмена согласования документа--%>
<div class="modal fade" id="btnCancel" tabindex="-1" role="dialog" aria-labelledby="btnCancel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-notify modal-danger" role="document">
        <div class="modal-content btnCancel">
            <div class="modal-header headerCancel d-none">
                <p class="heading lead">Отмена согласования документа</p>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="white-text">&times;</span>
                </button>
            </div>
            <div class="modal-body d-flex align-items-center justify-content-center">
                <div class="preloader-wrapper active big active crazy loaderCancel">
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
                <div class="text-center bodyCancel d-none">
                    <i class="fas fa-times fa-4x mb-3 animated rotateIn"></i>
                    <h6>Согласование отменено!</h6>
                </div>
            </div>
            <div class="modal-footer justify-content-center footerCancel d-none">
                <a type="button" class="btn btn-danger rounded" data-dismiss="modal">Продолжить работу</a>
            </div>
        </div>
    </div>
</div>

<%--Перенаправление документа на согласование--%>
<div class="modal fade" id="btnUndo" tabindex="-1" role="dialog" aria-labelledby="btnUndo" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-notify modal-primary" role="document">
        <div class="modal-content btnUndo">
            <div class="modal-header headerUndo">
                <p class="heading lead">Перенаправление документа на согласование</p>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="white-text">&times;</span>
                </button>
            </div>
            <div class="modal-body d-flex align-items-center justify-content-center">
                <div class="row returnUser w-100">
                    <div class="col-12">
                        <select data-placeholder="Выберите из справочника" class="chosen-select userList1001" id="userList1001" name="userList[]" required>
                            <option value="">Выберите из справочника</option>
                        </select>
                    </div>
                    <div class="col-12">
                        <div class="fontSmall text-left" id="userListPost1001"></div>
                    </div>
                </div>
                <div class="preloader-wrapper active big active crazy loaderUndo d-none">
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
                <div class="text-center bodyUndo d-none">
                    <i class="fas fa-check fa-4x mb-3 animated rotateIn"></i>
                    <h6>Перенаправление документа выполнено!</h6>
                </div>
            </div>
            <div class="modal-footer justify-content-center footerUndo">
                <a type="button" id="undoSave" class="btn btn-primary rounded">Перенаправить</a>
                <a type="button" class="btn btn-outline-primary rounded" data-dismiss="modal">Отмена</a>
            </div>
        </div>
    </div>
</div>