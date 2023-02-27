package jorpelu.erpsolved.controller;

import jakarta.jws.WebParam;
import jorpelu.erpsolved.model.FacturaEntity;
import jorpelu.erpsolved.model.LineaDeFacturaEntity;
import jorpelu.erpsolved.model.TercerosEntity;
import jorpelu.erpsolved.model.TipoDescuentoEntity;
import jorpelu.erpsolved.servicios.ServicioFacturas;
import jorpelu.erpsolved.servicios.ServicioProductos;
import jorpelu.erpsolved.servicios.ServicioTerceros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/facturas")
public class FacturaController {
    private TercerosEntity tercero;
    private List<LineaDeFacturaEntity> lineasProductos = new ArrayList<>();
    private FacturaEntity factura;

    @Autowired
    private ServicioFacturas facturasService;
    @Autowired
    private ServicioTerceros tercerosTotal;
    @Autowired
    private ServicioProductos productosTotal;

    @GetMapping({"/", "", "/nueva"})
    public String facturaNueva(Model model){

//        Iniciamos los elementos que vamos a cargar en la nueva factura y
//        damos formato a los numeros
        List<TipoDescuentoEntity> descuentos = new ArrayList<>();
        descuentos.add(new TipoDescuentoEntity());
        DecimalFormat formatoPrecios = new DecimalFormat("#.00");
        float totalFactura = 0;

//        Comprobamos si es una recarga de datos o sino crea el cliente
        model.addAttribute("terceroForm", Objects.requireNonNullElseGet(tercero, TercerosEntity::new));

        for (LineaDeFacturaEntity ln :
                lineasProductos) {
            String sPrecio = ln.getIdProd().getPrecio();
            sPrecio = sPrecio.replace(',','.');
            float fPrecio = Float.parseFloat(sPrecio);
            float precioTotalLinea;
            if(ln.getCantidad() != null){
                precioTotalLinea = fPrecio * ln.getCantidad();
            }else{
                ln.setCantidad(1);
                precioTotalLinea = fPrecio;
            }
            ln.setPrecioLinea((double) precioTotalLinea);
            totalFactura += precioTotalLinea;
        }

        model.addAttribute("lineaForm", new LineaDeFacturaEntity());
        model.addAttribute("totalFactura", formatoPrecios.format(totalFactura));
        model.addAttribute("prodFactura", lineasProductos.size());
        model.addAttribute("listaTerceros", tercerosTotal.findAll());
        model.addAttribute("listaFactura", lineasProductos);
        model.addAttribute("listaProductos", productosTotal.findAll());
        model.addAttribute("listaDescuentos", descuentos);

        return "ventas/facturas";
    }


    @GetMapping({"/submit/{id}"})
    public String addTerceroFactura(@PathVariable long id){
        this.tercero = tercerosTotal.findById(id);
        if(tercero==null){
            tercero = new TercerosEntity();
        }
        return "redirect:/facturas";
    }

    @PostMapping("/addP/{id}")
    public String addProductoFactura(@PathVariable int id, @ModelAttribute("lineaForm") LineaDeFacturaEntity linea){
        linea.setIdProd(productosTotal.findById(id));
        lineasProductos.add(linea);
        return "redirect:/facturas";
    }

    @PostMapping({"/addFact"})
    public String guardaFactura(){
        factura = new FacturaEntity();
        factura.setCif(tercero.getCif());
        factura.setIdTerceros(tercero);
        facturasService.add(factura);
        int idFactura = facturasService.LastID();
        factura.setId(idFactura);
//        factura.setFecha((Timestamp) new Date());
        for (LineaDeFacturaEntity ln :
                lineasProductos) {
            ln.setIdFact(factura.getId());
            facturasService.add(ln);
        }

        factura = new FacturaEntity();
        lineasProductos = new ArrayList<>();


        return "redirect:/facturas";
    }

    @GetMapping({"/all"})
    public String listAll(Model model){

        model.addAttribute("listaFacturas", facturasService.findAllFact());
        return "ventas/TodasLasFacturas";
    }

    @GetMapping({"/delete/{id}"})
    public String deleteFactura(@PathVariable int id){
        facturasService.deleteFactura(id);
        return "redirect:/facturas/all";
    }

    @GetMapping({"/edit/{id}"})
    public String editFactura(@PathVariable int id, Model model){

//        HACER MODO DETALLE, NO SE DEBERIA PODER EDITAR



//        FacturaEntity fact = facturasService.findFactByID(id);
//        List<LineaDeFacturaEntity> lineas = facturasService.findLineasByID_fact(id);
//        List<TipoDescuentoEntity> descuentos = new ArrayList<>();
//        float totalFactura = 0;
//        DecimalFormat formatoPrecios = new DecimalFormat("#.00");
//
//
//        for (LineaDeFacturaEntity ln :
//                lineas) {
//            String sPrecio = ln.getIdProd().getPrecio();
//            sPrecio = sPrecio.replace(',','.');
//            float fPrecio = Float.parseFloat(sPrecio);
//            float precioTotalLinea;
//            if(ln.getCantidad() != null){
//                precioTotalLinea = fPrecio * ln.getCantidad();
//            }else{
//                ln.setCantidad(1);
//                precioTotalLinea = fPrecio;
//            }
//            ln.setPrecioLinea((double) precioTotalLinea);
//            totalFactura += precioTotalLinea;
//        }

//        model.addAttribute("terceroForm", Objects.requireNonNullElseGet(fact.getIdTerceros(), TercerosEntity::new));
//        model.addAttribute("prodFactura", lineas.size());
//        model.addAttribute("listaTerceros", tercerosTotal.findAll());
//        model.addAttribute("listaProductos", productosTotal.findAll());
//        model.addAttribute("listaDescuentos", descuentos);
//        model.addAttribute("lineaForm", new LineaDeFacturaEntity());
//        model.addAttribute("listaFactura", lineas);
//        model.addAttribute("totalFactura", formatoPrecios.format(totalFactura));



        return "ventas/facturas";
    }
}
