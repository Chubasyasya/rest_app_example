package kpfu.itis.allayarova.service;

import jakarta.persistence.EntityNotFoundException;
import kpfu.itis.allayarova.client.NewsApiClient;
import kpfu.itis.allayarova.dto.request.NewRequest;
import kpfu.itis.allayarova.dto.response.NewResponse;
import kpfu.itis.allayarova.mapper.NewMapper;
import kpfu.itis.allayarova.model.NewEntity;
import kpfu.itis.allayarova.repository.NewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewService {
    private final NewRepository newRepository;
    private final NewMapper newMapper;
    private final NewsApiClient newsApiClient;
    public NewResponse findByIdOrThrow(Long id) {
        NewEntity entity = newRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("NewEntity not found with id " + id));
        return newMapper.toResponse(entity);
    }

    public Long save(NewRequest request) {
        return newRepository.save(newMapper.toEntity(request)).getId();
    }

    public NewResponse update(NewRequest request, Long id) {
        NewEntity entity = newRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("NewEntity not found with id " + id));
        return newMapper.toResponse(entity);
    }

    public void deleteByIdOrThrow(Long id) {
        if (!newRepository.existsById(id)) {
            throw new EntityNotFoundException("NewEntity not found with id " + id);
        }
        newRepository.deleteById(id);
    }

    public List<NewResponse> findPatch() {
        return newsApiClient.getTopHeadlines();
    }
}
