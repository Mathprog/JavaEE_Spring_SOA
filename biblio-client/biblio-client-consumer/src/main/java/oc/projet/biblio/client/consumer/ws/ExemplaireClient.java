package oc.projet.biblio.client.consumer.ws;

import oc.projet.biblio.client.consumer.generated.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class ExemplaireClient extends WebServiceGatewaySupport {


    public GetExemplaireResponse getExemplaireClientRequest(){
        GetExemplaireRequest exemplaireRequest = new GetExemplaireRequest();

        GetExemplaireResponse exemplaireResponse = (GetExemplaireResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", exemplaireRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetExemplaireRequest"));
        return exemplaireResponse;
    }

    public GetExemplaireByIdResponse getExemplaireByIdCLientRequest(int id){
        GetExemplaireByIdRequest exemplaireByIdRequest = new GetExemplaireByIdRequest();
        exemplaireByIdRequest.setId(id);

        GetExemplaireByIdResponse  exemplaireByIdResponse = (GetExemplaireByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", exemplaireByIdRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetExemplaireRequest"));

        return exemplaireByIdResponse;
    }

    public GetExemplaireByBookResponse getExemplaireByBookCLientRequest(OuvrageWS ouvrageWS){
        GetExemplaireByBookRequest exemplaireByBookRequest = new GetExemplaireByBookRequest();
        exemplaireByBookRequest.setBook(ouvrageWS);

        GetExemplaireByBookResponse getExemplaireByBookResponse = (GetExemplaireByBookResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", exemplaireByBookRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetExemplaireRequest"));

        return getExemplaireByBookResponse;
    }

    public GetExemplaireCreateResponse getExemplaireCreateClientRequest (OuvrageWS ouvrageWS){
        GetExemplaireCreateRequest getExemplaireCreateRequest = new GetExemplaireCreateRequest();
        getExemplaireCreateRequest.setOuvrage(ouvrageWS);

        GetExemplaireCreateResponse getExemplaireCreateResponse = (GetExemplaireCreateResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", getExemplaireCreateRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetExemplaireRequest"));

        return getExemplaireCreateResponse;
    }
}
