package com.github.tomjankes.conwaysgameoflife.swing

case class GameDimensions(width: Int, height: Int, zoom: Int) {
  val frameWidth: Int = width * zoom
  val frameHeight: Int = height * zoom
  val panelWidth: Int = frameWidth - zoom
  val panelHeight: Int = frameHeight - zoom

  def rect(x: Int, y: Int) : (Int, Int) = {
    ((x * zoom) - (zoom / 2), (y * zoom) - (zoom / 2))
  }
}

