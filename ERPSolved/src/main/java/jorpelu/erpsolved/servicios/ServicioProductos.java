package jorpelu.erpsolved.servicios;

import jorpelu.erpsolved.repo.IProductoInterface;
import jorpelu.erpsolved.model.ProductoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioProductos {
//    private List<ProductoEntity> repositorio = new ArrayList<>();
    @Autowired
    private IProductoInterface productInterface;

    public ProductoEntity add(ProductoEntity producto){
//        repositorio.add(producto);
        productInterface.save(producto);
        return producto;
    }

    public List<ProductoEntity> findAll(){
        return productInterface.findAll();
    }

    public ProductoEntity findById(long id){
        if(productInterface.findById(id).isPresent())
            return productInterface.findById(id).get();
        else
            return null;
    }

    public void edit(ProductoEntity producto){
        productInterface.delete(productInterface.findById((long) producto.getId()).get());
        productInterface.save(producto);
    }
    public void delete(ProductoEntity producto){
        productInterface.delete(producto);
    }
//    @PostConstruct
//    public void init(){
//
//        repositorio = productInterface.findAll();
//        repositorio.addAll(
//                Arrays.asList(new ProductoEntity(1,"Arroz", 4, 5.99f, "Comida"),
//                        new ProductoEntity(2,"Leche", 0, 2.99f, "Comida"),
//                        new ProductoEntity(3,"Servillets", 10, 1.99f, "Limpieza"),
//                        new ProductoEntity(4,"Movil", 21, 890.99f, "Electronica"))
//        );
//    }
}
