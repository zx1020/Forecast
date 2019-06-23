package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.external.org.json.JSONArray;

public class TestServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
        
    }

    @SuppressWarnings("null")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");  //�����������
        PrintWriter out = response.getWriter(); //ͨ��PrintWrite��������ʽ���html�����ظ��ͻ��ˣ���ʾ��IE��
       
        String ybs=request.getParameter("ybs");
        String ts=request.getParameter("ts");
        String rq=request.getParameter("rq");
        String ycff=request.getParameter("ycff");
        String yczq=request.getParameter("yczq");
        String data = rq.replaceAll("-","");  //�����ڸ�ʽ�е�-ȥ��
		System.out.println("ybs:"+ybs+";"+"ts:"+ts+";"+"rq:"+data+";"+"ycff:"+ycff+";"+"yczq:"+yczq);
		String[] yucezhi=null;
		String[] shijizhi=null;
		int[] riqi=null;
		int a = 0;
		int b = 0;
		int c = 0;
		try {
		    a = Integer.parseInt(ybs);
		    b = Integer.parseInt(ts);
		    c = Integer.parseInt(data);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		switch(yczq){
		case "����Ԥ��":
			switch(ycff){
			case"ARMA":
				try {
					yucezhi = ARMA.getarma(a,b,c);	
					shijizhi=GMn.gethuisesj(a,b,c);
				    riqi=GMn.gethuiserq(a,b,c);
				} catch (MWException e) {
					e.printStackTrace();
				}
				for(int i=0;i<b;i++){
				  response.getWriter().print(riqi[i]+" "+yucezhi[i]+" "+shijizhi[i]+" ");
				}
				break;
			case"��ͨ��ɫ����":
				try {
					yucezhi = GM1.gethuise1(a,b,c);	
				    shijizhi=GMn.gethuisesj(a,b,c);
				    riqi=GMn.gethuiserq(a,b,c);
				} catch (MWException e) {
					e.printStackTrace();
				}
				for(int i=0;i<b;i++){
				  response.getWriter().print(riqi[i]+" "+yucezhi[i]+" "+shijizhi[i]+" ");
				}
				break;
			case"�������ɫ����":
				try {
					yucezhi = GMn.gethuiseyc(a,b,c);
				    shijizhi=GMn.gethuisesj(a,b,c);
				    riqi=GMn.gethuiserq(a,b,c);
				} catch (MWException e) {
					e.printStackTrace();
				}
				for(int i=0;i<b;i++){
				  response.getWriter().print(riqi[i]+" "+yucezhi[i]+" "+shijizhi[i]+" ");
				}
				
				break;
			case"PSO&GMn":
				try {
					yucezhi = PSOGM.getpsogm(a,b,c);
				    shijizhi=GMn.gethuisesj(a,b,c);
				    riqi=GMn.gethuiserq(a,b,c);
				} catch (MWException e) {
					e.printStackTrace();
				}
				for(int i=0;i<b;i++){
				  response.getWriter().print(riqi[i]+" "+yucezhi[i]+" "+shijizhi[i]+" ");
				}
				break;
			case"PSO&GM1":
				try {
					
					yucezhi = PSOGM1.getpsogm1(a,b,c);
				    shijizhi=GMn.gethuisesj(a,b,c);
				    riqi=GMn.gethuiserq(a,b,c);
				} catch (MWException e) {
					e.printStackTrace();
				}
				for(int i=0;i<b;i++){
				  response.getWriter().print(riqi[i]+" "+yucezhi[i]+" "+shijizhi[i]+" ");
				}
				break;
			}
			break;
		case "����Ԥ��":
			switch(ycff){
			case"ARMA":
				try {
					yucezhi = ARMA.getarma(a,b,c);	
					shijizhi=GMn.gethuisesj(a,b,c);
				    riqi=GMn.gethuiserq(a,b,c);
				} catch (MWException e) {
					e.printStackTrace();
				}
				for(int i=0;i<b;i++){
				  response.getWriter().print(riqi[i]+" "+yucezhi[i]+" "+shijizhi[i]+" ");
				}
				break;
			case"��ͨ��ɫ����":
				try {
					yucezhi = GM1.gethuise1(a,b,c);	
				    shijizhi=GMn.gethuisesj(a,b,c);
				    riqi=GMn.gethuiserq(a,b,c);
				} catch (MWException e) {
					e.printStackTrace();
				}
				for(int i=0;i<b;i++){
				  response.getWriter().print(riqi[i]+" "+yucezhi[i]+" "+shijizhi[i]+" ");
				}
				break;
			case"PSO&GM1":
				try {
					
					yucezhi = PSOGM1.getpsogm1(a,b,c);
				    shijizhi=GMn.gethuisesj(a,b,c);
				    riqi=GMn.gethuiserq(a,b,c);
				} catch (MWException e) {
					e.printStackTrace();
				}
				for(int i=0;i<b;i++){
				  response.getWriter().print(riqi[i]+" "+yucezhi[i]+" "+shijizhi[i]+" ");
				}
				break;
			}
			break;
		case "����Ԥ��":
			response.getWriter().write("1");
			/*switch(ycff){
			case"ARMA":
				try {
					yucezhi = ARMA.getarma(a,b,c);	
					shijizhi=GMn.gethuisesj(a,b,c);
				    riqi=GMn.gethuiserq(a,b,c);
				} catch (MWException e) {
					e.printStackTrace();
				}
				for(int i=0;i<b;i++){
				  response.getWriter().print(riqi[i]+" "+yucezhi[i]+" "+shijizhi[i]+" ");
				}
				break;
			case"��ͨ��ɫ����":
				try {
					yucezhi = GM1.gethuise1(a,b,c);	
				    shijizhi=GMn.gethuisesj(a,b,c);
				    riqi=GMn.gethuiserq(a,b,c);
				} catch (MWException e) {
					e.printStackTrace();
				}
				for(int i=0;i<b;i++){
				  response.getWriter().print(riqi[i]+" "+yucezhi[i]+" "+shijizhi[i]+" ");
				}
				break;
			case"PSO&GM1":
				try {
					
					yucezhi = PSOGM1.getpsogm1(a,b,c);
				    shijizhi=GMn.gethuisesj(a,b,c);
				    riqi=GMn.gethuiserq(a,b,c);
				} catch (MWException e) {
					e.printStackTrace();
				}
				for(int i=0;i<b;i++){
				  response.getWriter().print(riqi[i]+" "+yucezhi[i]+" "+shijizhi[i]+" ");
				}
				break;
			}*/
			break;
			
			
		}


       
    }

}

