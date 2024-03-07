package com.atlixin.yygh.mapper;

import com.atlixin.yygh.model.cmn.Dict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DicMapper extends BaseMapper<Dict> {
//    List<Dict> selectByParentIdDictList(Long id);
}
