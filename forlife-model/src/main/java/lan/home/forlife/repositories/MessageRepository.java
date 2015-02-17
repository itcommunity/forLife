package lan.home.forlife.repositories;

import lan.home.forlife.domain.Message;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yar on 17.02.15.
 */
public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {
}
