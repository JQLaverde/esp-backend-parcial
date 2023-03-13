package com.dh.catalogservice.service;

import com.dh.catalogservice.domain.feign.IMovieRepository;
import com.dh.catalogservice.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService  implements ICatalogService{

    @Autowired
    private IMovieRepository movieRepository;


    @Override
    public List<Movie> getMovieByGenre(String genre) {
         ResponseEntity<List<Movie>> response = movieRepository.getMovieByGenre(genre);
         return response.getBody();
    }
}
