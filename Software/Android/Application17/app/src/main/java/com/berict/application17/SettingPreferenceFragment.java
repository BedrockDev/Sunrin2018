package com.berict.application17;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

public class SettingPreferenceFragment extends PreferenceFragment {

    SharedPreferences prefs;

    ListPreference network;
    // need to declare as a global variable due to avoid being garbage collected
    SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (key.equals("network")) {
                network.setSummary(sharedPreferences.getString("network", "LTE"));
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        network = (ListPreference) findPreference("network");

        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        network.setSummary(prefs.getString("network", "LTE"));

        prefs.registerOnSharedPreferenceChangeListener(listener);
    }
}
