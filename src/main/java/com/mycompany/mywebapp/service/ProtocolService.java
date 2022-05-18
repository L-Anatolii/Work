package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.dto.ProtocolDto;
import com.mycompany.mywebapp.entity.Protocol;
import com.mycompany.mywebapp.jdbc.dao.ProtocolDao;
import com.mycompany.mywebapp.сonverter.ProtocolConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProtocolService {

    @Autowired
    private ProtocolDao protocolDao;

    @Autowired
    private ProtocolConverter converter;

    public List<ProtocolDto> getAllProtocols(){
        List<Protocol> protocols = protocolDao.findAll();
        return converter.entityToDto(protocols);
    }

    public void save(ProtocolDto protocolDto){
        protocolDao.save(converter.dtoToEntity(protocolDto));
    }

    public ProtocolDto findById(Long id) {
        Protocol protocol = protocolDao.findById(id);
        return converter.entityToDto(protocol);
    }

    public void update(Long id, ProtocolDto protocolDto) {
        protocolDao.update(id, converter.dtoToEntity(protocolDto));
    }

    public void delete(Long id){
        protocolDao.delete(id);
    }

}
