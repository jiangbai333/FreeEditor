/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author hsoft
 */
public final class excelUtil {
    
    /**
     * 
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static List<List<String>> getList(String path) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        List<List<String>> result = new ArrayList<List<String>>();

        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

        for ( int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++ ) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);

                int minColIx = xssfRow.getFirstCellNum();
                int maxColIx = xssfRow.getLastCellNum();

                List<String> rowList = new ArrayList<String>();

                for ( int colIx = minColIx; colIx < maxColIx; colIx++ ) {
                        XSSFCell cell = xssfRow.getCell(colIx);
                        if (cell == null) {
                                continue;
                        }
                        rowList.add(transform(cell));
                }

                result.add(rowList);
        }
        return result;
    }
    
    private static String transform(XSSFCell cell) {
        switch ( cell.getCellType() ) {
            case Cell.CELL_TYPE_NUMERIC :
                cell.setCellType(Cell.CELL_TYPE_STRING);
                return cell.getStringCellValue();
            default:
                return cell.getStringCellValue();
        }
    }
}
