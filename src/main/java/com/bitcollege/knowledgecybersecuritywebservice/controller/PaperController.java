package com.bitcollege.knowledgecybersecuritywebservice.controller;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Paper;
import com.bitcollege.knowledgecybersecuritywebservice.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaperController {

    @Autowired
    private PaperService paperService;

    @GetMapping("/knowledge-units/{kuId}/sectors/{sId}/papers")
    public List<Paper> searchPaper(@PathVariable Long kuId,
                                   @PathVariable Long sId,
                                   @RequestParam (defaultValue = "", required = false) String keywords ,
                                   @RequestParam (defaultValue = "", required = false) String koId,
                                   @RequestParam (defaultValue = "", required = false) String startYear,
                                   @RequestParam (defaultValue = "", required = false) String endYear,
                                   @RequestParam (defaultValue = "", required = false) String title,
                                   @RequestParam (defaultValue = "", required = false) String doi,
                                   @RequestParam (defaultValue = "", required = false) String author
                                   ){



        return paperService.searchPaper(
                kuId,
                sId,
                keywords.equals("") ? null : keywords,
                koId.isEmpty() ? null : Long.valueOf(koId),
                startYear.isEmpty() ? null : Integer.valueOf(startYear),
                endYear.isEmpty() ? null : Integer.valueOf(endYear),
                title.isEmpty() ? null : title,
                doi.isEmpty() ? null : doi,
                author.isEmpty() ? null : author
        );
    }
}
