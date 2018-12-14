package com.interaction.acitivity.unscrambleit.view.activities

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.interaction.acitivity.unscrambleit.R
import kotlinx.android.synthetic.main.activity_unscramble_it_beginner_level1.*

class UnscrambleIT_beginner_level1 : AppCompatActivity() {
    val KEY_TEXT_VALUE = "";
    private lateinit var RESULT_SETENCE: ArrayList<String>
    private lateinit var USER_SETENCE: ArrayList<String>
    private lateinit var setenceToCompleteList: ArrayList<Button>
    private lateinit var setenceButtonList: ArrayList<Button>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unscramble_it_beginner_level1)
        RESULT_SETENCE = ArrayList()
        USER_SETENCE = ArrayList()
        setenceButtonList = ArrayList()
        setenceToCompleteList = ArrayList()
        var finalSetence = "THE BOOK IS ON THE TABLE"
        RESULT_SETENCE.add("THE")
        RESULT_SETENCE.add("BOOK")
        RESULT_SETENCE.add("IS")
        RESULT_SETENCE.add("ON")
        RESULT_SETENCE.add("THE")
        RESULT_SETENCE.add("TABLE")
        RESULT_SETENCE.shuffle()
        //txtViewAnswer.setText("")

        val imageLevelLayout = findViewById<LinearLayout>(R.id.imgLevel)
        val imageLevelParams = LinearLayout.LayoutParams(120, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        imageLevelParams.setMargins(0, 35, 0, 0)
        var image = ImageView(this)
        image.setImageResource(R.drawable.bookfirstlevelbeginner)
        imageLevelLayout.addView(image, imageLevelParams)


        val setenceButtonLayout = findViewById<LinearLayout>(R.id.setenceButtons)
        val setenceButtonParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)
        setenceButtonParams.setMargins(0,0,5,0)

        val setenceToCompleteLayout = findViewById<LinearLayout>(R.id.setenceToComplete)
        val setenceToCompleteParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)
        setenceToCompleteParams.setMargins(0, 0, 5, 0)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

       /* if(savedInstanceState != null){
            setenceButtonLayout.removeView(setenceButtonLayout)
            setenceToCompleteLayout.removeView(setenceToCompleteLayout)
            setenceButtonLayout.addView(setenceButtonLayout)
            setenceToCompleteLayout.addView(setenceToCompleteLayout)
        }*/

        for(i: Int in 0 until RESULT_SETENCE.size) run {
            var btn = Button(this)
            btn.id = i
            val id_ = btn.id;
            btn.setText(RESULT_SETENCE[i])
            btn.setTextColor(Color.parseColor("#FFFFFFFF"))
            btn.setBackgroundColor(Color.parseColor("#FF1183C4"))
            setenceButtonList.add(btn)
            setenceButtonLayout.addView(btn, setenceButtonParams)
            var btnOrigin = findViewById<Button>(id_)

            var btnSetence = Button(this)
            btnSetence.id = i
            val idToComplete = btnSetence.id
            btnSetence.setTextColor(Color.parseColor("#FD000000"))
            btnSetence.setBackgroundColor(Color.parseColor("#FFE19E10"))
            setenceToCompleteList.add(btnSetence)
            setenceToCompleteLayout.addView(btnSetence, setenceToCompleteParams)
            btnSetence.isClickable = false
            var btnToComplete = findViewById<Button>(idToComplete)

            btnOrigin.setOnClickListener(){
                for(i in 0 until setenceToCompleteList.size){
                    var element = setenceToCompleteList[i]
                    if(element.text.toString().equals("")){
                        element.setText(btn.text.toString())
                        element.setTextColor(Color.parseColor("#FD000000"))
                        element.setBackgroundColor(Color.parseColor("#FF1183C4"))
                        btn.setTextColor(Color.parseColor("#FFE19E10"))
                        btn.setBackgroundColor(Color.parseColor("#FFE19E10"))
                        btn.isClickable = false
                        element.isClickable = true
                        break
                    }
                }
            }

           btnToComplete.setOnClickListener(){
               for(i in 0 until setenceButtonList.size) {
                   var element = setenceButtonList[i]
                    if(element.text.toString().equals(btnToComplete.text.toString()) && element.currentTextColor != Color.parseColor("#FFFFFFFF")){
                        element.setTextColor(Color.parseColor("#FFFFFFFF"))
                        element.setBackgroundColor(Color.parseColor("#FF1183C4"))
                        element.isClickable = true
                        break
                    }
                }

                for(i: Int in btnToComplete.id until setenceToCompleteList.size) {
                   if (setenceToCompleteList[i].text.toString() == "" || i + 1 == setenceToCompleteList.size) {
                       setenceToCompleteList[i].setTextColor(Color.parseColor("#FFE19E10"))
                       setenceToCompleteList[i].setBackgroundColor(Color.parseColor("#FFE19E10"))
                       setenceToCompleteList[i].setText("")
                       setenceToCompleteList[i].isClickable = false
                       if(i > 0 && setenceToCompleteList[i - 1].text.toString() == "") {
                           setenceToCompleteList[i - 1].setBackgroundColor(Color.parseColor("#FFE19E10"))
                       }
                       break
                   } else {
                       setenceToCompleteList[i].setText(setenceToCompleteList[i + 1].text.toString())
                   }
                }
            }
        }

        btnClear.setOnClickListener(){
            for (i: Int in 0 until setenceToCompleteList.size) run {
                setenceToCompleteList[i].setTextColor(Color.parseColor("#FFE19E10"))
                setenceToCompleteList[i].setBackgroundColor(Color.parseColor("#FFE19E10"))
                setenceToCompleteList[i].setText("")
                setenceToCompleteList[i].isClickable = false

                setenceButtonList[i].setTextColor(Color.parseColor("#FFFFFFFF"))
                setenceButtonList[i].setBackgroundColor(Color.parseColor("#FF1183C4"))
                setenceButtonList[i].isClickable = true
            }
        }

        btnSend.setOnClickListener(){
            for(i: Int in 0 until setenceToCompleteList.size){
                if(setenceToCompleteList[i].text.toString().equals("")){
                    Toast.makeText(applicationContext,"COMPLETE THE SETENCE", Toast.LENGTH_SHORT).show()
                    break
                }
            }
            var userSetence: String = ""
            setenceToCompleteList.forEach { element ->
                userSetence += element.text.toString()
                if(setenceToCompleteList.indexOf(element) != setenceToCompleteList.size - 1){
                    userSetence += " "
                }
            }
            if(userSetence.equals(finalSetence)){
                Toast.makeText(applicationContext,"YOU WIN", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"YOU LOSE", Toast.LENGTH_SHORT).show()
            }
        }

  }

    /*override fun onSaveInstanceState(outState: Bundle) {
        outState.putBundle(KEY_TEXT_VALUE, setenceButtonList)
        super.onSaveInstanceState(outState)
      }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, UnscrambleIT_LevelsScreen::class.java)
        startActivity(intent)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }
}

