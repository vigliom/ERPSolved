package jorpelu.erpsolved.controller;

import jorpelu.erpsolved.servicios.ServicioProductos;
import jorpelu.erpsolved.servicios.ServicioTerceros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    ServicioProductos productos;
    @Autowired
    ServicioTerceros terceros;
    @GetMapping({"/login"})
    public String login() {
        return "login";
    }

    @GetMapping({"/inicio"})
    public String inicio(@RequestParam("nU")Optional<String> userName, @RequestParam("e")Optional<String> empresa,Model model)  {
        model.addAttribute("nUser", userName.orElse("vigliom"));
        model.addAttribute("nEmpresa", empresa.orElse("Empresa1"));
        model.addAttribute("nProds", productos.findAll().size());
        model.addAttribute("nClients", terceros.findClients().size());
        model.addAttribute("nProv", terceros.findProviders().size());
        return "inicio";
    }

    @GetMapping({"/home", "about-us", "/h", "/", " ", ""})
    public String home(){
        return "home";
    }


}
