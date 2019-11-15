<?php
	require '../conexion.php';
	$usuario=$_POST['usuario'];
	$password=$_POST['password'];
	$id_perfil=$_POST['id_perfil'];
	$id_perfil=$_POST['id_persona'];

	

	$query=$conexion->prepare("INSERT INTO usuarios (usuario, password) VALUES(?,?)");
	$resultado=$query->execute(array($usuario, $password));

	if($resultado){
		$id=$conexion->lastInsertId();
		$datos=array("CREATE"=>"OK", "ID"=>$id);
	}
	else{
		$datos=array("CREATE"=>"ERROR");
	}
	echo json_encode($datos);
	
?>