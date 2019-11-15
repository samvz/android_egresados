<?php
	require '../conexion.php';
	
	$query = $conexion->prepare("SELECT * FROM persona");

	$query->execute();
	$personas = $query->fetchAll(PDO::FETCH_ASSOC);

	header("content-type:application/json");
	
	echo json_encode($personas);


?>