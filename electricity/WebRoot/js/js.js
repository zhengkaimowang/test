function form_submit(){
	if(validate()){
	document.getElementById("login").submit();
	}
}
function form_reset(){
	document.getElementById("login").reset();
}
     
var code ; //��ȫ�� ������֤��  
function createCode()  
     {   
       code = "";  
       var codeLength = 4;//��֤��ĳ���  
       var checkCode = document.getElementById("checkCode");  
       var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//���к�ѡ�����֤����ַ�����ȻҲ���������ĵ�  
          
       for(var i=0;i<codeLength;i++)  
       {  
        
          
       var charIndex = Math.floor(Math.random()*36);  
       code +=selectChar[charIndex];  
         
         
       }   
       if(checkCode)  
       {  
         checkCode.className="code";  
         checkCode.value = code;  
       }  
     }   
function validate()  
     {  
       var inputCode = document.getElementById("input1").value.toUpperCase();  
       if(inputCode.length <=0)  
       {  
           alert("��������֤�룡"); 
		   return false;
       }  
       else if(inputCode != code)  
       {  
          alert("��֤���������");  
          createCode();//ˢ����֤��  
		  return false;
       }  
       else  
       {  
         return true; 
       }  
} 