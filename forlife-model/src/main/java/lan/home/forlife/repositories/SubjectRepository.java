package lan.home.forlife.repositories;

import lan.home.forlife.domain.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by yar on 27.01.15.
 */
public interface SubjectRepository extends PagingAndSortingRepository<Subject, Long> {

    @Query("SELECT s FROM Subject s JOIN FETCH s.pages WHERE s.id = (:id)")
    public Subject findByIdAndFetchPagesEagerly(@Param("id") Long id);
}
