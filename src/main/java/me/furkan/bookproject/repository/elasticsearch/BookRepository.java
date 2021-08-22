package me.furkan.bookproject.repository.elasticsearch;

import me.furkan.bookproject.model.Book;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface BookRepository extends ElasticsearchRepository<Book, Long> {
    Optional<Book> findByName(String name);
    Optional<Book> findById(long id);

    @Query("{\"match\": {\"name\": {\"query\": \"?0\", \"fuzziness\": \"AUTO\", \"operator\": \"or\"}}}")
    Optional<Book> findByNameLike(String name);

}
