package lan.home.forlife.repositories;

import lan.home.forlife.domain.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yar on 26.01.15.
 */
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
}
