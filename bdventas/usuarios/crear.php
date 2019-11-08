<?php
	require '../conexion.php';
	$usuario=$_POST['usuario'];
	$password=$_POST['password'];
	$nombres=$_POST['nombres'];

	$query=$conexion->prepare("INSERT INTO usuarios (usuario, password, nombres) VALUES(?,?,?)");
	$resultado=$query->execute(array($usuario, $password, $nombres));

	if($resultado){
		$id=$conexion->lastInsertId();
		$datos=array("CREATE"=>"OK", "ID"=>$id);
	}
	else{
		$datos=array("CREATE"=>"ERROR");
	}
	echo json_encode($datos);
	
?>