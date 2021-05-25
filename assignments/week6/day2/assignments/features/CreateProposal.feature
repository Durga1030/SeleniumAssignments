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
And Switch to ParentFrame
And Click New Option for New Proposal
And Get Proposal Number
And Assign Template Description as 'Sample Cucumber Test New Proposal Creation'
And Click on Mandatory Field Change Request Values tab
And Assign Short Description as 'Cucumber Test New Proposal Creation'
And Click Submit Button
Then Verify Creation Status




Examples:
|filterNav|
|Proposal|


