package com.bitcollege.knowledgecybersecuritywebservice.service;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Paper;

import java.util.List;

public interface PaperService {
    public List<Paper> searchPaper(Long kuId,
                                   Long sId,
                                   String keywords,
                                   Long koId,
                                   Integer startYear,
                                   Integer endYear,
                                   String title,
                                   String doi,
                                   String author);
}
