package com.bitcollege.knowledgecybersecuritywebservice.service;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Ksat;

import java.util.List;

public interface KsatService {
    public List<Ksat> findByWorkRoleId(Long workRoleId);
}
