<?php

require_once("osoby.php");

$host = "127.0.0.1"; // twoje lokalne IP w systemie
$port = 5000; // Numer portu może być dowolną dodatnią liczbą całkowitą z przedziału od 1024 do 65535.
set_time_limit(0);

// create socket
$socket = socket_create(AF_INET, SOCK_STREAM, 0) or die("Could not create socket\n");

$result = socket_bind($socket, $host, $port) or die("Could not bind to socket\n");
echo "bind socket to port: $port on host: $host\n";

$result = socket_listen($socket, 3) or die("Could not set up socket listener\n");
echo "start listening for connections - socket listen\n";

while(true) {

$spawn = socket_accept($socket) or die("Could not accept incoming connection\n");
echo "spawn another socket to handle communication\n";

$input = socket_read($spawn, 1024) or die("Could not read input\n");
echo "read client input from socket\n";
echo "Client message :".$input."\n";

if($input=="quit") {
	$msg = "Koniec pracy klienta i serwera.";
	echo "Server message :".$msg."\n";
	socket_write($spawn, $msg, strlen ($msg)) or die("Could not write output\n");
	socket_close($spawn);
	socket_close($socket);
	break;
}
else {
	$query = explode(":",$input);
	$msg = "";
	
	if(count($query)==3) {
		
		switch($query[1]) {
			case "imie":
				$osoby = $o->search_by_fname($query[2]);
				//print_r($osoby);
				for($i=0; $i<count($osoby); $i++) {
					$msg .= $osoby[$i]->info()."\n";
				}
			break;
			case "nazwisko":
				$osoby = $o->search_by_lname($query[2]);
				//print_r($osoby);
				for($i=0; $i<count($osoby); $i++) {
					$msg .= $osoby[$i]->info()."\n";
				}
			break;
			case "wiek":
				$osoby = $o->search_by_age($query[2]);
				//print_r($osoby);
				for($i=0; $i<count($osoby); $i++) {
					$msg .= $osoby[$i]->info()."\n";
				}
			break;
			case "wzrost":
				$osoby = $o->search_by_height($query[2]);
				//print_r($osoby);
				for($i=0; $i<count($osoby); $i++) {
					$msg .= $osoby[$i]->info()."\n";
				}
			break;
			case "waga":
				$osoby = $o->search_by_weight($query[2]);
				//print_r($osoby);
				for($i=0; $i<count($osoby); $i++) {
					$msg .= $osoby[$i]->info()."\n";
				}
			break;
			case "plec":
				$osoby = $o->search_by_gender($query[2]);
				//print_r($osoby);
				for($i=0; $i<count($osoby); $i++) {
					$msg .= $osoby[$i]->info()."\n";
				}
			break;
			default:
				$msg = "Nie ma takiego parametru jak ".$query[1];
			break;
		}
	}
	else {
		$msg = "Błąd - liczba elementów musi wynosić dokładnie 3.";
	}
	
	if($msg=="")
		$msg="Brak wyników.";
	echo "Server message :".$msg."\n";
	socket_write($spawn, $msg, strlen ($msg)) or die("Could not write output\n");
}

}

?>