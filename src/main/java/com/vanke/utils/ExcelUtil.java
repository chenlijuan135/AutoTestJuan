package com.vanke.utils;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
class ExcelUtil {
     static void writeExcel(OutputStream os) throws IOException, WriteException {

        //创建工作簿
        WritableWorkbook workbook = Workbook.createWorkbook(os);
        //创建sheet
        WritableSheet sheet = workbook.createSheet("sheetTest1",0);
        //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
        Label label1=new Label(0,0,"编号");
        sheet.addCell(label1);
        Label label2=new Label(0,1,"001");
        sheet.addCell(label2);

        Label label3=new Label(1,0,"姓名");
        sheet.addCell(label3);
        Label label4=new Label(1,1,"陈丽娟");
        sheet.addCell(label4);

        Label label5=new Label(2,0,"职业");
        sheet.addCell(label5);
        Label label6=new Label(2,1,"teacher");
        sheet.addCell(label6);

        Label label7=new Label(3,0,"时间");
        sheet.addCell(label7);
        //日期型数据
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        WritableCellFormat cf1 = new WritableCellFormat(DateFormats.FORMAT2);
        DateTime dt = new DateTime(3,1,date,cf1);
        sheet.addCell(dt);

        //把创建的内容写入到输出流中，并关闭输出流
        workbook.write();
        workbook.close();
        os.close();
    }

    static void readExcel(File file) throws IOException, BiffException{
        Workbook wb = Workbook.getWorkbook(file);//从文件流中取得Excel工作区对象
        Sheet sheet = wb.getSheet(0);//从工作区中取得页
        // Date date = null;
        for (int i = 0; i < sheet.getRows(); i++) {
            for (int j = 0; j < sheet.getColumns(); j++) {
                Cell cell = sheet.getCell(j, i);
                String str=cell.getContents();
               // DateTime accessTime = null;
                //日期格式处理方式：
                if(i==3) {
                    if (cell.getType() == CellType.DATE) {
                        DateCell dc = (DateCell)cell;
                        Date date = dc.getDate();    //获取单元格的date类型
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//HH:mm:ss

                        System.out.println(dateFormat.format(date));
                    }
                }
                else
                {
                    System.out.println(str);
                }

            }
        }

    }
}
