package com.pescadinha.formcreator;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.pescadinha.formcreator.FormCreator.IFormCreatorListener;

public class MainActivity extends AppCompatActivity implements IFormCreatorListener{

    private final static String TAG = "MainActivity";

    private FormCreator formCreator;
    private LinearLayout parentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentView = (LinearLayout) findViewById(R.id.parentView);


        FormFieldAttrs editTextAttrs = new FormFieldAttrs()
                .setHint("Enter username");

        FormFieldAttrs backgroundAttr = (FormFieldAttrs) editTextAttrs.clone();

        backgroundAttr.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));

        new FormCreator.Builder(this, parentView)
                .addRow(new FormField(FormCreator.FormWidget.EDIT_TEXT, 1, editTextAttrs))
                .addRow(new FormField(FormCreator.FormWidget.BUTTON, 2, backgroundAttr))
                .setFormCreatorListener(this)
                .create();
    }

    @Override
    public void onFieldClick(int id) {
        Log.d(TAG, id+"");
    }
}
