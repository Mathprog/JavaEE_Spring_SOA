package oc.projet.biblio.webapp.controller.serviceWeb;


import io.biblio.api.usager_web_service.*;
import oc.projet.biblio.business.service.UsagerService;
import oc.projet.biblio.model.entity.Usager;
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
public class UsagerEndPoint {

    private static final String NAMESPACE_URI = "http://biblio.io/api/usager-web-service";

    @Autowired
    private UsagerService usagerService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsagerRequest")
    @ResponsePayload
    public GetUsagerResponse getUsager(){
            GetUsagerResponse response = new GetUsagerResponse();
            List<Usager> usagers = this.usagerService.findAll();
            List<UsagerWS> usagersWS = new ArrayList<>();
            for (Usager usager : usagers){
                UsagerWS usagerws = new UsagerWS();
                BeanUtils.copyProperties(usager, usagerws);
                usagersWS.add(usagerws);
            }
            response.getUsagerWS().addAll(usagersWS);

            return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsagerByEmailRequest")
    @ResponsePayload
    public GetUsagerByEmailResponse getUsagerByEmail(@RequestPayload GetUsagerByEmailRequest request){
        Usager usager = this.usagerService.findUsagerByEmail(request.getEmail());
        UsagerWS usagerWs = new UsagerWS();
        BeanUtils.copyProperties(usager, usagerWs);
        GetUsagerByEmailResponse guber = new GetUsagerByEmailResponse();
        guber.setUsagerWS(usagerWs);
        return guber;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsagerCreateRequest")
    @ResponsePayload
    public GetUsagerCreateResponse getUsagerCreate(@RequestPayload GetUsagerByEmailRequest request){
        Usager usager = this.usagerService.createUsager(request.getEmail());
        UsagerWS usagerWs = new UsagerWS();
        BeanUtils.copyProperties(usager, usagerWs);
        GetUsagerCreateResponse guber = new GetUsagerCreateResponse();
        guber.setUsagerWS(usagerWs);
        return guber;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsagerByIdRequest")
    @ResponsePayload
    public GetUsagerByIdResponse getUsagerById(@RequestPayload GetUsagerByIdRequest request){
        Usager usager = this.usagerService.find(request.getId());
        UsagerWS usagerWs = new UsagerWS();
        BeanUtils.copyProperties(usager, usagerWs);
        GetUsagerByIdResponse guber = new GetUsagerByIdResponse();
        guber.setUsagerWS(usagerWs);
        return guber;
    }


}