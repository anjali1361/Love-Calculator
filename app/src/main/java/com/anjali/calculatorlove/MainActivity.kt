package com.anjali.calculatorlove

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main_small.*
import kotlin.random.Random

class MainActivity() : AppCompatActivity(){
    lateinit var male: EditText
    lateinit var female: EditText
    lateinit var button: Button
    lateinit var result:TextView
    var check = false
    var f: String =""
    var m: String=""

    var results:String =""

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_large)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = R.string.app_name.toString()

        showResult()
    }
  //when activity is destroyed this mthod gets called
//
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {//this bundle object helps us to preserve values of multiple views
//
//        f = female.getText().toString()
//        m = male.getText().toString()
//
//        outPersistentState.putString("male",m)
//        outPersistentState.putString("female",f)
//        outPersistentState.putString("result",results)
//
//        super.onSaveInstanceState(outState, outPersistentState)
//    }

    //to restore the value when recreated
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//
//        male.setText(savedInstanceState.getString("male"))
//        female.setText(savedInstanceState.getString("female"))
//        result.setText(savedInstanceState.getString("result"))
//
//        super.onRestoreInstanceState(savedInstanceState)
//    }

    @SuppressLint("SetTextI18n")
    fun showResult() {

        male = findViewById(R.id.etmale)
        female = findViewById(R.id.etfemale)
        result = findViewById(R.id.result)
        button = findViewById(R.id.btncaculator)

        button.setOnClickListener {

            f = female.getText().toString()
            m = male.getText().toString()

            val myRandomInt = Random.nextInt(until = 100)
            results ="$myRandomInt%"

            if (f.equals("") || m.equals("")) {
                Toast.makeText(this@MainActivity, R.string.enter_names, Toast.LENGTH_SHORT).show()
            } else {

                if(check) {
                    result.setText("")
                    etfemale.setText("")
                    etmale.setText("")
                    check = false
                    button.setText(R.string.calculate)
                }
                else{
                    result.setText(results)
                    check = true
                    button.setText(R.string.try_again)


                }
            }

        }

    }
}

