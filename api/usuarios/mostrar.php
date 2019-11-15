<?php
	require '../conexion.php';
	$query = $conexion->prepare("SELECT * FROM usuarios WHERE estado = 1");

	$query->execute();
	$usuarios = $query->fetchAll(PDO::FETCH_ASSOC);
	
	echo json_encode($usuarios);

?>