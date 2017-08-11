package com.lirun.sharebook.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {
	

	public final static String TITLE_STYLE = "titleStyle";
	public final static String COLUMN_STYLE = "columnStyle";
	public final static String DATA_STYLE = "dataStyle";
	
	public static HSSFWorkbook getHSSFWorkbook(String sheetName,
			String[] title, String[][] values, HSSFWorkbook wb) {
		// 第一步，创建一个webbook，对应一个Excel文件
		if (wb == null) {
			wb = new HSSFWorkbook();
		}
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet(sheetName);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = null;
		// 创建标题
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}

		return wb;
	}
	public static HSSFCellStyle getStyle(HSSFWorkbook workbook,String param){
//		HashMap<String,HSSFCellStyle> map = new HashMap<String,HSSFCellStyle>();
		//title sytle
		HSSFCellStyle titleStyle = workbook.createCellStyle();
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		HSSFFont titleFont = workbook.createFont();
		titleFont.setFontHeightInPoints((short) 20);
		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		titleStyle.setFont(titleFont);
		//column style
		HSSFCellStyle columnStyle = workbook.createCellStyle();
		columnStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		columnStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		columnStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		columnStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		columnStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		HSSFFont columnFont = workbook.createFont();
		columnFont.setFontHeightInPoints((short) 12);
		columnFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		columnStyle.setFont(columnFont);
		//data style
		HSSFCellStyle dataStyle = workbook.createCellStyle();
		dataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		dataStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		dataStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		dataStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		dataStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		
//		map.put("titleStyle", titleStyle);
//		map.put("columnStyle", columnStyle);
//		map.put("dataStyle", dataStyle);
		if(TITLE_STYLE.equals(param)){
			return titleStyle;
		}else if(COLUMN_STYLE.equals(param)){ 
			return columnStyle;
		}else if(DATA_STYLE.equals(param)){
			return dataStyle;
		}
		return null;
	}
}
