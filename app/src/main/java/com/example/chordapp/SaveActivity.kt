package com.example.chordapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.text.StringSearch
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import com.example.chordapp.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlinx.android.synthetic.main.activity_save.*


@ExperimentalStdlibApi
class SaveActivity : AppCompatActivity() {

    //private lateinit var acorde02: String

    private var acorde01: String? = null
    private var acorde02: String? = null
    private var acorde03: String? = null
    private var acorde04: String? = null
    private var acorde05: String? = null
    private var acorde06: String? = null
    private var songtype: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        btnWrite.setOnClickListener {
            writeFiles()
             }
        btnCheck.setOnClickListener {
            checkFiles()
            }

        playFiles()

    }

    private fun playFiles(){

        val btpl = findViewById<Button>(R.id.btnPlay)

        btpl.setOnClickListener {
            readFiles()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("my_name1", acorde01)
            intent.putExtra("my_name2", acorde02)
            intent.putExtra("my_name3", acorde03)
            intent.putExtra("my_name4", acorde04)
            intent.putExtra("my_name5", acorde05)
            intent.putExtra("my_name6", acorde06)
            intent.putExtra("song_type", songtype)
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

        val key3 = "mykey3"
        openFileOutput(key3, Context.MODE_PRIVATE).use {
            it.write(bt3Chd.text.toString().toByteArray())
        }

        val key4 = "mykey4"
        openFileOutput(key4, Context.MODE_PRIVATE).use {
            it.write(bt4Chd.text.toString().toByteArray())
        }

        val key5 = "mykey5"
        openFileOutput(key5, Context.MODE_PRIVATE).use {
            it.write(bt5Chd.text.toString().toByteArray())
        }

        val key6 = "mykey6"
        openFileOutput(key6, Context.MODE_PRIVATE).use {
            it.write(bt6Chd.text.toString().toByteArray())
        }
        Toast.makeText(applicationContext, "SAVED", Toast.LENGTH_SHORT).show()
    }

private fun readFiles(){

    try {
        val key1 = "mykey1"
        openFileInput(key1).use {
            acorde01 = it.readBytes().decodeToString()
            if (searchChord(acorde01!!) == false) acorde01 = ""
        }
    }
    catch (e : Exception){acorde01 = ""}



try{
    val key2 = "mykey2"
    openFileInput(key2).use{
        acorde02 = it.readBytes().decodeToString()
        if(searchChord(acorde02!!)==false) acorde02 = ""
    }
}
catch (e : Exception){acorde02 = ""}


try {
    val key3 = "mykey3"
    openFileInput(key3).use{
        acorde03 = it.readBytes().decodeToString()
        if(searchChord(acorde03!!)==false) acorde03 = ""
    }
}
catch (e : Exception){acorde03 = ""}

    try{
        val key4 = "mykey4"
        openFileInput(key4).use{
            acorde04 = it.readBytes().decodeToString()
            if(searchChord(acorde04!!)==false) acorde04 = ""
        }
    }
    catch (e : Exception){acorde04 = ""}

    try{
        val key5 = "mykey5"
        openFileInput(key5).use{
            acorde05 = it.readBytes().decodeToString()
            if(searchChord(acorde05!!)==false) acorde05 = ""
        }
    }
    catch (e : Exception){acorde05 = ""}


    try{
        val key6 = "mykey6"
        openFileInput(key6).use{
            acorde06 = it.readBytes().decodeToString()
            if(searchChord(acorde06!!)==false) acorde06 = ""
        }
    }
    catch (e : Exception){acorde06 = ""}


    val readswitch = findViewById<Switch>(R.id.switch2)

    if (readswitch.isChecked == true){
        songtype = "piano"
        }
    else{
        songtype= "keyboard"
    }

}


    private fun checkFiles(){
        readFiles()
        txt1.text = "Os Acodes são: $acorde01, $acorde02, $acorde03, $acorde04, $acorde05, $acorde06"
    }



     private fun searchChord(toFind: String): Boolean {

        var chords = arrayOf(
            "C", "Cm", "C#", "C#m", "Db", "Dbm",
            "D", "Dm", "D#", "D#m", "Eb", "Ebm",
            "E", "Em",
            "F", "Fm", "F#", "F#m", "Gb", "Gbm",
            "G", "Gm", "G#", "G#m", "Ab", "Abm",
            "A", "Am", "A#", "A#m", "Bb", "Bbm",
            "B", "Bm",""
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
        const val TAG = "SaveActivity"
        const val FILE_NAME = "my_file"
        const val K1CHD = "k1chd"
        const val K2CHD = "k2chd"
        const val K3CHD = "k3chd"
        const val K4CHD = "k4chd"
        const val K5CHD = "k5chd"
        const val K6CHD = "k6chd"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_settings, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.help_item) {
            val intent = Intent(this, HelpActivity::class.java)
            startActivity(intent)
        }
        return true
    }




}




