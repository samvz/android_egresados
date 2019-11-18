<?php

	require 'conexion.php';

	$datos = null;
	
	session_start();
	if(isset($_SESSION['usuario'])){

		$datos=array("LOGIN" =>"OK");
	}

	else if (!empty($_POST))
	{
		$usuario=$_POST['usuario'];
		$password=$_POST['password'];

		$query=$conexion->prepare("SELECT * FROM usuario WHERE usuario=? AND password=?");
		$query->execute(array($usuario, $password));
		$resultado=$query->fetch();

		if($resultado){
			$_SESSION['usuario']=$resultado["usuario"];
			$datos=array("LOGIN"=>"OK");
		}
		else{
			$datos=array("LOGIN"=>"ERROR");
		}
	}
	
	echo json_encode($datos);
?>