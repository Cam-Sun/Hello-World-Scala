import BeforeAutomation.Calculator
import org.scalatest.flatspec.AnyFlatSpec

class CalculatorSpec extends AnyFlatSpec {
  val calc:Calculator = new Calculator // make a new object of our Class so we can access all the methods within
  "add" should "add two numbers" in {
    val input = calc.add(1,2)
    val expectedResult = 3
    assert(input == expectedResult)
  }

  "multiply" should "multiply 2 Int together" in {
    val input = calc. multiply(2, 3)
    val expectedResult = 6
    assert(input == expectedResult)
  }

  "subtract" should "subtract the 2nd Int from the 1st Int" in {
    val input = calc.subtract(33, 22)
    val expectedResult = 11
    assert(input == expectedResult)
  }

  "divive" should "divide the 1st Int by the 2nd Int" in {
    val input = calc.divide(9, 3)
    val expectedResult = 3
    assert(input == expectedResult)
  }

//  "divide" should "divide the 1st Int by the 2nd Int which should not be zero " in {
//    val input = calc.divide(9, 0)
//


}
