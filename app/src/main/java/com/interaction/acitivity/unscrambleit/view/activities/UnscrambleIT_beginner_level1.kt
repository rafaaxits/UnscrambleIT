package com.interaction.acitivity.unscrambleit.view.activities

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.google.firebase.database.*
import com.interaction.acitivity.unscrambleit.R
import kotlinx.android.synthetic.main.activity_unscramble_it_beginner_level1.*
import java.util.*

class UnscrambleIT_beginner_level1 : AppCompatActivity() {

    val KEY_TEXT_VALUE = "";
    private lateinit var RESULT_SETENCE: ArrayList<String>
    private lateinit var USER_SETENCE: ArrayList<String>
    private lateinit var setenceToCompleteList: ArrayList<Button>
    private lateinit var setenceButtonList: ArrayList<Button>
    var firebaseDatabase: FirebaseDatabase? = null
    var myRef: DatabaseReference? = null
    var finalSetence:String = ""
    var TAG = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unscramble_it_beginner_level1)

        firebaseDatabase = FirebaseDatabase.getInstance()
        myRef = firebaseDatabase!!.getReference()

        val intent = intent
        var level = intent.getStringExtra("level")
        var levelInt = level.last().toString().toInt()

        var nameLevel = when(levelInt){
            1 -> "1º LEVEL"
            2 -> "2º LEVEL"
            3 -> "3º LEVEL"
            4 -> "4º LEVEL"
            5 -> "5º LEVEL"
            else -> {
                "LEVEL"
            }
        }
        txtLevelName.setText(nameLevel)
        getDataFromFireBase(level)

        val imageLevelLayout = findViewById<LinearLayout>(R.id.imgLevel)
        val imageLevelParams = LinearLayout.LayoutParams(120, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        imageLevelParams.setMargins(0, 35, 0, 0)
        var image = ImageView(this)
        image.setImageResource(R.drawable.bookfirstlevelbeginner)
        imageLevelLayout.addView(image, imageLevelParams)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

       /* if(savedInstanceState != null){
            setenceButtonLayout.removeView(setenceButtonLayout)
            setenceToCompleteLayout.removeView(setenceToCompleteLayout)
            setenceButtonLayout.addView(setenceButtonLayout)
            setenceToCompleteLayout.addView(setenceToCompleteLayout)
        }*/
  }

    /*override fun onSaveInstanceState(outState: Bundle) {
        outState.putBundle(KEY_TEXT_VALUE, setenceButtonList)
        super.onSaveInstanceState(outState)
      }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, UnscrambleIT_LevelsScreen::class.java)
        intent.putExtra("level", "Beginner")
        startActivity(intent)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    fun getDataFromFireBase(level: String){
        val dataBaseReference = FirebaseDatabase.getInstance().getReference("levels/$level")
        dataBaseReference.addListenerForSingleValueEvent(object : ValueEventListener {

             override fun onDataChange(p0: DataSnapshot) {
                 RESULT_SETENCE = ArrayList()
                 USER_SETENCE = ArrayList()
                 setenceButtonList = ArrayList()
                 setenceToCompleteList = ArrayList()

                 var setence = "setence" + (1..3).shuffled().last()
                 finalSetence = p0.child(setence).value as String
                 finalSetence.split(" ").forEach { element ->
                     RESULT_SETENCE.add(element)
                 }
                 RESULT_SETENCE.shuffle()

                 val setenceButtonLayout = findViewById<LinearLayout>(R.id.setenceButtons)
                 val setenceButtonParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)
                 setenceButtonParams.setMargins(0,0,5,0)

                 val setenceButtonLayout2 = findViewById<LinearLayout>(R.id.setenceButtons2)

                 val setenceToCompleteLayout = findViewById<LinearLayout>(R.id.setenceToComplete)
                 val setenceToCompleteParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)
                 setenceToCompleteParams.setMargins(0, 0, 5, 0)

                 val setenceToCompleteLayout2 = findViewById<LinearLayout>(R.id.setenceToComplete2)

                 for(i: Int in 0 until RESULT_SETENCE.size) run {
                     var btn = Button(applicationContext)
                     btn.id = i
                     val id_ = btn.id;
                     btn.setText(RESULT_SETENCE[i])
                     btn.setTextColor(Color.parseColor("#FFFFFFFF"))
                     btn.setBackgroundColor(Color.parseColor("#FF1183C4"))
                     if(i < 6){
                         var previousBoolean = false
                         /*var forAux = ""
                         if(i > 0)
                         RESULT_SETENCE.subList(0, i-1).forEach { element -> forAux + element};
                         var previousSetence = forAux;
                         if((previousSetence.length + RESULT_SETENCE[i].length) > 41){ // tamanho maximo de caracteres no layout
                             setenceButtonList.add(btn)
                             setenceButtonLayout2.addView(btn, setenceButtonParams)
                             previousBoolean = true
                         }*/
                         if(!previousBoolean) {
                             setenceButtonList.add(btn)
                             setenceButtonLayout.addView(btn, setenceButtonParams)
                         }
                     }else {
                         setenceButtonList.add(btn)
                         setenceButtonLayout2.addView(btn, setenceButtonParams)
                     }

                     var btnOrigin = findViewById<Button>(id_)

                     var btnSetence = Button(applicationContext)
                     btnSetence.id = i
                     val idToComplete = btnSetence.id
                     btnSetence.setTextColor(Color.parseColor("#FD000000"))
                     btnSetence.setBackgroundColor(Color.parseColor("#FFE19E10"))

                     if(i < 6){
                         setenceToCompleteList.add(btnSetence)
                         setenceToCompleteLayout.addView(btnSetence, setenceToCompleteParams)
                     } else{
                         setenceToCompleteList.add(btnSetence)
                         setenceToCompleteLayout2.addView(btnSetence, setenceToCompleteParams)
                     }

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
                     var needToComplete = false
                     for(i: Int in 0 until setenceToCompleteList.size){
                         if(setenceToCompleteList[i].text.toString().equals("")){
                             Toast.makeText(applicationContext,"COMPLETE THE SETENCE", Toast.LENGTH_SHORT).show()
                             needToComplete = true
                         }
                     }
                     if(!needToComplete){
                         var userSetence: String = ""
                         setenceToCompleteList.forEach { element ->
                             userSetence += element.text.toString()
                             if(setenceToCompleteList.indexOf(element) != setenceToCompleteList.size - 1){
                                 userSetence += " "
                             }
                         }
                         if(userSetence.equals(finalSetence)){
                             Toast.makeText(applicationContext,"YOU WIN", Toast.LENGTH_SHORT).show()
                             val intent = Intent(applicationContext, UnscrambleIT_GameResult::class.java)
                             intent.putExtra("level", level)
                             intent.putExtra("result", "YOU WIN")
                             startActivity(intent)
                         }else{
                             Toast.makeText(applicationContext,"YOU LOSE", Toast.LENGTH_SHORT).show()
                             val intent = Intent(applicationContext, UnscrambleIT_GameResult::class.java)
                             intent.putExtra("level", level)
                             intent.putExtra("result", "YOU LOSE")
                             startActivity(intent)
                         }
                     } else {

                     }
                 }
            }

             override fun onCancelled(p0: DatabaseError) {
                 Log.d(TAG, "Error")
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}

