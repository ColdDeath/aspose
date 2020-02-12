<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="../fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/datatablesUtil.js" defer></script>
<script type="text/javascript" src="resources/js/questDatatables.js" defer></script>
<jsp:include page="../fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3><spring:message code="quests.admin.title"/></h3>

            <div class="view-box">
                <table class="table table-striped display" id="datatable">
                    <thead>
                    <tr>
                        <th><spring:message code="quests.admin.name"/></th>
                        <th><spring:message code="quests.admin.isActive"/></th>
                        <th><spring:message code="quests.admin.createDate"/></th>
                        <th><spring:message code="common.edit"/></th>
                        <th><spring:message code="common.delete"/></th>
                    </tr>
                    </thead>
                </table>
                <div class="form-group">
                    <a class="btn btn-info" onclick="add('<spring:message code="quests.admin.adding"/>')">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                        <spring:message code="quests.admin.add"/>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../fragments/footer.jsp"/>

<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title" id="modalTitle"></h3>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" id="detailsForm">
                    <div class="form-group">
                        <label for="name" class="control-label col-xs-3"><spring:message code="quests.admin.name"/>:</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name" placeholder="<spring:message code="quests.admin.name"/>">
                        </div>
                    </div>

                </form:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="save()">
                    <span class="fa fa-check"></span>
                    <spring:message code="common.save"/>
                </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                    <span class="fa fa-close"></span>
                    <spring:message code="common.cancel"/>
                </button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title" id="modalTitleDialog"></h3>
            </div>
            <div class="modal-body">
                <p></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="">
                    <span class="fa fa-check"></span>
                    <spring:message code="common.yes"/>
                </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                    <span class="fa fa-close"></span>
                    <spring:message code="common.no"/>
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
