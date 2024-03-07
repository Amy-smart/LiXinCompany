package com.atlixin.yygh.test;


import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class EasyExcelWrite {
    public static void main(String[] args) {

        // 实现写操作
        List<UEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UEntity u = new UEntity();
            u.setId(i);
            u.setName("lixin" + i);
            list.add(u);
        }
        String fileName = "/Users/lx/excel测试.xls";
        EasyExcel.write(fileName, UEntity.class).sheet().doWrite(list);

    }
}
