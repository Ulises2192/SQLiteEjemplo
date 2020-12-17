package com.ulisesdiaz.sqliteejemplo

import android.view.View

/****
 * Project: SQLiteEjemplo
 * From: com.ulisesdiaz.sqliteejemplo
 * Created by: Ulises Diaz on 16/12/20 ar 02:09 PM
 * All rights reserved 2020
 ****/
interface ClickListener {

    fun clickListener(view: View, index: Int)
}