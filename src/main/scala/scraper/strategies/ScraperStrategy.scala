package scraper.strategies

import models.Athlete
import scraper.Scraper.JDoc

/**
  * @author ddexter
  */
trait ScraperStrategy {
  def parse(jDoc: JDoc): Seq[Athlete]
}
