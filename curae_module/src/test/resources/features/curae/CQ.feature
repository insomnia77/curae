#language = en
Feature: CQ


  Background:
    * user is on the page "LoginPage"
    * user fills the field "User Name" with value "test.qa@cvhcare.com"
    * user fills the field "Password" with value "password"
    * user clicks the button "Log in"

  @cq
  Scenario Outline: patients
    * user is on the page "HomePage"
    * user clicks the button "Compliance & Quality"
   # * breakpoint
    * user is on the page "ComplianceAndQualityPage"
    * user clicks the button "Follow Ups"
    * user is on the page "FollowUpsPage"
    * user (search patient) "<searchValue>"
    * user is on the page "FollowUpsPage"
    * user clicks the button "first patient in list"

    Examples:
      | searchValue      |
      | 555729337A |
      | 620766715A |

    #todo: add patient with code a5a3c404b6a6a3c8
      | a5a3c404b6a6a3c8 |

