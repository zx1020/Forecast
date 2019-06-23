package demo;


import PSOGMYC11.*;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

public class PSOGM1 {
	public static void main(String[] args) throws MWException {
		getpsogm1(5,12,201401);
	}
	
	public static String[] getpsogm1(int ybs, int ts, int rq) throws MWException{
	
	yucezhi psogm1 = null;   //yucezhi是打包时定义的classname，用于调用matlab程序
	Object[] result= null;//用于保存计算结果。
	double[] res=new double[50];
    String arry[]=new String[50];
	try{
	    psogm1=new yucezhi();    //初始化matlab对象
	    result=psogm1.PSOGMYC11(1, ybs,ts,rq); 
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
	    if (psogm1 != null)    //释放建立的matlab类对象
            psogm1.dispose();
         }
		
		return arry; 
}


}