package api

import models.DraftPosition.DraftPosition
import play.api.libs.json.Json
import scalaj.http._

/**
  * @author ddexter
  */
case class API(key: String) {
  def queryForPlayer(name: String, position: DraftPosition): Seq[QueryResult] = {
    val pos = position.abbvPosition
    val res = Http(API.DRAFT_URL + s"/search/name/$name/pos/$pos")
      .option(HttpOptions.allowUnsafeSSL)
      .timeout(API.TIME_OUT, API.TIME_OUT).asString
    (Json.parse(res.body) \ "results").as[Seq[QueryResult]]
  }
}

object API {
  private val DRAFT_URL = "https://draft.gnmerritt.net/api/v1"
  private val TIME_OUT = 60000
}
