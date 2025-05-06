package com.example.imadassignment2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val ScoreScreen = findViewById<TextView>(R.id.txtScoreScreen)
        val Score = findViewById<TextView>(R.id.txtScore)
        val Response = findViewById<TextView>(R.id.txtResponse)
        val Review = findViewById<Button>(R.id.btnReview)
        val Exit = findViewById<Button>(R.id.btnExit)
        val intent = intent

        ScoreScreen.text = "Score Screen"

        val finalScore = intent.getIntExtra("final_score", 0)
        val totalQuestions = intent.getIntExtra("total_questions", 0)

        Score.text = "Your Final Score: $finalScore / $totalQuestions"
        //Score from the previous page with the true or flase questions

        when (finalScore) {
            5 -> Response.text = "Impressive! You did great."
            4 -> Response.text = "You did very well, almost there."
            3 -> Response.text = "You did good, but you can do better."
            2 -> Response.text = "You did ok, but need to work on your History knowledge."
            1 -> Response.text = "You need to work on your History knowledge."
            else -> Response.text = "Keep studying History!" }
        //Gemini took my original if statement and changed it to when statement
        //Personal response to the score from the user

        Exit.setOnClickListener {
            finishAffinity()// Terminates the app without any harmful activity towards the program
        }
    }
}