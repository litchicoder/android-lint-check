package com.example.myapplication

import android.content.Context
import android.widget.Toast
import java.util.logging.Logger

class Test {
    // We have a custom lint check bundled with :library
    // that this module depends on. The lint check looks
    // for mentions of "lint", which should trigger an
    // error
    val s = "lint"
    fun lint(context: Context) {

        Toast.makeText(context,"hello",Toast.LENGTH_LONG).show()
    }
}
