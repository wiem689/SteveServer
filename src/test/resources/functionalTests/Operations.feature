Feature: Automed Operrations 
As a user, I should make some operations 
	Description: Automation test project 
	
	

  Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
 Then the user is connected
     
 
     Scenario: Operations when charge point selected and Connector ID =0 and availability = OPERATIVE   
	
  And I click on operations V1.6 button
  And I select charge point 'wiem'
  And I click all charge point 
  And I select connecter ID '0'
  And I select availability Type 'OPERATIVE'
  And I click perform button
  Then User is on the task result
 
 Scenario: Operations when charge point selected and Connector ID =1 and availability = OPERATIVE  
	
  And I click on operations V1.6 button
  And I select charge point 'wiem'
  And I click all charge point 
  And I select connecter ID '1'
  And I select availability Type 'OPERATIVE'
  And I click perform button
  Then User is on the task result
 
    
 Scenario: Operations When charge point selected and Connector ID =2 and availability = INOPERATIVE  
	
  And I click on operations V1.6 button
  And I select charge point 'wiem'
  And I select connecter ID '2'
  And I select availability Type 'INOPERATIVE'
  And I click perform button
  Then User is on the task result
  
  
  Scenario: Operations When charge point selected and Connector ID =3 and availability = OPERATIVE  
	
  And I click on operations V1.6 button
  And I select charge point 'wiem'
  And I click all charge point 
  And I select connecter ID '3'
  And I select availability Type 'OPERATIVE'
  And I click perform button
  Then User is on the task result
  
  
  
  Scenario: Operations When charge point selected and Connector ID =empty and availability = OPERATIVE  
	
  And I click on operations V1.6 button
  And I select charge point 'wiem'
  And I click all charge point 
  And I select connecter ID ''
  And I select availability Type 'OPERATIVE'
  And I click perform button
  Then User is on the task result
  
  
  
   Scenario:  Operations When charge point not selected and Connector ID =2 and availability = OPERATIVE
	
  And I click on operations V1.6 button
  And I select connecter ID '2'
  And I select availability Type 'OPERATIVE'
  And I click perform button
  Then User is on the task result
  
  
  Scenario: Operations When charge point selected and Connector ID =1 and availability = OPERATIVE and finally deselected before running  

  And I click on operations V1.6 button
  And I select charge point 'wiem'
  And I click all charge point 
  And I select connecter ID '1'
  And I select availability Type 'OPERATIVE'
  And I click none charge point
  And I click perform button
  Then User is on the task result
  
  
  Scenario: Configuration charge  when Key = HeartbeatInterval

  And I click on operations V1.6 button
  And I click change configuration
  And I select charge point 'wiem'
  And I click all charge point 
  And I select Key Type 'Predefined'
  And I select Configuration Key 'HeartbeatInterval'
  And I enter Value '1'
  And I click perform button
  Then User is on the task result
    
 
  Scenario: Configuration charge  when Key = Custom   
    
  And I click on operations V1.6 button
  And I click change configuration
  And I select charge point 'wiem'
  And I click all charge point 
  And I select Key Type 'Custom'
  And I enter Custom Configuration Key '2'
  And I enter Value '1'
  And I click perform button
  Then User is on the task result
    
    
  Scenario: Operations to Get Diagnostics 

   
  And I click on operations V1.6 button
    And I click get Diagnostics
    And I select charge point 'wiem'
    And I click all charge point 
    And I enter Location '1'
    And I enter Retries '2'
    And I enter Retry Interval  '9'
    And I enter Start Date '2022-07-25 00:00'
    And I enter Stop Date '2022-07-31 00:00'
    And I click diagnostics perform button
    Then User is on the task result
    
    
    
    
    

 Scenario: Operations to Get remote start transaction 
    
  And I click on operations V1.6 button
    And I click get remote start transaction
    And I select charge point 'wiem'
    And I select ConnectorId2 '1'
    And I select OCPP ID Tag'9c756eda'
    And I click perform button
    Then User is on the task result
    
  
   Scenario: Operations to Get remote stop transaction 
   
  And I click on operations V1.6 button
    And I click get remote stop transaction
    And I select charge point 'wiem'
    And I click perform button
    Then User is on the task result
    
    
    
    
    
    Scenario: Reset when user in SOFT reset  
  
  And I click on operations V1.6 button
    And I click get remote reset
    And I select charge point 'wiem'
    And I click all charge point 
    And I select Reset Type'SOFT'
    And I click perform button
    Then User is on the task result
    
    
  Scenario: Reset when user in HARD reset  
  
  And I click on operations V1.6 button
    And I click get remote reset
    And I select charge point 'wiem'
    And I click all charge point 
    And I select Reset Type'HARD'
    And I click perform button
    Then User is on the task result
    
    
    
    
    
    
    Scenario: Unlock Connector When user make Unlock Connector with id=1
     
  And I click on operations V1.6 button
    And I click get Unlock Connector
    And I select charge point 'wiem' 
    And I select ConnectorId2 '1'
    And I click perform button
    Then User is on the task result
  
  
  Scenario: Unlock Connector When user make Unlock Connector with id=2
     
  And I click on operations V1.6 button
    And I click get Unlock Connector
    And I select charge point 'wiem' 
    And I select ConnectorId2 '2'
    And I click perform button
    Then User is on the task result
    
    
  Scenario: Operations when user in update firmware 
  
  And I click on operations V1.6 button
  And I click get Update Firmware
  And I select charge point 'wiem' 
  And I enter Location '1'
  And I enter Retries '2'
  And I enter Retry Interval  '3'
  And I enter Retrieve Date '2022-11-30 00:00'
  And I click perform button Update Firmware
  Then User is on the task result  
    
    
    
    
    
 Scenario: Operations when User Reserve Charge Point 
  
  And I click on operations V1.6 button
  And I click reservation now
  And I select charge point 'wiem'
  And I select ConnectorId2 '1'
  And I enter expiry Date '2022-10-30 00:00'
  And I select OCPP ID Tag'9c756eda'
  And I click perform reservation button
  Then User is on the task result
   
   
 
   Scenario: Operations when User Cancel Reservation Charge Point 

    
  And I click on operations V1.6 button
    And I click cancel reservation
    And I select charge point 'wiem'
    And I select Existing Reservation ''
    And I click perform button
    Then User is on the task result   
    
    
    
    
    
    Scenario: Operations data transfer 
    And I click on operations V1.6 button
    And I click data transfer
    And I select charge point 'wiem'
    And I click all charge point 
    And I Enter Vendor ID '1'
    And I Enter Message ID '2'
    And I Enter Data '3'
    And I click perform button
    Then User is on the task result
    
    
    
    
    Scenario: Operations when User In Get Configuration  
    And I click on operations V1.6 button
    And I click get configuration
    And I select charge point 'wiem'
    And I click all charge point 
    And I select parameters 'SupportedFeatureProfiles'
    And I click all parameters
    And I Enter Custom Config Key '1'
    And I click perform button
    Then User is on the task result 
    
    
     Scenario: Operations when User  Get Local List  
    And I click on operations V1.6 button
  And I click get Local List Version
  And I select charge point 'wiem'
    And I click all charge point 
    And I click perform button
    Then User is on the task result 
    
    
    
    
    Scenario: Operations when User send local list   
    And I click on operations V1.6 button
    And I click set Local List Version
    And I select charge point 'wiem'
    And I click all charge point 
    And I Enter List Version '2'
    And I select Get Update Type'FULL'
    And I click send empty list
    And I click perform button
    Then User is on the task result
    
   Scenario: Operations When User Put Trigger Message   
    And I click on operations V1.6 button
    And I click Get Trigger Message
    And I select charge point 'wiem'
    And I click all charge point 
    And I select Trigger Message 'BootNotification'
    And I select connecter ID '1'
    And I click perform button
    Then User is on the task result 
    
    
    
    
    Scenario: Operations When User Get Composite Schedule
    And I click on operations V1.6 button
    And I click Get Composite Schedule
    And I select charge point 'wiem'
    And I click all charge point 
    And I select connecter ID '1'
    And I Enter Composite Schedule '2'
    And I select Charging Rate Unit 'W'
    And I click perform button
    Then User is on the task result    
   
    
  
  
  
  
    
  
 
    
      