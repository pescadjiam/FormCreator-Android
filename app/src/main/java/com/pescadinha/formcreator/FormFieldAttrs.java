package com.pescadinha.formcreator;

import android.graphics.Color;

/**
 * Created by dengun on 02/09/16.
 */
public class FormFieldAttrs implements Cloneable{

    private String text, hint, gravity;
    private int textColor = -1, backgroundColor = -1;

    public FormFieldAttrs(){}

    @Override
    protected Object clone() {
        try {
            final FormFieldAttrs result = (FormFieldAttrs) super.clone();
            return result;
        } catch (final CloneNotSupportedException ex){
            throw new AssertionError();
        }

    }

    public FormFieldAttrs setText(String text){
        this.text = text;
        return this;
    }

    public FormFieldAttrs setHint(String hint){
        this.hint = hint;
        return this;
    }


    public FormFieldAttrs setGravity(String gravity) {
        this.gravity = gravity;
        return this;
    }

    public FormFieldAttrs setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public FormFieldAttrs setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public String getText() {
        return text;
    }

    public String getHint() {
        return hint;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public String getGravity() {
        return gravity;
    }
}
