var ajaxUrl = "rest/profile/quests/";
getUrlVar("id");

if ($.isNumeric(questId)) {
    getResult(questId);
}

function getResult(id) {
    $.get(ajaxUrl + id + "/results/", function(data) {
        getQuest(id, data);
    });
}

function getQuest(id, resultData) {
    $.get(ajaxUrl + id, function(data) {
        getQuestions(resultData, data);
    })
        .fail(function (data) {
            $('.view-box').remove();
            $('#questName').html('Ошибка: опрос уже был Вами пройден, либо уже не является активным')
        });
}

function getQuestions(resultData, questData) {
    var ajaxUrlQuestions = ajaxUrl + questData.id + "/questions/";
    $.get(ajaxUrlQuestions, function(data) {
        fillForm(resultData, questData, data, true)
    });
}

function fillForm(resultData, questData, questionsData, createHtml) {
    if (createHtml) {
        $('#questId').val(questData.id);
        $('#questName').html(questData.name);
        $('#status').val(resultData.status);
        for (i = 0; i < questionsData.length; i++) {
            addQuestion(i, questionsData);
            switch (questionsData[i].answerTypeId) {
                case 0:
                    var variantsData = questionsData[i].variants;
                    for (j = 0; j < variantsData.length; j++) {
                        addAnswerVariant(j, variantsData, i, questionsData[i].id);
                    }
                    break;
                case 1:
                    addAnswerText(i, questionsData[i].id);
                    break;
            }
        }
    }
    if (resultData) {
        $('#resultId').val(resultData.id);
        for (i = 0; i < resultData.answers.length; i++) {
            $('input[answerQuestionId=' + resultData.answers[i].question.id + ']').val(resultData.answers[i].id);
            if (resultData.answers[i].variant != null) {
                $(':radio[value=' + resultData.answers[i].variant.id + '][questionId=' + resultData.answers[i].question.id + ']').prop('checked', true);
            }
            else {
                $('textarea[questionId=' + resultData.answers[i].question.id + ']').text(resultData.answers[i].answerText);
            }
        }
    }
}

function addAnswerVariant(i, variantsData, questionNumber, questionId) {
    $('.form-questions .row#questionNumber' + questionNumber + ' .form-answers')
        .append($('.template-answers-variants').html()
            .replace(/'{number}'/g, i)
            .replace(/'{questionNumber}'/g, questionNumber));

    $('#question' + questionNumber + 'VariantId' + i).attr("questionId", questionId);
    $('#question' + questionNumber + 'VariantId' + i).val(variantsData[i].id);
    $('#question' + questionNumber + 'VariantName' + i).html(variantsData[i].name);
    $('#questionNumber' + questionNumber + 'VariantNumber' + i).hide().fadeIn(200);
}

function addAnswerText(questionNumber, questionId) {
    $('.form-questions .row#questionNumber' + questionNumber + ' .form-answers')
        .append($('.template-answers-text').html()
            .replace(/'{questionNumber}'/g, questionNumber));

    $('#question' + questionNumber + 'AnswerText').attr("questionId", questionId);
    $('.form-questions .row#questionNumber' + questionNumber + ' .form-answers .form-survey-content').hide().fadeIn(200);
}

function addQuestion(i, questionsData) {
    $('.form-questions').append($('.template-question').html()
        .replace(/'{number}'/g, i));

    $('#answerId' + i).attr('answerQuestionId', questionsData[i].id);
    $('#questionId' + i).val(questionsData[i].id);
    $('#questionName' + i).html(questionsData[i].number + ". " + questionsData[i].name);
    $('#answerTypeId' + i).val(questionsData[i].answerTypeId);
    $('.form-questions .row#questionNumber' + i).hide().fadeIn(200);
}

function saveResult() {
    $('#status').val('INPROCESS');
    $.ajax({
        type: "POST",
        url: ajaxUrl + questId + "/results/entire/",
        data: JSON.stringify($('#result').serializeObject()),
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            successNoty('quest.admin.saved');
            fillForm(data, null, null, false)
        },
        error: function (jqXHR) {
            failNoty(jqXHR);
        }
    });
}

function finishResult() {
    if ($('#result').validator('update').validator('validate').has('.has-error').length == 0) {
        $('#status').val('COMPLETED');
        $.ajax({
            type: "POST",
            url: ajaxUrl + questId + "/results/entire/",
            data: JSON.stringify($('#result').serializeObject()),
            contentType: "application/json; charset=utf-8",
            success: function () {
                showCloseDialog(i18n["quests.my.completedTitle"], i18n["quests.my.completed"], "location.href='my-quests'");
            },
            error: function (jqXHR) {
                failNoty(jqXHR);
            }
        });
    }
}

function showCloseDialog(title, text, okFunction) {
    $('#modalTitleDialog').html("<span class='fa fa-lg fa-exclamation-triangle'></span> &nbsp;" + title);
    $('#dialog p').text(text);
    $('#dialog .btn.btn-primary')[0].setAttribute("onclick", okFunction);
    $('#dialog').modal();
}