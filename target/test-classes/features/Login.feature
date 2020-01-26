Feature: Application Login

@WebTest
Scenario Outline: Validating login
Given Initialize browser with chrome
And Navigate to "http://www.qaclickacademy.com/" site
When Click on Login link in home page to land on sign in page
When User enters <Username> and <Password>
Then Verify user logged in succesfully
And Close the browser

Examples:
|Username                     |Password     |
|chandrababuthummala@gmail.com|MrNobody@2009|




	
