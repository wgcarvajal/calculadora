package com.arandasoft.pocsplit.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.arandasoft.pocsplit.R;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeoutException;

import io.split.android.client.SplitClient;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.SplitFactory;
import io.split.android.client.SplitFactoryBuilder;
import io.split.android.client.api.Key;
import io.split.android.client.events.SplitEvent;
import io.split.android.client.events.SplitEventTask;

public class MainActivity extends AppCompatActivity {

    String apikey = "ghav3jk22qmt2o9t43oqvaqmhfrk31h1nacu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SplitClientConfig config = SplitClientConfig.builder()
                .build();

// Create a new user key to be evaluated
        String matching = "wilson";
        String bucketingKey = null;
        Key k = new Key(matching, bucketingKey);

// Create client
        SplitFactory splitFactory = null;


        try {
            splitFactory = SplitFactoryBuilder.build(apikey, k, config, getApplicationContext());
            SplitClient client = splitFactory.client();




            client.on(SplitEvent.SDK_READY, new SplitEventTask() {


                @Override
                public void onPostExecution(SplitClient client) {
                    String treatment = client.getTreatment("AndroidTestPot");
                    Log.i("treatment",treatment);
                }

            });
            client.on(SplitEvent.SDK_READY_TIMED_OUT, new SplitEventTask() {
                // handle for timeouts here
            });

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }




    }
}
