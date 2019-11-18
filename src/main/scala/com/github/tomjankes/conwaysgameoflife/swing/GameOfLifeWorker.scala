package com.github.tomjankes.conwaysgameoflife.swing

import java.util

import com.github.tomjankes.conwaysgameoflife.Board
import com.typesafe.scalalogging.LazyLogging
import javax.swing.SwingWorker

class GameOfLifeWorker(
                        val initialBoard: Board,
                        val frame: MainFrame,
                        val iterations: Int,
                        val sleepMs: Long
                      ) extends SwingWorker[Board, Board] with LazyLogging {

  override def doInBackground(): Board = {
    var board = initialBoard

    publish(board)

    for (_ <- 0 to iterations) {
      board = board.nextBoard()
      publish(board)
      Thread.sleep(sleepMs)
    }
    board
  }

  override def process(chunks: util.List[Board]): Unit = {
    val lastBoard = chunks.get(chunks.size() - 1)
    frame.updateGUI(lastBoard)
  }

}