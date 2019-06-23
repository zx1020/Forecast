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
		
		yucezhi huise1 = null;   //yucezhi�Ǵ��ʱ�����classname�����ڵ���matlab����
		Object[] result= null;//���ڱ����������
		double[] res=new double[50];
	    String arry[]=new String[50];
	    
		try{
		
		    huise1=new yucezhi();    //��ʼ��matlab����
		    result=huise1.getGM(1, ybs,ts,rq); //����matlab�ķ���
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
		    if (huise1 != null)    //�ͷŽ�����matlab�����
	            huise1.dispose();
	         }
			
			return arry; 
	}
	



}
