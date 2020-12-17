package com.ulisesdiaz.sqliteejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.ulisesdiaz.sqliteejemplo.DB.AlumnoCRUD
import com.ulisesdiaz.sqliteejemplo.Models.Alumno

class NuevoAlumnoActivity : AppCompatActivity() {

    var crud: AlumnoCRUD? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_alumno)

        val id = findViewById<EditText>(R.id.editId)
        val nombre = findViewById<EditText>(R.id.editNombre)
        val btnNuevoAlumno = findViewById<Button>(R.id.btnNuevoAlumno)

        crud = AlumnoCRUD(this)

        btnNuevoAlumno.setOnClickListener {
            crud?.newAlumno(Alumno(id.text.toString(), nombre.text.toString()))
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}