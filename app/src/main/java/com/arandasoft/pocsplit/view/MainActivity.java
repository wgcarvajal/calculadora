package com.arandasoft.pocsplit.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.arandasoft.pocsplit.R;
import com.arandasoft.pocsplit.util.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    private Button buttonpot;
    private Button buttonraiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        buttonpot = findViewById(R.id.buttonpot);
        buttonraiz = findViewById(R.id.buttonraiz);

        PreferenceManager preferenceManager = PreferenceManager.getInstance(this);

        String pot = preferenceManager.getKeyPot();
        String sqrt = preferenceManager.getKeySqrt();

        showHide(pot,buttonpot);
        showHide(sqrt,buttonraiz);

    }

    private void showHide(String flag,Button btn)
    {
        switch (flag)
        {
            case "off":
                btn.setVisibility(View.GONE);
                break;
            case "on":
                btn.setVisibility(View.VISIBLE);
                break;
            default:
                btn.setVisibility(View.GONE);
                break;
        }
    }
}
