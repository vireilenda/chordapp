package com.example.chordapp

import android.content.Intent
import android.media.SoundPool
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_play.*

class PlayActivity:AppCompatActivity() {

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


    private lateinit var soundPool: SoundPool


    private lateinit var checkSound:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        soundPool=SoundPool.Builder().setMaxStreams(9).build()
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)



        val chordbtn1: String = intent.getStringExtra("my_name1").toString()
        val chordbtn2: String = intent.getStringExtra("my_name2").toString()
        val chordbtn3: String = intent.getStringExtra("my_name3").toString()
        val chordbtn4: String = intent.getStringExtra("my_name4").toString()
        val chordbtn5: String = intent.getStringExtra("my_name5").toString()
        val chordbtn6: String = intent.getStringExtra("my_name6").toString()
        val chordbtn7: String = intent.getStringExtra("my_name7").toString()
        val chordbtn8: String = intent.getStringExtra("my_name8").toString()
        val songChoice:String = intent.getStringExtra("song_type").toString()
        checkSound=songChoice

 
        textView10.text = songChoice

        // this creates a vertical layout Manager
        //recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager



        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 5 Views containing
//        for (i in 1..5) {
//            data.add(ItemsViewModel("B" + i ))
//        }

        if (chordbtn1 != ""){
            data.add(ItemsViewModel(chordbtn1))
        }
        if (chordbtn2 != ""){
            data.add(ItemsViewModel(chordbtn2))
        }
        if (chordbtn3 != ""){
            data.add(ItemsViewModel(chordbtn3))
        }
        if (chordbtn4 != ""){
            data.add(ItemsViewModel(chordbtn4))
        }
        if (chordbtn5 != ""){
            data.add(ItemsViewModel(chordbtn5))
        }
        if (chordbtn6 != ""){
            data.add(ItemsViewModel(chordbtn6))
        }

        if (chordbtn7 != ""){
            data.add(ItemsViewModel(chordbtn7))
        }
        if (chordbtn8 != ""){
            data.add(ItemsViewModel(chordbtn8))
        }

        sounds()

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview

        recyclerview.adapter = adapter


        //adapter.setOnItemClickListener(object : CustomAdapter.onItemClickListenerTest {
        adapter.setOnItemTouchListener(object : CustomAdapter.onItemTouchListener {
           //override fun itemClickTest(position: Int) {
            override fun itemTouchTest(position: Int) {
                     //Toast.makeText(applicationContext, "botão $position", Toast.LENGTH_SHORT).show()
                    selectButtonChord(data[position].text)
                    }
                 }
            )


    }



//teste para levar as funções para o reclicleview

    private fun sounds(){
        if (checkSound == "piano")
        {
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

    private fun selectButtonChord(nameChord:String) {

        when (nameChord) {
            "C"   -> playChord(c4,e4,g4)
            "Cm"  -> playChord(c4,d4Black,g4)
            "C#"  -> playChord(c4Black,f4,g4Black)
            "C#m" -> playChord(c4,e4,g4Black)
            "Db"  -> playChord(c4,f4,g4Black)
            "Dbm" -> playChord(c4,e4,g4Black)
            "D"   -> playChord(d4,f4Black,a4)
            "Dm"  -> playChord(d4,f4,a4)
            "D#"  -> playChord(d4Black,g4,a4Black)
            "D#m" -> playChord(d4Black,f4Black,b4)
            "Eb"  -> playChord(d4Black,g4,a4Black)
            "Ebm" -> playChord(d4Black,f4Black,b4)
            "E"   -> playChord(e4,g4,b4)
            "Em"  -> playChord(e4,f4Black,b4)
            "F"   -> playChord(f4,a4,c5)
            "Fm"  -> playChord(f4,g4Black,c5)
            "F#"  -> playChord(f4Black,a4Black,c5Black)
            "F#m" -> playChord(f4Black,a4,c5Black)
            "Gb"  -> playChord(f4Black,a4Black,c5Black)
            "Gbm" -> playChord(f4Black,a4,c5Black)
            "G"   -> playChord(g4,b4,d5)
            "Gm"  -> playChord(g4,a4Black,d5)
            "G#"  -> playChord(g4Black,b4,d5Black)
            "G#m" -> playChord(g4Black,a4Black,d5Black)
            "Ab"  -> playChord(g4Black,b4,d5Black)
            "Abm" -> playChord(g4Black,a4Black,d5Black)
            "A"   -> playChord(a4,c5Black,e5)
            "Am"  -> playChord(a4,c5,e5)
            "A#"  -> playChord(a4Black,d5,f5)
            "A#m" -> playChord(a4Black,c5Black,f5)
            "Bb"  -> playChord(a4Black,d5,f5)
            "Bbm" -> playChord(a4Black,c5Black,f5)
            "B"   -> playChord(b4,d5Black,f5Black)
            "Bm"  ->playChord(b4,d5,f5Black)
        }

    }

    private fun playChord(note1:Int,note2:Int,note3:Int){
        soundPool.play(note1, 1f, 1f, 0, 0, 1f)
        soundPool.play(note2, 1f, 1f, 0, 0, 1f)
        soundPool.play(note3, 1f, 1f, 0, 0, 1f)
    }



//fim do teste





    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_settings, menu)
        return true
    }

    @ExperimentalStdlibApi
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.setting_item) {
            val intent = Intent(this, SaveActivity::class.java)
            startActivity(intent)
        }
        if (item.itemId == R.id.help_item) {
            val intent = Intent(this, HelpActivity::class.java)
            startActivity(intent)
        }
        return true
    }



}