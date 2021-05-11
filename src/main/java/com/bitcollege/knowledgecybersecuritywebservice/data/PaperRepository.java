package com.bitcollege.knowledgecybersecuritywebservice.data;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaperRepository extends JpaRepository<Paper, Long> {

    /*
    @Procedure(name="sp_search_papers")
    public List<Paper> sp_search_papers(@Param("ku") Long kuId,
                                        @Param("sector") Long sId,
                                        @Param("keywords") String keywords,
                                        @Param("ko") Long koId,
                                        @Param("start_year") Integer startYear,
                                        @Param("end_year") Integer endYear,
                                        @Param("title") String title,
                                        @Param("doi") String doi,
                                        @Param("authors") String author);
     */

    @Query(nativeQuery = true,value = "call sp_search_papers(?1,?2,?3,?4,?5,?6,?7,?8,?9)")
    public List<Paper> sp_search_papers(Long kuId,
                                        Long sId,
                                        String keywords,
                                        Long koId,
                                        Integer startYear,
                                        Integer endYear,
                                        String title,
                                        String doi,
                                        String author);
}
