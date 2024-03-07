package com.atlixin.yygh.test;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class EasyExcelListener extends AnalysisEventListener<UEntity> {

    // 读取内容表头除外
    @Override
    public void invoke(UEntity uEntity, AnalysisContext analysisContext) {
        System.out.println(uEntity);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头信息" + headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
