package api

import models.DraftPosition
import models.DraftPosition.DraftPosition
import play.api.libs.json._
import play.api.libs.functional.syntax._

/**
  * @author ddexter
  */
case class QueryResult(firstName: String, lastName: String, position: DraftPosition, college: String, id: Int) {
  override def toString: String = firstName + " " + lastName + ": " + position.abbvPosition + " out of " + college
}
object QueryResult {
  implicit val queryResultReads = (
    (__ \ "first_name").read[String] and
      (__ \ "last_name").read[String] and
      (__ \ "fantasy_position").read[String].map(DraftPosition.draftPositionsByName(_)) and
      (__ \ "college" \ "name").read[String] and
      (__ \ "id").read[Int]
    )(QueryResult.apply _)
}
