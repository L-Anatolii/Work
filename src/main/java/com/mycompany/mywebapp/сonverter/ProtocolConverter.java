package com.mycompany.mywebapp.сonverter;

import com.mycompany.mywebapp.dto.ProtocolDto;
import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.entity.Protocol;
import com.mycompany.mywebapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProtocolConverter {

    @Autowired
    TypeConverter converter;

    @Autowired
    EmployeeRepository employeeRepository;


    public ProtocolDto entityToDto(Protocol protocol){
        ProtocolDto dto = new ProtocolDto();
        dto.setProtocolId(protocol.getId());
        dto.setDateOfExamination(converter.dateToString((Date) protocol.getDateOfExamination()));
        dto.setChairman(protocol.getChairman());
        dto.setOneMemberOfCommission(protocol.getOneMemberOfCommission());
        dto.setTwoMemberOfCommission(protocol.getTwoMemberOfCommission());
        dto.setThreeMemberOfCommission(protocol.getThreeMemberOfCommission());
        dto.setFourMemberOfCommission(protocol.getFourMemberOfCommission());
        return dto;
    }

    public List<ProtocolDto> entityToDto (List<Protocol> protocols){
        return protocols.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
    }

    public Protocol dtoToEntity(ProtocolDto protocolDto){
        Protocol protocol =  new Protocol();
        protocol.setId(protocolDto.getProtocolId());
        protocol.setDateOfExamination(converter.stringToDate(protocolDto.getDateOfExamination()));
        protocol.setChairman(protocolDto.getChairman());
        protocol.setOneMemberOfCommission(protocolDto.getOneMemberOfCommission());
        protocol.setTwoMemberOfCommission(protocolDto.getTwoMemberOfCommission());
        protocol.setThreeMemberOfCommission(protocolDto.getThreeMemberOfCommission());
        protocol.setFourMemberOfCommission(protocolDto.getFourMemberOfCommission());
        return protocol;
    }

    public List<Protocol> dtoToEntity(List<ProtocolDto> dto){
        return dto.stream().map(x-> dtoToEntity(x)).collect(Collectors.toList());
    }
}
