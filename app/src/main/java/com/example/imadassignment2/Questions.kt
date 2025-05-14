package com.example.imadassignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Questions : AppCompatActivity() {

    private lateinit var txtQuestion: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button
    private lateinit var txtAnswerFeedback: TextView

    private var currentQuestionIndex = 0
    private var score = 0 // Initialize score to 0

    private val questions = listOf(
        Question("The First All Race Election in South Africa Was In 1994.", true),
        Question("Is The Cradle Of Humankind located in Johannesburg.", true),
        Question("Apartheid Ended in 1997.", false),
        Question("Nelson Mandela became the first South African president after he got released from jail and after the apartheid ended.", true),
        Question("Only White and Black people were separated.", false)
        // All 5 questions with answers of true or false in the quiz
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)


        txtQuestion = findViewById(R.id.txtQuestion)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        btnNext = findViewById(R.id.btnNext)
        txtAnswerFeedback = findViewById(R.id.txtAnswerFeedback)


        displayQuestion() // Display the first question


        btnTrue.setOnClickListener {
            checkAnswer(true) // Pass the user's answer as true
        }

        btnFalse.setOnClickListener {
            checkAnswer(false) // Pass the user's answer as false
        }

        btnNext.setOnClickListener {
            moveToNextQuestion() // Move to the next question
        }


        btnNext.isEnabled = false // Disable the "Next" button initially
    }

    private fun displayQuestion() {
        if (currentQuestionIndex < questions.size) { // Check if there are more questions
            val question = questions[currentQuestionIndex] // Get the current question
            txtQuestion.text = question.text


            txtAnswerFeedback.text = "" // Clear the answer feedback text
            btnTrue.isEnabled = true // Enable the "True" button
            btnFalse.isEnabled = true // Enable the "False" button
            btnNext.isEnabled = false // Disable the "Next" button
        } else {

            txtQuestion.text = "Quiz Finished!"
            txtAnswerFeedback.text = ""
            btnTrue.visibility = Button.GONE // Hide the "True" button
            btnFalse.visibility = Button.GONE // Hide the "False" button
            btnNext.text = "Score Screen"
            btnNext.isEnabled = true // Enable the "Next" button
            btnNext.setOnClickListener {
                val intent = Intent(this, ScoreScreen::class.java)
                intent.putExtra("final_score", score)
                intent.putExtra("total_questions", questions.size)
                startActivity(intent) //Move to the Score Screen page
                finish()} // Finish the current page
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val currentQuestion = questions[currentQuestionIndex]
        if (userAnswer == currentQuestion.answer) { // Check if the user's answer matches the correct answer
            txtAnswerFeedback.text = "Correct!"
            txtAnswerFeedback.setTextColor(getColor(R.color.black))
            score++ // Increase the score if the answer is correct
        } else {
            txtAnswerFeedback.text = "Incorrect. The correct answer was ${currentQuestion.answer}." // Display the correct answer
            txtAnswerFeedback.setTextColor(getColor(R.color.black))
        }

        btnTrue.isEnabled = false // Disable the "True" button
        btnFalse.isEnabled = false // Disable the "False" button
        btnNext.isEnabled = true // Enable the "Next" button
    }

    private fun moveToNextQuestion() {
        currentQuestionIndex++ // Move to the next question
        displayQuestion() // Display the next question
    }

    data class Question(val text: String, val answer: Boolean) // Data class to represent a question with text and answer
}