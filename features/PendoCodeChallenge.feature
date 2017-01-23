#Author: sidrmarti@gmail.com

#@tag
Feature: Pendo Automation Code Challenge

Scenario: Save product to short list with a note 
Given Open chrome browser and navigate to google
	And Search for hacky sack
When On results page click shopping and choose fourth result
	Then Save to short list and add note


