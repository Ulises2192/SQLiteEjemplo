package com.ulisesdiaz.sqliteejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.ulisesdiaz.sqliteejemplo.DB.AlumnoCRUD
import com.ulisesdiaz.sqliteejemplo.Models.Alumno

class DetalleAlumnoActivity : AppCompatActivity() {

    var crud: AlumnoCRUD? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_alumno)
        val editId = findViewById<EditText>(R.id.editId)
        val editNombre = findViewById<EditText>(R.id.editNombre)
        val btnActualizar = findViewById<Button>(R.id.btnActualizarAlumno)
        val btnEliminar = findViewById<Button>(R.id.btnElminarAlumno)

        val idAlumno = intent.getStringExtra("ID")

        crud = AlumnoCRUD(this)

        val item = crud?.getAlumno(idAlumno!!)

        editId.setText(item?.id)
        editNombre.setText(item?.nombre)

        btnActualizar.setOnClickListener {
            val alumno = Alumno(editId.text.toString(), editNombre.text.toString())
            crud?.updateAlumno(Alumno(editId.text.toString(), editNombre.text.toString()))
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnEliminar.setOnClickListener {
            crud?.deleteAlumno(Alumno(editId.text.toString(), editNombre.text.toString()))
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}