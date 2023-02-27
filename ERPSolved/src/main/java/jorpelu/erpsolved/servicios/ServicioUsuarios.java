package jorpelu.erpsolved.servicios;

import jorpelu.erpsolved.repo.IUserInterface;
import jorpelu.erpsolved.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuarios{

    @Autowired
    IUserInterface users;

    public void add(Usuario user){
        users.save(user);
    }
    public void delete(int id){
        if(users.findById((long) id).isPresent())
            users.delete(users.findById((long) id).get());
    }
    public List<Usuario> findAll(){
        return users.findAll();
    }

}
