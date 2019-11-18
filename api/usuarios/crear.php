<?php
	require '../conexion.php';

	if (!empty($_POST))
	{
		$datos = array(
			":id_perfil" => isset($_POST['id_perfil']) ? $_POST['id_perfil'] : '',
			":id_persona" => isset($_POST['id_persona']) ? $_POST['id_persona'] : '',
			":usuario" => isset($_POST['usuario']) ? $_POST['usuario'] : '',
			":password" => isset($_POST['password']) ? $_POST['password'] : ''
		);

		try {
			$query=$conexion->prepare("INSERT INTO usuario (id_perfil, id_persona, usuario, password) VALUES(:id_perfil, :id_persona, :usuario, :password)");
			$resultado=$query->execute($datos);

			$datos=array("CREATE"=>"OK");

		} catch (Exception $e) {
		    $datos=array("CREATE"=>"ERROR");
		}	
		
		echo json_encode($datos);
		
	}
	
?>