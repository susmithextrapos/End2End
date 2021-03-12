Feature: Login into Application

Scenario Outline: Positive test validation Login
Given Initialize the browser with chrome
And Navigate to "http://qaclickacademy.com" site
And Click on Login link in home page to land on Secure sign in page
When User enters <username> and <password> and log in
Then verify that the user is successfully loged in


Examples:
|username				|password		|
|test99@gmail.com		|123456			|
|mailtosusmith@gmail.con|chuchu143		|
