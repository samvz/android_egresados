<?php
	require '../conexion.php';

	if (!empty($_POST))
	{
		$datos = array(
			":id_persona" => isset($_POST['id_persona']) ? $_POST['id_persona'] : '',
			":nombres" => isset($_POST['nombres']) ? $_POST['nombres'] : '',
			":apellidos" => isset($_POST['apellidos']) ? $_POST['apellidos'] : '',
			":direccion" => isset($_POST['direccion']) ? $_POST['direccion'] : '',
			":telefono" => isset($_POST['telefono']) ? $_POST['telefono'] : '',
			":celular" => isset($_POST['celular']) ? $_POST['celular'] : '',
			":email" => isset($_POST['email']) ? $_POST['email'] : '',
			":sexo" => isset($_POST['sexo']) ? $_POST['sexo'] : '',
			":foto" => isset($_POST['foto']) ? $_POST['foto'] : '',
			":id_tipo_doc" => isset($_POST['id_tipo_doc']) ? $_POST['id_tipo_doc'] : '',
			":id_ubigeo" => isset($_POST['id_ubigeo']) ? $_POST['id_ubigeo'] : '',
			":id_cargo" => isset($_POST['id_cargo']) ? $_POST['id_cargo'] : '',
		);

		try {
			$query=$conexion->prepare("UPDATE persona SET nombres = :nombres, apellidos =:apellidos, direccion =:direccion, telefono =:telefono, 
						celular =:celular, email =:email, sexo =:sexo, foto =:foto, id_tipo_doc =:id_tipo_doc, id_ubigeo =:id_ubigeo, id_cargo =:id_cargo
						WHERE id_persona =:id_persona");
			$resultado=$query->execute($datos);

			$datos=array("UPDATE"=>"OK");

		} catch (Exception $e) {
		    $datos=array("UPDATE"=>"ERROR");
		}	
		
		echo json_encode($datos);
		
	}
	
?>