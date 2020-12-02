#language = en
#@all
Feature: AccountCreation

  Background:
    * user is on the page "LoginPage"
    * user fills the field "User Name" with value "test.qa@cvhcare.com"
    * user fills the field "Password" with value "password"
    * user clicks the button "Log in"



  @createAccount
  Scenario: account creation
    * user is on the page "HomePage"
    * user clicks the button "Account Management"
    * breakpoint
    #todo: user don't have access to account management


