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
    private var score = 0


    private val questions = listOf(
        Question("The First All Race Election in South Africa Was In 1994.", true),
        Question("Is The Cradle Of Humankind located in Johannesburg.", true),
        Question("Apartheid Ended in 1997 .", false),
        Question("Nelson Mandela became the first South African president after he got released from jail and after the apartheid ended.", true),
        Question("Only White and Black people were separated.", false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)


        txtQuestion = findViewById(R.id.txtQuestion)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        btnNext = findViewById(R.id.btnNext)
        txtAnswerFeedback = findViewById(R.id.txtAnswerFeedback)


        displayQuestion()


        btnTrue.setOnClickListener {
            checkAnswer(true)
        }

        btnFalse.setOnClickListener {
            checkAnswer(false)
        }

        btnNext.setOnClickListener {
            moveToNextQuestion()
        }


        btnNext.isEnabled = false
    }

    private fun displayQuestion() {
        if (currentQuestionIndex < questions.size) {
            val question = questions[currentQuestionIndex]
            txtQuestion.text = question.text


            txtAnswerFeedback.text = ""
            btnTrue.isEnabled = true
            btnFalse.isEnabled = true
            btnNext.isEnabled = false
        } else {

            txtQuestion.text = "Quiz Finished!"
            txtAnswerFeedback.text = ""
            btnTrue.visibility = Button.GONE
            btnFalse.visibility = Button.GONE
            btnNext.text = "Score Screen"
            btnNext.isEnabled = true
            btnNext.setOnClickListener {
                val intent = Intent(this, ScoreScreen::class.java)
                intent.putExtra("final_score", score)
                intent.putExtra("total_questions", questions.size)
                startActivity(intent)
                finish()}
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val currentQuestion = questions[currentQuestionIndex]
        if (userAnswer == currentQuestion.answer) {
            txtAnswerFeedback.text = "Correct!"
            txtAnswerFeedback.setTextColor(getColor(R.color.black))
            score++
        } else {
            txtAnswerFeedback.text = "Incorrect. The correct answer was ${currentQuestion.answer}."
            txtAnswerFeedback.setTextColor(getColor(R.color.black))
        }


        btnTrue.isEnabled = false
        btnFalse.isEnabled = false
        btnNext.isEnabled = true
    }

    private fun moveToNextQuestion() {
        currentQuestionIndex++
        displayQuestion()
    }


    data class Question(val text: String, val answer: Boolean)
}