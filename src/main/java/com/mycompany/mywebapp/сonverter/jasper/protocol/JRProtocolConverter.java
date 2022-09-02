package com.mycompany.mywebapp.сonverter.jasper.protocol;

import com.mycompany.mywebapp.dto.jasper.protocol.JRProtocolDto;
import com.mycompany.mywebapp.entity.Protocol;
import com.mycompany.mywebapp.сonverter.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JRProtocolConverter {
    @Autowired
    TypeConverter converter;
    @Autowired
    SubJREmployeeConverter jrConverter;
    public JRProtocolDto entityToDto(Protocol protocol){
        JRProtocolDto dto = new JRProtocolDto();
        dto.setProtocolId(protocol.getId());
        dto.setDateOfExamination(converter.dateToString((Date) protocol.getDateOfExamination()));
        dto.setChairman(TypeConverter.enamToString(protocol.getChairman()));
        dto.setOneMemberOfCommission(TypeConverter.enamToString(protocol.getOneMemberOfCommission()));
        dto.setTwoMemberOfCommission(TypeConverter.enamToString(protocol.getTwoMemberOfCommission()));
        dto.setThreeMemberOfCommission(TypeConverter.enamToString(protocol.getThreeMemberOfCommission()));
        dto.setFourMemberOfCommission(TypeConverter.enamToString(protocol.getFourMemberOfCommission()));
        dto.setSubReport(jrConverter.entityToDto(protocol.getEmployees()));
        return dto;
    }
    public List<JRProtocolDto> entityToDto (List<Protocol> protocols){
        return protocols.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
    }
}
