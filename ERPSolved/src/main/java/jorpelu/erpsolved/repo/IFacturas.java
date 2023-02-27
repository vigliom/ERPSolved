package jorpelu.erpsolved.repo;

import jorpelu.erpsolved.model.FacturaEntity;
import jorpelu.erpsolved.model.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface IFacturas extends JpaRepository<FacturaEntity, Integer> {

    @Query(value="SELECT * FROM factura ORDER BY factura.id LIMIT 10 OFFSET ?1", nativeQuery = true)
    List<FacturaEntity> getFacturaLimit(int offset);
}
