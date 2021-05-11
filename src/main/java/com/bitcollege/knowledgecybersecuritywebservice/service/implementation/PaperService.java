package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import com.bitcollege.knowledgecybersecuritywebservice.data.PaperRepository;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Service
public class PaperService implements com.bitcollege.knowledgecybersecuritywebservice.service.PaperService {

    @Autowired
    private PaperRepository paperRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Paper> searchPaper(Long kuId,
                                   Long sId,
                                   String keywords,
                                   Long koId,
                                   Integer startYear,
                                   Integer endYear,
                                   String title,
                                   String doi,
                                   String author) {
        return paperRepository.sp_search_papers(kuId, sId, keywords, koId, startYear, endYear, title, doi, author);
        /*
        Query query  = entityManager.createNamedStoredProcedureQuery("sp_search_papers");
        query.setParameter("ku",kuId);
        query.setParameter("sector",sId);
        query.setParameter("keywords",keywords);
        query.setParameter("ko",koId);
        query.setParameter("start_year",startYear);
        query.setParameter("end_year",endYear);
        query.setParameter("title",title);
        query.setParameter("doi",doi);
        query.setParameter("authors", author);
        return query.getResultList();
         */
    }
}
