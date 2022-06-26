//package com.mycompany.mywebapp.service;
//
//import com.mycompany.mywebapp.entity.Certification;
//import com.mycompany.mywebapp.exception.CertificationNotFoundException;
//import com.mycompany.mywebapp.repository.CertificationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class CertificationService {
//    @Autowired
//    private CertificationRepository certificationRepository;
//
//    public List<Certification> getAllCertifications(){
//        return (List<Certification>) certificationRepository.findAll();
//    }
//
//    public void save(Certification certification){
//        certificationRepository.save(certification);
//    }
//
//    public Certification findById(Long id) throws CertificationNotFoundException {
//        Optional<Certification> certification = certificationRepository.findById(id);
//        if(certification.isPresent()){
//            return certification.get();
//        }
//        throw new CertificationNotFoundException(("Could not find any certification with ID"+ id));
//    }
//
//    public void delete(Long id) throws CertificationNotFoundException{
//        Long count = certificationRepository.countById(id);
//        if(count == null || count == 0){
//            throw new CertificationNotFoundException("Could not find any certification with ID"+ id);
//        }
//        certificationRepository.deleteById(id);
//    }
//
//}
