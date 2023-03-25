/*
    NAME: ERTUGRUL SAHIN , JOHN OLAYENI , LEVI MAXWELL
    STUDENT NUMBER : A00270022, A00260853 , A00263436
    DESCRIPTION : The application keeps the scores of the two teams in the match. Scores are updated with the numbers 1,2,3.
    When the teams scored, how many points were scored, that number is added to the total score.
    At the time the number is dropped, the specified score is reduced.
 */

package com.example.jav1001_scorekeeper

import android.annotation.SuppressLint
import android.app.ActionBar
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity() {
    // We have created a score variable to keep the selected score on the radiobutton.
    private var score:Int=0



    @SuppressLint("SetTextI18n", "SuspiciousIndentation", "UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // We called the views that we used in the UI and assigned each of them to variables.
        val teamAIncrease:ImageButton = findViewById(R.id.teamAIncrease)
        val teamBIncrease:ImageButton = findViewById(R.id.teamBIncrease)
        val teamADecrease:ImageButton = findViewById(R.id.teamADecrease)
        val teamBDecrease:ImageButton = findViewById(R.id.teamBDecrease)
        val teamAScoreTextView:TextView = findViewById(R.id.teamAScore)
        val teamBScoreTextView:TextView = findViewById(R.id.teamBScore)
        val changeMode:Switch = findViewById(R.id.change_mode)

        //The method that works when pressing the increase button in Team A
        teamAIncrease.setOnClickListener {
            // We added the value we selected in the radio button and the value from teamA's textview, and assigned the textview of teamA as a result.
            teamAScoreTextView.text=(teamAScoreTextView.text.toString().toInt()+score).toString()

        }
        //The method that works when pressing the increase button in Team B
        teamBIncrease.setOnClickListener {
            // We added the value we selected in the radio button and the value from teamB's textview, and assigned the textview of teamB as a result.
                teamBScoreTextView.text=(teamBScoreTextView.text.toString().toInt()+score).toString()
        }
        //The method that works when pressing the decrease button in Team A
        teamADecrease.setOnClickListener {
            // Before reducing temA's score, we have checked whether it is 0 or not and
            // if the teamA textview value is greater or equal to the selected score, we have done the decrease.
            if (teamAScoreTextView.text.toString().toInt()!=0 && teamAScoreTextView.text.toString().toInt()>=score)
            // We decreased the value we selected in the radio button and the value from teamA's textview, and assigned the textview of teamB as a result.
            teamAScoreTextView.text=(teamAScoreTextView.text.toString().toInt()-score).toString()
        }
        //The method that works when pressing the decrease button in Team B
        teamBDecrease.setOnClickListener {
            // Before reducing temB's score, we have checked whether it is 0 or not and
            // if the teamB textview value is greater or equal to the selected score, we have done the decrease.
            if (teamBScoreTextView.text.toString().toInt()!=0 && teamBScoreTextView.text.toString().toInt()>=score)
            // We decreased the value we selected in the radio button and the value from teamB's textview, and assigned the textview of teamB as a result.
                teamBScoreTextView.text=(teamBScoreTextView.text.toString().toInt()-score).toString()
        }


        // Switch button changed function
        changeMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                // Changed ActionBar Color
                supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#8C65E8")))
                // if switch button isChecked we changed dark mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                // if switch button is not checked we changed light mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

        }

    }
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                // If one with id is selected
                R.id.one ->
                    if (checked) {
                        // We check that the radio button is checked
                        // The value 1 from the radio button is assigned to the score variable
                        score=view.text.toString().toInt()
                    }
                // If two with id is selected
                R.id.two ->
                    if (checked) {
                        // We check that the radio button is checked
                        // The value 2 from the radio button is assigned to the score variable
                        score=view.text.toString().toInt()
                    }
                // If three with id is selected
                R.id.three ->
                    if (checked) {
                        // We check that the radio button is checked
                        // The value 3 from the radio button is assigned to the score variable
                        score=view.text.toString().toInt()
                    }
            }
        }
    }
}