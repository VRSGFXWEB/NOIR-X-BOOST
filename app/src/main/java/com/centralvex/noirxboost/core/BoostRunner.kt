package com.centralvex.noirxboost.core

import android.content.Context
import android.util.Log
import java.io.File

/**
 * Menjalankan boost_noir.sh dari assets. Tidak ada pengecekan status
 * premium/berlangganan di sini — setiap pemanggilan langsung dieksekusi.
 */
object BoostRunner {
    private const val TAG = "NoirBoost"
    private const val SCRIPT_NAME = "boost_noir.sh"

    fun runFullBoost(context: Context? = null) {
        if (context == null) {
            Log.i(TAG, "runFullBoost() dipanggil tanpa context — lewati eksekusi shell.")
            return
        }
        try {
            val scriptFile = File(context.cacheDir, SCRIPT_NAME)
            context.assets.open("scripts/$SCRIPT_NAME").use { input ->
                scriptFile.outputStream().use { output -> input.copyTo(output) }
            }
            scriptFile.setExecutable(true)

            val process = ProcessBuilder("su", "-c", scriptFile.absolutePath)
                .redirectErrorStream(true)
                .start()
            process.waitFor()
            Log.i(TAG, "Boost selesai dengan kode: ${process.exitValue()}")
        } catch (e: Exception) {
            Log.e(TAG, "Boost gagal dijalankan: ${e.message}")
        }
    }
}
