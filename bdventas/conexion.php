<?php
	try{
		$conexion = new PDO("mysql:host=localhost;dbname=bdventas","root","");
	}catch (Exception $e){
		echo $e->getMessage();

	}

?>