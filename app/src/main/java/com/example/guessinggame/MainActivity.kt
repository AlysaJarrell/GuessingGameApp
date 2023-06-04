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

//        start game play
        textView.text = "Take a guess, (choose a number between 1 and 100)"
//      when 'Done' button is clicked it will do the following
        imageButtonDone.setOnClickListener {
//          Turns the text we get from a string to an Int so we can compare the guess with the random number
            val guess: Int = editText.text.toString().toInt()
//          Makes sure the input is valid, if it is over 100, display message and clear input
            if (guess > 100){
                textView.text = "$guess is over 100, the number is between 1 and 100; input a lower number"
                editText.text.clear()
            }
            else {

//            checks to see if guess was less than random number, prints message and clears guess
                if (guess < random) {
                    textView.text = "$guess is too low, try again."
                    editText.text.clear()
                }

//            checks to see if guess was greater than random number, prints message and clears guess
                else if (guess > random) {
                    textView.text = "$guess is too high, try again."
                    editText.text.clear()

                }
//            guess and number would have been equal, prints message and clears guess
                else {
                    textView.text = "You got it! the number was $random"
                    editText.text.clear()

                }
            }
        }
//      when replay button is presses we reset the game
        imageButtonReplay.setOnClickListener {
            reset()
        }

    }
//  creates the function reset(), prompts the same as the start and gets a new random number, clears any guess
    @SuppressLint("SetTextI18n")
    fun reset(){
        random = nextInt(1, 100)
        textView.text = "Take a guess, (choose a number between 1 and 100)"
        editText.text.clear()
    }
}