Feature: Delete existing Leads in Leaftaps

Background:
Given Launch Chrome browser
When Load URL 'http://leaftaps.com/opentaps'
And Type username as 'DemoSalesManager'
And Type password as 'crmsfa'
And Click Login Button
Then Verify Login is successful
And Click CRM SFA Link
And Click Leads Tab

Scenario Outline: Delete existing Lead using Phone Number

When Click Find Leads Menu
And Click on Phone Tab
And Assign Phone Numer as <phNum>
And Click Find Leads Button
And Capture lead ID of First Matching lead 
And Click First Matching Result
And Click Delete Button
And Click Find Leads Menu
And Enter the Captured LeadId
And Click Find Leads Button
And Verify the Delete Status
Then Close the Browser

Examples:
|phNum|
|498|
|99|

