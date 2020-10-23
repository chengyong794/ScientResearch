package com.chengyong.util;

/**
 * 系统数据导出Excel 生成器
 *
 */

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExportProjectUtils {

    private final int SPLIT_COUNT = 65536; //Excel每个工作簿的行数

    private List<String> fieldName = null; //excel标题数据集

    private List<List<String>> fieldData = null; //excel数据内容

    private HSSFWorkbook workBook = null;

    /**
     * 构造器
     * @param fieldName 结果集的字段名
     * @param fieldData
     */
    public ExportProjectUtils(List<String> fieldName, List<List<String>> fieldData) {
        //字段名
        this.fieldName = fieldName;
        //数据
        this.fieldData = fieldData;
    }

    /**
     * 完成xls表创建
     * 创建HSSFWorkbook对象
     * @return HSSFWorkbook
     */
    public HSSFWorkbook createWorkbook() throws IOException {
        workBook = new HSSFWorkbook();//创建一个工作薄对象
        int rows = fieldData.size();//总的记录数
        int sheetNum = 0;           //指定sheet的页数

        if (rows % SPLIT_COUNT == 0) {
            sheetNum = rows / SPLIT_COUNT;
        } else {
            sheetNum = rows / SPLIT_COUNT + 1;
        }

        for (int i = 1; i <= sheetNum; i++) {//循环2个sheet的值
            HSSFSheet sheet = workBook.createSheet("Page " + i);//使用workbook对象创建sheet对象
            HSSFRow headRow = sheet.createRow((short) 0); //创建行，0表示第一行（本例是excel的标题）
            for (int j = 0; j < fieldName.size(); j++) {//循环excel的标题
                HSSFCell cell = headRow.createCell( j);//使用行对象创建列对象，0表示第1列
                /**************对标题添加样式begin********************/
                //设置列的宽度/
                sheet.setColumnWidth(j, 6000);
                HSSFCellStyle cellStyle = workBook.createCellStyle();//创建列的样式对象
                HSSFFont font = workBook.createFont();//创建字体对象
                //字体加粗
                font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                //字体颜色变红
                font.setColor(HSSFColor.RED.index);
                //如果font中存在设置后的字体，并放置到cellStyle对象中，此时该单元格中就具有了样式字体
                cellStyle.setFont(font);
                /**************对标题添加样式end********************/

                //添加样式
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);

                if(fieldName.get(j) != null){
                    //将创建好的样式放置到对应的单元格中
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue((String) fieldName.get(j));//为标题中的单元格设置值
                }else{
                    cell.setCellValue("-");
                }
            }
            //分页处理excel的数据，遍历所有的结果
            for (int k = 0; k < (rows < SPLIT_COUNT ? rows : SPLIT_COUNT); k++) {
                if (((i - 1) * SPLIT_COUNT + k) >= rows)//如果数据超出总的记录数的时候，就退出循环
                    break;
                HSSFRow row = sheet.createRow((short) (k + 1));//创建1行
                //分页处理，获取每页的结果集，并将数据内容放入excel单元格
                List<String> rowList = (List<String>) fieldData.get((i - 1) * SPLIT_COUNT + k);
                for (int n = 0; n < rowList.size(); n++) {//遍历某一行的结果
                    HSSFCell cell = row.createCell( n);//使用行创建列对象
                    if(rowList.get(n) != null){
                        cell.setCellValue((String) rowList.get(n).toString());
                    }else{
                        cell.setCellValue("");
                    }
                }
            }
        }

        return workBook;
    }

    public void expordExcel(OutputStream os) throws Exception {
        workBook = createWorkbook();
        workBook.write(os);//将excel中的数据写到输出流中，用于文件的输出
        os.close();
    }

    //解决设置名称时的乱码
    public static String processFileName(HttpServletRequest request, String fileNames) {
        String codedfilename = null;
        try {
            String agent = request.getHeader("USER-AGENT");
            if (null != agent && -1 != agent.indexOf("MSIE") || null != agent
                    && -1 != agent.indexOf("Trident")) {// ie

                String name = java.net.URLEncoder.encode(fileNames, "UTF8");

                codedfilename = name;
            } else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等


                codedfilename = new String(fileNames.getBytes("UTF-8"), "iso-8859-1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codedfilename;
    }
}
