<?php

	$ref = $_SERVER['HTTP_REFERER'];
	$idp = intval(substr($ref,strlen("https://foka.umg.edu.pl/~s47620/3%20rok/psi/PSI_LAB5/lista_pracownikow.php?pracownik="),strlen($ref)));
	
	include_once('db_pgsql.php');
	$db = new DbPgSql();
	$db->connect();
	$sql = "DELETE FROM rekrutacja.pracownicy WHERE idp=$idp;";
	$db->query($sql);
	$db->disconnect();
	
	header("Location: lista_pracownikow.php");
?>