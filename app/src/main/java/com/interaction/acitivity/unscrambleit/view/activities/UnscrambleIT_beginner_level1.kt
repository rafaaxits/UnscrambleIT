package com.interaction.acitivity.unscrambleit.view.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.interaction.acitivity.unscrambleit.R
import kotlinx.android.synthetic.main.activity_unscramble_it_beginner_level1.*

class UnscrambleIT_beginner_level1 : AppCompatActivity() {
  val KEY_TEXT_VALUE = "";
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unscramble_it_beginner_level1)
        txtViewAnswer.setText("");

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        if(savedInstanceState != null){
          txtViewAnswer.setText(savedInstanceState.getString(KEY_TEXT_VALUE))
        }

        btnThe.setOnClickListener(){
          txtViewAnswer.setText(txtViewAnswer.text.toString() +" "+ btnThe.text.toString() +" ")
        }
        btnBook.setOnClickListener(){
          txtViewAnswer.setText(txtViewAnswer.text.toString() + " "+ btnBook.text.toString()+" ")
        }
        btnIs.setOnClickListener(){
          txtViewAnswer.setText(txtViewAnswer.text.toString() +" "+ btnIs.text.toString()+" ")
        }
        btnOn.setOnClickListener(){
          txtViewAnswer.setText(txtViewAnswer.text.toString() +" "+ btnOn.text.toString()+" ")
        }
        btnTable.setOnClickListener(){
          txtViewAnswer.setText(txtViewAnswer.text.toString() +" "+ btnTable.text.toString()+" ")
        }
        btnClear.setOnClickListener(){
            txtViewAnswer.setText("")
        }

  }

  override fun onSaveInstanceState(outState: Bundle) {
    outState.putCharSequence(KEY_TEXT_VALUE, txtViewAnswer.text);
    super.onSaveInstanceState(outState)
  }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, UnscrambleIT_BeginnerLevels::class.java)
        startActivity(intent)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }
}
