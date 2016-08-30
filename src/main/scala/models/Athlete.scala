package models

import models.DraftPosition.DraftPosition

/**
  * @author ddexter
  */
class Athlete(val id: Int,
              val firstName: String,
              val lastName: String,
              val position: DraftPosition,
              val team: String,
              val rank: Int)
