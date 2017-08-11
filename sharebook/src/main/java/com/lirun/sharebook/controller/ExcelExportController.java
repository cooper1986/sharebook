package com.lirun.sharebook.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lirun.sharebook.utils.ExcelUtils;
import com.lirun.sharebook.vo.Students;

@Controller
public class ExcelExportController {

	public static <T> File setExcelExport(String[] column,List<T> dataList){
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		// sheet
		HSSFSheet sheet = workbook.createSheet("批量人员导出");
		sheet.setColumnWidth(1, 3000);//姓名
		sheet.setColumnWidth(3, 6000);//身份证号
		sheet.setColumnWidth(4, 6000);//单位名称
		sheet.setColumnWidth(5, 3000);//联系电话
		sheet.setColumnWidth(6, 6000);//联系地址
		sheet.setColumnWidth(7, 8000);//备注
		
		//title
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, column.length-1));
		HSSFCell title_cell = sheet.createRow(0).createCell(0);
		title_cell.setCellValue("2016全国双创周工作人员信息采集表");
		title_cell.setCellStyle(ExcelUtils.getStyle(workbook, ExcelUtils.TITLE_STYLE));
		//column
		HSSFRow row_title = sheet.createRow(1);
		for (int i = 0; i < column.length; i++) {
			HSSFCell cell = row_title.createCell(i);
			cell.setCellStyle(ExcelUtils.getStyle(workbook, ExcelUtils.COLUMN_STYLE));
			cell.setCellValue(column[i]);
		}
		//data
		Field[] params = null;
		HSSFRow row_value = null;
		FileOutputStream fos = null;
		HSSFCell dataCell = null;
		File file = null;
		for (int i = 0; i < dataList.size(); i++) {
			row_value = sheet.createRow(i + 2);
			params = dataList.get(i).getClass().getDeclaredFields();
			for (int j = 0; j < params.length; j++) {
				params[j].setAccessible(true);
				try {
					dataCell = row_value.createCell(j);
					dataCell.setCellStyle(ExcelUtils.getStyle(workbook, ExcelUtils.DATA_STYLE));
					dataCell.setCellValue(params[j].get(dataList.get(i)).toString());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		try {
//			file = new File("C:/Users/Administrator/Desktop/Excel/"+System.currentTimeMillis()+".xls");
			file = File.createTempFile(String.valueOf(System.currentTimeMillis()), ".xls");
			if(!file.exists()){
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		    fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				file.deleteOnExit();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
		
		
		
		
		
		
	}
	
	@RequestMapping("/excelExport.do")
	@ResponseBody
	public String exportExcel(HttpServletRequest request)
			throws IllegalArgumentException, IllegalAccessException {
		String[] title = { "序号", "姓名", "性别","身份证号","单位名称","联系电话","联系地址","备注" };

		List<Students> list = new ArrayList<Students>();
		list.add(new Students(1, "li", 2));
		list.add(new Students(2, "zhao", 2));
		list.add(new Students(3, "wang", 2));
		list.add(new Students(4, "jiang", 2));
		
		File file = setExcelExport(title,list);
		System.out.println(file);

		return null;
	}
}
