package lan.home.forlife.repositories;

import lan.home.forlife.domain.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yar on 20.01.15.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Override
    @CacheEvict("default")
    <S extends User> S save(S s);

    @Cacheable("default")
    User findUserByUsername(String username);
}
