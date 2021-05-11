package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import com.bitcollege.knowledgecybersecuritywebservice.data.KsatRepository;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Ksat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KsatService implements com.bitcollege.knowledgecybersecuritywebservice.service.KsatService {

    @Autowired
    private KsatRepository ksatRepository;


    @Override
    public List<Ksat> findByWorkRoleId(Long workRoleId) {
        return ksatRepository.findByWorkRoleId(workRoleId);
    }
}
