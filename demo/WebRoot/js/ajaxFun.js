
function ajaxFun(){
	 $.ajax({
         type: "POST",
         url: "TestServlet",
         data: {ycff: $('#ycff').text(),yczq:$('#yczq').text(),ybs: $('input[name="ybs"]').val(),ts: $('input[name="ts"]').val(),rq:$('input[name="rq"]').val()},
         success: function(result){
        	if (result==1){
    			alert("暂无数据");
    		}
        	else{
        	 var str= new Array(); //定义一数组 
        	 var str1= new Array(); //定义一数组 
        	 var str2= new Array(); //定义一数组 
        	 var str3= new Array(); //定义一数组 
        	 str=result.split(" ");//字符分割
        	 
        	//遍历一下str数据  将日期、预测、实际放入三个str中
        	 for(var i = 0,j = 0;i < (str.length+1)/3-1; i++){ 
                 j=3*i;
                 str1[i]=str[j];
                 str2[i]=str[j+1];
                 str3[i]=str[j+2];
             }
        	 var json = eval(str); //转换为json格式
        	 var json1 = eval(str1); 
        	 var json2 = eval(str2); 
        	 var json3 = eval(str3); 
        
        	 var tbody = document.getElementById('tbMain'); 
        	 
        	 $("#tbMain  tr").empty(""); //清除上一次请求填充的表格数据
        	
        	 //填充表格
             for(var i = 0,j = 0;i < (json.length+1)/3-1; i++){ //遍历一下json数据  
                 j=3*i;
                 var trow = getDataRow(j); //定义一个方法,返回tr数据  
                 tbody.appendChild(trow);  
             }
             function getDataRow(a){  
            	    var row = document.createElement('tr'); //创建行  
            	      
            	    var idCell = document.createElement('td'); //创建第一列 
            	    idCell.innerHTML =json[a]; //填充数据  
            	    row.appendChild(idCell); //加入行  ，下面类似  
            	      
            	    var nameCell = document.createElement('td');//创建第二列  
            	    nameCell.innerHTML = json[a+1];  
            	    row.appendChild(nameCell);  
            	      
            	    var jobCell = document.createElement('td');//创建第三列 
            	    jobCell.innerHTML = json[a+2];  
            	    row.appendChild(jobCell);  
            	      
            	    return row; //返回tr数据      
            	    }  
             
            //绘制折线图
            var myChart = echarts.init(document.getElementById("myChart"));
 			// alert(tbSecond);
 			var Option = {
				    title: {
				        text: '光伏发电量',
				    },
				    tooltip: {
				        trigger: 'axis'
				    },
				    legend: {
				        data:['预测值','实际值']
				    },
				    toolbox: {
				        show: true,
				        feature: {
				            dataZoom: {
				                yAxisIndex: 'none'
				            },
				            dataView: {readOnly: false},
				            magicType: {type: ['line', 'bar']},
				            restore: {},
				            saveAsImage: {}
				        }
				    },
				    xAxis:  {
				        type: 'category',
				        boundaryGap: false,
				        data:json1
				    },
				    yAxis: {
				        type: 'value',
				        axisLabel: {
				            formatter: '{value} kwh'
				        }
				    },
				    series: [
				        {
				            name:'预测值',
				            type:'line',
				            data:json2
				        },
				        {
				            name:'实际值',
				            type:'line',
				            data:json3
				        }
				    ]
				};
 			// alert(Option);
 			myChart.setOption(Option);
 		     
         }
      },
 	     error:function (msg) {
 			alert("ajax111请求失败");
 			}
     });
}



