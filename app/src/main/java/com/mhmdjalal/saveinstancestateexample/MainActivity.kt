package com.mhmdjalal.saveinstancestateexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        var RESULT: String = "results"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getDouble(RESULT)

            text_result.text = result.toString()
        }

        button_result.setOnClickListener {
            val length = edittext_length.text.toString()
            val width = edittext_width.text.toString()
            val height = edittext_height.text.toString()

            if (length.trim().isEmpty()) {
                edittext_length.error = "Length must be not empty"
                return@setOnClickListener
            }

            if (width.trim().isEmpty()) {
                edittext_height.error = "Width must be not empty"
                return@setOnClickListener
            }

            if (height.trim().isEmpty()) {
                edittext_height.error = "Height must be not empty"
            }

            val result = length.toDouble() * width.toDouble() * height.toDouble()

            text_result.text = result.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble(RESULT, text_result.text.toString().toDouble())
    }
}
