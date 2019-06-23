<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>My JSF 'ajaxDemo.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="./js/forecast.css" >
    <link rel="stylesheet" type="text/css" href="./js/bootstrap.min.css">
    <script type="text/javascript" src="./js/jquery.min.js" ></script>
    <script type="text/javascript" src="./js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="./js/echarts.min.js" ></script>
    <script type="text/javascript" src="./js/ajaxFun.js"></script>
    <script type="text/javascript" src="./js/jedate/src/jedate.js"></script>
    <link type="text/css" rel="stylesheet" href="./js/jedate/skin/jedate.css">
  </head>
  
  <body>
		<div class="hidden-xs"><!--超小屏幕激活隐藏-->
     	<header>
			<div id="intro">
			    <span class="title-1">
			        <span class="char1" style="display: inline-block; transition: none 0s ease 0s; transform: translateX(-2px) translateY(60px) rotate(-28deg);">光</span>
			        <span class="char2" style="display: inline-block; transition: none 0s ease 0s; transform: translateX(-4px) translateY(25px) rotate(-20deg);">伏</span>
                    <span class="char3" style="display: inline-block; transition: none 0s ease 0s; transform: translateX(-3px) translateY(6px) rotate(-11deg);">发</span>			        
			        <span class="char4" style="display: inline-block; transition: none 0s ease 0s; transform: translateX(0px) translateY(1px) rotate(-1deg);">★</span>
			        <span class="char5" style="display: inline-block; transition: none 0s ease 0s; transform: translateX(3px) translateY(6px) rotate(11deg);">电</span>
			        <span class="char6" style="display: inline-block; transition: none 0s ease 0s; transform: translateX(4px) translateY(30px) rotate(22deg);">系</span>
			        <span class="char7" style="display: inline-block; transition: none 0s ease 0s; transform: translateX(-3px) translateY(69px) rotate(28deg);">统</span>
			    </span>
			    <span class="title-2">能量预测</span>
		    </div>
		</header>
		</div>
		<div class="visible-xs-block"><!--超小屏幕激活显示-->
		    <div class="page-header">
		    	<p class="title-2" style="color: white; text-align: center;">光伏发电能量预测系统</p>
			</div>
		</div>
		
		<div class="container">
            <nav class="navbar navbar-btn" id="nav">
            <div class="btn-group  btn-group-lg">
            	<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" name="yczq">
                                                        预测周期 <span class="caret"></span>
                </button>
            	<ul class="dropdown-menu" id="nav-ul-2">
            	
            	  <li><a onclick="showday();">按日预测</a></li>
            	  <li><a onclick="showmonth();">按月预测</a></li>
            	  <li><a onclick="showyear();">按年预测</a></li>
            	</ul>
            </div>
            <div class="btn-group  btn-group-lg">
            	<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" name="ycff">
                                                        预测方法 <span class="caret"></span>   <!-- caret是一个下拉三角符号-->
                </button>
            	<ul class="dropdown-menu" id="nav-ul-1" role="menu"  aria-labelledby="dLabel">
            	  <li><a>ARMA</a></li>
            	  <li><a>普通灰色理论</a></li>
            	  <li id="gmn"><a>多变量灰色理论</a></li>
            	  <li id="pgm1"><a>PSO&GM1</a></li>
            	  <li id="pgmn"><a>PSO&GMn</a></li>
            	</ul>
            </div>
            
            <div class="btn-group  btn-group-lg">
            	<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" name="sjdq">
                                                        数据读取<span class="caret"></span>
                </button>
            	<ul class="dropdown-menu" id="nav-ul-3">
            	  <li><a>读取Excel</a></li>
            	  <li><a>读取SQL</a></li>
            	</ul>
            </div> 
            <div class="btn-group  btn-group-lg" id="nav-ul-4">
            	<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        帮助
               </button>
            </div> 
            </nav>
            <div class="row">
            	<div class="col-md-3">
            		<div class="panel panel-success">
	            		<ul class="nav nav-tabs">
	            			<li role="presentation">
	            				<a onclick="showxx();">详细信息</a>
	            			</li>
	            			<li role="presentation">
	            				<a onclick="showsj();">详细数据</a>
	            			</li>
	            		</ul>
	            		<div class="panel-body" id="xx">
	            			<table  class="table table-bordered text-center">
	            				<tr>
	            					<td>预测周期</td><td id='yczq'></td>
	            				</tr>
	            				<tr><td>预测方法</td><td id="ycff"></td></tr>
	            				<tr><td>所在电站</td><td id='szdz'></td></tr>
	            				<tr><td>所在城市</td><td></td></tr>
	            				<tr><td>预测设备</td><td></td></tr>
	            				<tr><td>天气类型</td><td></td></tr>
	            				<tr><td>气温(℃)</td><td></td></tr>
	            				<tr><td>日照强度</td><td></td></tr>
	            				<tr><td>风向(°)</td><td></td></tr>
	            				<tr><td>风速(m/s)</td><td></td></tr>
	            				<tr><td>当前时间</td><td id='data'></td></tr>
	            			</table>	
	            		</div>
	            		<div class="panel-body" id="sj" style="display: none;">
	            		 <table  class="table table-bordered text-center">
	            			<thead>  
						      <tr>  
						         <td style="line-height: 40px;">日期</td>
						         <td>预测值(kWh)</td>
						         <td>实际值(kWh)</td>
						      </tr>   
						   </thead>  
						   <tbody id="tbMain"></tbody> 
	            		 </table>
	            		</div>
            		</div>
            	</div>
            	<div class="col-md-9">
            		<div class="panel panel-success">
            			<div class="panel-heading">
            				<h3 class="panel-title">预测结果</h3>
            			</div>
            			<div class="panel-body">
            				<form class="form-inline" id="form">
            					<div class="form-group">
            						<label for="exampleInputName2">样本数：</label>
            						<input type="number" class="form-control" id="exampleInputName2" name="ybs" min="1" max="15" name="ybs"/>
            					</div>
            					<div class="form-group">
            						<label for="exampleInputEmail2">显示天数：</label>
            						<input type="number" class="form-control" id="tianshu" name="ts" min="1" max="15" name="ts"/>
            					</div>
            					<div class="form-group" id="in">
                                    <label for="exampleInputEmail2">起始日期：</label>
                                    <input type="text" class="form-control" id="datainput" placeholder="请选择" name="rq"/>
                                </div>
                                
                             
					            <!-- 写成type=“submit”会导致ajax请求失败 -->					
					            <button type="button" onclick="ajaxFun()" class="btn btn-success"  style="margin-top: 10px;">提交</button>
                           </form>
                                    	
                            <div class="panel panel-default" id="pic">
            				    <div class="panel-heading">
            					    <h3 class="panel-title text-center">图形分析</h3>
            				    </div>
            				    <div class="panel-body">
            					    <div id="myChart" style="height:350px;"></div>
            				    </div>
            			    </div>	
            		    </div><!--面板body--> 	
            		</div> <!--面板-->  
            	</div><!--右侧col-md-x--> 
            </div>    <!--row-->
	    </div>  <!--container-->
	    
     <script type="text/javascript" src="./js/click.js"></script>	       
	</body>
	

</html>
