<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="collapse navbar-collapse nav navbar-nav">
            <a href="my-quests">
                <img class="logo-navbar" src="resources/images/logo.png" alt="">
            </a>
        </div>
        <sec:authorize access="isAuthenticated()">
        <a href="my-quests" class="navbar-brand"><spring:message code="app.title"/></a>
        <div class="collapse navbar-collapse">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="admin/quests"><spring:message code="quests.admin.title"/></a>
                    </li>
                </ul>
            </sec:authorize>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <div class="navbar-text">
                        <spring:message code="app.credentials"/>:
                        <sec:authentication property="principal.username"/>
                    </div>
                </li>
                <li class="navbar-right-margin">
                    <form:form class="navbar-form" action="logout" method="post">
                        <button class="btn btn-primary" type="submit">
                                <span class="glyphicon glyphicon-log-out" aria-hidden="true">
                                    <spring:message code="app.quit"/>
                                </span>
                        </button>
                    </form:form>
                </li>
            </ul>
        </div>
    </div>
    </sec:authorize>
</div>