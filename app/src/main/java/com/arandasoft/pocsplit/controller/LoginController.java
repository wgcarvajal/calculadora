package com.arandasoft.pocsplit.controller;

import com.arandasoft.pocsplit.view.LoginActivity;

public class LoginController {

    private LoginActivity loginActivity;

    public LoginController(LoginActivity activity){
        loginActivity = activity;
    }



    public void initListeners(){
        loginActivity.getLoginBtn().setOnClickListener(view -> {

        });
    }

}
