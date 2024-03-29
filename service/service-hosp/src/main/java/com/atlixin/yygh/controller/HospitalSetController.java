package com.atlixin.yygh.controller;

import com.atlixin.yygh.service.HospitalSetService;
import com.atlixin.yygh.model.hosp.HospitalSet;
import com.atlixin.yygh.common.result.Result;
import com.atlixin.yygh.config.MD5;
import com.atlixin.yygh.vo.hosp.HospitalSetQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/admin/hosp/hospitalSet")
@CrossOrigin
public class HospitalSetController {
    @Autowired
    HospitalSetService hospitalSetService;

    // 1 查询医院设置表所有信息
    @GetMapping("/findAll")
    public Result<List<HospitalSet>> findAllHospSet() {
        List<HospitalSet> list = hospitalSetService.list();
        return Result.ok(list);
    }

    // 2 删除
    @DeleteMapping("/deleteById/{id}")
    public Result deleteHostSetById(@PathVariable Long id) {

        boolean flag = hospitalSetService.removeById(id);
//        if (flag) {
//            return Result.ok();
//        } else {
//            return Result.fail();
//        }
        return Result.ok();
    }
    // 3 分页查询
    @PostMapping("/findPageHospSet/{currentPage}/{limit}")
    public Result findPageHospSet(@PathVariable Long currentPage,
                                  @PathVariable Long limit,
                                  @RequestBody(required = false) HospitalSetQueryVo hospitalQueryVo) {
        Page<HospitalSet> page = new Page<>(currentPage, limit);
        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        String hoscode = hospitalQueryVo.getHoscode();
        String hosname = hospitalQueryVo.getHosname();
        if (!StringUtils.isEmpty(hoscode)) {
            queryWrapper.eq("hoscode", hoscode);
        }
        if (!StringUtils.isEmpty(hosname)) {
            queryWrapper.like("hosname", hosname);
        }
        Page<HospitalSet> pageHosSet = hospitalSetService.page(page, queryWrapper);
        return Result.ok(pageHosSet);
    }
    // 4 添加医院设置
    @PostMapping("/saveHospSet")
    public Result saveHospSet(@RequestBody HospitalSet hospitalSet) {
        Random random = new Random();
        hospitalSet.setStatus(0);
        hospitalSet.setSignKey(MD5.encrypt((System.currentTimeMillis())+ ""+random.nextInt(1000)));
        boolean save = hospitalSetService.save(hospitalSet);
//        if (save) {
//            return Result.ok();
//        } else {
//            return Result.fail();
//        }
        return Result.ok();
    }
    // 5 根据ID获取医院设置
    @PostMapping("/findHospSetById/{id}")
    public Result findHospSetById(@PathVariable Long id) {
        HospitalSet byId = hospitalSetService.getById(id);
        return Result.ok(byId);
    }

    // 6 修改医院设置
    @PostMapping("/updateHospSet")
    public Result updateHospSet(@RequestBody HospitalSet hospitalSet) {
        boolean updateById = hospitalSetService.updateById(hospitalSet);
        if (updateById) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 7 批量删除医院设置
    @DeleteMapping("/batchRemove")
    public Result batchRemoveHospitalSet(@RequestBody List<Long> list) {
        boolean falg = hospitalSetService.removeByIds(list);
//        if (falg) {
//            return Result.ok();
//        } else {
//            return Result.fail();
//        }
        return Result.ok();
    }

    // 8 医院锁定和解锁
    @PostMapping("/lockHospitalSet/{id}/{status}")
    public Result lockHospitalSet(@PathVariable Long id,
                                  @PathVariable Integer status) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        hospitalSet.setStatus(status);
        boolean flag = hospitalSetService.updateById(hospitalSet);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 9 发送签名密钥
    @PutMapping("/sendKey/{id}")
    public Result sendKey(@PathVariable Long id) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        hospitalSet.getSignKey();
        hospitalSet.getHoscode();
        // TODO 短信发送
        return Result.ok();
    }

}
