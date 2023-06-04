package com.example.guessinggame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var imageButtonReplay: ImageButton
    lateinit var imageButtonDone: ImageButton

    var random: Int = nextInt(1, 100)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        imageButtonReplay = findViewById(R.id.imageButtonReplay)
        imageButtonDone = findViewById(R.id.imageButtonDone)

        textView.text = "Take a guess, (choose a number between 1 and 100)"

        imageButtonDone.setOnClickListener {

            val number: Int = editText.text.toString().toInt()

            if (number < random) {
                textView.text = "That guess was too low, try again."
                editText.text.clear()
            }
            else if (number > random) {
                textView.text = "That guess was too high, try again."
                editText.text.clear()

            }
            else{
                textView.text = "You got it! the number was $random"
                editText.text.clear()

            }
        }

        imageButtonReplay.setOnClickListener {
            reset()
        }

    }
    @SuppressLint("SetTextI18n")
    fun reset(){
        random = nextInt(1, 100)
        textView.text = "Take a guess, (choose a number between 1 and 100)"
        editText.text.clear()
    }
}