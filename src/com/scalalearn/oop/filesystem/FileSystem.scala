package com.scalalearn.oop.filesystem

import java.util.Scanner

import com.scalalearn.oop.commands.Command
import com.scalalearn.oop.files.Directory

object FileSystem extends App {

  val root = Directory.ROOT
  var state = State(root, root) // needs var as it is not immutable
  val scanner = new Scanner(System.in)

  while (true) {
    state.show
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)
  }

}
