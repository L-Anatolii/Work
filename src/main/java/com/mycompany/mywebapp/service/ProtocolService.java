package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.dto.ProtocolDto;

import com.mycompany.mywebapp.entity.Protocol;
import com.mycompany.mywebapp.repository.ProtocolRepository;
import com.mycompany.mywebapp.сonverter.ProtocolConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ProtocolService {

    @Autowired
    private ProtocolConverter converter;

    @Autowired
    private ProtocolRepository protocolRepository;

    @Transactional
    public List<ProtocolDto> getAllProtocols(){
        List<Protocol> protocols = (List<Protocol>) protocolRepository.findAll();
        return converter.entityToDto(protocols);
    }
    @Transactional
    public void save(ProtocolDto protocolDto){
        protocolRepository.save(converter.dtoToEntity(protocolDto));
    }
    @Transactional
    public ProtocolDto findById(Long id) throws Exception {
        Optional<Protocol> protocol = protocolRepository.findById(id);
        if(protocol.isPresent()){
            return converter.entityToDto(protocol.get());
        }
        throw new Exception();
    }

    @Transactional
    public void delete(Long id) throws Exception {
    Long count = protocolRepository.countById(id);
        if(count == null || count == 0){
            throw new Exception();
        }
        protocolRepository.deleteById(id);
    }
}
