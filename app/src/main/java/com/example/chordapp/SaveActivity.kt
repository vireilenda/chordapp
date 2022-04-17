package com.example.chordapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
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
    private var acorde07: String? = null
    private var acorde08: String? = null
    private var songtype: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        readFiles()

        btnWrite.setOnClickListener {
            writeFiles()
            readFiles()
             }
      //  btnCheck.setOnClickListener {
            //checkFiles()
       //     }

        val btpl2 = findViewById<Button>(R.id.button)
        btpl2.setOnClickListener {
            readFiles()
            val intent = Intent (this, PlayActivity::class.java)
            intent.putExtra("my_name1", acorde01)
            intent.putExtra("my_name2", acorde02)
            intent.putExtra("my_name3", acorde03)
            intent.putExtra("my_name4", acorde04)
            intent.putExtra("my_name5", acorde05)
            intent.putExtra("my_name6", acorde06)
            intent.putExtra("my_name7", acorde07)
            intent.putExtra("my_name8", acorde08)
            intent.putExtra("song_type", songtype)
            startActivity(intent)
            }


       // playFiles()

    }

//    private fun playFiles(){
//
//        val btpl = findViewById<Button>(R.id.btnPlay)
//
//        btpl.setOnClickListener {
//            readFiles()
//            val intent = Intent(this, MainActivity::class.java)
//            intent.putExtra("my_name1", acorde01)
//            intent.putExtra("my_name2", acorde02)
//            intent.putExtra("my_name3", acorde03)
//            intent.putExtra("my_name4", acorde04)
//            intent.putExtra("my_name5", acorde05)
//            intent.putExtra("my_name6", acorde06)
//            intent.putExtra("song_type", songtype)
//            startActivity(intent)
//        }
//
//    }

    private fun writeFiles(){
        val key1 = "mykey1"
        openFileOutput(key1, Context.MODE_PRIVATE).use {
            if(searchChord(bt1Chd.text.toString())==false){
                it.write("".toByteArray())
            }
            else it.write(bt1Chd.text.toString().toByteArray())
        }

        val key2 = "mykey2"
        openFileOutput(key2, Context.MODE_PRIVATE).use {
            if(searchChord(bt2Chd.text.toString())==false){
                it.write("".toByteArray())
            }
            else it.write(bt2Chd.text.toString().toByteArray())
        }

        val key3 = "mykey3"
        openFileOutput(key3, Context.MODE_PRIVATE).use {
            if(searchChord(bt3Chd.text.toString())==false){
                it.write("".toByteArray())
            }
            else it.write(bt3Chd.text.toString().toByteArray())
        }

        val key4 = "mykey4"
        openFileOutput(key4, Context.MODE_PRIVATE).use {
            if(searchChord(bt4Chd.text.toString())==false){
                it.write("".toByteArray())
            }
            else it.write(bt4Chd.text.toString().toByteArray())
        }

        val key5 = "mykey5"
        openFileOutput(key5, Context.MODE_PRIVATE).use {
            if(searchChord(bt5Chd.text.toString())==false){
                it.write("".toByteArray())
            }
            else it.write(bt5Chd.text.toString().toByteArray())
        }

        val key6 = "mykey6"
        openFileOutput(key6, Context.MODE_PRIVATE).use {
            if(searchChord(bt6Chd.text.toString())==false){
                it.write("".toByteArray())
            }
            else it.write(bt6Chd.text.toString().toByteArray())
        }
        val key7 = "mykey7"
        openFileOutput(key7, Context.MODE_PRIVATE).use {
            if(searchChord(bt7Chd.text.toString())==false){
                it.write("".toByteArray())
            }
            else it.write(bt7Chd.text.toString().toByteArray())
        }
        val key8 = "mykey8"
        openFileOutput(key8, Context.MODE_PRIVATE).use {
            if(searchChord(bt8Chd.text.toString())==false){
                it.write("".toByteArray())
            }
            else it.write(bt8Chd.text.toString().toByteArray())
        }

        Toast.makeText(applicationContext, "SAVED", Toast.LENGTH_SHORT).show()
    }

private fun readFiles(){

    try {
        val key1 = "mykey1"
        openFileInput(key1).use {
            acorde01 = it.readBytes().decodeToString()
            if (searchChord(acorde01!!) == false) acorde01 = ""
            textChord1.text = acorde01
            }
    }
    catch (e : Exception){
        acorde01 = ""
        textChord1.text = acorde01
    }

try{
    val key2 = "mykey2"
    openFileInput(key2).use{
        acorde02 = it.readBytes().decodeToString()
        if(searchChord(acorde02!!)==false) acorde02 = ""
        textChord2.text = acorde02
    }
}
catch (e : Exception){
    acorde02 = ""
    textChord2.text = acorde02
}


try {
    val key3 = "mykey3"
    openFileInput(key3).use{
        acorde03 = it.readBytes().decodeToString()
        if(searchChord(acorde03!!)==false) acorde03 = ""
        textChord3.text = acorde03
    }
}
catch (e : Exception){
    acorde03 = ""
    textChord3.text = acorde03
    }

    try{
        val key4 = "mykey4"
        openFileInput(key4).use{
            acorde04 = it.readBytes().decodeToString()
            if(searchChord(acorde04!!)==false) acorde04 = ""
            textChord4.text = acorde04
        }
    }
    catch (e : Exception){
        acorde04 = ""
        textChord4.text = acorde04
    }

    try{
        val key5 = "mykey5"
        openFileInput(key5).use{
            acorde05 = it.readBytes().decodeToString()
            if(searchChord(acorde05!!)==false) acorde05 = ""
            textChord5.text = acorde05
        }
    }
    catch (e : Exception){
        acorde05 = ""
        textChord5.text = acorde05
    }


    try{
        val key6 = "mykey6"
        openFileInput(key6).use{
            acorde06 = it.readBytes().decodeToString()
            if(searchChord(acorde06!!)==false) acorde06 = ""
            textChord6.text = acorde06
        }
    }
    catch (e : Exception){
        acorde06 = ""
        textChord6.text = acorde06
    }



    try{
        val key7 = "mykey7"
        openFileInput(key7).use{
            acorde07 = it.readBytes().decodeToString()
            if(searchChord(acorde07!!)==false) acorde07 = ""
            textChord7.text = acorde07
        }
    }
    catch (e : Exception){
        acorde07 = ""
        textChord7.text = acorde07
    }



    try{
        val key8 = "mykey8"
        openFileInput(key8).use{
            acorde08 = it.readBytes().decodeToString()
            if(searchChord(acorde08!!)==false) acorde08 = ""
            textChord8.text = acorde08
        }
    }
    catch (e : Exception){
        acorde08 = ""
        textChord8.text = acorde08
    }



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
        txt1.textSize = resources.getDimension(R.dimen.my_value)
        txt1.text = "Os Acordes são: $acorde01 $acorde02 $acorde03 $acorde04 $acorde05 $acorde06 $acorde07 $acorde08"
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




