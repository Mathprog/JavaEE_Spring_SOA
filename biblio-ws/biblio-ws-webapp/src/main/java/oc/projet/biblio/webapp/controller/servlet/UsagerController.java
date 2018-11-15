package oc.projet.biblio.webapp.controller.servlet;


import oc.projet.biblio.business.service.UsagerService;
import oc.projet.biblio.model.entity.Usager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path="/pret")
    @Transactional
    public String showAllPret(@RequestParam("email") String email, Map<String, Object> model){
        Usager usager = this.usagerService.findUsager_pretsByEmail(email);
        model.put("usager", usager);
        return "pret";
    }

    @PostMapping(path="/pret/detail")
    @Transactional
    public String showAllPretDetails(@RequestParam("email") String email, Map<String, Object> model){
        Usager usager = this.usagerService.findUsager_pretsDetailsByEmail(email);
        model.put("usager", usager);
        return "pretDetails";
    }

    @GetMapping(path="/prets")
    @Transactional
    public String showAllPrets(){
        return "usagerOuvrages";
    }

    @GetMapping(path = "/{email}")
    @Transactional
    public String showUsagerDetails(@PathVariable("email") String email, Map<String, Object> model){

        Usager usager = this.usagerService.findUsagerByEmail(email);
        model.put("usager", usager);
        return "usager";
    }
}
