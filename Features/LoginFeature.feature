Feature: Login

Scenario: Successful Login with valid credentials
		Given User Launch Chrome browser
		When user opens url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
		And user enters username as "Admin" and password as "admin123"
		And click on Login
		Then page title should be "OrangeHRm"
		When user click on profile
		And Click on Logout
		Then close browser
		
Scenario: Login with In-valid credentials
		Given User Launch Chrome browser
		When user opens url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
		And user enters username as "Admin123" and password as "admin123"
		And click on Login
		Then "Invalid credentials" Error message should popup
		And close browser