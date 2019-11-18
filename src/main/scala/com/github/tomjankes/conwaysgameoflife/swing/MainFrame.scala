package com.github.tomjankes.conwaysgameoflife.swing

import com.github.tomjankes.conwaysgameoflife.Board
import javax.swing.{JFrame, SwingUtilities, WindowConstants}

class MainFrame(val panel: MainPanel, val dimensions: GameDimensions) extends JFrame {
  add(panel)
  setSize(dimensions.frameWidth, dimensions.frameHeight + 30)
  setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  setTitle("Conway's Game of Life")
  setVisible(true)

  def updateGUI(board: Board) : Unit = {
    if (!SwingUtilities.isEventDispatchThread) {
      SwingUtilities.invokeLater(() => { updateGUI(board) })
    } else {
      panel.board = board
      panel.repaint()
    }
  }
}