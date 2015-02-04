package lan.home.forlife.repositories;

import lan.home.forlife.domain.Type;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yar on 26.01.15.
 */
public interface TypeRepository extends CrudRepository<Type, Long> {
    Type findTypeByName(String name);
}
