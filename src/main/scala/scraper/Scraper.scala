package scraper

import org.jsoup.Jsoup

/**
  * @author ddexter
  */
object Scraper {
  type JDoc = org.jsoup.nodes.Document
  def loadHTML(url: String): JDoc = Jsoup.connect(url).get()
}
