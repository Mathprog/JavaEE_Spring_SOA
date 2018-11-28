package oc.projet.biblio.client.consumer.ws;

import oc.projet.biblio.client.consumer.generated.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UsagerClient extends WebServiceGatewaySupport {

    public GetUsagerResponse getUsagerClientRequest(){
        GetUsagerRequest usagerRequest = new GetUsagerRequest();
        GetUsagerResponse responseUsager = (GetUsagerResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", usagerRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetUsagerRequest"));

        return responseUsager;
    }

    public GetUsagerByEmailResponse getUsagerByEmailClientRequest(String email){
        GetUsagerByEmailRequest usagerRequest = new GetUsagerByEmailRequest();
        usagerRequest.setEmail(email);
        GetUsagerByEmailResponse usagerByEmailResponse = (GetUsagerByEmailResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", usagerRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetUsagerByEmailRequest"));

        return usagerByEmailResponse;
    }

    public GetUsagerCreateResponse getUsagerCreateClientRequest(String email){
        GetUsagerCreateRequest usagerRequest = new GetUsagerCreateRequest();
        usagerRequest.setEmail(email);

        GetUsagerCreateResponse getUsagerCreateResponse = (GetUsagerCreateResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", usagerRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetUsagerCreateRequest"));

        return getUsagerCreateResponse;

    }

    public GetUsagerByIdResponse getUsagerByIdClientRequest(int id){
        GetUsagerByIdRequest usagerByIdRequest = new GetUsagerByIdRequest();
        usagerByIdRequest.setId(id);

        GetUsagerByIdResponse usagerByIdResponse = (GetUsagerByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", usagerByIdRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetUsagerByIdRequest"));

        return usagerByIdResponse;
    }

}
