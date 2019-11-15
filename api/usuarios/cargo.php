<?php
	include '../conexion.php';

	$nombre=$_REQUEST['nombre'];
	

	$query=$conexion->prepare("INSERT INTO cargo (nombre) VALUES(?)");
	$resultado=$query->execute(array($nombre));

    // var_dump($resultado); die;

	if($resultado){
		$id=$conexion->lastInsertId();
		$datos=array("CREATE"=>"OK", "ID"=>$id);
	}
	else{
		$datos=array("CREATE"=>"ERROR");
	}
	echo json_encode($datos);
	
?>