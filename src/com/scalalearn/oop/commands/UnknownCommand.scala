package com.scalalearn.oop.commands

import com.scalalearn.oop.filesystem.State

class UnknownCommand extends Command {

  override def apply(state: State): State =
    state.setMessage("Command not found!")

}
