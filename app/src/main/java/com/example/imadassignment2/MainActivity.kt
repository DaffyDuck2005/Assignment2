package com.example.imadassignment2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var Welcome: TextView
    private lateinit var Sentence: TextView
    private lateinit var Start: Button
    private var currentIndex = 0   // Index to keep track of the current sentence being displayed
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private val sentences = arrayOf(
        "Time to test your knowledge about the past of time.",
        "This app will test your understanding of your history lessons by providing a series of questions with answers of True or False.",
        "As a question is answered, the screen will display if the question was answered correctly or not and will move onto the next question.",
        "Once all the questions are complete, you will see your final score of the questions and where you went wrong by clicking on Review."
        //Array of Questions to be displayed
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Welcome = findViewById(R.id.txtWelcome)
        Sentence = findViewById(R.id.txtSentence)
        Start = findViewById(R.id.btnStart)
        Welcome.text = "Welcome"
        Sentence.text = sentences[currentIndex]
        handler = Handler(Looper.getMainLooper())// Handler to loop through the sentences
        runnable = Runnable {
            currentIndex++ // Move to the next sentence
            if (currentIndex < sentences.size) { // Check if there are more sentences
                Sentence.text = sentences[currentIndex] // Display the next sentence
                handler.postDelayed(runnable, 8000)// Delay for 8 second before displaying the next sentence
            } else {
                handler.removeCallbacks(runnable) // Remove the runnable if there are no more sentences
                Start.isEnabled = true // Enable the "Start" button
                Sentence.text = "Press Start to begin the quiz"
                Start.setOnClickListener {
                    val intent = Intent(this, Questions::class.java) // Move to the Questions page
                    startActivity(intent)//Once the button "Start" is pressed, the quiz will start
                }
            }
        }
        handler.postDelayed(runnable, 8000)// Delay for 8 second before starting the loop
        Start.isEnabled = false // Disable the "Start" button initially
    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable) // Remove the runnable when the activity is destroyed
    }
}