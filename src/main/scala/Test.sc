import models.DraftPosition.RUNNING_BACK
import scraper.Scraper
import scraper.strategies.ESPN

val x = Scraper.loadHTML("http://www.espn.com/fantasy/football/story/_/id/16288373/fantasy-football-rankings-2016-espn-nfl-ranks-running-backs")
val espn = ESPN(RUNNING_BACK)
espn.parse(x)