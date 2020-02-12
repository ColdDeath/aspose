<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="ru">
<head>
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title><spring:message code="app.title"/></title>
    <base href="${pageContext.request.contextPath}/"/>
    <link href="resources/img/favicon.ico" rel="icon" type="image/x-icon">
    <link href="resources/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <link rel="stylesheet" href="resources/css/index.css">
</head>
<body id="customSkin" class="dark-skin">

<header>
    <nav class="navbar fixed-top navbar-toggleable-md navbar-expand-lg scrolling-navbar double-nav black white-text">
        <a class="navbar-brand ml-3" href="index">
            <img src="resources/img/Logo.png" height="30" alt="Логотип">
        </a>
        <span class="breadcrumb-dn mr-auto">
        <h6 class="mt-2">Система документооборота ИАС "Тариф"</h6>
      </span>
        <ul class="nav navbar-nav nav-flex-icons ml-auto">
            <li class="nav-item">
                <a class="nav-link" data-toggle="modal" data-target="#helpBlock"><i class="far fa-question-circle mr-2"></i><span class="clearfix d-none d-sm-inline-block mr-3">Поддержка</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-user mr-2"></i><span id="templateUser"><sec:authentication property="principal.username"/></span>
                </a>
                <div id="currentUser" class="fontSmall" data-current="1"></div>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                    <%--<a class="dropdown-item" href="#"><i class="fas fa-cog"></i> Настройки</a>--%>
                    <form:form id="form-logout" class="dropdown-item" action="logout" method="post">
                        <span type="submit" onclick="document.forms['form-logout'].submit();">
                            <i class="fas fa-sign-out-alt"></i> <spring:message code="app.quit"/>
                        </span>
                    </form:form>
                </div>
            </li>
        </ul>
    </nav>
</header>