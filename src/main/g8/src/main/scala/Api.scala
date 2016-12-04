package $package$

import unfiltered.request._
import unfiltered.filter.Plan
import unfiltered.filter.request.ContextPath
import unfiltered.response._
import org.json4s.JsonDSL._

object Api extends Plan {
  def intent = {
    case ContextPath(_, Seg("users" :: id)) =>
      Json(("user" -> ("id" -> id) ~ ("name" -> "finnegan")))
  }
}
