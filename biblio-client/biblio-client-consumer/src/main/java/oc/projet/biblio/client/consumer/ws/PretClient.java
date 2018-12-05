package oc.projet.biblio.client.consumer.ws;

import oc.projet.biblio.client.consumer.generated.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.time.LocalDate;

public class PretClient extends WebServiceGatewaySupport{

    public GetExemplaireResponse getExemplaireClientResponse(){
        GetExemplaireRequest exemplaireRequest = new GetExemplaireRequest();

        GetExemplaireResponse exemplaireResponse = (GetExemplaireResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", exemplaireRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetExemplaireRequest"));

        return exemplaireResponse;
    }

    public GetExemplaireByIdResponse getExemplaireByIdClientRequest(int id){
        GetExemplaireByIdRequest exemplaireByIdRequest = new GetExemplaireByIdRequest();
        exemplaireByIdRequest.setId(id);

        GetExemplaireByIdResponse exemplaireByIdResponse = (GetExemplaireByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", exemplaireByIdRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetExemplaireRequest"));
        return exemplaireByIdResponse;
    }

    public GetPretCreateResponse getPretCreateClientRequest (UsagerWS usagerWS, ExemplaireWS exemplaireWS, LocalDate datePret, LocalDate dateFin){
        GetPretCreateRequest pretCreateRequest = new GetPretCreateRequest();
        pretCreateRequest.setUsager(usagerWS);
        pretCreateRequest.setExemplaire(exemplaireWS);
        pretCreateRequest.setDatePret(datePret);
        pretCreateRequest.setDateFin(dateFin);

        GetPretCreateResponse pretCreateResponse = (GetPretCreateResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", pretCreateRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetExemplaireRequest"));
        return pretCreateResponse;
    }

    public GetPretByExemplaireResponse getPretByExemplaireClientRequest (ExemplaireWS exemplaireWS){
        GetPretByExemplaireRequest exemplaireRequest = new GetPretByExemplaireRequest();
        exemplaireRequest.setExemplaire(exemplaireWS);

        GetPretByExemplaireResponse exemplaireResponse = (GetPretByExemplaireResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", exemplaireRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetExemplaireRequest"));
        return exemplaireResponse;
    }

    public GetPretByUsagerResponse getPretByUsagerClientRequest(UsagerWS usagerWS){
        GetPretByUsagerRequest pretByUsagerRequest = new GetPretByUsagerRequest();
        pretByUsagerRequest.setUsager(usagerWS);

        GetPretByUsagerResponse pretByUsagerResponse = (GetPretByUsagerResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/soapws/bibliosoap", pretByUsagerRequest,
                        new SoapActionCallback(
                                "http://biblio.io/api/biblio-web-service/GetExemplaireRequest"));
        return pretByUsagerResponse;
    }

}
