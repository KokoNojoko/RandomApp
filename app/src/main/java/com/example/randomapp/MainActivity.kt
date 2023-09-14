package com.example.randomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var questionTextView: TextView
    private lateinit var optionAButton: Button
    private lateinit var optionBButton: Button
    private lateinit var optionCButton: Button

    private var currentQuestionIndex = 0
    private val questionBank = arrayOf(
        Question("What are the two official languages for Android development?", "A) Kotlin and Java"),
        Question("What is the biggest mammal in the planet?", "Blue Whale"),
        Question("Question 3", "Answer 3")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.textView)
        optionAButton = findViewById(R.id.button)
        optionBButton = findViewById(R.id.button2)
        optionCButton = findViewById(R.id.button3)

        updateQuestion()

        optionAButton.setOnClickListener {
            checkAnswer("A")
        }

        optionBButton.setOnClickListener {
            checkAnswer("B")
        }

        optionCButton.setOnClickListener {
            checkAnswer("C")
        }
    }

    private fun updateQuestion() {
        if (currentQuestionIndex < questionBank.size) {
            val currentQuestion = questionBank[currentQuestionIndex]
            questionTextView.text = currentQuestion.questionText
            optionAButton.text = currentQuestion.optionA
            optionBButton.text = currentQuestion.optionB
            optionCButton.text = currentQuestion.optionC
        } else {
            // All questions have been answered
            Toast.makeText(this, "Quiz completed!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkAnswer(selectedOption: String) {
        val currentQuestion = questionBank[currentQuestionIndex]
        if (selectedOption == currentQuestion.correctOption) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
        }

        // Move to the next question
        currentQuestionIndex++
        updateQuestion()
    }
}

class Question(val questionText: String, val correctOption: String) {
    val optionA: String = "A) Kotlin and Java"
    val optionB: String = "B) Java and Python"
    val optionC: String = "C) Kotlin and Python"
}
