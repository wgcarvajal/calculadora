package com.arandasoft.pocsplit.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.arandasoft.pocsplit.R;
import com.arandasoft.pocsplit.util.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    private Button buttonpot;
    private Button buttonraiz;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        buttonpot = findViewById(R.id.buttonpot);
        buttonraiz = findViewById(R.id.buttonraiz);
        backButton = findViewById(R.id.backButton);

        PreferenceManager preferenceManager = PreferenceManager.getInstance(this);

        String pot = preferenceManager.getKeyPot();
        String sqrt = preferenceManager.getKeySqrt();

        showHide(pot,buttonpot);
        showHide(sqrt,buttonraiz);

        backButton.setOnClickListener(view -> {

            Intent loginIntent = new Intent(this,LoginActivity.class);
            startActivity(loginIntent);
            finish();

        });

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
