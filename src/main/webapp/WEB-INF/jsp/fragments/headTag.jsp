<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <sec:csrfMetaTags/>

    <title><spring:message code="app.title"/></title>
    <base href="${pageContext.request.contextPath}/"/>

    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/bootstrap-toggle/2.2.0/css/bootstrap-toggle.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.0/demo/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.0/lib/noty.css">
    <link rel="stylesheet" href="webjars/datatables/1.10.13/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="webjars/datetimepicker/2.5.4/jquery.datetimepicker.css">
    <link rel="stylesheet" href="webjars/jquery-ui/1.12.1/jquery-ui.min.css">
    <link rel="shortcut icon" href="resources/images/favicon.ico">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/pretty-checkbox.min.css">

    <%-- http://stackoverflow.com/a/24070373/548473 --%>
    <script type="text/javascript" src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
    <script type="text/javascript" src="webjars/jquery-serializejson/2.8.1/jquery.serializejson.min.js"></script>
    <script type="text/javascript" src="webjars/jquery-serialize-object/2.1.0/jquery.serialize-object.min.js"></script>
    <script type="text/javascript" src="webjars/sortablejs/1.6.0/Sortable.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/bootstrap-toggle/2.2.0/js/bootstrap-toggle.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap-validator/0.11.9/js/validator.js"></script>
    <script type="text/javascript" src="webjars/datatables/1.10.13/js/jquery.dataTables.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.13/js/dataTables.bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/noty/3.1.0/lib/noty.min.js" defer></script>
    <script type="text/javascript" src="webjars/datetimepicker/2.5.4/build/jquery.datetimepicker.full.min.js" defer></script>
    <script type="text/javascript" src="resources/js/d3.min.js"></script>
    <script type="text/javascript" src="resources/js/d3pie.js"></script>
    <script type="text/javascript" src="resources/js/notyUtil.js"></script>
    <script type="text/javascript" src="resources/js/getparam.js"></script>
</head>
