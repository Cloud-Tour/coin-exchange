package fun.cloudtour.mappers;

import fun.cloudtour.domain.AdminBank;
import fun.cloudtour.dto.AdminBankDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-02T16:51:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class AdminBankDtoMappersImpl implements AdminBankDtoMappers {

    @Override
    public AdminBank toConvertEntity(AdminBankDto source) {
        if ( source == null ) {
            return null;
        }

        AdminBank adminBank = new AdminBank();

        adminBank.setName( source.getName() );
        adminBank.setBankName( source.getBankName() );
        adminBank.setBankCard( source.getBankCard() );

        return adminBank;
    }

    @Override
    public AdminBankDto toConvertDto(AdminBank source) {
        if ( source == null ) {
            return null;
        }

        AdminBankDto adminBankDto = new AdminBankDto();

        adminBankDto.setName( source.getName() );
        adminBankDto.setBankName( source.getBankName() );
        adminBankDto.setBankCard( source.getBankCard() );

        return adminBankDto;
    }

    @Override
    public List<AdminBank> toConvertEntity(List<AdminBankDto> source) {
        if ( source == null ) {
            return null;
        }

        List<AdminBank> list = new ArrayList<AdminBank>( source.size() );
        for ( AdminBankDto adminBankDto : source ) {
            list.add( toConvertEntity( adminBankDto ) );
        }

        return list;
    }

    @Override
    public List<AdminBankDto> toConvertDto(List<AdminBank> source) {
        if ( source == null ) {
            return null;
        }

        List<AdminBankDto> list = new ArrayList<AdminBankDto>( source.size() );
        for ( AdminBank adminBank : source ) {
            list.add( toConvertDto( adminBank ) );
        }

        return list;
    }
}
