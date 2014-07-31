package com.infinum.txexamples

import org.apache.commons.lang.RandomStringUtils
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly=true)
class RandomService {

	private static final int randomStringLength = 16
	private static final String charset = (('a'..'z') + ('A'..'Z') + ('0'..'9')).join()
	
	String generateRandom(){
		return RandomStringUtils.random(
				randomStringLength, charset.toCharArray())
	}
}
