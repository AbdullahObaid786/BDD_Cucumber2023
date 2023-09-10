@DatabaseLoginFeature @Regression
Feature: Techfios billing login page functionality validation

@DbLoginScenario1 
Scenario: User should be able to login with valid credentials 
Given User is on the techfios login page
When User enters "username" from MYSQL database
When User enters "password" from MYSQL database
When User clicks on signin button
Then User should be land on dashboard page
