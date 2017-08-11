package com.lirun.tempFileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TempFiletest {

	@Test
	public void Test() {
		File file = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			file = File.createTempFile("lirun", ".xls");
			fis = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\Excel\\1.xls"));
			fos = new FileOutputStream(file);
			byte[] b = new byte[1024];
			int len = 0;
			while((len = fis.read(b))!=-1){
				fos.write(b, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				file.deleteOnExit();
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(file);
		System.out.println("end");
	}
}
