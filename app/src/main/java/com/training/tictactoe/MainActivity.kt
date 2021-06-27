package com.training.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var txtplayer1Points: TextView
    lateinit var txtplayer2Points: TextView
    var player1 = 0
    var player2 = 0
    val gameState = arrayOf<Int>(2,2,2,2,2,2,2,2,2)
    val winPosition = arrayOf(
        arrayOf(0, 1, 2), arrayOf(3, 4, 5), arrayOf(6, 7, 8), arrayOf(0, 3, 6),
        arrayOf(1, 4, 7), arrayOf(2, 5, 8), arrayOf(0, 4, 8), arrayOf(2, 4, 6)
    )

   var activePlayer =0
    var count = 0
    var gameactive=true
    //  O:0
    //  X:1


    lateinit var btn0: Button
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var textStatus: TextView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtplayer1Points = findViewById(R.id.txtPlayer1)
        txtplayer2Points = findViewById(R.id.txtPlayer2)
        textStatus = findViewById(R.id.txtStatus)
        btn0 = findViewById(R.id.btn_00)
        btn1 = findViewById(R.id.btn_01)
        btn2 = findViewById(R.id.btn_02)
        btn3 = findViewById(R.id.btn_10)
        btn4 = findViewById(R.id.btn_11)
        btn5 = findViewById(R.id.btn_12)
        btn6 = findViewById(R.id.btn_20)
        btn7 = findViewById(R.id.btn_21)
        btn8 = findViewById(R.id.btn_22)

            btn0.setOnClickListener(this)
            btn1.setOnClickListener(this)
            btn2.setOnClickListener(this)
            btn3.setOnClickListener(this)
            btn4.setOnClickListener(this)
            btn5.setOnClickListener(this)
            btn6.setOnClickListener(this)
            btn7.setOnClickListener(this)
            btn8.setOnClickListener(this)
    }
    override fun onClick(v: View?) {

        val btn = v as Button

        var clickedImage = v.tag.toString()
        if ((gameState[clickedImage.toInt()] == 2) ) {
            count++

            if(activePlayer==1)
            {
                btn.text="O"
                textStatus.text="X's turn"
                activePlayer=0
                gameState[clickedImage.toInt()]=1
                gameactive=false
                checkWin()


            }
            else
            {
                btn.text="X"
                textStatus.text="O's turn"
                activePlayer=1
                gameState[clickedImage.toInt()]=0
                gameactive=false
                checkWin()
            }
            println("Count is $count")
            if(count==9)
            {
                println("From count 9 called ")
                draw()
            }

        }





    }

    private fun draw() {
        Toast.makeText(this,"Draw!!",Toast.LENGTH_SHORT).show()
        reset(0)
    }


    private fun checkWin(){

            for(i in 0 until 9 step 3) {
                if (gameState[i] == gameState[i + 1] && gameState[i] == gameState[i + 2] && !(gameState[i] == 2)) {
                    if (activePlayer == 1) {
                        Toast.makeText(this, "Player 1 won", Toast.LENGTH_SHORT).show()
                        player1++
                        println("Player 1 is $player1")
                        txtplayer1Points.text = "Player1: $player1"
                        textStatus.text="X's turn"
                        reset(0)
                        return
                    } else {
                        Toast.makeText(this, "Player 2 won", Toast.LENGTH_SHORT).show()
                        player2++
                        println("Player 2 is $player2")
                        txtplayer2Points.text = "Player2: $player2"
                        textStatus.text="O's turn"
                        reset(1)
                        return
                    }
                }
            }
             for(i in 0 until 3 ){
                if(gameState[i]==gameState[i+3] && gameState[i]==gameState[i+6] && !(gameState[i]==2)) {
                    if (activePlayer == 1) {
                        Toast.makeText(this, "Player 1 won", Toast.LENGTH_SHORT).show()
                        player1++
                        println("Player 1 is $player1")
                        txtplayer1Points.text = "Player1: $player1"
                        textStatus.text="X's turn"
                        reset(0)
                        return
                    } else {
                        Toast.makeText(this, "Player 2 won", Toast.LENGTH_SHORT).show()
                        player2++
                        println("Player 2 is $player2")
                        txtplayer2Points.text = "Player2: $player2"
                        textStatus.text="O's turn"
                        reset(1)
                        return
                    }
                }
                }

            if (gameState[0] == gameState[4] && gameState[0] == gameState[8] && !(gameState[0] == 2)) {
                if (activePlayer == 1) {
                    Toast.makeText(this, "Player 1 won", Toast.LENGTH_SHORT).show()
                    player1++
                    println("Player 1 is $player1")
                    txtplayer1Points.text = "Player1: $player1"
                    textStatus.text="X's turn"
                    reset(0)
                    return
                } else {
                    Toast.makeText(this, "Player 2 won", Toast.LENGTH_SHORT).show()
                    player2++
                    println("Player 2 is $player2")
                    txtplayer2Points.text = "Player2: $player2"
                    textStatus.text="O's turn"
                    reset(1)
                    return
                }
            }

        if (gameState[2] == gameState[4] && gameState[2] == gameState[6] && !(gameState[2] == 2)) {
            if (activePlayer == 1) {
                Toast.makeText(this, "Player 1 won", Toast.LENGTH_SHORT).show()
                player1++
                println("Player 1 is $player1")
                txtplayer1Points.text = "Player1: $player1"
                textStatus.text="X's turn"
                reset(0)
                return
            } else {
                Toast.makeText(this, "Player 2 won", Toast.LENGTH_SHORT).show()
                player2++
                println("Player 2 is $player2")
                txtplayer2Points.text = "Player2: $player2"
                textStatus.text="O's turn"
                reset(1)
                return
            }
        }


            println("End")
        }
    fun reset(act:Int)
    {
    for(i in 0 until 9)
    {
        gameState[i]=2
        btn0.text=""
        btn1.text=""
        btn2.text=""
        btn3.text=""
        btn4.text=""
        btn5.text=""
        btn6.text=""
        btn7.text=""
        btn8.text=""


        println("$gameState")
        count=0
        activePlayer=act

    }
    }


    }