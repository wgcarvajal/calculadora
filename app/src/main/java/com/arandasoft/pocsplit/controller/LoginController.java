package com.arandasoft.pocsplit.controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.arandasoft.pocsplit.model.Operation;
import com.arandasoft.pocsplit.split.SplitManager;
import com.arandasoft.pocsplit.util.PreferenceManager;
import com.arandasoft.pocsplit.view.LoginActivity;
import com.arandasoft.pocsplit.view.MainActivity;

public class LoginController implements SplitManager.SplitCallback {

    private LoginActivity loginActivity;

    public LoginController(LoginActivity activity){
        loginActivity = activity;
    }



    public void initListeners(){
        loginActivity.getLoginBtn().setOnClickListener(view -> {
            //ProgressBar

            closeKeyboard();
            String name = loginActivity.getEdtUser()
                    .getText().toString();
            if(name.isEmpty())
            {
                String errorMessage = "Ingrese usuario";
                Toast.makeText(loginActivity, errorMessage,Toast.LENGTH_LONG).show();
            }
            else {
                LoginActivity.getProgressBar().setVisibility(View.VISIBLE);
                SplitManager splitManager = new SplitManager(loginActivity, name);

                splitManager.execute(this);
            }

        });
    }

    @Override
    public void onSuccess(Operation operation) {
        LoginActivity.getProgressBar().setVisibility(View.GONE);

        //Guardar en SharedPreferences

        String pot = operation.getAndroidTestPot();
        String sqrt = operation.getAndroidTestSqrt();

        Log.i("response pot",pot);
        Log.i("response sqrt",sqrt);
        PreferenceManager preferenceManager = PreferenceManager.getInstance(loginActivity);
        preferenceManager.setKeyPot(pot);
        preferenceManager.setKeySqrt(sqrt);
        operation.getAndroidTestSqrt();
        Intent calculatorIntent = new Intent(loginActivity,MainActivity.class);
        loginActivity.startActivity(calculatorIntent);
        loginActivity.finish();

    }

    @Override
    public void onFailed(String error) {

        LoginActivity.getProgressBar().setVisibility(View.GONE);
        String errorMessage = "Ocurrió un error con la conexión";

        //Mostrar un toast de error
        Toast.makeText(loginActivity, errorMessage,Toast.LENGTH_LONG).show();
    }

    private void closeKeyboard() {
        View view = loginActivity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) loginActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
