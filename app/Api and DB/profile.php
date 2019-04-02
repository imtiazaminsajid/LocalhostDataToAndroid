<?php
header('content-type: application/json');
$host="localhost";
$user="root";
$password="";
$db_name="test_db";

$conn=mysqli_connect($host,$user,$password,$db_name);



if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$sql = "SELECT * FROM test";
$result = mysqli_query($conn,$sql);

while($row = mysqli_fetch_assoc($result))
{
    $array[]=$row;
}

echo json_encode($array);

mysqli_close($conn);
?>