<?php

	$ref = $_SERVER['HTTP_REFERER'];
	$idp = intval(substr($ref,strlen("https://foka.umg.edu.pl/~s47620/3%20rok/psi/PSI_LAB5/lista_pracownikow.php?pracownik="),strlen($ref)));
	
	$nazwisko = $_POST["nazwisko"];
	$imie = $_POST["imie"];
	$wiek = $_POST["wiek"];
	$doswiadczenie = $_POST["doswiadczenie"];
	$zainteresowania = $_POST["zainteresowania"];
	
	include_once('db_pgsql.php');
	$db = new DbPgSql();
	$db->connect();
	$sql = "UPDATE rekrutacja.pracownicy SET nazwisko='$nazwisko', imie='$imie', wiek=$wiek, doswiadczenie='$doswiadczenie', zainteresowania='$zainteresowania' WHERE idp=$idp;";
	$db->query($sql);
	$db->disconnect();
	
	header("Location: lista_pracownikow.php");
?>