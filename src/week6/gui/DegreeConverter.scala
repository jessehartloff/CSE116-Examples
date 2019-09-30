package week6.gui

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.{Button, TextField}
import scalafx.scene.layout.VBox


object DegreeConverter extends JFXApp {

  val inputDisplay: TextField = new TextField {
    style = "-fx-font: 18 ariel;"
  }

  val outputDisplay: TextField = new TextField {
    editable = false
    style = "-fx-font: 18 ariel;"
  }

  val button: Button = new Button {
    minWidth = 100
    minHeight = 100
    style = "-fx-font: 28 ariel;"
    text = "F to C"
    onAction = new ButtonListener(inputDisplay, outputDisplay)
  }

  val verticalBox: VBox = new VBox(){
    children = List(inputDisplay, button, outputDisplay)
  }

  this.stage = new PrimaryStage {
    title = "Degree Converter"
    scene = new Scene() {
      content = List(verticalBox)
    }
  }

}
