package jorpelu.erpsolved.controller;

import jorpelu.erpsolved.model.TercerosEntity;
import jorpelu.erpsolved.model.Usuario;
import jorpelu.erpsolved.servicios.ServicioTerceros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/terceros")
public class TercerosController {
    @Autowired
    private ServicioTerceros terceros;

    @GetMapping({"/list","/", ""})
    public String lista(Model model){
    model.addAttribute("title", "Terceros");
    model.addAttribute("listaTerceros", terceros.findAll());
    return "terceros";
    }

    @GetMapping({"/delete/{id}"})
    public String borrarTerceroForm(@PathVariable long id, Model model){
        TercerosEntity tercero= terceros.findById(id);
        if (tercero.getProv()==1){
            terceros.delete(tercero);
            return "redirect:/terceros/proveedores";
        }else if (tercero.getCliente() ==1){
            terceros.delete(tercero);
            return "redirect:/terceros/clientes";
        }else{
            terceros.delete(tercero);
            return "redirect:/terceros";
        }

    }

    @GetMapping({"/proveedores"})
    public String findProviders(Model model){
        model.addAttribute("title", "Terceros");
        model.addAttribute("listaTerceros", terceros.findProviders());
        return "terceros";
    }
    @PostMapping("/new/submit")
    public String nuevoTerceroSubmit(@ModelAttribute("terceroForm") TercerosEntity tercero){
        if(tercero.getCliente()==null){
            tercero.setCliente((byte) 0);
        }

        if(tercero.getProv() == null){
            tercero.setProv((byte) 0);
        }
        terceros.add(tercero);
        return "redirect:/terceros";
    }

    @GetMapping("/edit/{id}")
    public String editTercero(@PathVariable int id, Model model) {
        TercerosEntity terceroModificado = terceros.findById(id);
        model.addAttribute("terceroForm", terceroModificado);
        return "terceroDetalle";
    }
    @GetMapping("/new")
    public String nuevoTercero(Model model){
        TercerosEntity tercero= new TercerosEntity();
        model.addAttribute("terceroForm", tercero);
        return "terceroDetalle";
    }

    @PostMapping("/edit/submit")
    public String editTerceroSubmit(@ModelAttribute("terceroForm") TercerosEntity tecero){
        terceros.edit(tecero);
        return "redirect:/terceros";
    }
    @GetMapping({"/clientes"})
    public String findClients(Model model){
        model.addAttribute("title", "Terceros");
        model.addAttribute("listaTerceros", terceros.findClients());
        return "terceros";
    }
}
