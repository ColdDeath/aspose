var ajaxUrl = "rest/admin/quests/";
var ajaxUrlQuestions = "rest/admin/questions/";
var ajaxAutocompleteVariantsUrl = "rest/admin/variants/tags/"

var questId = getUrlVar("id");

var el = document.getElementById('questions');
var sortable = Sortable.create(el, {
    ghostClass: 'ghost',
    disabled: true,
    onEnd: function (evt) {
        reorderQuestions();
    }
});

$(document).ready(function () { // function for coloring active tab
    $(".btn-pref .btn").click(function () {
        $(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
        $(this).removeClass("btn-default").addClass("btn-primary");
        if ($('.tab-pane.fade.in.active#tab3') != null) {
            getQuestResults();
        }
    });
});

$(function() {
    $('#toogleFixQuestionsOrder').change(function() {
        var state = sortable.option("disabled");
        sortable.option("disabled", !state);
        if (state)
        {
            successNoty('quest.admin.reorderingQuestionsEnabled');
        }
        else
        {
            warningNoty('quest.admin.reorderingQuestionsDisabled');
        }
    })
})

if (!$.isNumeric(questId)) {
    if ($('.form-questions .row').length == 0)
    {
        addQuestionVariants(true);
    }
}
else {
    getQuest(questId);
}

function getQuest(id) {
    $.get(ajaxUrl + id, function(data) {
        getQuestions(data);
    });
}

function getQuestions(questData) {
    var ajaxUrlQuestions = ajaxUrl + questData.id + "/questions/";
    $.get(ajaxUrlQuestions, function(data) {
        fillForm(questData, data, true)
    });
}

function fillForm(questData, questionsData, createHtml) {
    $('#questId').val(questData.id);
    $('#questName').val(questData.name);
    $('#isActive').prop('checked', questData.isActive).change();
    for (i = 0; i < questionsData.length; i++) {
        switch(questionsData[i].answerTypeId) {
            case 0:
                if (createHtml) addQuestionVariants();
                var variantsData = questionsData[i].variants;
                for (j = 0; j < variantsData.length; j++) {
                    if (createHtml) addVariant(i);
                    $('#question' + i + 'VariantId' + j).val(variantsData[j].id);
                    $('#question' + i + 'VariantName' + j).val(variantsData[j].name);
                }
                break;
            case 1:
                if (createHtml) addQuestionText();
                break;
        }
        $('#questionId' + i).val(questionsData[i].id);
        $('#questionName' + i).val(questionsData[i].name);
    }
}

function saveQuest() {
    if ($('#quest').validator('update').validator('validate').has('.has-error').length == 0) {
        $.ajax({
            type: "POST",
            url: ajaxUrl,
            data: JSON.stringify($('#quest').serializeObject()),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                successNoty('quest.admin.saved');
                fillForm(data, data.questions, false)
            },
            error: function (jqXHR) {
                failNoty(jqXHR);
            }
        });
    }
    else
    {
        errorNoty('common.notAllFieldsFilledAllTabs');
    }
}
/*
function replacer(key, value) {
    if ($.isNumeric(value)) { return Number(value); }
    else { return value; }
}
*/
function addVariant(questionNumber) {
    var number = $('.form-questions .row#questionNumber' + questionNumber + ' .form-variants .form-group').length;
    $('.form-questions .row#questionNumber' + questionNumber + ' .form-variants')
        .append($('.template-variant').html()
            .replace(/'{number}'/g, number)
            .replace(/'{numberInc}'/g, (number + 1))
            .replace(/'{questionNumber}'/g, questionNumber));
    setAutoComplete('#question' + questionNumber + 'VariantName' + number);
    $('#question' + questionNumber + 'VariantNumber' + number).hide().fadeIn(200);

}

function deleteVariant(questionNumber, number) {
    var variantsCount = $('.form-questions .row#questionNumber' + questionNumber + ' .form-variants .form-group').length;
    if(variantsCount < 3) {
        errorNoty('quest.admin.less2variantsNoty');
        return false;
    }
    vPath = '#question' + questionNumber + 'VariantNumber';
    $(vPath + number).fadeOut(200,function(){$(this).remove(); reorderVariants(questionNumber);});
}

