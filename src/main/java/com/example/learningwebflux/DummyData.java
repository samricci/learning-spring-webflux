//package com.example.learningwebflux;
//
//import com.example.learningwebflux.document.Playlist;
//import com.example.learningwebflux.repository.PlaylistRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import static java.util.UUID.randomUUID;
//import static reactor.core.publisher.Flux.just;
//
//@Component
//public class DummyData implements CommandLineRunner {
//    private final PlaylistRepository playlistRepository;
//
//    DummyData(PlaylistRepository playlistRepository) {
//        this.playlistRepository = playlistRepository;
//    }
//
//    @Override
//    public void run(String... args) {
//    	playlistRepository.deleteAll()
//                .thenMany(
//                        just("API REST Spring Boot", "Deploy de uma aplicação java no IBM Cloud", "Java 8",
//                                "Github", "Spring Security", "Web Service RESTFULL", "Bean no Spring Framework")
//                                .map(nome -> new Playlist(randomUUID().toString(), nome))
//                                .flatMap(playlistRepository::save))
//                .subscribe(System.out::println);
//    }
//}
