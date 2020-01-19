package fold

// http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-fold-example/

object FoldListExamples extends App {

  println("How to initialize a sequence of donut prices")
  val prices: Seq[Double] = Seq(1.5, 2.0, 2.5)
  println(s"Donut prices = $prices") // Donut prices = List(1.5, 2.0, 2.5)

  println("\nHow to sum all the donut prices using fold function")
  val sumOfPrices: Double = prices.fold(0.0)(addTwoPrices)
  def addTwoPrices(a: Double, b: Double): Double = a + b
  println(s"sum = $sumOfPrices") // sum = 6.0

  println("\nHow to initialize a Sequence of donuts")
  val donuts: Seq[String] = Seq("Plain", "Strawberry", "Glazed")
  println(s"Elements of donuts1 = $donuts") // Elements of donuts1 = List(Plain, Strawberry, Glazed)

  println("\nHow to create a String of all donuts using fold function")
  val donutLine: (String, String) => String = (acc, newDonut) => acc + newDonut + " donut "
  println(donuts.fold("")(donutLine)) // Plain donut Strawberry donut Glazed donut
}