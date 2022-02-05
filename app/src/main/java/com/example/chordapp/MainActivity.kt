package com.example.chordapp

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.Switch
import android.widget.ToggleButton
import androidx.annotation.RequiresApi
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import com.example.chordapp.MainActivity2.Companion.K1CHD
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates
import kotlin.arrayOf as arrayOf


@ExperimentalStdlibApi
class MainActivity : AppCompatActivity() {

    private var c4 = 0
    private  var c4Black:Int = 0
    private  var d4:Int = 0
    private  var d4Black:Int = 0
    private  var e4:Int = 0
    private  var f4:Int = 0
    private  var f4Black:Int = 0
    private  var g4:Int = 0
    private  var g4Black:Int = 0
    private  var a4:Int = 0
    private  var a4Black:Int = 0
    private  var b4:Int = 0
    private var c5 = 0
    private  var c5Black:Int = 0
    private  var d5:Int = 0
    private  var d5Black:Int = 0
    private  var e5:Int = 0
    private var f5:Int = 0
    private  var f5Black:Int = 0
    private  var g5:Int = 0
    private  var g5Black:Int = 0
    private  var a5:Int = 0
    private  var a5Black:Int = 0
    private  var b5:Int = 0


    private lateinit var soundPool:SoundPool

private class KeyChord(
        var btntxt:String = "",
        var btnchord:String = "",
        var outputSound:Boolean = true
)


    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



/*
        val teste5 = "C"
        val song5 = findViewById<Button>(R.id.button5)
        song5.setOnClickListener {
            selectButtonChord(teste5)
        }

        */

        soundPool=SoundPool.Builder().setMaxStreams(8).build()
        sounds()


       // val key1= KeyChord()


        //key1.btnchord = intent.getStringExtra("my_name1").toString()
        //button1.text =key1.btnchord


        val chordbtn1: String = intent.getStringExtra("my_name1").toString()
        val chordbtn2: String = intent.getStringExtra("my_name2").toString()
        val chordbtn3: String = intent.getStringExtra("my_name3").toString()
        val chordbtn4: String = intent.getStringExtra("my_name4").toString()
        val chordbtn5: String = intent.getStringExtra("my_name5").toString()
        val chordbtn6: String = intent.getStringExtra("my_name6").toString()


        button1.text = chordbtn1.toString()
        button2.text = chordbtn2.toString()
        button3.text = chordbtn3.toString()
        button4.text = chordbtn4.toString()
        button5.text = chordbtn5.toString()
        button6.text = chordbtn6.toString()

        val song1 = findViewById<Button>(R.id.button1)
        song1.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action){MotionEvent.ACTION_DOWN -> selectButtonChord(chordbtn1)}
            return@OnTouchListener true
        })


        val song2 = findViewById<Button>(R.id.button2)
        val song3 = findViewById<Button>(R.id.button3)
        val song4 = findViewById<Button>(R.id.button4)
        val song5 = findViewById<Button>(R.id.button5)
        val song6 = findViewById<Button>(R.id.button6)








        song2.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action){MotionEvent.ACTION_DOWN -> selectButtonChord(chordbtn2)}
            return@OnTouchListener true
        })

        song3.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action){MotionEvent.ACTION_DOWN -> selectButtonChord(chordbtn3)}
            return@OnTouchListener true
        })

        song4.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action){MotionEvent.ACTION_DOWN -> selectButtonChord(chordbtn4)}
            return@OnTouchListener true
        })

        song5.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action){MotionEvent.ACTION_DOWN -> selectButtonChord(chordbtn5)}
            return@OnTouchListener true
        })

        song6.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action){MotionEvent.ACTION_DOWN -> selectButtonChord(chordbtn6)}
            return@OnTouchListener true
        })



        //setListener()
    }

