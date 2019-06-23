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
		
		yucezhi thegray = null;   //yucezhi�Ǵ��ʱ�����classname�����ڵ���matlab����
		Object[] result= null;//���ڱ����������
		double[] res=new double[50];
	    String arry[]=new String[50];
	    
		try{
		
		    thegray=new yucezhi();    //��ʼ��matlab����
		    result=thegray.GMYC(1, ybs,ts,rq);  //����matlab�ķ�����GMYC��.m�ļ���function����
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
		    if (thegray != null)    //�ͷŽ�����matlab�����
	            thegray.dispose();
	         }
			
			return arry; 
	}
	
	public static String[] gethuisesj(int ybs, int ts, int rq) throws MWException{
			
			shijizhi thegray = null;   //shijizhi�Ǵ��ʱ�����classname�����ڵ���matlab����
			Object[] result= null;//���ڱ����������
			double[] res=new double[50];
		    String arry[]=new String[50];
			try{
			
			    thegray=new shijizhi();    //��ʼ��matlab����
			    result=thegray.GMSJ(1, ybs,ts,rq);  //����matlab�ķ�����GMSJ��.m�ļ���function����
			    MWNumericArray output = (MWNumericArray)result[0];//�����objectת����MWNumericArray
			    res=output.getDoubleData(); //��MWNumericArray�����ж�ȡ���ݣ�������������� 
			    for(int i=0;i<ts;i++){
			    	arry[i] = String.valueOf(res[i]);
			    }
			    System.out.println(res[0]); //�ڿ���̨������
			    }
			
			    catch (Exception e)
		         {
		             System.out.println("Exception: " + e.toString());
		         }
		       
		         finally
		         {
			 // �ͷű�����Դ
			    MWArray.disposeArray(result);//�ͷŽ�����Object����
			    if (thegray != null)    //�ͷŽ�����matlab�����
		            thegray.dispose();
		         }
				
				return arry; 
		}
	public static int[] gethuiserq(int ybs, int ts, int rq) throws MWException{
		
		riqi thegray = null;   //riqi�Ǵ��ʱ�����classname�����ڵ���matlab����
		Object[] result= null;//���ڱ����������
		int[] res=new int[50];
		try{
		
		    thegray=new riqi();    //��ʼ��matlab����
		    result=thegray.GMRQ(1, ybs,ts,rq);  //����matlab�ķ�����GMRQ��.m�ļ���function����
		    MWNumericArray output = (MWNumericArray)result[0];//�����objectת����MWNumericArray
		    res=output.getIntData(); //��MWNumericArray�����ж�ȡ���ݣ��������������   
		    System.out.println(res[0]); //�ڿ���̨������
		    }
		
		    catch (Exception e)
	         {
	             System.out.println("Exception: " + e.toString());
	         }
	       
	         finally
	         {
		 // �ͷű�����Դ
		    MWArray.disposeArray(result);//�ͷŽ�����Object����
		    if (thegray != null)    //�ͷŽ�����matlab�����
	            thegray.dispose();
	         }
			
			return res; 
	}
}    