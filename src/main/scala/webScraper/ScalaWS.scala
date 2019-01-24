package webScraper

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL._

object ScalaWS extends App {

  private val url = "URL goes here"

  printAll(getHTMLBody)

  def getHTMLBody: List[String] = {
    val browser = JsoupBrowser()
    val doc: browser.DocumentType = browser.get(url)
    val items = doc >> elementList("tr td")
    items.map(_ >> allText("a")).filter(_.nonEmpty).drop(1)
  }

  def printAll(strings: List[String]): Unit = {
    strings.foreach(println)
    println(strings.size)
  }
}