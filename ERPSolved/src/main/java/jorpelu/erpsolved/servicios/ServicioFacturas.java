package jorpelu.erpsolved.servicios;

import jorpelu.erpsolved.model.FacturaEntity;
import jorpelu.erpsolved.model.LineaDeFacturaEntity;
import jorpelu.erpsolved.repo.IFacturas;
import jorpelu.erpsolved.repo.ILineaFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioFacturas {

//    INTRODUCIMOS LAS INTERFACES A LAS TABLAS

    @Autowired
    private ILineaFactura lineasDeFactura;
    @Autowired
    private IFacturas facturas;

    public List<FacturaEntity> findAllFact(){
        return facturas.findAll();
    }

    public int LastID(){
        int size = (int) facturas.count();
        FacturaEntity f= facturas.findAll().get(size-1);
        return f.getId();
    }
    public FacturaEntity findFactByID(int id){
        if(facturas.findById(id).isPresent())
            return facturas.findById(id).get();
        return null;
    }
    public List<LineaDeFacturaEntity> findAllLineas(){
        return  lineasDeFactura.findAll();
    }

    public List<LineaDeFacturaEntity> findLineasByID_fact(int id){
        return lineasDeFactura.getAllByIdFact(id);
    }

    public FacturaEntity add(FacturaEntity factura){
        facturas.save(factura);
        return factura;
    }
    public void deleteFactura(int id){
        facturas.delete(facturas.findById(id).get());
    }

    public LineaDeFacturaEntity add(LineaDeFacturaEntity lineaDeFacturaEntity){
        lineasDeFactura.save(lineaDeFacturaEntity);
        return lineaDeFacturaEntity;
    }

}
