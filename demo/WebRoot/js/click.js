
//点击导航栏选择预测方法等时,触发的点击事件,

$('#nav-ul-1').on('click','li',function(){    //给id=nav-ul-1的ul元素绑定一个事件委托函数，ul里面的li被点击后触发
	var a=$(this);                            //a为当前点击的标签
	$('#ycff').text(a.text());                //将id=ycff的标签中的文字改为a中的文字
});


$('#nav-ul-2').on('click','li',function(){
	var b=$(this);
	$('#yczq').text(b.text());
});
	

$('#nav-ul-3').on('click','li',function(){
    var a=$(this);  /*获取当前选定的标签*/
});

$('#nav-ul-4').on('click','li',function(){
           alert("帮助信息"); /*   此处应编写弹出帮助文档*/
});

//显示当前日期时间
var myData=new Date();
var t=myData.toLocaleString();
$('#data').text(t);

//点击切换显示详细信息和详细数据
function showxx(){
	$('#sj').css('display' , 'none');
    $('#xx').css('display' , 'block');
}
function showsj(){
	$('#xx').css('display' , 'none');
    $('#sj').css('display' , 'block');
}

function showday(){
	$('#gmn').css('display' , 'block');//显示GMn和psogm下拉选项
	$('#pgm1').css('display' , 'block');
	$('#pgmn').css('display' , 'block');
	
	$('input[name="rq"]').remove(); //删除日期输入框
	var input = document.createElement("input"); //创建日期input框
	var bodyFa =document.getElementById("in"); //获取input父元素
	$(input).attr("type", "text");  //设定input属性值
	$(input).attr("class", "form-control");
	$(input).attr("id", "datainput1");
	$(input).attr("name", "rq");
	$(input).attr("placeholder", "请选择"); 
	bodyFa.appendChild(input);//将创建的input放入指定位置
	  $(function () {
	      jeDate("#datainput1",{
	          format:"YYYY-MM-DD",
	          isTime:false,
	      })
	  }); 
}
function showmonth(){
	$('#gmn').css('display' , 'none');//隐藏GMn和psogm下拉选项
	$('#pgm1').css('display' , 'block');	
	$('#pgmn').css('display' , 'none');	
	$('input[name="rq"]').remove();
	var input = document.createElement("input");
	var bodyFa =document.getElementById("in");
	$(input).attr("type", "text");
	$(input).attr("class", "form-control");
	$(input).attr("id", "datainput2");
	$(input).attr("name", "rq");
	$(input).attr("placeholder", "请选择");
	bodyFa.appendChild(input);
	$(function () {
	      jeDate("#datainput2",{
	          format:"YYYY-MM",
	          isTime:false,
	          minDate:"2013-07"
	      })
	  }); 
	}
function showyear(){
	$('#gmn').css('display' , 'none');
	$('#pgm1').css('display' , 'block');
	$('#pgmn').css('display' , 'none');	
	$('input[name="rq"]').remove();
	var input = document.createElement("input");
	var bodyFa =document.getElementById("in");
	$(input).attr("type", "text");
	$(input).attr("class", "form-control");
	$(input).attr("id", "datainput3");
	$(input).attr("name", "rq");
	$(input).attr("placeholder", "请选择");
	bodyFa.appendChild(input);
	  $(function () {
	      jeDate("#datainput3",{
	          format:"YYYY",
	          isTime:false,
	      })
	  });
	}    












/*function showday(){
	$('#gmn').css('display' , 'block');
	$('#pgm').css('display' , 'block');
	$(function () {
	    //或者为这样的
	    jeDate("#datainput",{
	        format:"YYYY-MM-DD",
	        isTime:false,
	        minDate:"2017-01-01"
	    })
	}); 
}
function showmonth(){
	$('#gmn').css('display' , 'none');
	$('#pgm').css('display' , 'none');
	$(function () {
	    jeDate("#datainput",{
	        format:"YYYY-MM",
	        isTime:false,
	        minDate:"2013-07"
	    })
	}); 
}
function showyear(){
	$('#gmn').css('display' , 'none');
	$('#pgm').css('display' , 'none');
	$(function () {
	    jeDate("#datainput",{
	        format:"YYYY",
	        isTime:false,
	    })
	});
}*/


