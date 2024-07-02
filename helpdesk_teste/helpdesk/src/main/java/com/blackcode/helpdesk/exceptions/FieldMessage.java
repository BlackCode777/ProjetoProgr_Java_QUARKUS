package com.blackcode.helpdesk.exceptions;

public class FieldMessage implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String messageDefault;

    public FieldMessage() {
    };

    public FieldMessage(String fieldName, String messageDefault) {
        this.fieldName = fieldName;
        this.messageDefault = messageDefault;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessageDefault() {
        return messageDefault;
    }

    public void setMessageDefault(String messageDefault) {
        this.messageDefault = messageDefault;
    }

}
