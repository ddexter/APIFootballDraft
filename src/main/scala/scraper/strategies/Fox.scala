package scraper.strategies

import models.{Athlete, FoxPundit}
import models.DraftPosition.DraftPosition
import models.FoxPundit.FoxPundit
import org.jsoup.nodes.Element

import scala.collection.JavaConversions._
import scraper.Scraper.JDoc

/**
  * @author ddexter
  */
case class Fox(position: DraftPosition, pundit: FoxPundit) extends ScraperStrategy {
  // 1. Todd Gurley (LA - RB)
  val NAME_RANK_PATTERN = """(\d+)\. ([a-zA-Z\-\'\. ]+) ([a-zA-Z\-\']+) \(([a-zA-Z]+) - [a-zA-Z]+\)""".r
  val NBSP = "\u00a0"
  val NUM_COL = 6

  override def parse(jDoc: JDoc): Seq[Athlete] = {
    // Player rows, drop header
    val elements = jDoc.select("tbody > tr").iterator.toList.tail
    elements.flatMap(tr => getAthleteFromRow(tr, position, pundit))
  }

  private def getAthleteFromRow(row: Element, position: DraftPosition, foxPundit: FoxPundit): Option[Athlete] = {
    val tds = row.select("td")
    if (tds.size != NUM_COL) None
    else tds.get(0).text.replace(NBSP, " ") match {
      case NAME_RANK_PATTERN(rank, first, last, team) => foxPundit match {
          case FoxPundit.AVERAGE => Some(new Athlete(rank.toInt, first, last, position, team, rank.toInt))
          case _ => Some(new Athlete(tds.get(foxPundit.column).text.toInt, first, last, position, team, tds.get(foxPundit.column).text.toInt))
        }
      case _ => None
    }
  }
}
