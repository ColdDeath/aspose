<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="../fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/questUtil.js" defer></script>
<jsp:include page="../fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3><spring:message code="quest.admin.title"/></h3>

            <div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="...">
                <div class="btn-group" role="group">
                    <button type="button" id="questioons" class="btn btn-primary" href="#tab1" data-toggle="tab"><span
                            class="glyphicon glyphicon-list" aria-hidden="true"></span>
                        <div class="hidden-xs"><spring:message code="quest.admin.questions"/></div>
                    </button>
                </div>
                <div class="btn-group" role="group">
                    <button type="button" id="parameters" class="btn btn-default" href="#tab2" data-toggle="tab"><span
                            class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                        <div class="hidden-xs"><spring:message code="quest.admin.parameters"/></div>
                    </button>
                </div>
                <div class="btn-group" role="group">
                    <button type="button" id="results" class="btn btn-default" href="#tab3" data-toggle="tab"><span
                            class="glyphicon glyphicon-stats" aria-hidden="true"></span>
                        <div class="hidden-xs"><spring:message code="quest.admin.results"/></div>
                    </button>
                </div>
            </div>

            <form:form id="quest" data-toggle="validator" role="form">
                <div class="well">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1">
                            <div class="view-box">
                                <div class="form-questions" id="questions">

                                </div>
                                <a class="btn btn-info" onclick="addQuestionText()">
                                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                    <spring:message code="quest.admin.addQuestionText"/>
                                </a>

                                <a class="btn btn-info" onclick="addQuestionVariants(true)">
                                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                    <spring:message code="quest.admin.addQuestionVariants"/>
                                </a>
                            </div>

                        </div>
                        <div class="tab-pane fade in" id="tab2">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <div class="form-horizontal">
                                                <div class="form-group">
                                                    <input type="hidden" name="id" id="questId">
                                                    <label class="label-quest control-label col-sm-2" for="questName">
                                                        <spring:message code="quest.admin.questName"/>:
                                                    </label>

                                                    <div class="col-sm-10">
                                                        <input required class="form-control" name="name" id="questName">
                                                        <div class="help-block with-errors"></div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="label-quest control-label col-sm-2" for="isActive">
                                                        <spring:message code="quest.admin.enableQuest"/>:
                                                    </label>

                                                    <div class="col-sm-10">
                                                        <input name="isActive" id="isActive" type="checkbox"
                                                               data-toggle="toggle" value="true"
                                                               data-on="<spring:message code="common.yes"/>"
                                                               data-off="<spring:message code="common.no"/>"
                                                               data-onstyle="success" data-offstyle="danger">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade in" id="tab3">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <div class="form-horizontal">
                                                <div class="form-results text-center">

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>

            <a class="btn btn-success pull-right float-save" onclick="saveQuest()">
                <span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span>
                <spring:message code="quest.admin.save"/>
            </a>
            <div class="pull-right float-menu">
                <label class="label-wrap"><spring:message code="quest.admin.fixQuestionsOrder"/></label>
                <input id="toogleFixQuestionsOrder" type="checkbox"
                       data-toggle="toggle"
                       data-on="<spring:message code="common.yes"/>"
                       data-off="<spring:message code="common.no"/>"
                       data-onstyle="success" data-offstyle="danger">
            </div>
        </div>
    </div>
</div>


<div class="template-question" style="display: none;">
    <div class="row" id="questionNumber'{number}'">
        <div class="col-sm-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <input type="hidden" name="questions['{number}'][id]" id="questionId'{number}'">
                            <input type="hidden" name="questions['{number}'][number]" id="questionNumberOrder'{number}'">
                            <input type="hidden" name="questions['{number}'][answerTypeId]" id="questionAnswerTypeId'{number}'">
                            <label class="label-question control-label col-sm-2" for="questionName'{number}'">
                                <spring:message code="quest.admin.question"/> '{numberInc}':
                            </label>

                            <div class="col-sm-10">
                                <input required class="form-control" name="questions['{number}'][name]"
                                       id="questionName'{number}'">
                                <div class="help-block with-errors"></div>
                            </div>
                        </div>
                        <div class="form-variants">

                        </div>
                        <div class="pull-right">
                            <a class="btn btn-info" onclick="addVariant('{number}')">
                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                <spring:message code="quest.admin.addVariant"/>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="question-footer panel-footer text-right">
                    <a class="btn btn-danger" type="button" onclick="deleteQuestion('{number}')">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="template-variant" style="display: none;">
    <div class="form-group" id="question'{questionNumber}'VariantNumber'{number}'">
        <input type="hidden" name="questions['{questionNumber}'][variants]['{number}'][id]" id="question'{questionNumber}'VariantId'{number}'">
        <label class="label-variant control-label col-sm-2" for="question'{questionNumber}'VariantName'{number}'">
            <spring:message code="quest.admin.variant"/> '{numberInc}':
        </label>

        <div class="col-sm-9">
            <input required class="form-control" name="questions['{questionNumber}'][variants]['{number}'][name]"
                   id="question'{questionNumber}'VariantName'{number}'">
            <div class="help-block with-errors"></div>
        </div>

        <a class="btn btn-danger" type="button" onclick="deleteVariant('{questionNumber}','{number}')">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
        </a>
    </div>
</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
