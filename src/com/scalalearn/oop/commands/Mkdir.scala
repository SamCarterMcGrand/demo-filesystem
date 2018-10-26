package com.scalalearn.oop.commands

import com.scalalearn.oop.files.{DirEntry, Directory}
import com.scalalearn.oop.filesystem.State

class Mkdir(name: String) extends Command {

  override def apply(state: State): State = {
    val wd = state.wd
    if (wd.hasEntry(name)) {
      state.setMessage("Entry " + name + " already exists!")
    }
    else if (name.contains(Directory.SEPARATOR)) {
      state.setMessage(name + " must not contain separators!")
    }
    else if (checkIllegal(name)) {
      state.setMessage(name + ": illegal entry name!")
    }
    else doMkdir(state, name)
  }

  def checkIllegal(str: String): Boolean = {
    name.contains(".")
  }

  def doMkdir(state: State, str: String): State = {
    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry): Directory = {
      /*
        someDir
          /a
          /b
          (new) /d

          => new someDir
          /a
          /b
          /d
       */

      if(path.isEmpty) currentDirectory.addEntry(newEntry)
      else {
        /*
          currentDirectory = /a
          path = ["b"]
         */
      }
    }
    val wd: = state.wd

    // 1. all the directories in the full path
    val allDirsInPath = wd.getAllFoldersInPath

    // 2. update new structure with new directory entry
    val newDir = Directory.empty(wd.path, name)

    // 3. update the whole directory structure starting from the root
    //      (directory structure is immutable)
    val newRoot = updateStructure(state.root, allDirsInPath, newDir)

    // 4. find new working directory instance given wd, in the NEW directory structure
    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)
  }

}
