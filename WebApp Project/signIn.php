<!DOCTYPE html>
<html>
<head>
<title>Sign In</title>
    
</head>
<body align="center" style="background-image: url('imagesbg.jpg'); color:white;">
<?php
// connect to dataBase

$conn = new mysqli("localhost", "myuser", "mypass", "mydb");
//header('Location: signIn.php?emailLogin=$emailLogin');

?>
<?php
if(isset($_POST['clickLoginBtn'])) {
	//uname   email	pword  rpword 
	$emailLogin =null;
	$pwdLogin = null;
	$emailLogin = $_POST['emailLogin'];	
	$pwdLogin = $_POST['pwdLogin'];
		
	if ($emailLogin && $pwdLogin) {
		$query = $conn->prepare("SELECT * FROM user_tb WHERE email= ? ;");
			$query->bind_param("s", $emailLogin);
			$query->execute();
			$result = $query->get_result();				
			foreach ($result as $row) {
			if($row['password']== $pwdLogin)
			{
				$userName=$row['userName'];
				//$myURL="offers.php?emailLogin=$emailLogin&userName=$userName";					
				header("location: offers.php?emailLogin=$emailLogin&userName=$userName");
				?>
				<script>

					
				</script>
			<?php	
			}
			else
			{
				?>				
				<h1 >password mismatch</h1>
				<script> 
					window.addEventListener('load' ,function(){			      
					document.getElementsByClassName('middlecontent')[0].style.display = "none";			
					document.getElementById("SignInId2").style.display="block"; });
				</script>
				<?php
			}
			}
		}
	}

?>
</div>
	<br /> <br /><br /> <br /><br /> <br />
	<form class="singId-content" method="Post">
	<!--action="/YourOffers.php"-->
    <div class="containersingin">
	
      <h1>Sign In</h1>
	  <hr>
      <p>Please enter account details</p>  <br /> 	
      <label type="text"><b>Email   :</b></label> 
      <input type="email" placeholder="Enter Email" id="email3" name="emailLogin" required>  <br /> 	<br /> 	

      <label type="text"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" id="psw3" name="pwdLogin" required> <br /> 	 <br /> 	
 	
      <button type="submit" class="signupbtn" name="clickLoginBtn">Sign In</button>
	  <hr>
	  
	  <br />
    </div>
  </form>

	
	</div>
	<style>
 form {
 width:30%;
 height:80%;
 margin:auto;
 position:relative;
 color: black;
 background-color:powderblue;
 align:center;
 border-style: solid;
	border-width:1px;
	border-color: white ;	
 }
   input {
 width:30%;
 height: 25px;
   }
 </style> 
	
	</body>