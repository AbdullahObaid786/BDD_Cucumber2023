@NegativeLoginFeature @Regression
Feature: Techfios billing Negative login page functionality validation

Background:
Given User is on the techfios login page

@NegativeLoginScenario1 @Sanity
Scenario Outline: User should not be able to login with invalid credentials
When User enters username as "<username>"
When User enters password as "<password>"
When User clicks on signin button
Then User should be land on dashboard page
Examples: 
|username						|password|
|demo2@techfios.com	|abc123|
|demo@techfios.com	|abc124|
|demo2@techfios.com	|abc1245|
|										|				|

#@NegativeLoginScenario2 @Smoke
#Scenario: User should not be able to login with invalid credentials 
#When User enters username as "demo@techfios.com"
#When User enters password as "abc124"
#When User clicks on signin button
#Then User should be land on dashboard page
#
#@NegativeLoginScenario3 @Smoke
#Scenario: User should not be able to login with invalid credentials 
#When User enters username as "demo2@techfios.com"
#When User enters password as "abc1245"
#When User clicks on signin button
#Then User should be land on dashboard page
#
#@NegativeLoginScenario4
#Scenario: User should not be able to login with invalid credentials 
#When User enters username as ""
#When User enters password as ""
#When User clicks on signin button
#Then User should be land on dashboard page