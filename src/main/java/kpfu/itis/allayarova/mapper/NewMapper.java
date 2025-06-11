package kpfu.itis.allayarova.mapper;

import kpfu.itis.allayarova.dto.request.NewRequest;
import kpfu.itis.allayarova.dto.response.NewResponse;
import kpfu.itis.allayarova.model.NewEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewMapper {

    NewResponse toResponse(NewEntity entity);

    NewEntity toEntity(NewRequest request);

}