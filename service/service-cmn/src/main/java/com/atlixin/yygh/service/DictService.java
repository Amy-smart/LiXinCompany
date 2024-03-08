package com.atlixin.yygh.service;


import com.atlixin.yygh.model.cmn.Dict;
import com.atlixin.yygh.vo.cmn.DictEeVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DictService extends IService<Dict> {
    // 导出
    void exportDic(HttpServletResponse response);

    // 根据数据id查询子数据列表
    List<Dict> findChlidData(Long id);

}
