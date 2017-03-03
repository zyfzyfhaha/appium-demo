package com.cheguo.tuoche;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class tuoche {
	
	public static void main(String[] args) throws IOException{
			  try {
				  Desktop.getDesktop().open(new File("src/rescources/test.bat"));
		 //		  Process  process =  Runtime.getRuntime().exec("cmd.exe /c start F:\\jenkins\\workspace\\test.exe");
		 //		  String a = process.getOutputStream().toString();

			  } catch (IOException e) {
			   e.printStackTrace();
			  }
			 }
	}


