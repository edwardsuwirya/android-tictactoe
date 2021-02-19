package info.mylabstudio.tictactoe.utils

var board = arrayOf(
    arrayOf(BoardState.BLANK, BoardState.BLANK, BoardState.BLANK),
    arrayOf(BoardState.BLANK, BoardState.BLANK, BoardState.BLANK),
    arrayOf(BoardState.BLANK, BoardState.BLANK, BoardState.BLANK)
)

var boardCoordinate = mapOf(
    1 to arrayOf(2, 2),
    2 to arrayOf(2, 1),
    3 to arrayOf(2, 0),
    4 to arrayOf(1, 2),
    5 to arrayOf(1, 1),
    6 to arrayOf(1, 0),
    7 to arrayOf(0, 2),
    8 to arrayOf(0, 1),
    9 to arrayOf(0, 0)
)

const val WINNER_TEXT = " is a winner"
const val PLAYER_TURN_TEXT = "'s turn"

const val PLAYER1_PARAM = "player1"
const val PLAYER2_PARAM = "player2"