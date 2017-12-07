package org.mightyfrog.android.quicksettingstileservicesample

import android.content.Intent
import android.content.SharedPreferences
import android.os.IBinder
import android.preference.PreferenceManager
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.util.Log

/**
 * @author Shigehiro Soejima
 */
class CustomTileService : TileService() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate() {
        super.onCreate()

        prefs = PreferenceManager.getDefaultSharedPreferences(this)
    }

    override fun onClick() {
        Log.e("test", "onClick")

        if (qsTile.state == Tile.STATE_ACTIVE) {
            Intent(this, MainActivity::class.java).apply {
                startActivityAndCollapse(this)
            }
        }
    }

    override fun onTileRemoved() {
        Log.e("test", "onTileRemoved")
    }

    override fun onTileAdded() {
        Log.e("test", "onTileAdded")
    }

    override fun onStartListening() {
        Log.e("test", "onStartListening")
        if (prefs.getBoolean("enabled", true)) {
            qsTile.state = Tile.STATE_ACTIVE
        } else {
            qsTile.state = Tile.STATE_INACTIVE
        }
        qsTile.updateTile()
    }

    override fun onBind(intent: Intent?): IBinder {
        Log.e("test", "onBind")
        return super.onBind(intent)
    }

    override fun onStopListening() {
        Log.e("test", "onStopListening")
        super.onStopListening()
    }

    override fun onDestroy() {
        Log.e("test", "onDestroy")
        super.onDestroy()
    }
}