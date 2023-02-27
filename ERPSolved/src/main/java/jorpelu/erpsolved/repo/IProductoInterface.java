package jorpelu.erpsolved.repo;

import jorpelu.erpsolved.model.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface IProductoInterface extends JpaRepository<ProductoEntity, Long> {
    @Query(value="SELECT * FROM producto ORDER BY producto.id LIMIT 10 OFFSET ?1", nativeQuery = true)
    List<ProductoEntity> getProductoLimit(int offset);
}
