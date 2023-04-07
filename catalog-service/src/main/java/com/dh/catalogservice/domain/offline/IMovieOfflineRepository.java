package com.dh.catalogservice.domain.offline;

import com.dh.catalogservice.domain.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieOfflineRepository extends MongoRepository<Movie, Long> {
    List<Movie> findAllByGenre(String genre);
}
