package com.pescadinha.formcreator;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by dengun on 02/09/16.
 */
public class FormCreator {

    public interface IFormCreatorListener {
        void onFieldClick(int id);
    }

    private static final String TAG = "FormCreator";

    private LinearLayout parentView;
    private Context context;


    public enum FormWidget {
        EDIT_TEXT, CHECKBOX, BUTTON;
    }

    public FormCreator(Context context, LinearLayout parentView) {
        this.parentView = parentView;
        this.context = context;

        if(parentView == null){
            throw new NullPointerException("Your parent view cannot be null");
        }

        if(parentView.getOrientation() == LinearLayout.HORIZONTAL){
            throw new IllegalArgumentException("Your parent view must have vertical orientation");
        }
    }

    public static class Builder implements View.OnClickListener{

        private LinearLayout parentView;
        private FormField[] fields;
        private Context context;

        private View.OnClickListener clickListener;
        private IFormCreatorListener iFormCreatorListener;

        public Builder(Context context, LinearLayout parentView){
            this.parentView = parentView;
            this.context = context;
        }

        public Builder setFormCreatorListener(IFormCreatorListener iFormCreatorListener){
            this.iFormCreatorListener = iFormCreatorListener;
            return this;
        }

       public Builder addRow(FormField[] fields){
            this.fields = fields;
            handleField(fields);
            return this;
       }

        public Builder addRow(FormField field){
            this.fields = new FormField[] { field };
            handleField(fields);
            return this;
        }

        public FormCreator create(){
            return new FormCreator(context, parentView);
        }

        private void handleField(FormField[] formFields){
            if(formFields.length == 1){
                FormField field = formFields[0];

                if(field.getFormFieldAttrs() != null){

                    FormFieldAttrs attrs = field.getFormFieldAttrs();

                    switch (field.getFormWidget()) {
                        case EDIT_TEXT:
                            EditText editText = new EditText(context);

                            if(field.getId() != -1){
                                editText.setId(field.getId());
                            }

                            if(attrs.getText() != null){
                                editText.setText(attrs.getText());
                            }

                            if(attrs.getHint() != null){
                                editText.setHint(attrs.getHint());
                            }

                            if(attrs.getBackgroundColor() != -1) {
                                editText.setBackgroundColor(attrs.getBackgroundColor());
                            }

                            if(iFormCreatorListener != null){
                                editText.setOnClickListener(this);
                            }

                            parentView.addView(editText);
                            break;
                        case BUTTON:
                            Button button = new Button(context);

                            if(field.getId() != -1){
                                button.setId(field.getId());
                            }

                            if(attrs.getText() != null){
                                button.setText(attrs.getText());
                            }

                            if(attrs.getHint() != null){
                                button.setHint(attrs.getHint());
                            }

                            if(attrs.getBackgroundColor() != -1) {
                                button.setBackgroundColor(attrs.getBackgroundColor());
                            }


                            button.setOnClickListener(this);
                            parentView.addView(button);
                    }
                }
            }
        }

        @Override
        public void onClick(View view) {
            if(iFormCreatorListener != null && view.getId() != -1){
                iFormCreatorListener.onFieldClick(view.getId());
            }
        }
    }







}
