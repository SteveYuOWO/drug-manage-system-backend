package com.steveyu.drugmanagesystem.api;

import com.steveyu.drugmanagesystem.dto.DrugCommentDto;
import com.steveyu.drugmanagesystem.entity.DrugComment;
import com.steveyu.drugmanagesystem.service.DrugCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/drugcomment")
public class DrugCommentApi {
    @Autowired
    DrugCommentService drugCommentService;

    @PostMapping
    public String saveDrugComment(@RequestBody DrugCommentDto drugCommentDto) {
        drugCommentService.saveDrugComment(drugCommentDto);
        return "插入成功";
    }

    @GetMapping("{page}/{size}/{drugId}")
    public Page<DrugComment> getAllDrugCommentsByDrugId(@PathVariable("page") Integer page,
                                    @PathVariable("size") Integer size,
                                    @PathVariable("drugId") Integer drugId) {
        return drugCommentService.getAllDrugCommentsByDrugId(PageRequest.of(page, size), drugId);
    }

    @DeleteMapping("{id}")
    public String deleteDrugCommentById(@PathVariable("id") Integer id) {
        return drugCommentService.deleteDrugCommentById(id) ? "删除成功": "删除失败";
    }
}
