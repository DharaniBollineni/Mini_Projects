<!DOCTYPE html>
<html>
<head>
    <title>Your Offers</title>
	
</head>
<body align="center" style="background-image: url('imagesbg.jpg'); color:DarkRed;">
<?php
// connect to dataBase
$emailLogin=$_GET['emailLogin'];
$userName=$_GET['userName'];
$conn = new mysqli("localhost", "myuser", "mypass", "mydb");

?>
		<h1>Welcome <?=$userName?></h1> 
		<br />
		<h1 style="color:white;"> LIST OF OFFERS</h1>
		<table border='1' cellpadding='1' cellspacing='1' align="center" style="background-color:powderblue;">	
		<br />
		<tr style="background-color:DeepSkyBlue; color:white;">
			<td height="10" width="250"><Strong>Item</Strong></td>
			<td height="10" width="250"><Strong>Price</<Strong></td>
		</tr>
<?php
		$result = $conn->query("SELECT * FROM offer_tb;");
		foreach ($result as $row) {
?>

			<tr>
			<td height="10" width="250"><Strong><?php echo $row['item_name']?></<Strong></td>
			<td height="10" width="250"><Strong><?php echo $row['price']?></<Strong></td>			
			</tr>
<?php
		}
?>
		</table>
		
		<center>
		<pre>
		<!--onclick="window.location.href = 'placeOrder.php'" -->
		
<Button id="btnPlaceOrder" onclick="window.location.href='placeOrder.php?emailLogin=<?php echo $_GET['emailLogin']?>'" style="height:40px; width:100px">Order </Button> 	<Button id="btnCancelOrder" onclick="window.location.href='editOrder.php?emailLogin=<?php echo $_GET['emailLogin']?>'" style="height:40px; width:100px">Edit Order</Button>  
<!--<Button id="btnsignOut" onclick="window.location='ProjectwithLayoutsCafeShop.php'" style="height:40px; width:100px">SignOut </Button> -->

</pre>
		
		</center>
</body>
<style>
button{
	background-color: Transparent;
    background-repeat:no-repeat;
    border: none;
    cursor:pointer;
    overflow: hidden;
	 color: white;
   // outline:none;
   border-style: solid;
	border-width:1px;
	border-color: #F0B27A ;
	background-color: rgba(153, 0, 0, 0.6);
	height:40px;
	width:120px;
}
button:focus {
  background-color: rgba(160,160,160,0.9);
}

button:hover {
  color: white;
  border-color: currentColor;
  font-weight: bold;
  background-color: rgba(255,178,102,0.9);
}
</style>


