package com.pescadinha.formcreator;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.pescadinha.formcreator.FormCreator.IFormCreatorListener;

public class MainActivity extends AppCompatActivity implements IFormCreatorListener, FormValidator.IFormValidation{

    private final static String TAG = "MainActivity";

    private FormCreator formCreator;
    private LinearLayout parentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentView = (LinearLayout) findViewById(R.id.parentView);


        /*FORM ATTRS*/
        FormFieldAttrs editTextAttrs = new FormFieldAttrs()
                .setHint("Enter username");

        FormFieldAttrs backgroundAttr = (FormFieldAttrs) editTextAttrs.clone();
        backgroundAttr.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));

        /*FORM VALIDATOR*/

        formCreator = new FormCreator.Builder(this, parentView)
                .addRow(new FormField(FormCreator.FormWidget.EDIT_TEXT, 1, editTextAttrs))
                .addRow(new FormField(FormCreator.FormWidget.BUTTON, 2, backgroundAttr))
                .setFormCreatorListener(this)
                .create();



    }

    @Override
    public void onFieldClick(int id) {
        System.out.println("ehehe");
        new FormValidator(this)
                .setRequiredFields(new FVRequiredField[]{
                        new FVRequiredField(formCreator.getViewById(1))
                }, true)
                .validate();
    }

    @Override
    public void onPasswordLengthError() {

    }

    @Override
    public void onEmailValidationError() {

    }

    @Override
    public void onRequiredFieldsError() {

    }

    @Override
    public void onValidationSuccessful() {

    }
}
