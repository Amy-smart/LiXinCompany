package com.atlixin.yygh.service;


import com.atlixin.yygh.model.cmn.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DictService extends IService<Dict> {
    // 根据父id查询下面的子数据
//    List<Dict> selectChild(Long id);

    // 根据数据id查询子数据列表
    List<Dict> findChlidData(Long id);

}
