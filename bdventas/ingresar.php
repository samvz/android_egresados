<?php

	require 'conexion.php';
	$usuario=$_POST['usuario'];
	$password=$_POST['password'];

	session_start();
	if(isset($_SESSION['usuario'])){

		$datos=array("LOGIN" =>"OK");
	}

	if($_SERVER["REQUEST_METHOD"]=="POST"){

		$query=$conexion->prepare("SELECT * FROM usuarios WHERE usuario=? AND password=? AND estado=1");
		$query->execute(array($usuario, $password));
		$resultado=$query->fetch();
		if($resultado){

			$_SESSION['usuario']=$resultado["nombres"];
			$datos=array("LOGIN"=>"OK");


		}
		else{
			$datos=array("LOGIN"=>"ERROR");
		}
		

	}
	echo json_encode($datos);
?>