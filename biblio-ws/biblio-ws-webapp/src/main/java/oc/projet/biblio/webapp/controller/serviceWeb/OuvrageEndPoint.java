package oc.projet.biblio.webapp.controller.serviceWeb;

import io.biblio.api.biblio_web_service.*;
import oc.projet.biblio.business.service.OuvrageService;
import oc.projet.biblio.model.entity.Ouvrage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.*;


@Endpoint
@Transactional(propagation = Propagation.REQUIRED)
public class OuvrageEndPoint {

    private static final String NAMESPACE_URI = "http://biblio.io/api/biblio-web-service";

    @Autowired
    private OuvrageService ouvrageService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOuvrageRequest")
    @ResponsePayload
    public GetOuvrageResponse getOuvrage(){
        GetOuvrageResponse OuvrageResponse = new GetOuvrageResponse();
        List<Ouvrage> usagers = this.ouvrageService.findAllOuvrage();
        List<OuvrageWS> ouvrageWS = new ArrayList<>();
        for (Ouvrage ouvrage : usagers){
            OuvrageWS ouvragews = new OuvrageWS();
            BeanUtils.copyProperties(ouvrage, ouvragews);
            ouvrageWS.add(ouvragews);
        }
        OuvrageResponse.getOuvrageWS().addAll(ouvrageWS);

        return OuvrageResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOuvrageByIdRequest")
    @ResponsePayload
    public GetOuvrageByIdResponse getOuvrageById(@RequestPayload GetOuvrageByIdRequest request) {
        GetOuvrageByIdResponse ouvrageResponseWS = new GetOuvrageByIdResponse();
        Ouvrage ouvrage = this.ouvrageService.find(request.getId());
        OuvrageWS ouvrageWS  = new OuvrageWS();
        BeanUtils.copyProperties(ouvrage, ouvrageWS);
        ouvrageResponseWS.setOuvrageWS(ouvrageWS);
        return ouvrageResponseWS;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOuvrageCreateRequest")
    @ResponsePayload
    public GetOuvrageCreateResponse getOuvrageCreate(@RequestPayload GetOuvrageCreateRequest request){
        GetOuvrageCreateResponse ouvrageResponse = new GetOuvrageCreateResponse();
        Ouvrage ouvrage = this.ouvrageService.createOuvrate(request.getTitre());
        OuvrageWS ouvrageWS = new OuvrageWS();
        BeanUtils.copyProperties(ouvrage, ouvrageWS);
        ouvrageResponse.setOuvrageWS(ouvrageWS);
        return ouvrageResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOuvrageByTitreRequest")
    @ResponsePayload
    public GetOuvrageByTitreResponse getOuvrageByTitre (@RequestPayload GetOuvrageByTitreRequest request){
        GetOuvrageByTitreResponse ouvrageResponse = new GetOuvrageByTitreResponse();
        List<Ouvrage> ouvrages = this.ouvrageService.findAllByTitreResearch(request.getTitre());
        List<OuvrageWS> ouvrageWSList = new ArrayList<>();
        for (Ouvrage ouvrage : ouvrages){
            OuvrageWS ouvrageWSLocal = new OuvrageWS();
            BeanUtils.copyProperties(ouvrage, ouvrageWSLocal);
            ouvrageWSList.add(ouvrageWSLocal);
        }
        ouvrageResponse.getOuvrageWS().addAll(ouvrageWSList);
        return ouvrageResponse;
    }

}
