package and08.lifecycle

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(javaClass.simpleName, "\"onCreate\" durchlaufen")
        Log.i(javaClass.simpleName, "savedInstanceState =${savedInstanceState}")
    }

    override fun onStart() {
        super.onStart()
        Log.i(javaClass.simpleName, "\"onStart\" durchlaufen")
    }

    override fun onResume() {
        super.onResume()
        Log.i(javaClass.simpleName, "\"onResume\" durchlaufen")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(javaClass.simpleName, "\"onRestart\" durchlaufen")
    }

    override fun onPause() {
        super.onPause()
        Log.i(javaClass.simpleName, "\"onPause\" durchlaufen")
    }

    override fun onStop() {
        super.onStop()
        Log.i(javaClass.simpleName, "\"onStop\" durchlaufen")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(javaClass.simpleName, "\"onDestroy\" durchlaufen")
    }

    override protected fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("test", "onSaveInstanceState-String")
        Log.i(javaClass.simpleName, "\"onSaveInstanceState\" durchlaufen")
    }

    override protected fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        findViewById<TextView>(R.id.edittext_lifecycle).text =
            savedInstanceState.getString("test")
        Log.i(javaClass.simpleName, "\"onRestoreInstanceState\" durchlaufen")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            Log.i(javaClass.simpleName, "@ Auf Landscape umgeschaltet")
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            Log.i(javaClass.simpleName, "@ Auf Portrait umgeschaltet")
    }
}