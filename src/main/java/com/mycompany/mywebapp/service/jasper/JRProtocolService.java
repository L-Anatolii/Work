package com.mycompany.mywebapp.service.jasper;

import com.mycompany.mywebapp.dto.ProtocolDto;
import com.mycompany.mywebapp.dto.jasper.protocol.JRProtocolDto;
import com.mycompany.mywebapp.entity.Protocol;
import com.mycompany.mywebapp.repository.ProtocolRepository;
import com.mycompany.mywebapp.сonverter.jasper.protocol.JRProtocolConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class JRProtocolService {

    @Autowired
    private ProtocolRepository protocolRepository;

    @Autowired
    JRProtocolConverter converter;

    @Transactional
    public JRProtocolDto findById(Long id) throws Exception {
        Optional<Protocol> protocol = protocolRepository.findById(id);
        if(protocol.isPresent()){
            return converter.entityToDto(protocol.get());
        }
        throw new Exception();
    }
}
