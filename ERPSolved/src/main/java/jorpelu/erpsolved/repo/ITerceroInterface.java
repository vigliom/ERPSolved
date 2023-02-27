package jorpelu.erpsolved.repo;

import jorpelu.erpsolved.model.TercerosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface ITerceroInterface extends JpaRepository<TercerosEntity, Long> {
    @Query(value="SELECT * FROM terceros ORDER BY terceros.id LIMIT 10 OFFSET ?1", nativeQuery = true)
    List<TercerosEntity> getTerceroLimit(int offset);

}
