package kpfu.itis.allayarova.controller;

import kpfu.itis.allayarova.dto.request.NewRequest;
import kpfu.itis.allayarova.dto.response.NewResponse;
import kpfu.itis.allayarova.model.NewEntity;
import kpfu.itis.allayarova.service.NewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewController {

    private final NewService service;

    @GetMapping("/{id}")
    public ResponseEntity<NewResponse> getById(@PathVariable Long id) {
        NewResponse response = service.findByIdOrThrow(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody NewRequest entity) {
        Long id = service.save(entity);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewResponse> update(@PathVariable Long id, @RequestBody NewRequest request) {
        NewResponse updated = service.update(request, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteByIdOrThrow(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<NewResponse>> findPatch() {
        List<NewResponse> news = service.findPatch();
        return ResponseEntity.ok(news);
    }
}
