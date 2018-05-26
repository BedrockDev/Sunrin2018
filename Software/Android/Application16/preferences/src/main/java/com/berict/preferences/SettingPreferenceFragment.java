package com.berict.preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.annotation.Nullable;

public class SettingPreferenceFragment extends PreferenceFragment {

    SharedPreferences prefs;

    ListPreference soundPreference;
    ListPreference keywordSoundPreference;
    PreferenceScreen keywordScreen;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        soundPreference = (ListPreference) findPreference("sound_list");
        keywordScreen = (PreferenceScreen) findPreference("keyword_screen");
        keywordSoundPreference = (ListPreference) findPreference("keyword_sound_list");

        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (!prefs.getString("sound_list", "").equals("")) {
            soundPreference.setSummary(prefs.getString("sound_list", "Helium"));
        }
        if (!prefs.getString("keyword_sound_list", "").equals("")) {
            soundPreference.setSummary(prefs.getString("keyword_sound_list", "Helium"));
        }

        if (prefs.getBoolean("keyword", false)) {
            keywordSoundPreference.setSummary("Enabled");
        } else {
            keywordSoundPreference.setSummary("Disabled");
        }

        prefs.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                if (key.equals("sound_list")) {
                    soundPreference.setSummary(prefs.getString("sound_list", "Helium"));
                }
                if (key.equals("keyword_sound_list")) {
                    keywordSoundPreference.setSummary(prefs.getString("keyword_sound_list", "Helium"));
                }
                if (key.equals("keyword")) {
                    if (sharedPreferences.getBoolean("keyword", false)) {
                        keywordScreen.setSummary("Enabled (modified)");
                        getPreferenceScreen().setSummary("Keyword alert (modified to enabled)");
                    } else {
                        keywordScreen.setSummary("Disabled (modified)");
                        getPreferenceScreen().setSummary("Keyword alert (modified to disabled)");
                    }
                }
            }
        });
    }
}
