package com.dh.catalogservice.service.queue;

import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CatalogListener {

    private final CatalogService service;

    @RabbitListener(queues = { "${queue.movie.name}" })
    public void receive(@Payload Movie movie) {
        //service.save(movie);
        System.out.println("Aqui metodo para guardar");
    }

    @RabbitListener(queues = { "${queue.serie.name}" })
    public void receive(@Payload Serie serie) {
        //service.save(serie);
        System.out.println("Aqui metodo para guardar");
    }

}
