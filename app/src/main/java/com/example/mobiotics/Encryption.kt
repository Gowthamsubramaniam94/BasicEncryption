package com.example.mobiotics

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Encryption : AppCompatActivity() {

    var mEncryptionEDT: EditText? = null
    var mOutputTxt: TextView? = null
    var mSubmitBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encryption)

        init()
    }

    fun init() {

        mEncryptionEDT = findViewById(R.id.encryption_edt)
        mSubmitBtn = findViewById(R.id.encryption_btn)
        mOutputTxt = findViewById(R.id.encryption_output_txt)

        mSubmitBtn?.setOnClickListener { encryption(mEncryptionEDT?.text.toString()) }
        mEncryptionEDT?.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString().trim().equals("")) {
                    mSubmitBtn?.visibility == View.GONE
                }
                else {
                    mSubmitBtn?.visibility = View.VISIBLE
                }
            }
        })
    }


    fun encryption(aInput: String) {

        val charArray = aInput
        var output = ""
        var currentStr = charArray[0]
        var index = 0
        var idx = 1
        for (i in charArray) {
            if ((index + 1) < charArray.length) {
                if (i == charArray[index + 1]) {
                    idx += 1
                } else {
                    output = "$output $currentStr $idx"
                    idx = 1
                }
                currentStr = charArray[index + 1]
                index += 1
            } else if ((index + 1) == charArray.length) {
                output = "$output $currentStr $idx"
            }
            mOutputTxt?.visibility = View.VISIBLE
            mOutputTxt?.text = output
        }
    }
}