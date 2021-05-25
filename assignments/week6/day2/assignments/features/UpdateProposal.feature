Feature: Update an existing Proposal in Service Now Application

Background:
Given Launch Chrome browser
When Load URL 'https://dev103117.service-now.com'
And Switch to ParentFrame
And Type username as 'admin'
And Type password as 'India@123'
And Click Login Button
Then Verify Login is successful


Scenario Outline: Update by filling the mandatory fields

When Enter Value in FilterNavigator as <filterNav>
And Click On My Proposals Option
And Switch to ParentFrame
And Search Existing Proposal using Proposal Number as <proposalNum>
And Click on Resultant ProposalNum Hyperlink
And Update the Proposal State value as Closed using index
And Click the Category Value Lookup
And Navigate to SubWindow1
And Click on the Template Management Link
And Switch to ParentWindow
And Switch to ParentFrame
And Click on Change Request Values Tab
And Click on Assignment Group Lookup
And Navigate to SubWindow1
And Enter Assign group as 'Change Management'
And Click on Change Management Link
And Switch to ParentWindow
And Switch to ParentFrame
And Enter Justification field value as 'N/A'
And Enter Risk Impact field value as 'N/A'
And Click on Update Button for updated proposal
And Verify the updated Information of proposal <proposalNum>



Examples:
|filterNav|proposalNum|
|Proposal|STDCHG0001336|


