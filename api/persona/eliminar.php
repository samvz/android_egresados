<?php
	require '../conexion.php';

	if (!empty($_POST))
	{

		$id_persona = isset($_POST['id_persona']) ? $_POST['id_persona'] : '';

		try {
			$query=$conexion->prepare("DELETE FROM persona WHERE id_persona = ?");
			$resultado=$query->execute(array($id_persona));

			$datos=array("DELETE"=>"OK");

		} catch (Exception $e) {
		    $datos=array("DELETE"=>"ERROR");
		}	
		
		echo json_encode($datos);
	}
	
	
?>