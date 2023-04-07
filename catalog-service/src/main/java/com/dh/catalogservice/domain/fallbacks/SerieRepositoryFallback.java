package com.dh.catalogservice.domain.fallbacks;

import com.dh.catalogservice.domain.feign.ISerieRepository;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.domain.offline.ISerieOfflineRepository;
import com.dh.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SerieRepositoryFallback implements ISerieRepository {

    private final ISerieOfflineRepository serieOfflineRepository;

    @Override
    public ResponseEntity<List<Serie>> getSerieByGenre(String genre) {
        List<Serie> listSeries = serieOfflineRepository.findAllByGenre(genre);
        return ResponseEntity.ok(listSeries);
    }
}
