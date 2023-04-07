package com.dh.catalogservice.domain.feign;


import com.dh.catalogservice.domain.fallbacks.SerieRepositoryFallback;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="serie-service", fallback = SerieRepositoryFallback.class)
public interface ISerieRepository {
    @GetMapping("/api/v1/series/{genre}")
    ResponseEntity<List<Serie>> getSerieByGenre(@PathVariable String genre);
}
