package com.example.learningwebflux.controller;

import com.example.learningwebflux.document.Playlist;
import com.example.learningwebflux.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("playlists")
    public Flux<Playlist> getPlaylists() {
        return playlistService.findAll();
    }

    @GetMapping("playlists/{id}")
    public Mono<Playlist> getPlaylist(@PathVariable String id) {
        return playlistService.findById(id);
    }

    @PostMapping("playlists")
    public Mono<Playlist> savePlaylist(@RequestBody Playlist playlist) {
        return playlistService.save(playlist);
    }

    @GetMapping(value = "/playlists/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>> getPlaylistByEvents() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Playlist> events = playlistService.findAll();
        System.out.println("Passou aqui events");
        return Flux.zip(interval, events);
    }
}
