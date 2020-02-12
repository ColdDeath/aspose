package ru.gbuac.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IfStatement {
    String condition;
    String thenVal;
    String elseVal;
    String fullText;

    public IfStatement(String condition, String thenVal, String elseVal, String fullText) {
        this.condition = condition;
        this.thenVal = thenVal;
        this.elseVal = elseVal;
        this.fullText = fullText;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getThenVal() {
        return thenVal;
    }

    public void setThenVal(String thenVal) {
        this.thenVal = thenVal;
    }

    public String getElseVal() {
        return elseVal;
    }

    public void setElseVal(String elseVal) {
        this.elseVal = elseVal;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }
}
