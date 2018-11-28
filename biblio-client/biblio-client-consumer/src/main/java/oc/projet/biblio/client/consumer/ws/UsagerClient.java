package oc.projet.biblio.client.consumer.ws;

import oc.projet.biblio.client.consumer.generated.GetUsagerRequest;
import oc.projet.biblio.client.consumer.generated.GetUsagerResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UsagerClient extends WebServiceGatewaySupport {

    public GetUsagerResponse getUsagerClientRequest(){
        GetUsagerRequest requestUsager = new GetUsagerRequest();
        GetUsagerResponse responseUsager = (GetUsagerResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", requestUsager,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-serviceGetCountryRequest/GetUsagerRequests"));

        return responseUsager;
    }

    
}
