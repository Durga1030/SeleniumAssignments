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
And Click Open Option for New Change
And Switch to ParentFrame
And Search Exiting Change using Change Number as <chNum>
And Click on Resultant Number Hyperlink
And Update the State value as Assess using index
And Click the Assignment Group Lookup
And Navigate to SubWindow1
And Click on Software dropdown option
And Click the value of Assignment Group 
And Switch to ParentWindow
And Switch to ParentFrame
And Click the Assigned To Lookup
And Navigate to SubWindow1
And Enter AssignedTo value as 'ITIL'
And Click on the ITILUser Link
And Switch to ParentWindow
And Switch to ParentFrame
And Click on Update Button
And Verify the updated Information for updated change request <chNum>



Examples:
|filterNav|chNum|
|Change|CHG0031061|


