package models

/**
  * @author ddexter
  */
object DraftPosition {
  sealed abstract class Position(val abbvPosition: String)
  case object RUNNING_BACK extends Position("RB")
  case object WIDE_RECEIVER extends Position("WR")
  case object TIGHT_END extends Position("TE")
  case object KICKER extends Position("K")
  case object QUARTER_BACK extends Position("QB")
  case object DEFENSE_SPECIAL_TEAMS extends Position("DST")

  val positions = Set(RUNNING_BACK, WIDE_RECEIVER, TIGHT_END, KICKER, QUARTER_BACK, DEFENSE_SPECIAL_TEAMS)
  val positionsByName = positions.map(p => p.abbvPosition -> p)
}
