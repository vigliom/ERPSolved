package jorpelu.erpsolved.repo;

import jorpelu.erpsolved.model.LineaDeFacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface ILineaFactura extends JpaRepository<LineaDeFacturaEntity, Integer> {

    @Query(value="SELECT * FROM linea_de_factura WHERE linea_de_factura.id_fact LIMIT 10 OFFSET ?1", nativeQuery = true)
    List<LineaDeFacturaEntity> getAllByIdFact(int id);
}
