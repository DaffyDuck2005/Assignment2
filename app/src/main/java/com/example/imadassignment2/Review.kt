package com.example.imadassignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.imadassignment2.Questions.Question // Assuming Question data class is here

class Review : AppCompatActivity() {

    private lateinit var txtReviewQuestion: TextView
    private lateinit var txtAnswer: TextView
    private lateinit var btnNextQuestion: Button

    private val txtReviewQuestions = listOf(
        Question("The First All Race Election in South Africa Was In 1994.", true),
        Question("Is The Cradle Of Humankind located in Johannesburg.", true),
        Question("Apartheid Ended in 1997 .", false),
        Question("Nelson Mandela became the first South African president after he got released from jail and after the apartheid ended.", true),
        Question("Only White and Black people were separated.", false)
    )

    private var currentReviewIndex = 0 // To keep track of the current question being reviewed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        txtReviewQuestion = findViewById(R.id.txtReviewQuestion)
        txtAnswer = findViewById(R.id.txtAnswer)
        btnNextQuestion = findViewById(R.id.btnNextQuestion)



        displayReviewQuestion()

        btnNextQuestion.setOnClickListener {
            currentReviewIndex++ // Move to the next question
            displayReviewQuestion() // Display the next question
        }
    }

    private fun displayReviewQuestion() {
        if (currentReviewIndex < txtReviewQuestions.size) {
            val currentQuestion = txtReviewQuestions[currentReviewIndex]
            txtReviewQuestion.text = "Question ${currentReviewIndex + 1}: ${currentQuestion.text}"
            txtAnswer.text = "Correct Answer: ${currentQuestion.answer}"

            // Change button text or behavior for the last question
            if (currentReviewIndex == txtReviewQuestions.size - 1) {
                btnNextQuestion.text = "Back to Score Screen"
                val intent = Intent(this, ScoreScreen::class.java)
                startActivity(intent)
                finish()
            }

        } else {
            // End of review - maybe show a message or go back
            txtReviewQuestion.text = "Review Complete!"
            txtAnswer.text = "" // Clear the answer text
            btnNextQuestion.isEnabled = false // Disable the button after review
            // Optionally, add a button to go back or to the main screen
        }
    }
}