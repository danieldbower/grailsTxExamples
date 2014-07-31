package com.infinum.txexamples

import groovyx.gpars.GParsPool

class DeadlockExampleService {

	RandomService randomService
	
	void createDeadlockExample(){
		
		GParsPool.withPool {
			Datum.list().each{
				it.randValue = randomService.generateRandom()
				if(!it.save()){
					log.error("Failed to save Datum")
				}
			}
		}
		
		Datum.list().each{
			println(it.randValue)
		}
	}
}
