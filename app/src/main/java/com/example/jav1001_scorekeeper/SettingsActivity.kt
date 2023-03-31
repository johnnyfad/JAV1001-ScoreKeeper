package com.example.jav1001_scorekeeper

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class SettingsActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        // We called the views that we used in the UI and assigned each of them to variables.
        val saveScore: Switch = findViewById(R.id.saveScores)
        val showScores: Switch = findViewById(R.id.showScores)
        val teamALinearLayout: LinearLayout = findViewById(R.id.teamALinearLayout)
        val teamBLinearLayout: LinearLayout = findViewById(R.id.teamBLinearLayout)
        val teamASavedScoreTextView: TextView = findViewById(R.id.teamASavedScore)
        val teamBSavedScoreTextView: TextView = findViewById(R.id.teamBSavedScore)

        // Here we pull the data we send from MainActivity
        val teamAScore = intent.getStringExtra("teamAScore")
        val teamBScore = intent.getStringExtra("teamBScore")



        val actionbar = supportActionBar
        // We changed actionbar title
        actionbar!!.title = "Settings"

        // The method that works in the click of the save switch
        saveScore.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                // If the save switch is checked, we save the data from MainActivity to Shared Preferences.
                val sharedPref = getPreferences(Context.MODE_PRIVATE)
                with (sharedPref.edit()) {
                    // here we save individual data with key
                    putString("teamAScore", teamAScore)
                    putString("teamBScore", teamBScore)
                    apply()
                }
                // After saving, we make the showScore switch visible.
                showScores.visibility= View.VISIBLE
                Toast.makeText(applicationContext, "Data added", Toast.LENGTH_SHORT).show()
            }else{
                // If the saveScore switch is not active, we make the show score switch, teamALinearlayout and teamBLinearlayout invisible
                showScores.visibility= View.INVISIBLE
                teamALinearLayout.visibility=View.INVISIBLE
                teamBLinearLayout.visibility=View.INVISIBLE
            }
        })
        showScores.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                // If the showScores switch is active, we first make the linearlayouts visible.
                teamALinearLayout.visibility=View.VISIBLE
                teamBLinearLayout.visibility=View.VISIBLE
                // We are getting the data we saved to Shared Preference.
                val sharedPref=getPreferences( Context.MODE_PRIVATE)
                val teamASavedScore:String=sharedPref.getString("teamAScore","").toString()
                val teamBSavedScore:String=sharedPref.getString("teamBScore","").toString()
                // We get data and write to Textview.
                teamASavedScoreTextView.text=teamASavedScore
                teamBSavedScoreTextView.text=teamBSavedScore
            }else{
                // If the showScores switch is not active, we make the show score teamALinearlayout and teamBLinearlayout invisible
                teamALinearLayout.visibility=View.INVISIBLE
                teamBLinearLayout.visibility=View.INVISIBLE
            }
        })


    }


}