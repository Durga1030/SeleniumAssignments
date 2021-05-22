Feature: Merge two existing Leads in Leaftaps

Background:
Given Launch Chrome browser
When Load URL 'http://leaftaps.com/opentaps'
And Type username as 'DemoSalesManager'
And Type password as 'crmsfa'
And Click Login Button
Then Verify Login is successful
And Click CRM SFA Link
And Click Leads Tab

Scenario Outline: Merge two Leads using Name

When Click on Merge Leads
And Assign FromLead Value using Lookup
And Window Handling to FromLead SubWindow
And Assign firstName in FindLead Popup as <fName1>
And Click Find Leads Button
And Click First Matching Result
And Window Handling to ParentWindow
And Get the IdNum of the Selected FromLead
And Assign ToLead Value using Lookup
And Window Handling to ToLead SubWindow
And Assign firstName in ToLead Popup as <fName2>
And Click Find Leads Button
And Click First Matching Result
And Window Handling to ParentWindow
And Get the IdNum of the Selected ToLead
And Click on Merge Button
And Handle Alerts for Merge Step
And Click Find Leads Menu
And Verify the Merge Result
Then Close the Browser


Examples:
|fName1|fName2|
|Durga|Shri|