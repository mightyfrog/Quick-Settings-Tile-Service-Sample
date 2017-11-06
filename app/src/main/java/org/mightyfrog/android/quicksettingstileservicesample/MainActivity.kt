package org.mightyfrog.android.quicksettingstileservicesample

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author Shigehiro Soejima
 */
class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val enabled = prefs.getBoolean("enabled", true)
        if (enabled) {
            tileStateText.text = getString(R.string.tile_enabled)
        } else {
            tileStateText.text = getString(R.string.tile_disabled)
        }

        fab.setOnClickListener {
            toggleTileState()
        }
    }

    private fun toggleTileState() {
        val enabled = prefs.getBoolean("enabled", true)
        if (enabled) {
            tileStateText.text = getString(R.string.tile_disabled)
        } else {
            tileStateText.text = getString(R.string.tile_enabled)
        }
        prefs.edit().putBoolean("enabled", !enabled).apply()
    }
}
