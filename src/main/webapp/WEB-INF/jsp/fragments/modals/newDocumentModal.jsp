<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="createSave" tabindex="-1" role="dialog" aria-labelledby="createSave"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-notify modal-success" role="document">
        <div class="modal-content btnSuccess">
            <div class="modal-header headerCreateTemplate">
                <p class="heading mx-auto">Внимание! Регистрация документа в
                    системе!</p>
            </div>
            <div class="modal-header headerSuccess d-none">
                <p class="heading lead">Документ успешно зарегистрирован!</p>
                <button type="button" class="close reloadButton" data-dismiss="modal" aria-label="Close">
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
                    <h6>Регистрационный номер:</h6>
                    <h3 id="regNumTemplate"></h3>
                </div>
            </div>
            <div class="modal-footer justify-content-center footerSuccess d-none">
                <a type="button" class="btn btn-success rounded" data-dismiss="modal">Продолжить работу</a>
                <%--<a id="modalLoad" href="" type="button" class="btn btn-primary rounded"><i class="fas fa-download mr-2"></i>Скачать</a>--%>
            </div>
        </div>
    </div>
</div>