<?php
	try{
		$conexion = new PDO("mysql:host=localhost;dbname=egresados","root","");
	}catch (Exception $e){
		echo $e->getMessage();

	}

?>