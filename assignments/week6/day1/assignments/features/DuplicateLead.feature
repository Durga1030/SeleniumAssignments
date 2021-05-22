Feature: Duplicate an existing Lead in Leaftaps

Background:
Given Launch Chrome browser
When Load URL 'http://leaftaps.com/opentaps'
And Type username as 'DemoSalesManager'
And Type password as 'crmsfa'
And Click Login Button
Then Verify Login is successful
And Click CRM SFA Link
And Click Leads Tab

Scenario Outline: Duplicate a lead by Email Id

When Click Find Leads Menu
And Click Email Tab
And Type Email Id as <emailId>
And Click Find Leads Button
And Capture First resulting Lead Name
And Click First Matching Result
And Click Duplicate Lead Button
And Verify the title as Duplicate Lead
And Click on CreateLead Button
And Verify the Duplicated LeadName is as same as Captured LeadName
Then Close the Browser


Examples:
|emailId|
|shri123@gmail.com|
|durgatest@gmail.com|