function reorderVariants(questionNumber) {
    var i = questionNumber;
    variants = $('.form-questions .row#questionNumber' + questionNumber + ' .form-variants .form-group');
    var variantsCount = variants.length;
    for (j = 0; j < variantsCount; j++) {
        var variantBody = variants[j];
        variantBody.setAttribute("id", "question" + i + "VariantNumber" + j);
        variantBody.children[0].setAttribute("id", "question" + i + "VariantId" + j);
        variantBody.children[0].setAttribute("name", "questions[" + i + "][variants][" + j + "][id]");
        variantBody.children[1].textContent = i18n['quest.admin.variant'] + " " + (j+1) + ":";
        variantBody.children[1].setAttribute("for", "question" + i + "VariantName" + j);
        variantBody.children[2].children[0].setAttribute("id", "question" + i + "VariantName" + j);
        variantBody.children[2].children[0].setAttribute("name", "questions[" + i +"][variants][" + j + "][name]");
        variantBody.children[3].setAttribute("onclick", "deleteVariant(" + i + "," + j + ")");
    }
}

function addQuestionVariants(create2Variants) {
    var number = $('.form-questions .row').length;
    $('.form-questions').append($('.template-question').html()
        .replace(/'{number}'/g, number)
        .replace(/'{numberInc}'/g, (number + 1)));
    $('.form-questions .row#questionNumber' + number + ' #questionNumberOrder' + number).val(number + 1);
    $('.form-questions .row#questionNumber' + number + ' #questionAnswerTypeId' + number).val(0);
    if (create2Variants) {
        addVariant(number);
        addVariant(number);
    }
    $('.form-questions .row#questionNumber' + number).hide().fadeIn(200);
}

function addQuestionText() {
    var number = $('.form-questions .row').length;
    $('.form-questions').append($('.template-question').html()
        .replace(/'{number}'/g, number)
        .replace(/'{numberInc}'/g, (number + 1)));
    $('.form-questions .row#questionNumber' + number + ' .form-variants').remove();
    $('.form-questions .row#questionNumber' + number + ' .pull-right').remove();
    $('.form-questions .row#questionNumber' + number + ' #questionNumberOrder' + number).val(number + 1);
    $('.form-questions .row#questionNumber' + number + ' #questionAnswerTypeId' + number).val(1);
    $('.form-questions .row#questionNumber' + number).hide().fadeIn(200);
}

function deleteQuestion(number) {
    qPath = '.form-questions .row#questionNumber';
    $(qPath + number).fadeOut(200,function(){$(this).remove(); reorderQuestions();});
}

function reorderQuestions() {
    questions = $('.form-questions .row');
    var questionsCount = questions.length;
    for (i = 0; i < questionsCount; i++) {
        questions[i].setAttribute("id", "questionNumber" + i);
        var questionBody = questions[i].children[0].children[0].children[0].children[0].children[0];
        questionBody.children[0].setAttribute("id", "questionId" + i);
        questionBody.children[0].setAttribute("name", "questions[" + i + "][id]");
        questionBody.children[1].setAttribute("id", "questionNumberOrder" + i);
        questionBody.children[1].setAttribute("name", "questions[" + i + "][number]");
        questionBody.children[1].setAttribute("value", i+1)
        questionBody.children[2].setAttribute("id", "questionAnswerTypeId" + i);
        questionBody.children[2].setAttribute("name", "questions[" + i + "][answerTypeId]");
        questionBody.children[3].textContent = i18n['quest.admin.question'] + " " + (i+1) + ":";
        questionBody.children[3].setAttribute("for", "questionName" + i);
        questionBody.children[4].children[0].setAttribute("id", "questionName" + i);
        questionBody.children[4].children[0].setAttribute("name", "questions[" + i + "][name]");
        var pullRight = questions[i].children[0].children[0].children[0].children[0].children[2];
        if (pullRight)
            pullRight.children[0].setAttribute("onclick", "addVariant(" + i + ")");
        var deleteQuestionButton = questions[i].children[0].children[0].children[1].children[0];
        deleteQuestionButton.setAttribute("onclick", "deleteQuestion(" + i + ")");
        reorderVariants(i);
    }
}

function setAutoComplete(inputId) {
    $(inputId).autocomplete({
        minLength: 1,
        delay: 500,
        source: function (request, response) {
            request: { query: request.term };
            $.getJSON(ajaxAutocompleteVariantsUrl, {query: request.term}, function (result) {
                response($.map(result, function (item) {
                    return {
                        label: item,
                        value: item
                    }
                }));
            });
        }
    });
}


