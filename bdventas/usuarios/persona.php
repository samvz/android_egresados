<?php
	include '../conexion.php';
	$nombres=$_POST['nombres'];
	$apellidos=$_POST['apellidos'];
	$direccion=$_POST['direccion'];
	$telefono=$_POST['telefono'];
	$celular=$_POST['celular'];
	$email=$_POST['email'];
	$sexo=$_POST['sexo'];
	$foto=$_POST['foto'];
	$tipo_doc=$_POST['id_tipo_doc'];
	$ubigeo=$_POST['id_ubigeo'];
	$cargo=$_POST['id_cargo'];


	$query=$conexion->prepare("INSERT INTO persona (nombres, apellidos, direccion, telefono, celular, email, sexo, foto) VALUES(?,?,?) WHERE id_persona=id_tipo_doc and id_tipo_doc=id_cargo and id_cargo=id_ubigeo");
	$resultado=$query->execute(array($usuario, $password, $nombres));

	if($resultado){
		$id=$conexion->lastInsertId();
		$datos=array("CREATE"=>"OK", "ID"=>$id);
	}
	else{
		$datos=array("CREATE"=>"ERROR");
	}
	echo json_encode($datos);
	
?>