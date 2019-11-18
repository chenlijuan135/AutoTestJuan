package com.vanke.utils;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test {
    public static void test1() throws IOException, WriteException, BiffException {
        OutputStream os = new FileOutputStream(new File("D:/test1.xls"));
        ExcelUtil.writeExcel(os);
        ExcelUtil.readExcel(new File("D:/test1.xls"));
        System.out.println("dev1");
        System.out.println("dev2");
    }
}
