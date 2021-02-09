package com.mark.acceptance

import cucumber.api.PendingException
import cucumber.api.scala.{EN, ScalaDsl}

class StepDefs extends ScalaDsl with EN {

  Given("""^my calculator is running$""") { () =>
    //// Write code here that turns the phrase above into concrete actions
    throw new PendingException()
  }

  When("""^I add (\d+) and (\d+)$""") { (arg0: Int, arg1: Int) =>
    //// Write code here that turns the phrase above into concrete actions
    throw new PendingException()
  }

  When("""^I subtract (\d+) and (\d+)$""") { (arg0: Int, arg1: Int) =>
    //// Write code here that turns the phrase above into concrete actions
    throw new PendingException()
  }

  Then("""^result should be equal to (\d+)$""") { (arg0: Int) =>
    //// Write code here that turns the phrase above into concrete actions
    throw new PendingException()
  }
}
