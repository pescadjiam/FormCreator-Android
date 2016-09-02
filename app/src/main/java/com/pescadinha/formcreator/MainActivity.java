package com.pescadinha.formcreator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private FormCreator formCreator;
    private LinearLayout parentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentView = (LinearLayout) findViewById(R.id.parentView);

        new FormCreator.Builder(parentView)
                .addRow(new FormField(FormField.FormWidget.EDIT_TEXT))

                .addRow(new FormField[] {
                        new FormField(FormField.FormWidget.EDIT_TEXT),
                        new FormField(FormField.FormWidget.BUTTON)
                })
                .create();



    }
}
