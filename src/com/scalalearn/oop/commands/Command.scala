package com.scalalearn.oop.commands

import com.scalalearn.oop.filesystem.State

trait Command {

  def apply(state: State): State

}

object Command {
  def from(input: String): Command =
    new UnknownCommand
}
