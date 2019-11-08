package com.arandasoft.pocsplit.split;

import android.content.Context;

import com.arandasoft.pocsplit.model.Operation;
import com.arandasoft.pocsplit.util.AppConstants;

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

/**
 * Created by Wilson Carvajal on 2019-11-08.
 */
public class SplitManager {

    private String name;
    private  SplitCallback callback;
    private Context context;

    public interface SplitCallback
    {
        void onSuccess(Operation operation);
        void onFailed(String error);
    }


    public SplitManager(Context context,String name)
    {
        this.name = name;
        this.context = context;
    }


    public void execute(final SplitCallback callback)
    {
        this.callback = callback;
        SplitClientConfig config = SplitClientConfig.builder()
                .build();
        String bucketingKey = null;
        Key k = new Key(name, bucketingKey);

        try {
            SplitFactory splitFactory = SplitFactoryBuilder.build(AppConstants.API_KEY, k, config, context.getApplicationContext());
            SplitClient client = splitFactory.client();
            client.on(SplitEvent.SDK_READY, new SplitEventTask() {
                @Override
                public void onPostExecution(SplitClient client) {
                    String androidTestPot = client.getTreatment("AndroidTestPot");
                    String androidTestSqrt = client.getTreatment("AndroidTestSqrt");

                    Operation operation = new Operation();
                    operation.setAndroidTestPot(androidTestPot);
                    operation.setAndroidTestSqrt(androidTestSqrt);
                    callback.onSuccess(operation);
                }

            });
            client.on(SplitEvent.SDK_READY_TIMED_OUT, new SplitEventTask() {
                @Override
                public void onPostExecution(SplitClient client) {
                    callback.onFailed("time out");
                }
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
