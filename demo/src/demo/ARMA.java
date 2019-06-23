
package demo;


import ARMA.*;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

public class ARMA {
	public static void main(String[] args) throws MWException {
		getarma(10,8,20170120);
	}
	
	public static String[] getarma(int ybs, int ts, int rq) throws MWException{
	
	yucezhi arma = null;   //yucezhi是打包时定义的classname，用于调用matlab程序
	Object[] result= null;//用于保存计算结果。
	double[] res=new double[50];
    String arry[]=new String[50];
	try{
		arma=new yucezhi();    //初始化matlab对象
	    result=arma.ARMA(1, ybs,ts,rq); //调用matlab的方法，GMYC是.m文件中function名字
	    MWNumericArray output = (MWNumericArray)result[0];//将结果object转换成MWNumericArray
	    res=output.getDoubleData(); //从MWNumericArray对象中读取数据，将结果存入数组 
	    for(int i=0;i<ts;i++){
	    	double d=res[i];
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
	    if (arma != null)    //释放建立的matlab类对象
	    	arma.dispose();
         }
		
		return arry; 
 }
}