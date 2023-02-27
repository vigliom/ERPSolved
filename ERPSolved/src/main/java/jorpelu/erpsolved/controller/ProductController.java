package jorpelu.erpsolved.controller;

import jorpelu.erpsolved.model.ProductoEntity;
import jorpelu.erpsolved.servicios.ServicioProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ServicioProductos productos;
//    @Autowired
//    IProductoInterface productos;
    @GetMapping({"/producto", "producto/list"})
    public String lista(@RequestParam("nU")Optional<String> userName, @RequestParam("e")Optional<String> empresa,Model model){
        model.addAttribute("nUser", userName.orElse("Vigliom"));
        model.addAttribute("nEmpresa", empresa.orElse("Empresa1"));
        model.addAttribute("listaProductos", productos.findAll());  //Lista de productos autoWired
        model.addAttribute("productoForm", new ProductoEntity());         //Formulario dento de la pagina
        return "producto";
    }

    @PostMapping("producto/new/submit")
    public String nuevoProductoSubmit(@ModelAttribute("productoForm") ProductoEntity nuevoProducto){
        productos.add(nuevoProducto);
        return "redirect:/producto";
    }

    @GetMapping({"/producto/edit/{id}"})
    public String editarProductForm(@PathVariable long id, Model model){
//            Optional<ProductoEntity> producto= Optional.ofNullable(productos.findById(id));
            ProductoEntity productoEntity = productos.findById(id);
            model.addAttribute("productoForm", productoEntity);


        return "producto_detalle";
    }
    @GetMapping({"/producto/delete/{id}"})
    public String borrarUserForm(@PathVariable long id, Model model){
        ProductoEntity producto = productos.findById(id);
        productos.delete(producto);
        return "redirect:/producto";
    }
    @PostMapping("/producto/edit/submit")
    public String editarProductoSubmit(@ModelAttribute("productoForm") ProductoEntity producto){
        productos.edit(producto);
        return "redirect:/producto";
    }


}
