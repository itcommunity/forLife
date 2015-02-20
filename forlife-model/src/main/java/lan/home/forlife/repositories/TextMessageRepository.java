package lan.home.forlife.repositories;

import lan.home.forlife.domain.TextMessage;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yar on 20.02.15.
 */
public interface TextMessageRepository extends PagingAndSortingRepository<TextMessage, Long> {
}
