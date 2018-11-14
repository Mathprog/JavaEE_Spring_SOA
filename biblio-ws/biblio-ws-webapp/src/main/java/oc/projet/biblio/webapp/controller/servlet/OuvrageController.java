package oc.projet.biblio.webapp.controller.servlet;


import oc.projet.biblio.business.service.OuvrageService;
import oc.projet.biblio.model.entity.Ouvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/ouvrage")
public class OuvrageController {

    @Autowired
    private OuvrageService ouvrageService;

    @GetMapping(path="/all") // Map ONLY GET Requests
    public String addNewUser (Map<String, Object> model) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        List<Ouvrage> ouvrages = this.ouvrageService.findAllOuvrage();
        model.put("ouvrages", ouvrages);
        return "ouvrages";
    }
}
