package com.ulisesdiaz.sqliteejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ulisesdiaz.sqliteejemplo.Adaptadores.AdaptadorCustom
import com.ulisesdiaz.sqliteejemplo.DB.AlumnoCRUD
import com.ulisesdiaz.sqliteejemplo.Models.Alumno

class MainActivity : AppCompatActivity() {

    var lista: RecyclerView? = null
    var adaptador: AdaptadorCustom? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    var alumnos: ArrayList<Alumno>? = null
    var crud: AlumnoCRUD? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        lista = findViewById(R.id.lista)


        // Configuracion LayoutManager
        lista?.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        lista?.layoutManager = layoutManager

        fab.setOnClickListener {
            startActivity(Intent(this, NuevoAlumnoActivity::class.java))
        }

        crud = AlumnoCRUD(this)
        alumnos = crud?.getAlumnos()

        adaptador = AdaptadorCustom(alumnos!!, object: ClickListener{
            override fun clickListener(view: View, index: Int) {
                Log.d("click", "implementar clicklistener")
                val intent = Intent(applicationContext, DetalleAlumnoActivity::class.java)
                intent.putExtra("ID", alumnos?.get(index)?.id)
                startActivity(intent)

            }

        }, object: LongClickListener{
            override fun lonClickListener(view: View, index: Int) {
                Log.d("LonClick", "implementar LonListener")
            }

        })

        lista?.adapter = adaptador
    }


}