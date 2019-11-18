package com.github.tomjankes.conwaysgameoflife

import org.scalatest.FunSpec

class BoardTest extends FunSpec {

  describe("A board") {
    it("should return all dead board if it was all dead") {
      assert(Board(Set()).nextBoard().cells.isEmpty)
    }

    it("should return all dead board if there was only one alive cell") {
      def cells = Set(Cell(0, 0))
      assert(Board(cells).nextBoard().cells.isEmpty)
    }

    it("should preserve block still life") {
      def cells = Set(
        Cell(0, 0), Cell(0, 1),
        Cell(1, 0), Cell(1, 1)
      )
      assert(Board(cells).nextBoard().cells == cells)
    }

    it("should resurrect new cell if there are three neighbours") {
      def cells = Set(
        Cell(0, 0), Cell(0, 1),
        Cell(1, 0)
      )
      assert(Board(cells).nextBoard().cells == Set(
        Cell(0, 0), Cell(0, 1),
        Cell(1, 0), Cell(1, 1)
      ))
    }
  }

}
