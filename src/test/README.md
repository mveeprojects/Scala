# Scala Testing

### ScalaTest testing styles (my favourites):

Source: http://www.scalatest.org/user_guide/selecting_a_style

__FunSuite - xUnit testing__
``` 
class SomeSpec extends FunSuite {
  test("test name goes here") { 
    test code goes here 
  }
}
```

__FunSpec - BDD testing__
```
class SomeSpec extends FunSpec {               
 describe("A Stack") {
   it("should pop values in last-in-first-out order") (pending)
   it("should throw NoSuchElementException if an empty stack is popped") (pending)
 }
}
```

__FeatureSpec - BDD testing similar to Cucumber (Given, When, Then)__
```
class SomeSpec extends FeatureSpec with GivenWhenThen {

  feature("feature name goes here") {
  
    scenario("scenario name goes here") {
      Given("Some things are in place ready to be used")
      test code setting stuff up goes here
    
      When("Something happens")
      method calls go here
    
      Then("The result should be this")
      assertions go here
    }
  }
}
```