package lan.home.forlife.repositories;

import lan.home.forlife.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yar on 26.01.15.
 */
public interface PageRepository extends PagingAndSortingRepository<Page, Long> {
}
