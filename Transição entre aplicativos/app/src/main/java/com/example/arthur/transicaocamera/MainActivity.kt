package com.example.arthur.transicaocamera

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var ImagemTirada : ImageView
    private lateinit var BotaoTirarFoto: Button
    private lateinit var NomeFoto: TextView
    private val CAMERA_REQUEST_CODE = 101


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.ImagemTirada = findViewById(R.id.imgemTirada)
        this.BotaoTirarFoto= findViewById(R.id.botaoTirarFoto)

        this.BotaoTirarFoto.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)


        }
    }

//    fun Foto(){
//        val intent : Intent(MediaStore.ACTION_IMAGE_CAPTURE),
//        if (intent.resolveActivity(packageManager) != null){
//            startActivity(intent)
//        }
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            ImagemTirada.setImageBitmap(imageBitmap)
        }
    }


}