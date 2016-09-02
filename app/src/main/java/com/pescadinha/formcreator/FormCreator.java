package com.pescadinha.formcreator;

import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by dengun on 02/09/16.
 */
public final class FormCreator {

    private static final String TAG = "FormCreator";

    private LinearLayout parentView;

    public FormCreator(LinearLayout parentView) {
        this.parentView = parentView;

        if(parentView == null){
            throw new NullPointerException("Your parent view cannot be null");
        }

        if(parentView.getOrientation() == LinearLayout.HORIZONTAL){
            throw new IllegalArgumentException("Your parent view must have vertical orientation");
        }
    }

    public static class Builder {

        private int formRows = 0;
        private LinearLayout parentView;
        private FormField[] widgets;

        public Builder(LinearLayout parentView){
            this.parentView = parentView;
        }

        public Builder addRow(FormField[] fields){
            this.widgets = fields;
            formRows++;
            return this;
        }

        public Builder addRow(FormField field){
            this.widgets = new FormField[] { field };
            return this;
        }

        public FormCreator create(){
            Log.d(TAG, formRows+"");
            return new FormCreator(parentView);
        }
    }






}
