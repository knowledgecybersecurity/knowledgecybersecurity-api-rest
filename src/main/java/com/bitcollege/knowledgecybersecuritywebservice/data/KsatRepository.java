package com.bitcollege.knowledgecybersecuritywebservice.data;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Ksat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KsatRepository extends JpaRepository<Ksat, Long> {


    @Query(value = "select _ksat.id, _ksat.type, _ksat.description\n" +
            "from ksat _ksat\n" +
            "join wr_ksat wrksat on _ksat.id = wrksat.fk_ksat\n" +
            "join work_role wr on wrksat.fk_knowledge_unit = wr.id\n" +
            "where wr.id = ?1", nativeQuery = true)
    public List<Ksat> findByWorkRoleId(Long workRoleId);
}
