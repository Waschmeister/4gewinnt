package com.example.whatclone


const val TURN_SEPARATOR = "-----------------------------------------------------"

fun render(data: GameData): String {

    var output = ""

    (0..5).forEach { rowIndex ->
        (0..6).forEach { columnIndex ->
            val fieldValue = data.board[columnIndex][5 - rowIndex]
            output += fieldValue ?: "."
        }
        output += "\n"
    }

    return output
}

fun placeChip(
    oldBoard: List<List<String?>>,
    columnToPlace: Int,
    currentPlayer: String
): List<List<String?>> {
    val newBoard = oldBoard.mapIndexed { columnIndex, oldColumn ->
        if (columnIndex == columnToPlace) addChipToColumn(oldColumn, currentPlayer)
        else oldColumn
    }
    return newBoard
}

fun addChipToColumn(oldColumn: List<String?>, currentPlayer: String): List<String?> {
    var hasChipInHand = true
    return oldColumn.map { oldValue ->
        when {
            oldValue != null -> oldValue
            hasChipInHand && oldValue == null -> {
                hasChipInHand = false
                currentPlayer
            }
            !hasChipInHand && oldValue == null -> null
            else -> throw java.lang.IllegalStateException("You fucked up, fool!")
        }
    }
}


fun main() {

    val gameData = GameData(
        board = listOf(
            listOf(null, null, null, null, null, null),
            listOf(null, null, null, null, null, null),
            listOf(null, null, null, null, null, null),
            listOf(null, null, null, null, null, null),
            listOf(null, null, null, null, null, null),
            listOf(null, null, null, null, null, null),
            listOf(null, null, null, null, null, null),
        ),
        currentPlayer = "X"
    )
    while (true) {

        println(render(gameData))
        println(TURN_SEPARATOR)
        println("Current player is ${gameData.currentPlayer}. Select column by number 0 - 6. 'Q' to quit.")
        println(TURN_SEPARATOR)
        val selectedAction = readlnOrNull()

        when {
            "q" == selectedAction -> System.exit(0)
            "Q" == selectedAction -> System.exit(0)
            selectedAction?.toIntOrNull() == null -> println("Please select a column 0-6 or Q")
            selectedAction?.toIntOrNull() != null -> {
                println("Selected colunn:  $selectedAction")
                gameData.board =
                    placeChip(
                        oldBoard = gameData.board,
                        columnToPlace = selectedAction?.toInt(),
                        currentPlayer = gameData.currentPlayer
                    )
                gameData.currentPlayer = if (gameData.currentPlayer == "X") "O" else "X"
            }
            else -> throw java.lang.IllegalStateException("Unknown user action was triggered: $selectedAction")
        }

    }
}