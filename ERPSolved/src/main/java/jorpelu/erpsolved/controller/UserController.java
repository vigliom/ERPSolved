package jorpelu.erpsolved.controller;


//import jorpelu.erpsolved.servicios.ServicioUsuarios;
import jorpelu.erpsolved.model.Usuario;
import jorpelu.erpsolved.servicios.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Controller
public class UserController {
    @Autowired
    private ServicioUsuarios usuarios;
    @GetMapping({"/user", "user/list"})
    public String lista(@RequestParam("nU") Optional<String> userName, @RequestParam("e")Optional<String> empresa, Model model){
//        usuarios.sortById();
        model.addAttribute("nUser", userName.orElse("Vigliom"));
        model.addAttribute("nEmpresa", empresa.orElse("Empresa1"));
        model.addAttribute("listaUsuarios", usuarios.findAll());
        return "user";
    }
    @GetMapping("/user/new")
    public String nuevo(@RequestParam("nU") Optional<String> userName, @RequestParam("e")Optional<String> empresa,Model model){
        model.addAttribute("nUser", userName.orElse("Vigliom"));
        model.addAttribute("nEmpresa", empresa.orElse("Empresa1"));
        Usuario usuario= new Usuario();
        model.addAttribute("userForm", usuario);
        return "user_detalle";
    }

    @PostMapping("user/new/submit")
    public String nuevoUserSubmit(@ModelAttribute("userForm") Usuario nuevoUsuario){
//        nuevoUsuario.setId(usuarios.findAll().get(usuarios.findAll().size()-1).getId()+1);
        usuarios.add(nuevoUsuario);
        return "redirect:/user";


    }
    @PostMapping("/user/edit/submit")
    public String editarUserSubmit(@ModelAttribute("userForm") Usuario usuario){

        return "redirect:/user";
    }
    @GetMapping({"/user/delete/{id}"})
    public String borrarUserForm(@RequestParam("nU") Optional<String> userName, @RequestParam("e")Optional<String> empresa,@PathVariable int id, Model model){
        model.addAttribute("nUser", userName.orElse("Vigliom"));
        model.addAttribute("nEmpresa", empresa.orElse("Empresa1"));
//        usuarios.sortById();
        usuarios.delete(id);
        return "redirect:/user";
    }
}