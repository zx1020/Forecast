package demo;
import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

import GM1.*;

public class GM1 {

	public static void main(String[] args) throws MWException {
		gethuise1(5,7,20170107);
	}
	
    public static String[] gethuise1(int ybs, int ts, int rq) throws MWException{
		
		yucezhi huise1 = null;   //yucezhi是打包时定义的classname，用于调用matlab程序
		Object[] result= null;//用于保存计算结果。
		double[] res=new double[50];
	    String arry[]=new String[50];
	    
		try{
		
		    huise1=new yucezhi();    //初始化matlab对象
		    result=huise1.getGM(1, ybs,ts,rq); //调用matlab的方法
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
		    if (huise1 != null)    //释放建立的matlab类对象
	            huise1.dispose();
	         }
			
			return arry; 
	}
	



}
