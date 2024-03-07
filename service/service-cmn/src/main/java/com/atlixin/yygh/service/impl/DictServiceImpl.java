package com.atlixin.yygh.service.impl;

import com.atlixin.yygh.mapper.DicMapper;
import com.atlixin.yygh.model.cmn.Dict;
import com.atlixin.yygh.service.DictService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl extends ServiceImpl<DicMapper, Dict> implements DictService {

//    @Override
//    public List<Dict> selectChild(Long id) {
//        return dicMapper.selectByParentIdDictList(id);
//    }

    // 根据数据id查询子数据列表
    @Override
    public List<Dict> findChlidData(Long id) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        List<Dict> dictList = baseMapper.selectList(wrapper);
        // 向list集合每个dict对象中设置hasChildren
        for (Dict dict:dictList) {
            Long dictId = dict.getId();
            boolean isChild = this.isChildren(dictId);
            dict.setHasChildren(isChild);
        }
        return dictList;
    }
    //判断id下面是否有子节点
    private boolean isChildren(Long id) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        Integer count = baseMapper.selectCount(wrapper);
        // 0>0    1>0
        return count>0;
    }

}
