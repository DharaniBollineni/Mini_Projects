document.getElementById('btnSignUp').addEventListener('click', function() {	
	document.getElementById('SignInId2').style.display = "none";
	document.getElementsByClassName('middlecontent')[0].style.display = "none";
	document.getElementById("singupId").style.display="block"; 	
 })
 //document.getElementById('btname1').addEventListener('click', async function() 
 function validateform()
 {
		var name = document.getElementById('uname2').value;   
		var password1=document.getElementById('pword2').value;  
		var conformPw=document.getElementById('rpword1').value;
		var emailcheck=document.getElementById('email2').value;
		//var oRE = /^[a-z0-9]+[_.-]?[a-z0-9]+$/i; 
		var oRE = /^[a-zA-Z\-]+$/i;
		//var emailre = /[@]/;
	
		if (!oRE.test(name)){  
				alert("Name can't have special characters");  
				return false;  
		}
		//else if(!emailre.test(emailcheck))
		//{
		//	alert("don't have @");  
		//		return false;  
		//}
		else if(password1.length<6){  
				alert("Password must be at least 6 characters long.");  
				document.getElementById('pword2').focus();
				return false;  
		}  
		else if(password1.length>6)
		{
			re = /[0-9]/;
			if(!re.test(password1)) {
				alert("Error: password must contain at least one number (0-9)!");
				form.pwd1.focus();
				return false;
			}
			re = /[a-z]/;
			if(!re.test(password1)) {
				alert("Error: password must contain at least one lowercase letter (a-z)!");
				form.pwd1.focus();
				return false;
			}
			re = /[A-Z]/;
			if(!re.test(password1)) {
				alert("Error: password must contain at least one uppercase letter (A-Z)!");
				form.pwd1.focus();
				return false;
			}
    	}
		//else if (conformPw != password1)
		//{
		//	alert("confrom password mismatch");  
		//	document.getElementById('pword2').focus();
		//	return false; 
			
		//}
		else{
				return true;
		}
}	 
 
 //document.getElementById('btname1').addEventListener('click',
	//async function() {		
		//let f = await fetch('/2019/info.php?address=' +
		//	'success submistion');
		//let t = await f.text();		
		//alert(t);
	//});
	
	/*ph.addEventListener('click', privateContentFuction() {
let phc= document.querySelector('.privateContent')
let preItems = sb.getElementsByTagName('pre')
let p = document.createElement('p')
p.appendChild(document.createTextNode(this.textContent));
document.getElementsByTagName('middlecontent')[0].appendChild(p);
})*/

// add append element to the middle content or welcome content
 
document.getElementsByClassName('ph')[0].addEventListener('click', function privateContentFuction() {

var p = document.createElement('p');
p.appendChild(document.createTextNode('Private Hire \n Home cafe is available to hire for private parties. Whether you would like to hire out the entire cafe for a party or celebration, or book a large table for a get together, we can accommodate. We can customise a menu for your group and theme your party anyway that you require. We are flexible and can arrange to sit down with you and plan your event, specific to your needs. /n For any enquiries, please email us at info@homeCafe.co.nz. '));
document.getElementsByClassName('middlecontent')[0].appendChild(p);
 })

 
 //document.getElementById('btnSignIn').addEventListener('click', function() {
//	document.getElementById('singupId').style.display = "none";
//	document.getElementsByClassName('middlecontent')[0].style.display = "none";
//	document.getElementById("SignInId2").style.display="block"; 	
// })
 
 
 
 // Button click to change the font color
 
 document.getElementById('fontBtn').addEventListener('click', colorChangeBtnHandler);	

function colorChangeBtnHandler() {
 	/*var c = 100
 		document.feedbacktextarea.style.color = hsl(' + c + ', 100%, 50%);
 		c++*/
		
 		// textinfo = document.getElementById("feedbacktextarea").innerHTML;
    //textinfo.style.color = 'blue';
	
	document.getElementsByClassName('feedbacktextarea')[0].style.color = 'red';
 }
 
 // offer background
 function OfferlabelBlinkBackground() {
 		document.getElementsByClassName('blinkingClass1')[0].style.backgroundColor = '#20B2AA';
		setTimeout("OfferlabelBlinkBackground()",1000);
 		
 }
 
 
 // for regiestor alerts
 function signupSuccessAlert() { alert('Successfully created'); }

 