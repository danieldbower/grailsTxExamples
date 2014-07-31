package com.infinum.txexamples

import grails.converters.JSON

class DeadlockExampleController {

	DeadlockExampleService deadlockExampleService
	
	def index(){
		deadlockExampleService.createDeadlockExample()
		
		render("Value") as JSON
	}
}
