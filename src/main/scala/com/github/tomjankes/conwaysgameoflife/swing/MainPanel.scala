package com.github.tomjankes.conwaysgameoflife.swing

import java.awt.{Color, Graphics}

import com.github.tomjankes.conwaysgameoflife.{Board, Cell}
import javax.swing.JPanel

class MainPanel(var board: Board, val dimensions: GameDimensions) extends JPanel {
  private val GameDimensions(gameWidth, gameHeight, zoom) = dimensions

  override def paint(g: Graphics): Unit = {
    for (x <- 0 to gameWidth; y <- 0 to gameHeight) {
      g.setColor(if (board.cells.contains(Cell(x, y))) Color.BLACK else Color.WHITE)
      val (rectX, rectY) = dimensions.rect(x, y)
      g.fillRect(rectX, rectY, zoom, zoom)
    }
    setSize(dimensions.panelWidth, dimensions.panelHeight)
  }
}

