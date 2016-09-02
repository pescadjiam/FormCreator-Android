package com.pescadinha.formcreator;

/**
 * Created by dengun on 02/09/16.
 */
public class FormField {

    public enum FormWidget {
        EDIT_TEXT, CHECKBOX, BUTTON;
    }

    private FormWidget widget;

    public FormField(FormWidget widget){
        this.widget = widget;
    }
}
