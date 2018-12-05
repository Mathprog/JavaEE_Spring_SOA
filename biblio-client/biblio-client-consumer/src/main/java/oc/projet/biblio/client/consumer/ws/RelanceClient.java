package oc.projet.biblio.client.consumer.ws;

import oc.projet.biblio.client.consumer.generated.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.time.LocalDate;

public class RelanceClient extends WebServiceGatewaySupport {

    public GetRelanceResponse getRelanceClientResponse(){
        GetRelanceRequest relanceRequest = new GetRelanceRequest();

        GetRelanceResponse relanceResponse = (GetRelanceResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", relanceRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetExemplaireRequest"));

        return relanceResponse;
    }

    public GetRelanceByIdResponse getRelanceByIdClientRequest (int id){
        GetRelanceByIdRequest relanceByIdRequest = new GetRelanceByIdRequest();
        relanceByIdRequest.setId(id);

        GetRelanceByIdResponse relanceByIdResponse = (GetRelanceByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", relanceByIdRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetExemplaireRequest"));

        return relanceByIdResponse;
    }

    public GetRelanceCreateResponse getRelanceCreateClientRequest (PretWS pretWS, LocalDate datFin){
        GetRelanceCreateRequest relanceCreateRequest = new GetRelanceCreateRequest();
        relanceCreateRequest.setPret(pretWS);
        relanceCreateRequest.setDateFin(datFin);

        GetRelanceCreateResponse relanceCreateResponse = (GetRelanceCreateResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", relanceCreateRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetExemplaireRequest"));

        return relanceCreateResponse;
    }

    public GetRelanceByUsagerResponse relanceByUsagerClientRequest (UsagerWS usagerWS){
        GetRelanceByUsagerRequest relanceByUsagerRequest = new GetRelanceByUsagerRequest();
        relanceByUsagerRequest.setUsager(usagerWS);

        GetRelanceByUsagerResponse relanceByUsagerResponse = (GetRelanceByUsagerResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", relanceByUsagerRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetExemplaireRequest"));

        return relanceByUsagerResponse;
    }
}
