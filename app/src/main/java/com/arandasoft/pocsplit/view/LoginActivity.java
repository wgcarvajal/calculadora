package com.arandasoft.pocsplit.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.arandasoft.pocsplit.R;
import com.arandasoft.pocsplit.controller.LoginController;

public class LoginActivity extends AppCompatActivity {

    private LoginController controller;

    public static ProgressBar getProgressBar() {
        return progressBar;
    }

    private static ProgressBar progressBar;

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
        controller = new LoginController(this);
        edtUser = findViewById(R.id.editText);
        loginBtn = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);
    }

}
