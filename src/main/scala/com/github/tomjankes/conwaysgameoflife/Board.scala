package com.github.tomjankes.conwaysgameoflife

import com.typesafe.scalalogging.LazyLogging

case class Board(cells: Set[Cell]) extends LazyLogging {
  def nextBoard() : Board = {
    def newCells = removeDeadCells() ++ resurrectCells()
    Board(newCells)
  }

  private def resurrectCells() : Set[Cell] = cells.flatMap(cell => {
    cell.allPotentialNeighbours()
      .filter(potentialNeighbour => !cells.contains(potentialNeighbour))
      .filter(potentialNeighbour =>
        potentialNeighbour.survives(wasAlive = false, numberOfLiveNeighbours(potentialNeighbour))
      )
  })

  private def removeDeadCells() : Set[Cell] =  {
    cells.filter(cell => cell.survives(wasAlive = true, numberOfLiveNeighbours(cell)))
  }

  private def numberOfLiveNeighbours(cell: Cell): Int = {
    cells.count(current => current.isNeighbour(cell))
  }
}
