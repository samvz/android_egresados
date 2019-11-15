<?php
	try{
		$conexion = new PDO("mysql:host=localhost;dbname=app_egresados","app_egresados",".egresados-");
	}catch (Exception $e){
		echo $e->getMessage();

	}

?>