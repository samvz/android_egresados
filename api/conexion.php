<?php
	try{
		$conexion = new PDO("mysql:host=localhost;dbname=egresados","root","",array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
	}catch (Exception $e){
		echo $e->getMessage();

	}

?>