package com.example.edna.ui

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.edna.R

class SettingsFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
    }
}