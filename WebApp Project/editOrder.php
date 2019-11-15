<html>
<head>
<title>Edit order</title>
</head>
<body align="center" style="background-image: url('imagesbg.jpg'); color:white;">
<br /><br /><br />
<h1> Edit order </h1>
<?php
$emailLogin=$_GET['emailLogin'];
// connect to dataBase
$conn = new mysqli("localhost", "myuser", "mypass", "mydb");
$emailLogin = $_GET['emailLogin']; 		
$sql="select * from order_tb WHERE email='$emailLogin';";
$result = $conn->query($sql);

?>
<center>
<h1>List of your orders</h1>
		<table border='2' cellpadding='5' cellspacing='5'>
		<tr>	
				<td><Strong><?php echo "OrderNumber"?></Strong></td>
				<td><Strong><?php echo "Name"?></Strong></td>
				<td><Strong><?php echo "Email"?></Strong></td>
				<td><Strong><?php echo "Phone"?></Strong></td>
				<td><Strong><?php echo "Item"?></Strong></td>
				<td><Strong><?php echo "Quantity"?></Strong></td>
				<td><Strong><?php echo "PickUp Time"?></Strong></td>
				<td><Strong><?php echo "Select To Delete"?></Strong></td>
		</tr>
<?php
		foreach ($result as $row) {
?>
			<tr><td><?php echo $row['order_number']?></td>
			<td><?php echo $row['contact_name']?></td>
			<td><?php echo $row['email']?></td>
			<td><?php echo $row['contact_number']?></td>
			<td><?php echo $row['item_name']?></td>
			<td><?php echo $row['quantity']?></td>
			<td><?php echo $row['pickup_time']?></td>
			<td>
			<form action="" method="POST">
				<input type="checkbox" name="records[]" value="<?php echo $row['order_number'];?>">
			
			</td>	</tr>
		<?php
		}
?>
		</table>
		<br />		
		<input type="submit" name="deletebtn" value="Delete Order">
		<?php 
			if(isset($_POST['deletebtn'])){
			$noOfRecords=count($_POST['records']);
			$r=0;
			while($r<$noOfRecords){
				$deleteKey=$_POST['records'][$r];
				$conn->query("Delete from order_tb where order_number='$deleteKey'");
				$r++;				
				}	
			header("Refresh:0");				
			}
			?>
			</form>
	</center>

</body>

<style>
 
  table { 
	
	border:solid 7px;
    border-top-color:#FEB9B9;
    border-right-color:#B22222;
    border-bottom-color:#B22222;
    border-left-color:#FEB9B9;
	background-color:white;
    color: black;	}
    
  
</style>