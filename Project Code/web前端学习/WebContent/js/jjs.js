/**
 * 
 */
//alert(document.getElementById("bt_bubb").value);
var af=document.getElementById("bt_bubb");
var ps=document.getElementById("ps");
/* var a=confirm("kdkfkdsf");
var b=prompt("请输入密码"); */
/* document.write(b);
document.write(a); */
af.onclick=function(){
	window.open("NewFile1.html","打开的规定的窗口","width=750,height=317,top=50,left=20");
}

//在一个元素里面嵌入信息；
function date_show(clock){
var now=new Date();
var year=now.getFullYear();
var months=now.getMonth();
var date=now.getDate();
var day=now.getDay();
var hour=now.getHours();
var minute=now.getMinutes();
var seconds=now.getSeconds();
var time=year+"年"+(months+1)+"月"+date+"日"+"星期"+day+"  "+hour+"时"+minute+"分钟"+seconds+"秒";
clock.innerHTML="当前时间"+time;
}



//遍历html文档；
var elementList="";
function getElement(node){
	var total=0;
	if(node.nodeType==1){
		total++;
		elementList=elementList+node.nodeName+",";
		
	}
	var childrens=node.childNodes;
	for(var m=node.firstChild;m!=null;m=m.nextSibling){
	total+=getElement(m);
	
	}
	return total;
}
function show(){
	var number =getElement(document);
	elementList=elementList.substring(0,elementList.length-1);
	
	alert("该文件中包含"+elementList+"等"+number+"个标志");
	
}

//在table中增加一个元素
function addElement(DOM_table){
	//获取文本内容来创建要添加的文本节点；
	var person =document.createTextNode(document.getElementById("person").value);
	var content=document.createTextNode(document.getElementById("content").value);
	//创建td类型的Element节点；     
	var td_person= document.createElement("td");
	var td_content= document.createElement("td");
	//创建tr类型的节点；
	var tr=document.createElement("tr");
	//创建一个tbody类型的节点；相当于一个部分一样；
    var tbody=document.createElement("tbody");
   
    //进行节点间的链接排列；tbody---tr---td---TextNode   从下往上开始布局；
    td_person.appendChild(person);
    td_content.appendChild(content);
    tr.appendChild(td_person);
    tr.appendChild(td_content);
    tbody.appendChild(tr);
   
    DOM_table.appendChild(tbody);
    document.getElementById("person").value="";
    document.getElementById("content").value="";
}



//删除表格里的最后第二行
function deleteFirstE(table){
	if(table.rows.length>1){
		table.deleteRow(1);
	}
	
}

//删除table中的最后一行
function deleteLastE(table){
	if(table.rows.length>1){
		table.deleteRow((table.rows.length)-1);
	}
	
}

onload=function(){
	var DOM_table=document.getElementById("comment");
	//设置周期性的运行一个函数；   然而此函数为更新元素里面的内容；
	window.setInterval("date_show(ps)",1000);
	//show();
	
	//对几个按钮设置监听事件；
	var button0=document.getElementById("button_add");
	var vname=document.getElementById("person"); //获取文本框中的值
	   vname.onblur=function(){alert("此时进行数据校验")}
	button0.onclick=function(){
		addElement(DOM_table);
		
		
	}
	var button1=document.getElementById("button_dele_fir");
	button1.onclick=function(){
		deleteFirstE(DOM_table);
	}
	var button2=document.getElementById("button_dele_la");
	button2.onclick=function(){
		deleteLastE(DOM_table);
		}
	
}







