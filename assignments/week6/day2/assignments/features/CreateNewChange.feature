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
And Click New Option for New Change
And Switch to ParentFrame
And Click Normal Change
And Create change by assigning short Desc as 'Sample Cucumber Test New Change Creation'
And Click Create Button
And Switch to Frame Default
And Click Open Option for New Change
And Switch to ParentFrame
Then Verify Creation Status




Examples:
|filterNav|
|Change|


