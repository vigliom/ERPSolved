package jorpelu.erpsolved.servicios;

import jorpelu.erpsolved.repo.ITerceroInterface;
import jorpelu.erpsolved.model.TercerosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioTerceros {
//    private List<Tercero> repositorio = new ArrayList<>();

    @Autowired
    private ITerceroInterface interfazBD;

    public TercerosEntity add(TercerosEntity tercero){
        interfazBD.save(tercero);
        return tercero;
    }

    public List<TercerosEntity> findAll() {
        return interfazBD.findAll();
    }
    public List<TercerosEntity> findProviders(){
        int li = 0;
        List<TercerosEntity> providers = new ArrayList<>();
        for (TercerosEntity tercero :
                interfazBD.findAll()) {
            if(tercero.getProv() != 0)
                providers.add(tercero);
        }
        return providers;
    }
    public List<TercerosEntity> findClients(){
        int li = 0;
        List<TercerosEntity> clients = new ArrayList<>();
        for (TercerosEntity tercero :
                interfazBD.findAll()) {
            if(tercero.getCliente()!=0)
                clients.add(tercero);
        }
        return clients;
    }
    public TercerosEntity findById(long id){
        if(interfazBD.findById(id).isPresent())
            return interfazBD.findById(id).get();
        else
            return null;
    }

    public TercerosEntity edit(TercerosEntity tercero){
        if (interfazBD.findById((long) tercero.getId()).isPresent())
            interfazBD.delete(interfazBD.findById((long) tercero.getId()).get());
        interfazBD.save(tercero);
        return tercero;
    }

    public boolean delete(TercerosEntity tercero){
         interfazBD.delete(tercero);
         return true;
    }
//    @PostConstruct
//    public void init(){
//        repositorio.addAll(
//                Arrays.asList(new Tercero(1,"Jorge", "perez","jorgeperez96jpl@gmail.com", "calle mi case", "1231231231D", true,true),
//                        new Tercero(2,"Paula", "perez","jorgeperez96jpl@gmail.com", "calle mi case", "1231231231D", true,true),
//                        new Tercero(3,"Jisus", "Pinar","jorgeperez96jpl@gmail.com", "calle mi case", "1231231231D", false,true),
//                        new Tercero(4,"Kevin", "Signes","jorgeperez96jpl@gmail.com", "calle mi case", "1231231231D", true,false))
//        );
//    }
}
