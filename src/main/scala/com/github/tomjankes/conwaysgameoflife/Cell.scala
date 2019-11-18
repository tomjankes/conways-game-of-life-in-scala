package com.github.tomjankes.conwaysgameoflife

case class Cell(x: Int, y: Int) {
  private def distanceTo(cell: Cell): Double = {
    Math.sqrt((x - cell.x) * (x - cell.x) + (y - cell.y) * (y - cell.y))
  }

  def isNeighbour(cell: Cell) : Boolean = {
    def distance = distanceTo(cell)
    distance > 0 && distance < 2
  }

  def allPotentialNeighbours() : Set[Cell] = {
    val neighbourDimensions = List(-1, 0, 1)
    val elems = for {
      diffX <- neighbourDimensions
      diffY <- neighbourDimensions
      cell = Cell(x + diffX, y + diffY)
      if cell != this
    } yield cell
    elems.toSet
  }

  def survives(wasAlive: Boolean, numOfLiveNeighbours: Int): Boolean = numOfLiveNeighbours match {
    case 2 => wasAlive
    case 3 => true
    case _ => false
  }
}
