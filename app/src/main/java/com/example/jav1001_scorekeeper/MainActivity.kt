/*
    NAME: ERTUGRUL SAHIN , JOHN OLAYENI , LEVI MAXWELL
    STUDENT NUMBER : A00270022, A00260853 , A00263436
    DESCRIPTION : The application keeps the scores of the two teams in the match. Scores are updated with the numbers 1,2,3.
    When the teams scored, how many points were scored, that number is added to the total score.
    At the time the number is dropped, the specified score is reduced.

    LAB6
    Dark mode feature was added to the application as an extra. Here, we determined the dark mode colors using the colors
    and theme layouts and activated and deactivated the dark mode with the switch.

    LAB7
    Added menu feature and new activity to the application. We created a new layout with the menu feature and connected this layout to MainActivity. We made the clicks of the buttons in the menu.

    When About clicked on the menu, we displayed the developer information with a toast message.

    When Settings are clicked on the menu, we made a transition to a new activity. We sent the scores of the teams during the transition process.
    In the new Activity, we saved these scores to Shared Preferences for the first time. We took the recorded data and printed it on the screen.
 */

package com.example.jav1001_scorekeeper

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.jav1001_scorekeeper.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    // We have created a score variable to keep the selected score on the radiobutton.
    private var score:Int=0

    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n", "SuspiciousIndentation", "UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // We called the views that we used in the UI and assigned each of them to variables.
        val changeMode:Switch = findViewById(R.id.change_mode)

        //The method that works when pressing the increase button in Team A
        binding.teamAIncrease.setOnClickListener {
            // We added the value we selected in the radio button and the value from teamA's textview, and assigned the textview of teamA as a result.
            binding.teamAScore.text=(binding.teamAScore.text.toString().toInt()+score).toString()

        }
        //The method that works when pressing the increase button in Team B
        binding.teamBIncrease.setOnClickListener {
            // We added the value we selected in the radio button and the value from teamB's textview, and assigned the textview of teamB as a result.
                binding.teamBScore.text=(binding.teamBScore.text.toString().toInt()+score).toString()
        }
        //The method that works when pressing the decrease button in Team A
        binding.teamADecrease.setOnClickListener {
            // Before reducing temA's score, we have checked whether it is 0 or not and
            // if the teamA textview value is greater or equal to the selected score, we have done the decrease.
            if (binding.teamAScore.text.toString().toInt()!=0 && binding.teamAScore.text.toString().toInt()>=score)
            // We decreased the value we selected in the radio button and the value from teamA's textview, and assigned the textview of teamB as a result.
                binding.teamAScore.text=(binding.teamAScore.text.toString().toInt()-score).toString()
        }
        //The method that works when pressing the decrease button in Team B
        binding.teamBDecrease.setOnClickListener {
            // Before reducing temB's score, we have checked whether it is 0 or not and
            // if the teamB textview value is greater or equal to the selected score, we have done the decrease.
            if (binding.teamBScore.text.toString().toInt()!=0 && binding.teamBScore.text.toString().toInt()>=score)
            // We decreased the value we selected in the radio button and the value from teamB's textview, and assigned the textview of teamB as a result.
                binding.teamBScore.text=(binding.teamBScore.text.toString().toInt()-score).toString()
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // We connect the settings menu.xml file to MainActivity
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.settings_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            // We click on the menus whose names we have given in the settings_menu.xml file.
            R.id.settings -> {
                // It works when the settings menu is clicked.
                // We are routing the new activity we have created.
                // While routing is being done, we are sending data at the same time.
                val intent = Intent(this, SettingsActivity::class.java)
                intent.putExtra("teamAScore", binding.teamAScore.text)
                intent.putExtra("teamBScore", binding.teamBScore.text)
                startActivity(intent)
                true
            }
            R.id.about -> {
                // It works when the about menu is clicked.
                val text = "Ertugrul,JAV1001"
                val duration = Toast.LENGTH_SHORT
                // We print a toast message on the screen
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
                true
            }
            else -> super.onOptionsItemSelected(item)
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