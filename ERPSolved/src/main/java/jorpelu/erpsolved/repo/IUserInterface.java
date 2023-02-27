package jorpelu.erpsolved.repo;

import jorpelu.erpsolved.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserInterface extends JpaRepository<Usuario, Long> {
    Usuario findByName(String name);

}
