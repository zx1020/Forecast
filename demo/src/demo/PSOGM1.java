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
	
	yucezhi psogm1 = null;   //yucezhi�Ǵ��ʱ�����classname�����ڵ���matlab����
	Object[] result= null;//���ڱ����������
	double[] res=new double[50];
    String arry[]=new String[50];
	try{
	    psogm1=new yucezhi();    //��ʼ��matlab����
	    result=psogm1.PSOGMYC11(1, ybs,ts,rq); 
	    MWNumericArray output = (MWNumericArray)result[0];//�����objectת����MWNumericArray
	    res=output.getDoubleData(); //��MWNumericArray�����ж�ȡ���ݣ�������������� 
	    for(int i=0;i<ts;i++){
	    	double d=res[i+1];
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
	    if (psogm1 != null)    //�ͷŽ�����matlab�����
            psogm1.dispose();
         }
		
		return arry; 
}


}