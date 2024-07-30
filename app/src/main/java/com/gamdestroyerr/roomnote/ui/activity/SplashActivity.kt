package com.gamdestroyerr.roomnote.ui.activity

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.io.InputStream

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crear un ImageView programáticamente
        val splashImageView = ImageView(this)
        splashImageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        // Intentar cargar la imagen desde la carpeta assets
        try {
            val inputStream: InputStream = assets.open("imgencarga.png") // Asegúrate de que la extensión sea correcta
            val bitmap = BitmapFactory.decodeStream(inputStream)
            splashImageView.setImageBitmap(bitmap)
            splashImageView.scaleType = ImageView.ScaleType.CENTER_CROP
            inputStream.close() // Cierra el InputStream después de usarlo
        } catch (e: Exception) {
            e.printStackTrace() // Manejo de errores en caso de que la imagen no se encuentre

        }

        setContentView(splashImageView)

        // Define la duración del splash screen (en milisegundos)
        val splashScreenDuration = 3000 // 3 segundos

        // Usa Handler para esperar la duración del splash screen antes de iniciar la siguiente actividad
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, NoteActivity::class.java)
            startActivity(intent)
            finish()
        }, splashScreenDuration.toLong())
    }
}
