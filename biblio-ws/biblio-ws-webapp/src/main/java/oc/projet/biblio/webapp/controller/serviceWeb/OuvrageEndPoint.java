package oc.projet.biblio.webapp.controller.serviceWeb;

import io.biblio.api.ouvrage_web_service.GetOuvrageResponse;
import io.biblio.api.ouvrage_web_service.OuvrageWS;
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

import java.util.ArrayList;
import java.util.List;


@Endpoint
@Transactional(propagation = Propagation.REQUIRED)
public class OuvrageEndPoint {

    private static final String NAMESPACE_URI = "http://biblio.io/api/ouvrage-web-service";

    @Autowired
    private OuvrageService ouvrageService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOuvrageRequest")
    @ResponsePayload
    public GetOuvrageResponse getUsager(){
        GetOuvrageResponse response = new GetOuvrageResponse();
        List<Ouvrage> usagers = this.ouvrageService.findAllOuvrage();
        List<OuvrageWS> ouvrageWS = new ArrayList<>();
        for (Ouvrage ouvrage : usagers){
            OuvrageWS ouvragews = new OuvrageWS();
            BeanUtils.copyProperties(ouvrage, ouvragews);
            ouvrageWS.add(ouvragews);
        }
        response.getOuvrageWS().addAll(ouvrageWS);

        return response;
    }

}
