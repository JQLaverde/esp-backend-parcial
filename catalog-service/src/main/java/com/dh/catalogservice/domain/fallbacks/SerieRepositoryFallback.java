package com.dh.catalogservice.domain.fallbacks;

import com.dh.catalogservice.domain.feign.ISerieRepository;
import com.dh.catalogservice.domain.model.Serie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SerieRepositoryFallback implements ISerieRepository {
    @Override
    public ResponseEntity<List<Serie>> getSerieByGenre(String genre) {
        //
        return ResponseEntity.ok(List.of(new Serie("-1", "Vacio", "Vacio", null)));
    }
}
