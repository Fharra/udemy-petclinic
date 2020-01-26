package org.springframework.samples.petclinic.controllers;

<<<<<<< HEAD
import org.springframework.samples.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
=======
import org.springframework.stereotype.Controller;
>>>>>>> 2a94a88240f183d72393534e0cbd61142eebca4f
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/index", "/index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){
        return "notImplemented";
    }

    @RequestMapping({"", "/index", "/index.html"})
    public String listVets(){
        return "owners/index";
    }

}
