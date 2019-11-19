<?php
	require '../conexion.php';
	$query = $conexion->prepare("SELECT * FROM tipo_doc");

	$query->execute();
	$documentos = $query->fetchAll(PDO::FETCH_ASSOC);
	
	echo json_encode($documentos);

?>