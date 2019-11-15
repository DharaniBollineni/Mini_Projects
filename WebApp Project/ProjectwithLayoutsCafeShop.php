
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Home Café</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="ProjectwithLayoutsCafeShopStyle.css" />	
</head>
<body onload="OfferlabelBlinkBackground()">
<header> 
    <h1> Home Café</h1>
	<div class="gallery-item">
	
	<?php
		for ($i = 1; $i < 6; $i++) 
		{?>
			<img src="cafe<?=$i?>.jpg" alt="Cafe Rouge - homeCafe" height="250" width="230" style='border-radius: 15px;'">
		<?php
		}
	?>
			
					
			<div class="caption">
				A Lot Can Happen Over Coffee
			</div>
		</div>	
	
	<nav>
		<ul>
				<li><a href="#">Menu</a> 
				<ul>
					<li><a href="Breakfast.pdf" target="_blank" Style="text-decoration: none" >Breakfast</a></li>
					<li><a href="Lunch.pdf" target="_blank" Style="text-decoration: none">Lunch</a></li>
					<li><a href="Coffee.pdf" target="_blank" Style="text-decoration: none">Coffee</a></li>
					<li><a href="ColdDrinks.pdf" target="_blank" Style="text-decoration: none">ColdDrink</a></li>
					 
				</ul>
				</li>
				
				<li><a href="#" class="ph" >Private Hire </a></li> 
				<li><a href="EventsCelebrations.php" >Events & Celebrations</a> </li> 
				<!--<ul>
					
					<li><a >BookEvents</a></li>
					<li><a >BookCelebrations</a></li>
					</li>	
					
				</ul>-->
				<li><a href="ContactUs.html">Contact Us</a> </li>
				<li><label class="blinkingClass1"><strong>Anniversary Offers </strong></label></li>
				<li>
				<input id="textboxSearch" type="text" placeholder="Search on Google..." onkeydown="if (event.keyCode == 13 || event.which == 13) { location='http://www.google.com/search?q=' + encodeURIComponent(document.getElementById('textboxSearch').value);}" />
					
				</li>
		</ul>		
	</nav>	
</header>
<body>
	<div class="sideLeft"> 
	<ul>
	<br /> <br /> <br /> 
		<li><Button id="btnSignUp">	SignUp </Button></li>	<br /> 		
		<li><Button id="btnSignIn" onclick="window.location.href = 'signin.php'">SignIn </Button></li>	<br /> 		
		<li><Button id="btnPlaceOrder" onclick="window.location.href = 'signin.php'">	Order </Button></li>	<br /> 		
		<li><Button id="btnCancelOrder" onclick="window.location.href = 'signin.php'"> Edit Order </Button></li>	<br /> 	
		<!--<li><Button id="btnAddToCart">	Add to cart </Button></li>	<br /> 		
		<li><Button id="btnReserveTable">	Reserve table </Button></li>	<br /> 	-->	
		<li><Button id="btnMap" onclick="window.open('https://www.google.com/maps/place/Home+Cafe/@-41.285361,174.7740054,15z/data=!4m5!3m4!1s0x6d38ae2934efc519:0xf6f1978f422490a8!8m2!3d-41.2765756!4d174.7784329')">	Map </Button></li>	
		
		
<br />
		<!--<h3>Play Music</h3>
		<!--<li><Button id="btnmusic">	Music </Button></li>	<br /> -->
		<audio
        controls
        src="bensound-tenderness.mp3" style="width: 150px; height:20px;">
			Music<code>audio</code> element.
    </audio>
		
	</ul>
	</div>
	
	
		
		
	<div id ="singupId">
			
			<br /> 
			<?php
// connect to dataBase
$conn = new mysqli("localhost", "myuser", "mypass", "mydb");

?>

