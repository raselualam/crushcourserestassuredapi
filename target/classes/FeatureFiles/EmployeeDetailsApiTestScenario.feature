@apiTesting @regression
Feature: App user should able to create, update, get and delete employee record through API

Scenario: Upskill multiple employee records

	Given Create new employee record in database
	When Get all employee data
	Then Get a single employee data by id