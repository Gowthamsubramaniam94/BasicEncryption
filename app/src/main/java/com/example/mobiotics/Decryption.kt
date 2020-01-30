package com.example.mobiotics

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_decryption.*

class Decryption : AppCompatActivity(){

    var mDecryptionEDT: EditText? = null
    var mOutputTxt: TextView? = null
    var mSubmitBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decryption)

        init()
    }

    fun init() {

        mDecryptionEDT = findViewById(R.id.decryption_edt)
        mSubmitBtn = findViewById(R.id.decryption_btn)
        mOutputTxt = findViewById(R.id.decryption_output_txt)

        mSubmitBtn?.setOnClickListener {
            decryption(mDecryptionEDT?.text.toString())
            hideKeyboard(decryption_main_view)}

        mDecryptionEDT?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s!!.length==0) {
                    mSubmitBtn?.visibility = View.GONE
                }
                else {
                    mSubmitBtn?.visibility = View.VISIBLE
                }

            }
        })
    }

    private fun hideKeyboard(view: View) {
        view.apply {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun decryption(aInput: String) {

        try {
            val output: StringBuffer? = StringBuffer()

            val aArray = aInput.chunked(2)

            for (i in aArray.indices) {

                val aStr: String = aArray[i]
                val aSize = Character.getNumericValue(aStr.get(1))

                for (j in 0 until aSize) {
                    output?.append(aStr.get(0).toString())
                }
            }
            mOutputTxt?.visibility = View.VISIBLE
            mOutputTxt?.text = output

        }catch (e:Exception){
            e.printStackTrace()
        }
    }


}