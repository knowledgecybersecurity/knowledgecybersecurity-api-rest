package com.bitcollege.knowledgecybersecuritywebservice.controller;

import com.bitcollege.knowledgecybersecuritywebservice.dto.PaperForList;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Paper;
import com.bitcollege.knowledgecybersecuritywebservice.entity.UserPaper;
import com.bitcollege.knowledgecybersecuritywebservice.service.PaperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PaperController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/knowledge-units/{kuId}/sectors/{sId}/papers/{userId}")
    public ResponseEntity<?> searchPaper(@PathVariable Long kuId,
                                   @PathVariable Long sId,
                                   @RequestParam (defaultValue = "", required = false) String keywords ,
                                   @RequestParam (defaultValue = "", required = false) String koId,
                                   @RequestParam (defaultValue = "", required = false) String startYear,
                                   @RequestParam (defaultValue = "", required = false) String endYear,
                                   @RequestParam (defaultValue = "", required = false) String title,
                                   @RequestParam (defaultValue = "", required = false) String doi,
                                   @RequestParam (defaultValue = "", required = false) String author,
                                   @PathVariable Long userId
                                   ){

        List<Paper> papers = paperService.searchPaper(
                kuId,
                sId,
                keywords.equals("") ? null : keywords,
                koId.isEmpty() ? null : Long.valueOf(koId),
                startYear.isEmpty() ? null : Integer.valueOf(startYear),
                endYear.isEmpty() ? null : Integer.valueOf(endYear),
                title.isEmpty() ? null : title,
                doi.isEmpty() ? null : doi,
                author.isEmpty() ? null : author);

        System.out.println(papers);

        List<PaperForList> paperForLists = papers.stream().map(x -> {
            PaperForList paperForList = modelMapper.map(x, PaperForList.class);
            UserPaper userPaper = x.getUserPapers().stream().filter(y -> y.getIdUser().equals(userId)).findFirst().orElse(null);
            if(userPaper != null) {
                paperForList.setIsFavoriteForThisUser(true);
            } else  {
                paperForList.setIsFavoriteForThisUser(false);
            }
            return paperForList;
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(paperForLists);

    }

}
