package com.atlixin.yygh.test;

import com.alibaba.excel.EasyExcel;

public class EasyExcelRead {
    public static void main(String[] args) {
        String fileName = "/Users/lx/excel测试.xls";
        EasyExcel.read(fileName, UEntity.class, new  EasyExcelListener()).sheet().doRead();

    }
}
