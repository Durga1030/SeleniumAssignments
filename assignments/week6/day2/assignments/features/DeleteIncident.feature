Feature: Create New Incident in Service Now Application

Background:
Given Launch Chrome browser
When Load URL 'https://dev103117.service-now.com'
And Switch to ParentFrame
And Type username as 'admin'
And Type password as 'India@123'
And Click Login Button
Then Verify Login is successful


Scenario Outline: Create new incident by filling the mandatory fields

When Enter Value in FilterNavigator as <filterNav> 
When Click Open Option
And Switch to ParentFrame
And Assign Incident Number as <incNum>
And Print and click the resultant number  
And Delete the Incident
Then Verify the Deleted Incident as <incNum>




Examples:
|filterNav|incNum|
|Incident|INC0011413|


