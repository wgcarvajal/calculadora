package com.arandasoft.pocsplit.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.arandasoft.pocsplit.R;
import com.arandasoft.pocsplit.controller.LoginController;

public class LoginActivity extends AppCompatActivity {

    private LoginController controller;

    public EditText getEdtUser() {
        return edtUser;
    }

    public Button getLoginBtn() {
        return loginBtn;
    }

    private EditText edtUser;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        controller.initListeners();
    }


    //Instantiate views
    private void init(){
        edtUser = findViewById(R.id.editText);
        loginBtn = findViewById(R.id.button);
    }

}
