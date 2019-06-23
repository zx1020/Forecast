
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
	
	yucezhi arma = null;   //yucezhi�Ǵ��ʱ�����classname�����ڵ���matlab����
	Object[] result= null;//���ڱ����������
	double[] res=new double[50];
    String arry[]=new String[50];
	try{
		arma=new yucezhi();    //��ʼ��matlab����
	    result=arma.ARMA(1, ybs,ts,rq); //����matlab�ķ�����GMYC��.m�ļ���function����
	    MWNumericArray output = (MWNumericArray)result[0];//�����objectת����MWNumericArray
	    res=output.getDoubleData(); //��MWNumericArray�����ж�ȡ���ݣ�������������� 
	    for(int i=0;i<ts;i++){
	    	double d=res[i];
	    	arry[i] = String.format("%.1f",d);
	    }
	   System.out.println(arry[0]); //�ڿ���̨������
	  
	   }
	
	    catch (Exception e)
         {
             System.out.println("Exception: " + e.toString());
         }
       
         finally
         {
	 // �ͷű�����Դ
	    MWArray.disposeArray(result);//�ͷŽ�����Object����
	    if (arma != null)    //�ͷŽ�����matlab�����
	    	arma.dispose();
         }
		
		return arry; 
 }
}