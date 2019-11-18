package com.github.tomjankes.conwaysgameoflife

import org.scalatest.FunSpec

class CellTest extends FunSpec {

  describe("A Cell with coordinates 0,0") {
    val cell = Cell(0, 0)
    it("should be neighbour to 0,1") {
      assert(cell.isNeighbour(Cell(0, 1)))
    }
    it("should be neighbour to 1,1") {
      assert(cell.isNeighbour(Cell(1, 1)))
    }
    it("should be neighbour to 1,0") {
      assert(cell.isNeighbour(Cell(1, 0)))
    }
    it("should be neighbour to -1,-1") {
      assert(cell.isNeighbour(Cell(-1, -1)))
    }
    it("should not be neighbour to 2,1") {
      assert(!cell.isNeighbour(Cell(2, 1)))
    }
  }

  describe("A cell with coordinates 1,-1") {
    val cell = Cell(1, -1)

    it ("should be neighbour with 0,0") {
      assert(cell.isNeighbour(Cell(0, 0)))
    }
    it ("should be neighbour with 1,0") {
      assert(cell.isNeighbour(Cell(1, 0)))
    }
    it ("should not be neighbour with 1,1") {
      assert(!cell.isNeighbour(Cell(1, 1)))
    }
  }

  describe("A Cell") {
    val cell = Cell(0, 0)
    it("should be alive if exactly three neighbours are alive") {
      assert(cell.survives(wasAlive = true, 3))
    }
    it("should be alive if exactly two neighbours are alive and it was alive") {
      assert(cell.survives(wasAlive = true, 2))
    }
    it("should die if exactly one neighbour is alive") {
      assert(!cell.survives(wasAlive = true, 1))
    }
    it("should die if more than three neighbours are alive") {
      assert(!cell.survives(wasAlive = true, 5))
    }
    it("should die if exactly two neighbours are alive and it was dead") {
      assert(!cell.survives(wasAlive = false, 2))
    }
    it("should return all it's neighbours") {
      val Cell(x, y) = cell
      val neighbours = cell.allPotentialNeighbours()

      assert(neighbours == Set(
        Cell(x - 1, y - 1), Cell(x - 1, y), Cell(x - 1, y + 1),
        Cell(x,     y - 1),                 Cell(x,     y + 1),
        Cell(x + 1, y - 1), Cell(x + 1, y), Cell(x + 1, y + 1)
      ))
    }
  }


}