/*
    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.button1->
            {
                soundPool.play(c4, 1f, 1f, 0, 0, 1f)
                soundPool.play(e4, 1f, 1f, 0, 0, 1f)
                soundPool.play(g4, 1f, 1f, 0, 0, 1f)
            }

            R.id.button2->
            {
                soundPool.play(d4, 1f, 1f, 0, 0, 1f)
                soundPool.play(f4Black, 1f, 1f, 0, 0, 1f)
                soundPool.play(a4, 1f, 1f, 0, 0, 1f)
            }
            R.id.button3->
            {
                soundPool.play(e4, 1f, 1f, 0, 0, 1f)
                soundPool.play(g5, 1f, 1f, 0, 0, 1f)
                soundPool.play(b5, 1f, 1f, 0, 0, 1f)
            }

            R.id.button4->
                selectButtonChord(chordbtn01)


        }
    }
*/



    private fun sounds(){
    val sw1 = findViewById<Switch>(R.id.switch1)

    sw1.setOnClickListener(){
        if (switch1.isChecked){
                c4 = soundPool.load(this, R.raw.c4, 1)
                c4Black = soundPool.load(this, R.raw.c4black, 1)
                e4 = soundPool.load(this, R.raw.e4, 1)
                f4 = soundPool.load(this, R.raw.f4, 1)
                f4Black = soundPool.load(this, R.raw.f4black, 1)
                g4 = soundPool.load(this, R.raw.g4, 1)
                g4Black = soundPool.load(this, R.raw.g4black, 1)
                d4 = soundPool.load(this, R.raw.d4, 1)
                d4Black = soundPool.load(this, R.raw.d4black, 1)
                a4 = soundPool.load(this, R.raw.a4, 1)
                a4Black = soundPool.load(this, R.raw.a4black, 1)
                b4 = soundPool.load(this, R.raw.b4, 1)

                c5 = soundPool.load(this, R.raw.c5, 1)
                c5Black = soundPool.load(this, R.raw.c5black, 1)
                e5 = soundPool.load(this, R.raw.e5, 1)
                f5 = soundPool.load(this, R.raw.f5, 1)
                f5Black = soundPool.load(this, R.raw.f5black, 1)
                g5 = soundPool.load(this, R.raw.g5, 1)
                g5Black = soundPool.load(this, R.raw.g5black, 1)
                d5 = soundPool.load(this, R.raw.d5, 1)
                d5Black = soundPool.load(this, R.raw.d5black, 1)
                a5 = soundPool.load(this, R.raw.a5, 1)
                a5Black = soundPool.load(this, R.raw.a5black, 1)
                b5 = soundPool.load(this, R.raw.b5, 1)
        }
        else{
            c4 = soundPool.load(this, R.raw.kc4, 1)
            c4Black = soundPool.load(this, R.raw.kc4black, 1)
            e4 = soundPool.load(this, R.raw.ke4, 1)
            f4 = soundPool.load(this, R.raw.kf4, 1)
            f4Black = soundPool.load(this, R.raw.kf4black, 1)
            g4 = soundPool.load(this, R.raw.kg4, 1)
            g4Black = soundPool.load(this, R.raw.kg4black, 1)
            d4 = soundPool.load(this, R.raw.kd4, 1)
            d4Black = soundPool.load(this, R.raw.kd4black, 1)
            a4 = soundPool.load(this, R.raw.ka4, 1)
            a4Black = soundPool.load(this, R.raw.ka4black, 1)
            b4 = soundPool.load(this, R.raw.kb4, 1)

            c5 = soundPool.load(this, R.raw.kc5, 1)
            c5Black = soundPool.load(this, R.raw.kc5black, 1)
            e5 = soundPool.load(this, R.raw.ke5, 1)
            f5 = soundPool.load(this, R.raw.kf5, 1)
            f5Black = soundPool.load(this, R.raw.kf5black, 1)
            g5 = soundPool.load(this, R.raw.kg5, 1)
            g5Black = soundPool.load(this, R.raw.kg5black, 1)
            d5 = soundPool.load(this, R.raw.kd5, 1)
            d5Black = soundPool.load(this, R.raw.kd5black, 1)
            a5 = soundPool.load(this, R.raw.ka5, 1)
            a5Black = soundPool.load(this, R.raw.ka5black, 1)
            b5 = soundPool.load(this, R.raw.kb5, 1)
        }


    }




    }

