package scraper.strategies

import models.Athlete
import models.DraftPosition.DraftPosition
import org.jsoup.nodes.Element
import scala.collection.JavaConversions._
import scraper.Scraper.JDoc

/**
  * @author ddexter
  */
case class ESPN(position: DraftPosition) extends ScraperStrategy {
  // 1. Adrian Peterson
  val NAME_RANK_PATTERN = """(\d+)\.\s+([a-zA-Z\-\'\. ]+) ([a-zA-Z\-\']+)""".r
  val NUM_COL = 3

  override def parse(jDoc: JDoc): Seq[Athlete] = {
    val elements = jDoc.select("tbody > tr.last").iterator.toList
    elements.flatMap(tr => getAthleteFromRow(tr, position))
  }

  private def getAthleteFromRow(row: Element, position: DraftPosition): Option[Athlete] = {
    val tds = row.select("td")
    if (tds.size() != NUM_COL) None
    else tds.get(0).text match {
      case NAME_RANK_PATTERN(rank, first, last) => Some(new Athlete(rank.toInt, first, last, position, tds.get(1).text, rank.toInt))
      case _ => None
    }
  }
}
