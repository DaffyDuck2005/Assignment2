package com.example.imadassignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Review : AppCompatActivity() {
    private lateinit var reviewQuestionTextView: TextView
    private lateinit var reviewAnswerTextView: TextView
    private lateinit var nextReviewButton: Button

    // Data class for question and answer
    // It's better to define this data class in a separate file if used across multiple activities
    data class QuestionAnswer(val question: String, val answer: Boolean) // Changed answer to Boolean based on previous context

    // Array of questions and answers - You should ideally receive this list from the ScoreScreen
    // For demonstration, we'll keep a sample array here.
    private val reviewQuestionsArray = arrayOf(
        QuestionAnswer("The First All Race Election in South Africa Was In 1994.", true),
        QuestionAnswer("Is The Cradle Of Humankind located in Johannesburg.", true),
        QuestionAnswer("Apartheid Ended in 1997.", false),
        QuestionAnswer("Nelson Mandela became the first South African president after he got released from jail and after the apartheid ended.", true),
        QuestionAnswer("Only White and Black people were separated.", false)
    ) //Questions from the Array

    private var currentReviewIndex = 0 // Initialize the index to 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        reviewQuestionTextView = findViewById(R.id.txtReviewQuestions)
        reviewAnswerTextView = findViewById(R.id.txtReviewAnswer)
        nextReviewButton = findViewById(R.id.btnQuestion)

        loadAndDisplayReviewQuestion() // Load and display the first question

        nextReviewButton.setOnClickListener {
            if (currentReviewIndex < reviewQuestionsArray.size - 1) { // Check if there are more questions
                currentReviewIndex++ // Move to the next question
                loadAndDisplayReviewQuestion() // Load and display the next question
            } else {
                nextReviewButton.text = "Score Screen"
                val intent = Intent(this, ScoreScreen::class.java)
                startActivity(intent) // Move back to sore screen
            }
        }
    }

    private fun loadAndDisplayReviewQuestion() {
        if (currentReviewIndex >= 0 && currentReviewIndex < reviewQuestionsArray.size) { // Check if the index is valid
            val currentQA = reviewQuestionsArray[currentReviewIndex] // Get the current question and answer
            reviewQuestionTextView.text = currentQA.question // Display the question
            reviewAnswerTextView.text = "Answer: ${currentQA.answer}" // Display the answer

            if (currentReviewIndex < reviewQuestionsArray.size - 1) { // Check if there are more questions
                nextReviewButton.text = "Next Question"
            }
        } else {
            reviewQuestionTextView.text = "No questions to review." // Display a message if there are no more questions
            reviewAnswerTextView.text = "" // Clear the answer text
            nextReviewButton.isEnabled = false // Disable the button
        }
    }
}