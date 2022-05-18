package com.mycompany.mywebapp.сonverter;

import com.mycompany.mywebapp.dto.EmployeeDto;
import com.mycompany.mywebapp.dto.ProtocolDto;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProtocolConverter {

    @Autowired
    TypeConverter converter;
    public ProtocolDto entityToDto(Protocol protocol){
        ProtocolDto dto = new ProtocolDto();
        dto.setProtocolId(protocol.getId());
        dto.setDateOfExamination(converter.dateToString((Date) protocol.getDateOfExamination()));
        dto.setChairman(TypeConverter.enamToString(protocol.getChairman()));
        dto.setOneMemberOfCommission(TypeConverter.enamToString(protocol.getOneMemberOfCommission()));
        dto.setTwoMemberOfCommission(TypeConverter.enamToString(protocol.getTwoMemberOfCommission()));
        dto.setThreeMemberOfCommission(TypeConverter.enamToString(protocol.getThreeMemberOfCommission()));
        dto.setFourMemberOfCommission(TypeConverter.enamToString(protocol.getFourMemberOfCommission()));
        return dto;
    }

    public List<ProtocolDto> entityToDto (List<Protocol> protocols){
        return protocols.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
    }

    public Protocol dtoToEntity(ProtocolDto protocolDto){
        Protocol protocol =  new Protocol();
        protocol.setId(protocolDto.getProtocolId());
        protocol.setDateOfExamination(converter.stringToDate(protocolDto.getDateOfExamination()));
        protocol.setChairman(TypeConverter.StringToEnam(protocolDto.getChairman()));
        protocol.setOneMemberOfCommission(TypeConverter.StringToEnam(protocolDto.getOneMemberOfCommission()));
        protocol.setTwoMemberOfCommission(TypeConverter.StringToEnam(protocolDto.getTwoMemberOfCommission()));
        protocol.setThreeMemberOfCommission(TypeConverter.StringToEnam(protocolDto.getThreeMemberOfCommission()));
        protocol.setFourMemberOfCommission(TypeConverter.StringToEnam(protocolDto.getFourMemberOfCommission()));

        return protocol;
    }

    public List<Protocol> dtoToEntity(List<ProtocolDto> dto){
        return dto.stream().map(x-> dtoToEntity(x)).collect(Collectors.toList());
    }
}
