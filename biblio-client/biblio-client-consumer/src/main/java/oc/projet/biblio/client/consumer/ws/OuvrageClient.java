package oc.projet.biblio.client.consumer.ws;

import oc.projet.biblio.client.consumer.generated.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class OuvrageClient extends WebServiceGatewaySupport {

    public GetOuvrageResponse geOuvrageClientRequest (){
        GetOuvrageRequest ouvrageRequest = new GetOuvrageRequest();

        GetOuvrageResponse ouvrageResponse = (GetOuvrageResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", ouvrageRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetOuvrageRequest"));

        return ouvrageResponse;
    }


    public GetOuvrageByIdResponse getOuvrageByIdClientRequest(int id){
        GetOuvrageByIdRequest ouvrageByIdRequest = new GetOuvrageByIdRequest();
        ouvrageByIdRequest.setId(id);

        GetOuvrageByIdResponse ouvrageByIdResponse = (GetOuvrageByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", ouvrageByIdRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetOuvrageByIdRequest"));

        return ouvrageByIdResponse;
    }


    public GetOuvrageCreateResponse getOuvrageCreateClientRequest(String titre){
        GetOuvrageCreateRequest ouvrageCreateRequest = new GetOuvrageCreateRequest();
        ouvrageCreateRequest.setTitre(titre);

        GetOuvrageCreateResponse ouvrageCreateResponse = (GetOuvrageCreateResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", ouvrageCreateRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetOuvrageCreateRequest"));

        return ouvrageCreateResponse;
    }

    public GetOuvrageByTitreResponse getOuvrageByTitreClientRequest(String titre){
        GetOuvrageByTitreRequest ouvrageByTitreRequest = new GetOuvrageByTitreRequest();
        ouvrageByTitreRequest.setTitre(titre);

        GetOuvrageByTitreResponse ouvrageByTitreResponse = (GetOuvrageByTitreResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", ouvrageByTitreRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetOuvrageCreateRequest"));

        return ouvrageByTitreResponse;
    }

}
