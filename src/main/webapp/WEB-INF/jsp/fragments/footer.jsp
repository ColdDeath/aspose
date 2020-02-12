<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="footer">
    <div class="container">
        <spring:message code="app.footer"/>
    </div>
</div>

<script type="text/javascript">
    var i18n = [];

    <c:forEach var='key' items='<%=new String[]{"quest.admin.noStatistics", "quest.admin.respondentsTotal", "quest.admin.noMoreAnswers", "quest.admin.showMoreAnswers", "quest.admin.reorderingQuestionsEnabled", "quest.admin.reorderingQuestionsDisabled", "quests.my.completedTitle","quests.my.completed","common.yes-small","common.no-small","common.in-process-small","common.deleted","common.saved","quest.admin.saved","common.enabled","common.disabled","common.status", "common.error", "quest.admin.less2variantsNoty", "common.notAllFieldsFilled", "common.notAllFieldsFilledAllTabs", "quest.admin.question", "quest.admin.variant", "common.search", "common.searchInfo", "common.searchFirst", "common.searchNext", "common.searchPrevious", "common.searchLast", "common.searchEmpty", "common.searchZeroRecords", "common.searchInfoEmpty", "common.searchLengthMenu", "common.searchInfoFiltered", "common.yes", "common.no", "common.confirmDelete", "common.deletingConfirm", "login.badCredentials"}%>'>
    i18n['${key}'] = '<spring:message code="${key}"/>';
    </c:forEach>
</script>
