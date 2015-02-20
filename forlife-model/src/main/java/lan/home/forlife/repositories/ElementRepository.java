package lan.home.forlife.repositories;

import lan.home.forlife.domain.Element;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yar on 26.01.15.
 */
public interface ElementRepository extends PagingAndSortingRepository<Element, Long> {
}
