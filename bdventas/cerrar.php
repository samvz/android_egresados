<?php
	
	session_start();
	session_destroy();
	$datos= array('LOGIN' => "CLOSE");
	echo json_encode($datos);

?>