/*
    private fun setListener()
    {
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }
*/
    private fun selectButtonChord(nameChord:String) {

       when (nameChord) {
            "C"   -> playChord(c4,     e4,g4)
            "Cm"  -> playChord(c4,     d4Black,g4)
            "C#"  -> playChord(c4Black,f4,     g4Black)
            "C#m" -> playChord(c4,     e4,     g4Black)
            "Db"  -> playChord(c4,     f4,     g4Black)
            "Dbm" -> playChord(c4,     e4,     g4Black)
            "D"   -> playChord(d4,     f4Black,a4)
            "Dm"  -> playChord(d4,     f4,     a4)
            "D#"  -> playChord(d4Black,g4,     a4Black)
            "D#m" -> playChord(d4Black,f4Black,b4)
            "Eb"  -> playChord(d4Black,g4,     a4Black)
            "Ebm" -> playChord(d4Black,f4Black,b4)
            "E"   -> playChord(e4,     g4,     b4)
            "Em"  -> playChord(e4,     f4Black,b4)
            "F"   -> playChord(f4,     a4,     c5)
            "Fm"  -> playChord(f4,     g4Black,c5)
            "F#"  -> playChord(f4Black,a4Black,c5Black)
            "F#m" -> playChord(f4Black,g4Black,c5Black)
            "Gb"  -> playChord(f4Black,a4Black,c5Black)
            "Gbm" -> playChord(f4Black,a4,     c5Black)
            "G"   -> playChord(g4,     b4,     d5)
            "Gm"  -> playChord(g4,     a4Black,d5)
            "G#"  -> playChord(g4Black,b4,     d5Black)
            "G#m" -> playChord(g4Black,a4Black,d5Black)
            "Ab"  -> playChord(g4Black,b4,     d5Black)
            "Abm" -> playChord(g4Black,a4Black,d5Black)
            "A"   -> playChord(a4,     c5Black,e5)
            "Am"  -> playChord(a4,     c5,     e5)
            "A#"  -> playChord(a4Black,d5,     f5)
            "A#m" -> playChord(a4Black,c5Black,f5)
            "Bb"  -> playChord(a4Black,d5,     f5)
            "Bbm" -> playChord(a4Black,c5Black,f5)
            "B"   -> playChord(b4,     d5Black,f5Black)
            "Bm"  ->playChord(b4,      d5,     f5Black)
            }

    }

    private fun playChord(note1:Int,note2:Int,note3:Int){
        soundPool.play(note1, 1f, 1f, 0, 0, 1f)
        soundPool.play(note2, 1f, 1f, 0, 0, 1f)
        soundPool.play(note3, 1f, 1f, 0, 0, 1f)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_settings, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.setting_item) {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        return true
    }





}

















/*


    private var kC4 = 0
    private var kC4Black: Int = 0
    private var kD4: Int = 0
    private var kD4Black: Int = 0
    private var kE4: Int = 0
    private var kF4: Int = 0
    private var kF4Black: Int = 0
    private var kG4: Int = 0
    private var kG4Black: Int = 0
    private var kA4: Int = 0
    private var kA4Black: Int = 0
    private var kB4: Int = 0
    private var kC5 = 0
    private var kC5Black: Int = 0
    private var kD5: Int = 0
    private var kD5Black: Int = 0
    private var kE5: Int = 0
    private var kF5: Int = 0
    private var kF5Black: Int = 0
    private var kG5: Int = 0
    private var kG5Black: Int = 0
    private var kA5: Int = 0
    private var kA5Black: Int = 0
    private var kB5: Int = 0



        kC4 = soundPool.load(this, R.raw.kc4, 1);
        kC4Black = soundPool.load(this, R.raw.kc4black, 1);
        kE4 = soundPool.load(this, R.raw.ke4, 1);
        kF4 = soundPool.load(this, R.raw.kf4, 1);
        kF4Black = soundPool.load(this, R.raw.kf4black, 1);
        kG4 = soundPool.load(this, R.raw.kg4, 1);
        kG4Black = soundPool.load(this, R.raw.kg4black, 1);
        kD4 = soundPool.load(this, R.raw.kd4, 1);
        kD4Black = soundPool.load(this, R.raw.kd4black, 1);
        kA4 = soundPool.load(this, R.raw.ka4, 1);
        kA4Black = soundPool.load(this, R.raw.ka4black, 1);
        kB4 = soundPool.load(this, R.raw.kb4, 1);

        kC5 = soundPool.load(this, R.raw.kc5, 1);
        kC5Black = soundPool.load(this, R.raw.kc5black, 1);
        kE5 = soundPool.load(this, R.raw.ke5, 1);
        kF5 = soundPool.load(this, R.raw.kf5, 1);
        kF5Black = soundPool.load(this, R.raw.kf5black, 1);
        kG5 = soundPool.load(this, R.raw.kg5, 1);
        kG5Black = soundPool.load(this, R.raw.kg5black, 1);
        kD5 = soundPool.load(this, R.raw.kd5, 1);
        kD5Black = soundPool.load(this, R.raw.kd5black, 1);
        kA5 = soundPool.load(this, R.raw.ka5, 1);
        kA5Black = soundPool.load(this, R.raw.ka5black, 1);
        kB5 = soundPool.load(this, R.raw.kb5, 1)



*/