package com.example.padc_x_recyclerview_tyno_rerun.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

abstract class BasicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    fun showInDialog(){
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Alert Dialog")
        alertDialog.setMessage("Hello Recycler View")
        alertDialog.setPositiveButton("OK"){ dialog, which ->
            dialog.cancel()
            alertDialog.show()
        }
    }
    fun showSnackbar(message : String) {
        Snackbar.make(window.decorView, message,Snackbar.LENGTH_LONG).show()
    }
}
