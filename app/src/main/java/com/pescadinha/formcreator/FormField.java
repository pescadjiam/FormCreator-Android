package com.pescadinha.formcreator;

import android.graphics.Color;
import android.widget.EditText;

/**
 * Created by dengun on 02/09/16.
 */
public class FormField {

    private FormCreator.FormWidget formWidget;
    private FormFieldAttrs formFieldAttrs;
    private int id;

    public FormField(FormCreator.FormWidget formWidget, int id ,FormFieldAttrs formFieldAttrs){
        this.formWidget = formWidget;
        this.formFieldAttrs = formFieldAttrs;
        this.id = id;
    }

    public FormFieldAttrs getFormFieldAttrs() {
        return formFieldAttrs;
    }

    public FormCreator.FormWidget getFormWidget() {
        return formWidget;
    }

    public int getId() {
        return id;
    }
}
