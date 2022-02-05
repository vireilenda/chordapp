package com.example.chordapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.text.StringSearch
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.chordapp.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlinx.android.synthetic.main.activity_main2.*


@ExperimentalStdlibApi
class MainActivity2 : AppCompatActivity() {

    private lateinit var acorde01: String
    private lateinit var acorde02: String
    private lateinit var acorde03: String
    private lateinit var acorde04: String
    private lateinit var acorde05: String
    private lateinit var acorde06: String

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        btnWrite.setOnClickListener {
            writeFile()
            writeFiles()
             }
        btnCheck.setOnClickListener {
            checkFile()
            readFiles()
        }


        val btpl = findViewById<Button>(R.id.btnPlay)

        btpl.setOnClickListener {
            //val textbtn1 = bt1Chd.text.toString()
           // val textbtn2 = bt2Chd.text.toString()

            readFiles()

            val textbtn1 = acorde01
            val textbtn2 = acorde02
            val textbtn3 = bt3Chd.text.toString()
            val textbtn4 = bt4Chd.text.toString()
            val textbtn5 = bt5Chd.text.toString()
            val textbtn6 = bt6Chd.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("my_name1", textbtn1)
            intent.putExtra("my_name2", textbtn2)
            intent.putExtra("my_name3", textbtn3)
            intent.putExtra("my_name4", textbtn4)
            intent.putExtra("my_name5", textbtn5)
            intent.putExtra("my_name6", textbtn6)

            startActivity(intent)
        }





    }


    private fun writeFiles(){
        val key1 = "mykey1"
        openFileOutput(key1, Context.MODE_PRIVATE).use {
            it.write(bt1Chd.text.toString().toByteArray())
        }

        val key2 = "mykey2"
        openFileOutput(key2, Context.MODE_PRIVATE).use {
            it.write(bt2Chd.text.toString().toByteArray())
        }
    }

private fun readFiles(){
    val key1 = "mykey1"
    openFileInput(key1).use{
        acorde01 = it.readBytes().decodeToString()
    }
    val key2 = "mykey2"
    openFileInput(key2).use{
        acorde02 = it.readBytes().decodeToString()
    }



}




    private fun writeFile() {
        try {
            openFileOutput(FILE_NAME, MODE_PRIVATE).use {
//                var k1chd1 = bt1Chd.text.toString()
//                 if(k1chd1!=""){
//                    if (searchChord(k1chd1)==false){
//                        k1chd1 = ""
//                        }
//                }

//                var k1chd2 = bt2Chd.text.toString()
//                if(k1chd2!="") {
//                    if (searchChord(k1chd2) == false) {
//                        k1chd2 = ""
//                    }
//                }

                var k1chd3 = bt3Chd.text.toString()
                if(k1chd3!="") {
                    if (searchChord(k1chd3) == false) {
                        k1chd3 = ""
                    }
                }

                var k1chd4 = bt4Chd.text.toString()
                if(k1chd4!="") {
                    if (searchChord(k1chd4) == false) {
                        k1chd4 = ""
                    }
                }

                var k1chd5 = bt5Chd.text.toString()
                if(k1chd5!="") {
                    if (searchChord(k1chd5) == false) {
                        k1chd5 = ""
                    }
                }

                var k1chd6 = bt6Chd.text.toString()
                if(k1chd6!="") {
                    if (searchChord(k1chd6) == false) {
                        k1chd6 = ""
                    }
                }

                val result = "$k1chd3, $k1chd4, $k1chd5, $k1chd6"
                it.write(result.toByteArray())
                Toast.makeText(applicationContext, "SAVE", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error", e)


        }
    }



    private fun checkFile() {
        try {
            openFileInput(FILE_NAME).use {
                val result = it.readBytes().decodeToString()
                txt1.text = result
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error", e)
        }
    }

     private fun searchChord(toFind: String): Boolean {

        var chords = arrayOf(
            "C", "Cm", "C#", "C#m", "Db", "Dbm",
            "D", "Dm", "D#", "D#m", "Eb", "Ebm",
            "E", "Em",
            "F", "Fm", "F#", "F#m", "Gb", "Gbm",
            "G", "Gm", "G#", "G#m", "Ab", "Abm",
            "A", "Am", "A#", "A#m", "Bb", "Bbm",
            "B", "Bm",
        )

        var found = Arrays.stream(chords).anyMatch { t -> t == toFind }
        if (found == false) {
            Toast.makeText(applicationContext, "CHORD NOT FOUND", Toast.LENGTH_LONG).show()
            return (false)
        }
        else{
            return (true)
        }
    }

    companion object {
        const val TAG = "MainActivity2"
        const val FILE_NAME = "my_file"
        const val K1CHD = "k1chd"
        const val K2CHD = "k2chd"
        const val K3CHD = "k3chd"
        const val K4CHD = "k4chd"
        const val K5CHD = "k5chd"
        const val K6CHD = "k6chd"
    }


}




