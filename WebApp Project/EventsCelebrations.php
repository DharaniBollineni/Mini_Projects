<html>
<head>
<title>Events & Celebrations</title>
</head>
<body style="background-image: url('imagesbg.jpg'); color:white;">
<center>
<h1 align="centre"> <u><em>Events & Celebrations </em></u></h1>

<h1>Call / Contact Us we will help you out:</h1>

<pre style="font-size: 20px"	><p>	
Weddings
Birthday Celebrations
Destination Lunches
Weekend Parties</p>
</pre>
<?php
// connect to dataBase
$conn = new mysqli("localhost", "myuser", "mypass", "mydb");

?>

<div>
<?php

	if(isset($_POST['enquiry'])) {
		$contact_name = $_POST['contact_name'];	
		$email = $_POST['email'];
		$phoneNumber= $_POST['phoneNumber'];
		$Event_type = $_POST['Event_type'];
		$needDate = $_POST['needDate'];
		$yourMsg= $_POST['yourMsg'];
		$query = $conn->prepare("INSERT INTO event_tb (contact_name, email, phoneNumber,Event_type,needDate,yourMsg) VALUES (?, ?, ?,?, ?, ?);");
		$query->bind_param("ssssss", $contact_name, $email, $phoneNumber,$Event_type,$needDate,$yourMsg);   
		if($query->execute())
		{
		?>
			<h1>Thank You we Will get back to you ASAP </h1> 
		<?php
		}else{
		?>
			<h1> Please provide all details  </h1>
		<?php	
	
		}		
	}
	
?>
</div>

<form id="contactForm" align="centre" method="post">

<h1> Please Submit your information</h1>
<hr />
  <div class="row">
    <label>Your name:</label><br />
    <input id="name"  name="contact_name" type="text"  size="40" required /><br />
    
  </div>
  <div class="row">
    <label >Your email:</label><br />
    <input id="email"  name="email" type="email" size="40" required /><br />
    
  </div>
  <div class="row">
    <label >Phone Number:</label><br />
    <input id="phonenumber"  name="phoneNumber" type="text" size="40" required /><br />
    
  </div>
   <div class="row">
    <label >Celebrations/Event</label><br />
    <input id="Celebrationsid"  name="Event_type" type="text" size="40" required /><br />
    
  </div>
   <div class="row">
    <label >Date:</label><br />
    <input id="dateid"  name="needDate" type="text" size="40" required /><br />
    
  </div>
  <div class="row">
    <label>Your message:</label><br />
    <textarea id="message"  name="yourMsg" rows="20" cols="50" required ></textarea><br />
   </div>
    
	<br /><br />
    <input id="submitbtn" type="submit" name="enquiry" value="Send" style="height:40px; width:100px" />
</form>
</center>
</body>