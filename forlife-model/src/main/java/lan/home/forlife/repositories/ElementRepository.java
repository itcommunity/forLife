package lan.home.forlife.repositories;

import lan.home.forlife.domain.Element;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by yar on 26.01.15.
 */
//public interface ElementRepository extends CrudRepository<Element, Long> {
public interface ElementRepository extends PagingAndSortingRepository<Element, Long> {
}
