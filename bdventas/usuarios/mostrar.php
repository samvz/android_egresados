<?php
	require '../conexion.php';
	$query = $conexion->prepare("SELECT u.usuario, u.password, p.nombre as perfil FROM usuario u, perfil p WHERE u.id_perfil=p.id_perfil");

	$query->execute();
	$usuarios = $query->fetchAll(PDO::FETCH_ASSOC);
	
	echo json_encode($usuarios);

?>