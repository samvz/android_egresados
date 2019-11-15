<?php
	require '../conexion.php';
	$nombre=$_POST['nombre'];

	$query=$conexion->prepare("INSERT INTO tipo_doc (nombre) VALUES(?)");
	$resultado=$query->execute(array($nombre));


	if($resultado){
		$id=$conexion->lastInsertId();
		$datos=array("CREATE"=>"OK", "ID"=>$id);
	}
	else{
		$datos=array("CREATE"=>"ERROR");
	}
	echo json_encode($datos);
	
?>