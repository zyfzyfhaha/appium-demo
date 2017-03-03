package com.cheguo.tuoche;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class App {
  
  //执行语句:start java -Xmx256m -Xms128m -jar spider.jar
  public static void main(String args[]){
        try {
          File apkDir=new File("F:\\jenkins\\workspace\\machine_install_tuoche\\app\\apks");
        if(!apkDir.exists()||apkDir.listFiles().length==0){
          System.out.println("请现在jenkins平台上点击立即构建或构建出问题了");
          return ;
        }
        File[] apkFileArr=apkDir.listFiles();
        Map<Integer,File> fileMap=new HashMap<>();
        for(int i=0;i<apkFileArr.length;i++){
          fileMap.put(i+1, apkFileArr[i]);
        }
        
        //输出提示选项
        System.out.println("===================输入选项===================");
        Iterator<Integer> iterator=fileMap.keySet().iterator();
        while(iterator.hasNext()){
          Integer key=iterator.next();
          File value=fileMap.get(key);
          System.out.println(value+"   <---->   "+key);;
        }
          
            System.out.print("请输入安装包后面的选项:");  
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s=null;
            int inputKey=-1;
            while((s= br.readLine())!=null){
              try {
          inputKey=Integer.parseInt(s);
        } catch (Exception e) {
        }
              if(fileMap.get(inputKey)!=null){
                break;
              }else{
                System.out.println("请输入争正确的选项值");
              }
            }
//            br.close();
//            System.in.close();
            File selectApkFile=fileMap.get(inputKey);
            System.out.println("您选择安装的包为:"+selectApkFile.getName());
            
            System.out.println("===========开始安装==================");
            String cmdStr="adb install -r "+selectApkFile.getAbsolutePath();
            Process process=Runtime.getRuntime().exec(cmdStr);
            InputStream is=process.getInputStream();
            BufferedReader infoReader=new BufferedReader(new InputStreamReader(process.getInputStream()));
            while((s=infoReader.readLine())!=null){
              System.out.println("安装进度----"+s);
            }
            infoReader.close();
            System.out.println("安装完成");
            
            //停住界面
            System.out.println("按q键退出");
            br = new BufferedReader(new InputStreamReader(System.in));
            s=null;
            while((s= br.readLine())!=null){
              if(s.equals("q")){
                break;
              }
            }
            br.close();
            
            //显示安装结果界面1分钟
//            Thread.sleep(60*1000);
        } catch (Exception e) {
            e.printStackTrace();  
        }  
  }

}