function getQuestResults() {
    $('.form-results').empty();
    var ajaxUrlResults = ajaxUrl + questId + "/results/count/";
    $.get(ajaxUrlResults, function(data) {
        $('.form-results').append(
            '<h4>' + i18n['quest.admin.respondentsTotal'] + ': ' + data + '</h4>' +
            '<hr/>'
        ).hide().fadeIn(200);
        if (data != 0) {
            createCharts()
        }
        else {
            $('.form-results').append(
                '<div>' + i18n['quest.admin.noStatistics'] + '</div>'
            ).hide().fadeIn(200);
        }
    });
}

function createCharts() {
    var ajaxUrlStatistics = ajaxUrl + questId + "/questions/statistics/";
    $.get(ajaxUrlStatistics, function(data) {
        runChartsCreation(data)
    });
}


function runChartsCreation(questions) {
    for (i = 0; i < questions.length; i++) {
        if (questions[i].answerTypeId == 0) {
            createPieChart(questions[i].number, questions[i].name, questions[i].content);
        }
        else
        {
            createTextViewer(questions[i].number, questions[i].name, questions[i].id);
        }
    }
}

function createTextViewer(questionNumber, questionName, questionId) {
    elementId = 'question' + questionNumber + 'ResultPie';
    $('.form-results').append(
        '<label id="question' + questionNumber + 'ResultLabel" class="label-result control-label">' + questionNumber + ". " + questionName + '</label>' +
        '<div class="form-viewer text-left" id="question' + questionNumber + 'ResultTextViewer"></div>' +
        '<a id="question' + questionNumber + 'loadmore" class="loadmore" onclick="getAndShowNextAnswer(' + questionNumber + ',' + questionId +')">' + i18n['quest.admin.showMoreAnswers'] + '</a>' +
        '<hr/>'
    ).hide().fadeIn(200);
    getAndShowNextAnswer(questionNumber, questionId);
}

function getAndShowNextAnswer(questionNumber, questionId) {
    var startAnswerId = 0;
    var questionAnswerIdPath = '#question' + questionNumber + 'ResultTextViewer .questionAnswerId';
    if ($(questionAnswerIdPath).length) {
        var currentAnswerId = $(questionAnswerIdPath).length - 1;
        startAnswerId = $(questionAnswerIdPath)[currentAnswerId].value;
    }
    var ajaxUrlAnswerText = ajaxUrlQuestions + questionId + "/answers/getonemorethanid/";
    $.get(ajaxUrlAnswerText + startAnswerId, function (data) {
        if (data) {
            showNextAnswer(questionNumber, data)
        }
        else {
            $('#question' + questionNumber + 'loadmore').text(i18n['quest.admin.noMoreAnswers']);
            $('#question' + questionNumber + 'loadmore').addClass('loadmore-off');
        }
    });
}

function showNextAnswer(questionNumber, answer) {
    $('#question' + questionNumber + 'ResultTextViewer').append(
        '<input type="hidden" class="questionAnswerId" value="' + answer.id +'">' +
        '<div id="question' + questionNumber + 'Answer' + answer.id + 'Text" class="panel panel-default panel-body">' + answer.answerText + '</div>'

    );
    $('#question' + questionNumber + 'Answer' + answer.id + 'Text').hide().fadeIn(400);
}

function createPieChart(questionNumber, questionName, contentJson) {
    elementId = 'question' + questionNumber + 'ResultPie';
    $('.form-results').append(
        '<label id="question' + questionNumber + 'ResultLabel" class="label-result control-label">' + questionNumber + ". " + questionName + '</label>' +
        '<div id="question' + questionNumber + 'ResultPie"></div>' +
        '<hr/>'
        );

    new d3pie(elementId, {
        "size": {
            "canvasWidth": 1000,
            "canvasHeight": 700,
            "pieOuterRadius": 170
        },
        "data": {
            "content": contentJson
        },
        "labels": {
            "outer": {
                "pieDistance": 140
            },
            "mainLabel": {
                "fontSize": 17
            },
            "percentage": {
                "color": "#e1e1e1",
                "fontSize": 14,
                "decimalPlaces": 0
            },
            "value": {
                "color": "#e1e1e1",
            },
            "lines": {
                "enabled": true,
            }
        },
        "effects": {
            "pullOutSegmentOnClick": {
                "effect": "linear",
                "speed": 400,
                "size": 15
            }
        },
        "misc": {
            "pieCenterOffset": {
                "y": -15
            }
        },
        "callbacks": {}
    });
}