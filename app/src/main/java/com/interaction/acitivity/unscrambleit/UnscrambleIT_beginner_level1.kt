package com.interaction.acitivity.unscrambleit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_unscramble_it_beginner_level1.*

class UnscrambleIT_beginner_level1 : AppCompatActivity() {
  val KEY_TEXT_VALUE = "";
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_unscramble_it_beginner_level1)
    txtViewAnswer.setText("");

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




  }
  override fun onSaveInstanceState(outState: Bundle) {
    outState.putCharSequence(KEY_TEXT_VALUE, txtViewAnswer.text);
    super.onSaveInstanceState(outState)
  }
}
