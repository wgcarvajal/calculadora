package com.arandasoft.pocsplit.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Wilson Carvajal on 2019-11-08.
 */
public class PreferenceManager {

    /**
     * Instance
     */
    private static PreferenceManager preferencesManager = null;

    /**
     * Shared Preferences
     */
    private SharedPreferences sharedPreferences;

    /**
     * Preferences variables
     */
    private PreferenceManager(Context context) {

        sharedPreferences = context
                .getSharedPreferences(
                        AppConstants.Preferences.PREFERENCES_NAME,
                        Context.MODE_PRIVATE);
    }

    /**
     * Return the only instance
     *
     * @param context
     */
    public static PreferenceManager getInstance(Context context) {
        if (preferencesManager == null) {
            preferencesManager = new PreferenceManager(context);
        }
        return preferencesManager;
    }

    // Private mode
    private SharedPreferences.Editor getEditor() {
        return sharedPreferences.edit();
    }

    public boolean setKeyPot(String keyPot)
    {
        return  getEditor().putString(AppConstants.configuration.KEY_POT,keyPot).commit();
    }

    public String getKeyPot()
    {
        return  sharedPreferences.getString(AppConstants.configuration.KEY_POT,"");
    }

    public boolean setKeySqrt(String keySqrt)
    {
        return  getEditor().putString(AppConstants.configuration.KEY_SQRT,keySqrt).commit();
    }

    public String getKeySqrt()
    {
        return  sharedPreferences.getString(AppConstants.configuration.KEY_SQRT,"");
    }
}
