package fun.cloudtour.mappers;

import fun.cloudtour.domain.UserBank;
import fun.cloudtour.dto.UserBankDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserBankDtoMapper {
    UserBankDtoMapper INSTANCE = Mappers.getMapper(UserBankDtoMapper.class);

    UserBank toConvertEntity(UserBankDto source);

    List<UserBank> toConvertEntity(List<UserBankDto> source);


    UserBankDto toConvertDto(UserBank source);

    List<UserBankDto> toConvertDto(List<UserBank> source);
}

