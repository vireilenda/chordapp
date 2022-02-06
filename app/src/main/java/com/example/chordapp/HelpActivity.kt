package com.example.chordapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity


class HelpActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
    }


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
        return true
    }





}