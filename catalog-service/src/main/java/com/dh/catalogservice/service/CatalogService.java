package com.dh.catalogservice.service;

import com.dh.catalogservice.domain.feign.IMovieRepository;
import com.dh.catalogservice.domain.feign.ISerieRepository;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatalogService  implements ICatalogService{

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private ISerieRepository serieRepository;


    @Override
    public Map<String, List<?>> getMovieAndSeriesByGenre(String genre) {

        ResponseEntity<List<Movie>> moviesResponse = movieRepository.getMovieByGenre(genre);
        ResponseEntity<List<Serie>> seriesReponse = serieRepository.getSerieByGenre(genre);

        Map<String, List<?>> response = new HashMap<>();
        response.put("movies", moviesResponse.getBody());
        response.put("series", seriesReponse.getBody());

         return response;
    }
}
