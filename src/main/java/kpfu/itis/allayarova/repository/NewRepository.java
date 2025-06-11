package kpfu.itis.allayarova.repository;

import kpfu.itis.allayarova.model.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
}
