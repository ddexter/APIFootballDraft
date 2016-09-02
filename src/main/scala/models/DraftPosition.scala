package models

/**
  * @author ddexter
  */
object DraftPosition {
  sealed abstract class DraftPosition(val abbvPosition: String)
  case object RUNNING_BACK extends DraftPosition("RB")
  case object WIDE_RECEIVER extends DraftPosition("WR")
  case object TIGHT_END extends DraftPosition("TE")
  case object KICKER extends DraftPosition("K")
  case object QUARTER_BACK extends DraftPosition("QB")
  case object DEFENSE_SPECIAL_TEAMS extends DraftPosition("DST")

  val draftPositions = Set(RUNNING_BACK, WIDE_RECEIVER, TIGHT_END, KICKER, QUARTER_BACK, DEFENSE_SPECIAL_TEAMS)
  val draftPositionsByName = draftPositions.map(p => p.abbvPosition -> p).toMap
}
