package com.example.app

import org.scalatra._

import org.json4s.{DefaultFormats, Formats}

// JSON handling support from Scalatra
import org.scalatra.json._

case class Domain(slug: String, name: String)

object DomainData {

  /**
   * Some fake flowers data so we can simulate retrievals.
   */
  var all = List(
      Domain("zensoftware", "zensoftware.co"),
      Domain("workload-pro", "workloadpro.com"),
      Domain("keep-reveiws-moving", "keepreviewsmoving.tech"))
}

class MyScalatraServlet extends MyScalatraWebAppStack with JacksonJsonSupport {
  protected implicit lazy val jsonFormats: Formats = DefaultFormats
  before() {
    contentType = formats("json")
  }

  get("/") {
    DomainData.all
  }
}

