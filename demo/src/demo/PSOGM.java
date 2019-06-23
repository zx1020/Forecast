package demo;

import PSOGMYC.*;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

public class PSOGM {
	public static void main(String[] args) throws MWException {
		getpsogm(5,7,20170107);
	}
	
    public static String[] getpsogm(int ybs, int ts, int rq) throws MWException{
		
		yucezhi psogm = null;   //yucezhi�Ǵ��ʱ�����classname�����ڵ���matlab����
		Object[] result= null;//���ڱ����������
		double[] res=new double[50];
	    String arry[]=new String[50];
	    
		try{
		    psogm=new yucezhi();    //��ʼ��matlab����
		    result=psogm.PSOGMYC(1, ybs,ts,rq); //����matlab�ķ���
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
		    if (psogm != null)    //�ͷŽ�����matlab�����
	            psogm.dispose();
	         }
			
			return arry; 
	}
	

}
