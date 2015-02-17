package lan.home.forlife.repositories;

import lan.home.forlife.domain.ElementType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yar on 26.01.15.
 */
public interface ElementTypeRepository extends CrudRepository<ElementType, Long> {
    ElementType findTypeByName(String name);
}
