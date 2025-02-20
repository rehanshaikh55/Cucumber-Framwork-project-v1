Feature: add Admin

Scenario: add New Admin
    Given User Launch Chrome browser
		When user opens url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
		And user enters username as "Admin" and password as "admin123"
		And click on Login
		Then click on Admin Section in Dashboard
		Then Click on Add Button
		And add user details in from 
		Then Click on save
		And checking success message
		Then close browser