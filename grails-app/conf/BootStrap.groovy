import org.apache.commons.lang.RandomStringUtils

import com.infinum.txexamples.Datum

class BootStrap {
	private static final int randomStringLength = 16
	private static final String charset = (('a'..'z') + ('A'..'Z') + ('0'..'9')).join()
	
    def init = { servletContext ->
		if(Datum.count() == 0){
			(0..50000).each{
				String randomString = RandomStringUtils.random(randomStringLength, charset.toCharArray())
				if(!new Datum(randValue:randomString).save()){
					log.error("Failed to save Datum")
				}
				
				if((it%1000) == 0){
					log.info "Inserted Datum $it"
				}
			}
		}
    }
    def destroy = {
    }
}
