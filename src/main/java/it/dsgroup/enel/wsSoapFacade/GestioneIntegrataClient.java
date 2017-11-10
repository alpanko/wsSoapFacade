package it.dsgroup.enel.wsSoapFacade;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import it.dsgroup.enel.ws.GestisciFunzione;
import it.dsgroup.enel.ws.GestisciFunzioneResponse;


public class GestioneIntegrataClient extends WebServiceGatewaySupport{
	
	private static final Logger logger = Logger.getLogger(GestioneIntegrataClient.class);
	@Autowired
	private Environment env;
	
	
	public String sayHello(String operazione, String id_funzione, String descr_funzione, String id_funzione_old) throws Exception{
		
		logger.info("Nel metodo say hello");
		String ret ="";
		try {
			GestisciFunzione request = new GestisciFunzione();
			request.setOperazione(operazione);
			request.setIdFunzione(id_funzione);
			request.setDescrFunzione(descr_funzione);
			request.setIdFunzioneOld(id_funzione_old);


					GestisciFunzioneResponse response = (GestisciFunzioneResponse) getWebServiceTemplate()
					.marshalSendAndReceive("http://localhost:8282/WebServiceProject/services/GestioneIntegrataSoap",
							request,
							new SoapActionCallback("http://localhost:8282/WebServiceProject/services/GestioneIntegrataSoap/GestisciFunzione"));
					logger.info("Fine chiamata al service response :"+response.getGestisciFunzioneResult());
					ret = response.getGestisciFunzioneResult();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw e;
		}
		
		
				
	    return ret;
	  }

}
