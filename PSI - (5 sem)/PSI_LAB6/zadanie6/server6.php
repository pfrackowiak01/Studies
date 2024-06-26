<?php

require_once("db_pgsql.php");
$pgdb = new DbPgSql();
$host = "127.0.0.1"; // twoje lokalne IP w systemie
$port = 7777; // Numer portu może być dowolną dodatnią liczbą całkowitą z przedziału od 1024 do 65535.
set_time_limit(0);

// create socket
$socket = socket_create(AF_INET, SOCK_STREAM, 0) or die("Could not create socket\n");

$result = socket_bind($socket, $host, $port) or die("Could not bind to socket\n");
echo "bind socket to port: $port on host: $host\n";

$result = socket_listen($socket, 3) or die("Could not set up socket listener\n");
echo "start listening for connections - socket listen\n";

$spawn = socket_accept($socket) or die("Could not accept incoming connection\n");
echo "spawn another socket to handle communication\n";

while(true) {

	$input = socket_read($spawn, 1024) or die("Could not read input\n");
	echo "read client input from socket\n";
	echo "Client message :".$input."\n";
	
	$parametry = explode(":",$input);
	$output = "";
	$pgdb->connect();

	if ($pgdb->getStatus()) {
		$query = "SELECT ksiazki.ksiazka.tytul, ksiazki.wydawnictwo.nazwa, ksiazki.kategoria.opis  FROM ksiazki.ksiazka, ksiazki.wydawnictwo, ksiazki.kategoria ";
		
		if ($parametry[0] == "wydawnictwo") $query .= "WHERE ksiazki.wydawnictwo.nazwa = '$parametry[1]'";
		else if ($parametry[0] == "kategoria") $query .= "WHERE ksiazki.kategoria.opis = '$parametry[1]'";
		else $query .= "WHERE $parametry[0] = '$parametry[1]'";
	
		$query .= " AND ksiazki.wydawnictwo.idw = ksiazki.ksiazka.idwyd AND ksiazki.kategoria.idk = ksiazki.ksiazka.idk";
		echo "\n SQL Query: ".$query."\n";
		$queryResult = $pgdb->query($query);
		
		if (!$queryResult) $output = "Błąd w zapytaniu!";
		else {
			while($line = pg_fetch_array($queryResult,null,PGSQL_ASSOC)) {
				$output .= implode("\t ",$line);
				$output .= "\n";
			}
			$output .= "\n";
			$pgdb->disconnect();
		}
	}
	socket_write($spawn, $output) or die("Could not write output\n");
	$output = "";
}

?>