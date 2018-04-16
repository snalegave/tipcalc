package edu.washington.snalegave.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mButton = findViewById(R.id.buttonGenTip) as Button
        val mEdit = findViewById(R.id.editAmount) as TextView
        val radioTipGroup = findViewById(R.id.radioTip) as RadioGroup

        mEdit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                //mEdit.setText("$"+ mEdit.getText().toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0.toString()== ""){
                    mButton.setEnabled(false);
                } else {
                    mButton.setEnabled(true);
                }

            }
        })
        mButton.setEnabled(false)
        mButton.setOnClickListener{

            val selectedID = radioTipGroup.checkedRadioButtonId

            var radioTipButton = findViewById(selectedID) as RadioButton

            val tipPercentage = radioTipButton.text.replace(Regex("\\D+"),"").toInt()

            val amount = ((mEdit.getText().toString()).toDouble())
            val tip = "%.2f".format((amount*tipPercentage/100))


            Toast.makeText(this@MainActivity, '$'+tip, Toast.LENGTH_SHORT).show()

        }


    }
}
