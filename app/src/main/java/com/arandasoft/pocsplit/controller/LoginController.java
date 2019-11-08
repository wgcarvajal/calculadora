package com.arandasoft.pocsplit.controller;

import android.view.View;
import android.widget.Toast;

import com.arandasoft.pocsplit.model.Operation;
import com.arandasoft.pocsplit.split.SplitManager;
import com.arandasoft.pocsplit.view.LoginActivity;

public class LoginController implements SplitManager.SplitCallback {

    private LoginActivity loginActivity;

    public LoginController(LoginActivity activity){
        loginActivity = activity;
    }



    public void initListeners(){
        loginActivity.getLoginBtn().setOnClickListener(view -> {
            //ProgressBar

            LoginActivity.getProgressBar().setVisibility(View.VISIBLE);
            SplitManager splitManager = new SplitManager(loginActivity, loginActivity.getEdtUser()
                    .getText().toString());

            splitManager.execute(this);

        });
    }

    @Override
    public void onSuccess(Operation operation) {
        //Guardar en SharedPreferences

        operation.getAndroidTestPot();
        operation.getAndroidTestSqrt();
        //Lanzar la calculadora

    }

    @Override
    public void onFailed(String error) {

        String errorMessage = "Ocurrió un error con la conexión";

        //Mostrar un toast de error
        Toast.makeText(loginActivity, errorMessage,Toast.LENGTH_LONG).show();
    }
}
