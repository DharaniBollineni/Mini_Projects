<html>
<head>
<title>Order</title>
</head>
<body align="center" style="background-image: url('imagesbg.jpg'); color:white;">
<br /><br /><br />
<h1> Order </h1>
<br />
<?php
$emailLogin=$_GET['emailLogin'];
// connect to dataBase
$conn = new mysqli("localhost", "myuser", "mypass", "mydb");

?>

<div>
<?php

	if(isset($_POST['order_button'])) {
		$contact_name = $_POST['contact_name'];	
		$email = $_POST['email'];
		$contact_number= $_POST['contact_number'];
		$item_name = $_POST['item_name'];
		$quantity = $_POST['quantity'];
		$pickup_time= $_POST['pickup_time'];
		$query = $conn->prepare("INSERT INTO order_tb (contact_name, email, contact_number,item_name,quantity,pickup_time) VALUES (?, ?, ?,?, ?, ?);");
		$query->bind_param("ssssis", $contact_name, $email, $contact_number,$item_name,$quantity,$pickup_time);   
		if($query->execute())
		{
		?>
			<h1>Thanks for order- it will be ready on time- please pay while pickup </h1> 
		<?php
		header("Refresh:3");
		}else{
		?>
			<h1> Please fill all details  </h1>
		<?php	
	
		}		
	}
	
?>
</div>
<form id="contactForm" method="POST">
  <div class="row">
    <label>Your name:</label><br />
    <input id="name"  name="contact_name" type="text"  size="40" required /><br />
    
  </div>
  <div class="row">
    <label >Your email:</label><br />
    <input id="email"  name="email" type="email" value="<?php echo $_GET['emailLogin']?>"size="40" required /><br />
    
  </div>
   <div class="row">
    <label>Contact number:</label><br />
    <input id="name"  name="contact_number" type="text"  size="40" required /><br />
    
  </div>
  <div class="row">
	<label style="color:black;">Item:</label> 
	<select name="item_name" type="text"  required >
		<option value="Espresso" name= "Espresso">Espresso</option>
		<option value="Americano" name= "Americano">Americano</option>
		<option value="Cappuccino" name= "Cappuccino">Cappuccino</option>
		<option value="Corto" name= "Corto">Corto</option>
		<option value="Latte" name= "Latte">Latte</option>
		<option value="Macchiato" name= "Macchiato">Macchiato</option>
		<option value="French" name= "French">French</option>
		<option value="IcedCoffee" name= "IcedCoffee">IcedCoffee</option>
		<option value="DecafCoffee" name= "DecafCoffee">DecafCoffee</option>
	</select>
   </div>
  <div class="row">
    <label style="color:black;">Quantity:</label><br />
    <input id="name"  name="quantity" type="number"  size="40" required /><br />
    
  </div>
  <div class="row">
    <label>PickUp Time:</label><br />
    <input id="name"  name="pickup_time" type="text"  size="40" required /><br />
  </div>
    
	<br /><br />
    <input id="submitbtn" name="order_button" type="submit" value="Send" />
</form>
</body>