<div>
<?php

	if(isset($_POST['REGISTER'])) {
	//uname   email	pword  rpword 
	//$uname = null;
	//$email = null;
	//$pword = null;
	//$rememberMe = null;
	//if($name && $hometown && $height && $team)
	$uname = $_POST['uname'];	
	$email = $_POST['email'];
	$pword = $_POST['pword'];
	$rpword = $_POST['rpword'];
	//$resultStatus=0;
	//$rememberMe = $_POST['rememberMe'];
	if($pword == $rpword)
	{					
			$query = $conn->prepare("INSERT INTO user_tb (username, email, password) VALUES (?, ?, ?);");
			$query->bind_param("sss", $uname,$email, $pword);   // need to check with type
			
			if($query->execute())
			{
	?>
		<!--<h1 javascript:signupSuccessAlert()> </h1>-->
            <h1>Successfully created </h1> 
			<h2>Please collect your Voucher.Use it only once. <a href="Voucher.pdf" target="_blank" > Voucher</a></h2>
			<h2>Please sign-in for other offers</h2>
			
			<script> 
			
			window.addEventListener('load' ,function(){			      
			document.getElementsByClassName('middlecontent')[0].style.display = "none";			
			document.getElementById("singupId").style.display="block";});
			</script>
			
	<?php
		
	}else{
				?>
				<h1> Please use different mail id</h1>
				<script>
			
			window.addEventListener('load' ,function(){			      
			document.getElementsByClassName('middlecontent')[0].style.display = "none";			
			document.getElementById("singupId").style.display="block";});
			</script>
	<?php	
	
	}		
	}else 	{
	?>
		<h1 >Confrom password mismatch</h1>
		<script> 
			window.addEventListener('load' ,function(){			      
			document.getElementsByClassName('middlecontent')[0].style.display = "none";			
			document.getElementById("singupId").style.display="block";});
		</script>
		
	<?php
	
	}
}
?>
</div>
			
			<form id= "singupformtable" method="post" onsubmit="return validateform()">
			<br /> <br /><br /><br /> 
			
			<table id="tablesignup" border='0' width='350px' cellpadding='0' cellspacing='0' align='center'>
				<center>
					<tr>
						<td><h2>SignUp <hr /></h2></td>						
					</tr>			
					<tr> <td>&nbsp;</td> </tr>					
				</center>
					<tr>
						
						<table border='0' width='350px' cellpadding='0' cellspacing='0' align='center'>
							<tr>						
								<td align='center'id="uname1"><strong>User Name</strong></td>
								<td><input type="text" id="uname2" name="uname" placeholder="Enter User Name" required /></td>
								
							</tr>
							<tr> <td>&nbsp;</td> </tr>
							<tr>
								<td align='center' id="email1"><strong>Email </strong></td>
								<td><input type="email" id="email2" name="email" placeholder="Enter Email" required  /></td>
							</tr>
							<tr> <td>&nbsp;</td> </tr>
							<tr>
								<td align='center' id="pword1"><strong>Password </strong></td>
								<td><input type="password" id="pword2" name="pword" placeholder="Enter Password" required /></td>
							</tr>
							<tr> <td>&nbsp;</td> </tr>
							<tr>
								<td align='center' id="rpword1"><strong>Re-enter Password</strong></td>
								<td><input type="password" id="rpword2" name="rpword" placeholder="Re-enter Password" required /></td>
							</tr>
							<tr> <td>&nbsp;</td> </tr>					
								<table border='0' cellpadding='0' cellspacing='0' width='350px' align='center'>
								<tr> <td>&nbsp;</td> </tr>					
							<!---<tr>
								<td align='center'><input type="checkbox" id="thecheckboxRememberMe" name="rememberMe" />
								
								
								<label for="thecheckboxRememberMe" id="lablem1" >
									 Remember Me
								</label></td>
							</tr>
					<tr> <td>&nbsp;</td> </tr>
					<tr> <td>&nbsp;</td> </tr> -->
					<tr>
						<td align='center'><input type='submit' id="btnRegistersignup" name='REGISTER' value="Register" ></td>
					</tr>
					</table>
					
		</table>
	</table>
	</form>
			
	</div>
	
	<div id ="SignInId2">
	</div>
	
	<div class="middlecontent">
			 <marquee behavior="scroll" direction="left">Sign Up For Anniversary Offers</marquee>
              <center>  <p><h2>A little bit about us</h2> </p></center>
                <p>Join us at the jetty, for a vibrant taste of classic Kiwi hospitality.</p>
				<p>Friendly and fun, it literally is a breath of fresh air. Everyone is welcome here. What better way to experience the Kiwi way of life and have a yarn to the locals.</p>

                <p>For some, it’s a place to soak up the unique atmosphere of the Marlborough Sounds over a craft beer or discover our signature seafood dishes. Not only do we aspire to serve you the very best fish & chips in the world, but many say that our superb seafood chowder is the perfect reminder of our exceptional ocean produce.</p>

<p>Or, perhaps, the Bight is just a great way to relax over another coffee and enjoy that magnificent view.</p>

<p>The Home Café is open 7 days per week serving all day breakfast & lunch. Our seasonal menus are created with love by qualified chefs with locally sourced products. Our wholesome & unique cabinet treats are baked fresh every day; including gluten-free, dairy free & vegan options.

We are also open Friday evenings with live music, serving delicious tapas & after work drinks.</p>

<p> <u>Located at</u> "70 Molesworth St, Thorndon, Wellington 6011" </p>
<p><u>Phone number :</u> 020202020</p>
<p><u>MailUs :</u> info@cafeday.com</p>
				
    </div>
	<div class="sideRight">
                
	<div id="box1">
	<h2 id="newsID"> News </h2>
	
	<p><strong>=></strong>Money laundering accused plead not guilty
<strong>=></strong>Kōkako populations flourishing after intense work to combat predator control...
<strong>=></strong>‘Sieg heil’ - Auckland mayoral candidate John Tamihere responds to debate question with Nazi phrase
<strong>=></strong>Kākāpō breeding season celebrated after endangered population sees highest number in 70 years..<a href="https://www.tvnz.co.nz/one-news/new-zealand">more</a></p>
	
	</div>
	<div id="box2">
	<h2 id="galleryId"> Gallery</h2>
	<?php
		//for($j=0;$j<2;$j++)
		//{
			for ($i = 0; $i < 14; $i++) 
		{?>
			<img src="c<?=$i?>.jpg" alt="Cafe Rouge - homeCafe" class="fleximageclass1">
		<?php
		}
		
	//	}
	?>
	
	</div>
	<div id="box3" >
	<h2 id="adsId"> Ads</h2> 
	<!--Have fun!!!!!
	<img src="cafeLogo.jpg" alt="Cafe Rouge - homeCafe" id= "box3image" />-->
	<video width="320" height="120" controls>
			<source src="Coffeevedio.mp4" type="video/mp4">
			About Coffee
	</video>
	</div>

</div>
</body>


<footer class="footerClass1">
	<h2>FeedBack </h2> 
	<pre><a href="https://www.facebook.com/homecafegroup/">FaceBook</a> | <a href="https://twitter.com/?lang=en">twitter</a> </pre>
	<textarea class= "feedbacktextarea" rows="5" cols="140" Style="background-color:#f2f2ff; margin:10px;"> </textarea><br />
	<button id="fontBtn"> Change font color </button> 

	<h4> This website uses cookies. By using our website, you agreeing with our Privacy Policy</h4>

</footer>
<script src="mainjs.js" type="text/javascript"></script>
</html>
