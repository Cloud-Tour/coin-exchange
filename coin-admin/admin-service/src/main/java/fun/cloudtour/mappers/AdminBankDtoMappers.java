package fun.cloudtour.mappers;

import fun.cloudtour.domain.AdminBank;
import fun.cloudtour.dto.AdminBankDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author cloudtour
 * @version 1.0
 * @description TODO
 * @date 2023/4/27 21:18
 */
@Mapper(componentModel = "spring")
public interface AdminBankDtoMappers {

    AdminBankDtoMappers INSTANCE = Mappers.getMapper(AdminBankDtoMappers.class) ;

    AdminBank toConvertEntity(AdminBankDto source) ;

    AdminBankDto toConvertDto(AdminBank source) ;


    List<AdminBank> toConvertEntity(List<AdminBankDto> source) ;

    List<AdminBankDto> toConvertDto(List<AdminBank> source) ;
}
