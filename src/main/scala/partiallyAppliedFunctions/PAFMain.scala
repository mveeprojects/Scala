package partiallyAppliedFunctions

object PAFMain extends App {

  // a general purpose function
  def calculateBill(vat: Int)(total: Double) = total + ((total / 100) * vat)

  // specific implementations of the general purpose function (PAFs - already partially applying the general function by setting the VAT value)
  def calculateBillUK = calculateBill(20)(_)
  def calculateBillDE = calculateBill(19)(_)

  // user of the PAF just needs to apply the remaining function parameters
  println(calculateBillUK(80))
  println(calculateBillDE(80))
}