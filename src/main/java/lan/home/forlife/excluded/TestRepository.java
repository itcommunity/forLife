package lan.home.forlife.excluded;

import lan.home.forlife.excluded.Test;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yar on 05.02.15.
 */
//@RepositoryRestResource(collectionResourceRel = "test", path = "test")
public interface TestRepository extends CrudRepository<Test, Long> {
}
