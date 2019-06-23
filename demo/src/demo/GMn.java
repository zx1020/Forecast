package demo;
import RQSJ.*;
import GMn.*;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

public class GMn {
	public static void main(String[] args) throws MWException {
		gethuiseyc(10,7,20170111);
		gethuisesj(10,7,20170111);
		gethuiserq(10,7,20170111);
	}
	public static String[] gethuiseyc(int ybs, int ts, int rq) throws MWException{
		
		yucezhi thegray = null;   //yucezhi是打包时定义的classname，用于调用matlab程序
		Object[] result= null;//用于保存计算结果。
		double[] res=new double[50];
	    String arry[]=new String[50];
	    
		try{
		
		    thegray=new yucezhi();    //初始化matlab对象
		    result=thegray.GMYC(1, ybs,ts,rq);  //调用matlab的方法，GMYC是.m文件中function名字
		    MWNumericArray output = (MWNumericArray)result[0];//将结果object转换成MWNumericArray
		    res=output.getDoubleData(); //从MWNumericArray对象中读取数据，将结果存入数组 
		    for(int i=0;i<ts;i++){
		    	double d=res[i+1];
		    	arry[i] = String.format("%.1f",d);
		    }
		   System.out.println(arry[0]); //在控制台输出结果
		  
		   }
		
		    catch (Exception e)
	         {
	             System.out.println("Exception: " + e.toString());
	         }
	       
	         finally
	         {
		 // 释放本地资源
		    MWArray.disposeArray(result);//释放建立的Object数组
		    if (thegray != null)    //释放建立的matlab类对象
	            thegray.dispose();
	         }
			
			return arry; 
	}
	
	public static String[] gethuisesj(int ybs, int ts, int rq) throws MWException{
			
			shijizhi thegray = null;   //shijizhi是打包时定义的classname，用于调用matlab程序
			Object[] result= null;//用于保存计算结果。
			double[] res=new double[50];
		    String arry[]=new String[50];
			try{
			
			    thegray=new shijizhi();    //初始化matlab对象
			    result=thegray.GMSJ(1, ybs,ts,rq);  //调用matlab的方法，GMSJ是.m文件中function名字
			    MWNumericArray output = (MWNumericArray)result[0];//将结果object转换成MWNumericArray
			    res=output.getDoubleData(); //从MWNumericArray对象中读取数据，将结果存入数组 
			    for(int i=0;i<ts;i++){
			    	arry[i] = String.valueOf(res[i]);
			    }
			    System.out.println(res[0]); //在控制台输出结果
			    }
			
			    catch (Exception e)
		         {
		             System.out.println("Exception: " + e.toString());
		         }
		       
		         finally
		         {
			 // 释放本地资源
			    MWArray.disposeArray(result);//释放建立的Object数组
			    if (thegray != null)    //释放建立的matlab类对象
		            thegray.dispose();
		         }
				
				return arry; 
		}
	public static int[] gethuiserq(int ybs, int ts, int rq) throws MWException{
		
		riqi thegray = null;   //riqi是打包时定义的classname，用于调用matlab程序
		Object[] result= null;//用于保存计算结果。
		int[] res=new int[50];
		try{
		
		    thegray=new riqi();    //初始化matlab对象
		    result=thegray.GMRQ(1, ybs,ts,rq);  //调用matlab的方法，GMRQ是.m文件中function名字
		    MWNumericArray output = (MWNumericArray)result[0];//将结果object转换成MWNumericArray
		    res=output.getIntData(); //从MWNumericArray对象中读取数据，将结果存入数组   
		    System.out.println(res[0]); //在控制台输出结果
		    }
		
		    catch (Exception e)
	         {
	             System.out.println("Exception: " + e.toString());
	         }
	       
	         finally
	         {
		 // 释放本地资源
		    MWArray.disposeArray(result);//释放建立的Object数组
		    if (thegray != null)    //释放建立的matlab类对象
	            thegray.dispose();
	         }
			
			return res; 
	}
}    