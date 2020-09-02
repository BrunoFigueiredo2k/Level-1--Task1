package com.example.level1_task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.level1_task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    /**
     * Set the initial (UI) state of the game.
     */
    private fun initViews() {
        /** Add click listeners to buttons: lower, equal and higher **/
        binding.btnLower.setOnClickListener {onLowerClick()}
        binding.btnEquals.setOnClickListener {onEqualClick()}
        binding.btnHigher.setOnClickListener {onHigherClick()}
        updateUI()
    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI() {
        binding.tvLastThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> binding.currentThrowImg.setImageResource(R.drawable.dice1)
            2 -> binding.currentThrowImg.setImageResource(R.drawable.dice2)
            3 -> binding.currentThrowImg.setImageResource(R.drawable.dice3)
            4 -> binding.currentThrowImg.setImageResource(R.drawable.dice4)
            5 -> binding.currentThrowImg.setImageResource(R.drawable.dice5)
            6 -> binding.currentThrowImg.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice(){
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    /** Checks for al three buttons: lower, equal and higher. See if user has guessed correctly and display Toast message **/
    private fun onLowerClick() {
        rollDice()
        if (currentThrow < lastThrow){
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onEqualClick() {
        rollDice()
        if (currentThrow == lastThrow){
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onHigherClick() {
        rollDice()
        if (currentThrow > lastThrow){
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /** Displays an correct Toast message (after click functions) */
    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
    }

    /** Displays an incorrect Toast message (after click functions) */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
    }
}