package com.github.tomjankes.conwaysgameoflife.swing

import com.github.tomjankes.conwaysgameoflife.{Board, Cell}

object AppRunner {
  val screenDimensions = 100
  val zoom = 5
  val numberOfIterations = 1000
  val sleepTimeBetweenIterationsMs = 100L

  def main(args: Array[String]): Unit = {

    val initialBoard = Set(
                   Cell(-5, 1),
      Cell(-4, 0),
      Cell(-3, 0), Cell(-3, 1), Cell(-3, 2),

      Cell(4, 0),  Cell(4, 1),  Cell(4, 2),
      Cell(5, 0),               Cell(5, 2),
      Cell(6, 0),  Cell(6, 1),  Cell(6, 2),

    ).map(cell => Cell(cell.x + 50, cell.y + 50))


    val board = Board(initialBoard)
    val dimensions = GameDimensions(screenDimensions, screenDimensions, zoom)
    val panel = new MainPanel(board, dimensions)
    val frame = new MainFrame(panel, dimensions)
    val game = new GameOfLifeWorker(board, frame, numberOfIterations, sleepTimeBetweenIterationsMs)
    game.execute()
  }
}
