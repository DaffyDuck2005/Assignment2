package com.example.imadassignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent


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
    )


    private var currentReviewIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        reviewQuestionTextView = findViewById(R.id.txtReviewQuestions)
        reviewAnswerTextView = findViewById(R.id.txtReviewAnswer)
        nextReviewButton = findViewById(R.id.btnQuestion)

        loadAndDisplayReviewQuestion()


        nextReviewButton.setOnClickListener {
            if (currentReviewIndex < reviewQuestionsArray.size - 1) {
                currentReviewIndex++
                loadAndDisplayReviewQuestion()
            } else {
                nextReviewButton.text = "Back to Score Screen"
                val intent = Intent(this, ScoreScreen::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadAndDisplayReviewQuestion() {
        if (currentReviewIndex >= 0 && currentReviewIndex < reviewQuestionsArray.size) {
            val currentQA = reviewQuestionsArray[currentReviewIndex]
            reviewQuestionTextView.text = currentQA.question
            reviewAnswerTextView.text = "Answer: ${currentQA.answer}"

            if (currentReviewIndex < reviewQuestionsArray.size - 1) {
                nextReviewButton.text = "Next Question"
            }
        } else {
            reviewQuestionTextView.text = "No questions to review."
            reviewAnswerTextView.text = ""
            nextReviewButton.isEnabled = false // Disable the button
        }
    }
}