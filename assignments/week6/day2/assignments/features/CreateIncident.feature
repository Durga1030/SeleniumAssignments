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
And Click New Option
And Switch to ParentFrame
And Get Incident Number
And Click on Lookup option to get CallerInfo
And Navigate to SubWindow1
And Search and Get User as <searchUser>
And Switch to ParentWindow
And Switch to ParentFrame
And Assign ShortDescription as 'Sample test cucumber - New Incident Creation'
And Click on Submit Button
Then Verify the Created Incident




Examples:
|filterNav|searchUser|
|Incident|System|


