package models

import models.DraftPosition.Position

/**
  * @author ddexter
  */
class Athlete(val id: Int,
              val firstName: String,
              val lastName: String,
              val position: Position,
              val team: String,
              val rank: Int)
