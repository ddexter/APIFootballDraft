package scraper

import api.{API, QueryResult}
import models.Athlete

import scala.io.StdIn

/**
  * @author ddexter
  */
class PlayerCanonicalizer(api: API) {
  def getCanonical(athlete: Athlete): Option[Athlete] = {
    val results = api.queryForPlayer(athlete.lastName.replaceAll("[^a-zA-Z]", ""), athlete.position)
    results match {
      case r if r.length == 1 => Some(canonicalizeAthlete(athlete, results.head))
      case r if r.isEmpty => None
      case _ => resolvePossibilities(athlete, results)
    }
  }

  private def canonicalizeAthlete(athlete: Athlete, queryResult: QueryResult): Athlete =
    new Athlete(queryResult.id,
      queryResult.firstName,
      queryResult.lastName,
      queryResult.position,
      athlete.team,
      athlete.rank
    )

  private def resolvePossibilities(athlete: Athlete, results: Seq[QueryResult]): Option[Athlete] = {
    println("Multiple candidates, select one:")
    results.zipWithIndex.foreach(result => println(result._2 + ": " + result._1))
    print("Choice: ")
    val choice = StdIn.readInt()
    choice match {
      case c if c == 0 => None
      case c if c < results.length => Some(canonicalizeAthlete(athlete, results(c)))
      case _ => None
    }
  }
}
