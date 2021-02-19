package info.mylabstudio.tictactoe.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import info.mylabstudio.tictactoe.*
import info.mylabstudio.tictactoe.utils.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var activePlayer = ""
    var player1 = ""
    var player2 = ""

    var currentBoard = board

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        player1 = intent.getStringExtra(PlayerRegistrationActivity.PLAYER1) ?: ""
        player2 = intent.getStringExtra(PlayerRegistrationActivity.PLAYER2) ?: ""
        activePlayer = player1
        showCurrentPlayerName("'s turn")
    }

    private fun showCurrentPlayerName(status: String) {
        tvCurrentPlayer.text = activePlayer + status
//        Log.d("Player 1: ", player1Pos.toString())
//        Log.d("Player 2:", player2Pos.toString())
    }

    fun buttonPlayClick(view: View) {
        val buttonSelected = view as Button
        var cellId = 0

        when (buttonSelected.id) {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }

        playGame(cellId, buttonSelected)
    }


    private fun move(cellId: Int, state: BoardState) {
        val pos = boardCoordinate[cellId]
        pos?.apply {
            currentBoard[pos[0]][pos[1]] = state
            val haveAWinner = winCalculation(pos[0], pos[1], state)
            if (!haveAWinner) {
                switchPlayer()
                showCurrentPlayerName("$PLAYER_TURN_TEXT")
            }
        }

    }

    private fun printBoard() {
        for (i in 0..2) {
            for (j in 0..2) {
                println("Board $i,$j :${board[i][j]}")
            }
        }
    }

    private fun winCalculation(currXPos: Int, currYPos: Int, state: BoardState): Boolean {
        for (i in 0..2) {
            if (currentBoard[currXPos][i] != state) {
                break
            }
            if (i == 2) {
                showWinner()
                return true
            }

        }
        for (i in 0..2) {
            if (currentBoard[i][currYPos] != state) {
                break
            }
            if (i == 2) {
                showWinner()
                return true
            }
        }
        return false
    }

    private fun switchPlayer() {
        if (activePlayer == player1) {
            activePlayer = player2
        } else {
            activePlayer = player1
        }
    }

    private fun showWinner() {
        showCurrentPlayerName("$WINNER_TEXT")
        clearBoard()
    }

    private fun clearBoard() {
        currentBoard = board
        button1.setText("")
        button1.setBackgroundResource(R.color.white)
        button2.setText("")
        button2.setBackgroundResource(R.color.white)
        button3.setText("")
        button3.setBackgroundResource(R.color.white)
        button4.setText("")
        button4.setBackgroundResource(R.color.white)
        button5.setText("")
        button5.setBackgroundResource(R.color.white)
        button6.setText("")
        button6.setBackgroundResource(R.color.white)
        button7.setText("")
        button7.setBackgroundResource(R.color.white)
        button8.setText("")
        button8.setBackgroundResource(R.color.white)
        button9.setText("")
        button9.setBackgroundResource(R.color.white)
    }

    private fun playGame(cellId: Int, buttonSelected: Button) {
        if (activePlayer == player1) {
            buttonSelected.text = BoardState.X.toString()
            buttonSelected.setBackgroundResource(R.color.orange)
            move(cellId, BoardState.X)
        } else {
            buttonSelected.text = BoardState.O.toString()
            buttonSelected.setBackgroundResource(R.color.green)
            move(cellId, BoardState.O)
        }
    }
}
