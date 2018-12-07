package oc.projet.biblio.client.webapp.controller;


import oc.projet.biblio.client.business.service.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ouvrages")
public class OuvrageController {

    @Autowired
    private OuvrageService ouvrageService;

    @RequestMapping(value = { "/liste" }, method = RequestMethod.GET)
    public String pretsPage(ModelMap model) {
        model.addAttribute("ouvrages", this.ouvrageService.findAllOuvrage() );
        model.addAttribute("ouvragesDispos", this.ouvrageService.findAllWithDispo());
        model.addAttribute("ouvragesNonDispos", this.ouvrageService.findAllWithNoDispo());
        return "ouvrages";
    }
}
