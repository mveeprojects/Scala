package partiallyAppliedFunctions

object PAFMain extends App {

  // a general purpose function
  def calculateBill(vat: Int)(total: Double): Double = total + ((total / 100) * vat)

  // specific implementations of the general purpose function (PAFs - already partially applying the general function by setting the VAT value)
  def calculateBillUK: Double => Double = calculateBill(20)(_)
  def calculateBillDE: Double => Double = calculateBill(19)(_)

  // user of the PAF just needs to apply the remaining function parameters
  println(calculateBillUK(80))
  println(calculateBillDE(80))
}