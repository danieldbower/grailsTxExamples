import com.infinum.txexamples.Datum
import com.infinum.txexamples.RandomService

class BootStrap {
	
	RandomService randomService
	
    def init = { servletContext ->
		if(Datum.count() == 0){
			(0..50000).each{
				if(!new Datum(randValue:randomService.generateRandom()).save()){
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
