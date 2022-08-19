/**
 * 
 */
//数字减框
    function jian(){
    	var count1;
    		count1=parseInt(document.getElementById("count").value);
    		if(count1<=1){
    			count1=1;
    		}else{
    			count1--;
    			
    		}
    		document.getElementById("count").value=count1;
    		document.getElementById("sum").innerHTML=parseInt(document.getElementById("price").innerHTML)*count1;
    }
    
    //数字加框
    	function jia(maxValue){
    		var count1;
    		count1=parseInt(document.getElementById("count").value);
    		
    		if(count1>=maxValue){
    			count1=maxValue;
    			
    		}else{
    			count1++;
    			
    		}
    		
    		document.getElementById("count").value=count1;
    		document.getElementById("sum").innerHTML=parseInt(document.getElementById("price").innerHTML)*count1;
    		
    	}
    	
    	//计算总价
    	function sum(){
    		
    		
    	}
    
    		
    
    	
 