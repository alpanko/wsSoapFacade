package it.dsgroup.enel.wsSoapFacade;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class soapWsFacadeController {
	
	private static final Logger logger = Logger.getLogger(soapWsFacadeController.class);
	
	@Autowired
	GestioneIntegrataClient gestioneIntegrataClient;
	

 

	@RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
		logger.info("Welcome page, non-rest");
        return "Welcome to RestTemplate Example.";
    }
 
    @RequestMapping("/gestisciFunzione/{operazione}/{id_funzione}/{descr_funzione}/{id_funzione_old}")
    public String gestisciFunzionePathVariable(@PathVariable String operazione ,
										    		@PathVariable String id_funzione,
										    		@PathVariable String descr_funzione,
										    		@PathVariable String id_funzione_old) throws Exception {//REST Endpoint.
    	logger.info("/gestisciFunzione/{operazione}/{id_funzione}/{descr_funzione}/{id_funzione_old}");
    	logger.info("Param list");
    	logger.info("operazione :"+operazione);
    	logger.info("id_funzione :"+id_funzione);
    	logger.info("descr_funzione :"+descr_funzione);
    	logger.info("id_funzione_old :"+id_funzione_old);
        return gestioneIntegrataClient.sayHello(operazione, id_funzione, descr_funzione, id_funzione_old);
    }
    
    
    @RequestMapping("/gestisciFunzione")
    public String gestisciFunzionePathVariableRequestParam(@RequestParam(value="operazione", required=true) String operazione,
    									@RequestParam(value="id_funzione", required=true) String id_funzione,
							    		@RequestParam(value="descr_funzione", required=true) String descr_funzione,
							    		@RequestParam(value="id_funzione_old", required=true) String id_funzione_old) throws Exception {//REST Endpoint.
    	logger.info("/gestisciFunzionerequestparam");
    	
    	logger.info("Param list");
    	logger.info("operazione :"+operazione);
    	logger.info("id_funzione :"+id_funzione);
    	logger.info("descr_funzione :"+descr_funzione);
    	logger.info("id_funzione_old :"+id_funzione_old);
    	return gestioneIntegrataClient.sayHello(operazione, id_funzione, descr_funzione, id_funzione_old);
    }
}