

Feature: Automed Operrations 
As a user, I should make some operations 
	Description: Automation test project 
	
	

  Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
 Then the user is connected
 
 
 
     Scenario: Operations when charge point selected and Connector ID =1 and availability = OPERATIVE  and initial_state= 0
     And I click on data management charge points button
	   And I select 'wiem' 
     And I click on operations V1.6 button
     And I select charge point 'wiem'
     And I click all charge point 
     And I select connecter ID '1'
     And I select availability Type 'OPERATIVE'
     And I click perform button change availability with Initial State 0
     Then User is on the task result

#Scenario: Operations when charge point selected and Connector ID =1 and availability = OPERATIVE  and initial_state= 1 
  #And I click perform button change availability with Initial State 1
  #Then User is on the task result