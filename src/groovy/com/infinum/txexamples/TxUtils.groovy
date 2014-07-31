package com.infinum.txexamples

import org.springframework.transaction.TransactionStatus
import org.springframework.transaction.interceptor.TransactionAspectSupport
import org.springframework.transaction.support.TransactionSynchronizationManager

class TxUtils {

	static boolean isTxActive(){
		TransactionSynchronizationManager.isSynchronizationActive()
	}

	static TransactionStatus currentTxStatus(){
		if(!isTxActive()){
			return null
		}

		TransactionAspectSupport.currentTransactionStatus()
	}
	
}
