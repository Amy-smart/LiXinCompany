package com.atlixin.yygh.controller;

import com.atlixin.yygh.common.result.Result;
import com.atlixin.yygh.model.cmn.Dict;
import com.atlixin.yygh.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api("数据字典接口")
@RestController
@RequestMapping("/admin/cmn/dict")
@CrossOrigin
public class DictController {

    @Autowired
    DictService dictService;

    // 查询子数据
    @ApiOperation(value = "根据数据id查询子数据列表")
    @GetMapping("/findChild/{id}")
    public Result findChildData(@PathVariable Long id) {
        List<Dict> list = dictService.findChlidData(id);
        return Result.ok(list);
    }
}
