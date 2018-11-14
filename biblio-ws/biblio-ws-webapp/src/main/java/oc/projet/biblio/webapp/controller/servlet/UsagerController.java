package oc.projet.biblio.webapp.controller.servlet;


import oc.projet.biblio.business.service.UsagerService;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Map;

@Controller
@RequestMapping(path = "/usager")
@Transactional
public class UsagerController {

    @Autowired
    private UsagerService usagerService;

    @GetMapping(path="/add") // Map ONLY GET Requests
    @Transactional
    public @ResponseBody String addNewUser () {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        this.usagerService.createUsager("tartenpiondzqdzq");
        return "saved";
    }

    @GetMapping(path="/pret/{email}")
    @Transactional
    public String showAllPret(@PathVariable("email") String email, Map<String, Object> model){
        Usager usager = this.usagerService.findUsagerByEmail(email);
        model.put("usager", usager);
        return "pret";
    }
}
