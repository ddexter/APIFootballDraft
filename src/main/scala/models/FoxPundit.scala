package models

/**
  * Enumeration of the multiple Fox pundits per top players page
  * @author ddexter
  */
object FoxPundit {
  sealed abstract class FoxPundit(val name: String, val column: Int)
  case object AVERAGE extends FoxPundit("Average", 0)
  case object FOWLER extends FoxPundit("Fowler", 2)
  case object MEYER extends FoxPundit("Meyer", 3)
  case object HALPIN extends FoxPundit("Halpin", 4)
  case object DJ_FOSTER extends FoxPundit("DJFoster", 5)

  val foxPundits = Set(AVERAGE, FOWLER, MEYER, HALPIN, DJ_FOSTER)
  val foxPunditsByName = foxPundits.map(p => p.name -> p)
}
