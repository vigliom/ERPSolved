package jorpelu.erpsolved.controller;

import jorpelu.erpsolved.servicios.ServicioFacturas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VentasController {

    @Autowired
    private ServicioFacturas facturasService;


    @GetMapping({"/ventas"})
    public String ultimaComprobacion(Model model){
        model.addAttribute("totalFacturas", facturasService.findAllFact().size());
        return "ventas";
    }
}
