package com.example.proyectodelvideojugos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import  com.example.proyectodelvideojugos.ListaVideos.ListaRespuesta
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.file.Files.list
import java.util.Collections.list

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val url = "https://api.rawg.io/api/games?page=2"

        val vs = ListaJuegosV (this)

        val request = StringRequest(Request.Method.GET,url,{
                response: String? ->

            val gson = Gson()

            var ListaRespuesta = gson.fromJson(response,ListaRespuesta::class.java)

            textView.text = ListaRespuesta.results.get(1).name



        },{error: VolleyError? ->

        })

        vs.addToRequestQueue(request)
    }

}