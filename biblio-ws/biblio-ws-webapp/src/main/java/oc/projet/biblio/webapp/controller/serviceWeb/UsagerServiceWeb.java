package oc.projet.biblio.webapp.controller.serviceWeb;


import oc.projet.biblio.business.service.UsagerService;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "Usager")
public class UsagerServiceWeb {

    @Autowired
    private UsagerService usagerService;


    @WebMethod
    public List<Usager> getAllUsager(){
        return this.usagerService.findAll();
    }
}
