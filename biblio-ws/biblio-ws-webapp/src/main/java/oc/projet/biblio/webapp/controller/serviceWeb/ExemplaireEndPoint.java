package oc.projet.biblio.webapp.controller.serviceWeb;


import io.biblio.api.biblio_web_service.*;
import oc.projet.biblio.business.service.ExemplaireService;
import oc.projet.biblio.model.entity.Exemplaire;
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
public class ExemplaireEndPoint {

    private static final String NAMESPACE_URI = "http://biblio.io/api/biblio-web-service";

    @Autowired
    private ExemplaireService exemplaireService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getExemplaireRequest")
    @ResponsePayload
    public GetExemplaireResponse getAllExemplaire (){
        GetExemplaireResponse exemplaireResponse = new GetExemplaireResponse();
        List<Exemplaire> exemplaires = this.exemplaireService.findAll();
        List<ExemplaireWS> exemplaireWSList = new ArrayList<>();
        for (Exemplaire exemplaire : exemplaires){
            ExemplaireWS exemplaireWS = new ExemplaireWS();
            BeanUtils.copyProperties(exemplaire, exemplaireWS);
            exemplaireWSList.add(exemplaireWS);
        }

        exemplaireResponse.getExemplaireWS().addAll(exemplaireWSList);
        return exemplaireResponse;
    }


}
