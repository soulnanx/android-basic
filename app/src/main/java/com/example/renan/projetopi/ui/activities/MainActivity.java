package com.example.renan.projetopi.ui.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.renan.projetopi.R;
import com.example.renan.projetopi.application.App;
import com.example.renan.projetopi.entity.Contact;


public class MainActivity extends ActionBarActivity {

    private UIHelper ui;
    private Contact contact;
    private App app;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        ui = new UIHelper();
        contact = new Contact();
        app = (App)getApplication();

        setEvents();
    }

    private void setEvents() {
        ui.img.setOnClickListener(eventBtn());
    }

    private View.OnClickListener eventBtn() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ui.edtName.getText().toString().isEmpty() || ui.edtNumber.getText().toString().isEmpty() ){
                    Toast.makeText(MainActivity.this, "Tá vazio saporra", Toast.LENGTH_SHORT).show();
                } else {
                    contact.setName(ui.edtName.getText().toString());
                    contact.setNumber(ui.edtNumber.getText().toString());

                    app.adapter.store(contact);

                    Contact c = app.adapter.findAll(Contact.class).get(0);

                    Toast.makeText(MainActivity.this, c.getName() + " was created!", Toast.LENGTH_SHORT).show();
                }

            }
        };
    }

    class UIHelper {
        ImageView img;
        EditText edtName;
        EditText edtNumber;

        public UIHelper(){
            img = (ImageView)findViewById(R.id.img_btn);
            edtName = (EditText)findViewById(R.id.name);
            edtNumber = (EditText)findViewById(R.id.number);
        }

    }

}
