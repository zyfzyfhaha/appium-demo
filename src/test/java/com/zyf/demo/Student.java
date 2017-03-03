package com.zyf.demo;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class Student {
		
	
//	public static void main(String [] args){
//		HashMap map = new HashMap();
//		map.put("01","student");
//	}


	String name;
	String sex;
	
	public Student(String name,String sex) {
	this.name=name;
	this.sex=sex;
	}
	
	public String toString(){
	return ("姓名:"+this.name+"\n"+"性别:"+this.sex+"\n"); 
	}
	
	
	public static void main(String [] args){
	HashMap hm=new HashMap();
	Student s1=new Student("张三","男");
	Student s2=new Student("李四","男");
	Student s3=new Student("小利","女");
	
	//存值是根据学生编号存的学生信息
	hm.put("001",s1);
	hm.put("002",s2);
	hm.put("003",s3);
	
	//查找学生编号是001的学生aaa
	//因为hm.get("001")反回的是Object所以加上强转
	Student s=(Student)hm.get("001");
	System.out.println(s);
	//其余的类似
	}
	
	Map map = new HashMap();
	
	

}
