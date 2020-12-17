package com.ulisesdiaz.sqliteejemplo.DB

import android.provider.BaseColumns

class AlumnosContract {

    companion object{

        val VERSION = 1
        val DATABASE_NAME = "alumno.db"

        class Entrada: BaseColumns{
            companion object{
                val NOMBRE_TABLA = "alumnos"
                val COLUMNA_ID = "id"
                val COLUMNA_NOMBRE = "nombre"
            }
        }
    }
}