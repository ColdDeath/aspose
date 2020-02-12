<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<link rel="stylesheet" href="resources/css/login.css">
<script type="text/javascript" src="resources/js/particles.min.js"></script>
<script type="text/javascript" src="resources/js/particlesUtil.js" defer></script>
<script type="text/javascript" src="resources/js/loginUtil.js" defer></script>
<body>
<div id="cover"></div>
<div id="particles-js" class="particles-js-container"></div>
<div class="logo-container">
    <img class="logo" src="resources/images/logo.png" alt="">
    <ul class="dgi-name">
        <li>ДОКУМЕНТООБОРОТ ИАС "ТАРИФ"</li>
        <li>ДЕПАРТАМЕНТА ЭКОНОМИЧЕСКОЙ ПОЛИТИКИ И</li>
        <li>РАЗВИТИЯ ГОРОДА МОСКВЫ</li>
    </ul>
</div>
<div class="body-container">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default login">
                    <div class="text-center">
                        <h2>Введите логин и пароль</h2>
                    </div>
                    <form:form class="form" action="login" method="post">
                        <div class="form-group">
                            <label for="username">Логин</label>
                            <input type="text" id="username" name="username" class="form-control" placeholder="Введите логин входа в компьютер">
                        </div>
                        <div class="form-group">
                            <label for="password">Пароль</label>
                            <input type="password" id="password" name="password" class="form-control" placeholder="Введите пароль входа в компьютер">
                        </div>
                        <div class="login-button">
                            <button class="center-block btn btn-lg btn-default" type="submit">Войти</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>

<script lang="javascript">
    $(window).on('load', function() {
        $("#cover").hide();
    });
</script>
</html>
