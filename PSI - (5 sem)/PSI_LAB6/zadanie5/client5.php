<?php

$host = "127.0.0.1";
$port = 5000; // tutaj port i host muszą być takie same jak zdefiniowano w server.php.
// No Timeout
set_time_limit(0);
//$message = "Gdynia";
$message = "quit";
//$message = "shutdown";

while(true) {
	$message = readline("Wprowadź zapytanie w formie znajdz:imie|nazwisko|wiek|wzrost|waga|plec:wartosc ");

	$socket = socket_create(AF_INET, SOCK_STREAM, 0) or die("Could not create socket\n");
	echo "Socket Create\n";

	$result = socket_connect ($socket, $host, $port);
	if ($result < 0) {
	 echo "socket_connect() failed.\nReason: ($result) " . socket_strerror($result) . "\n";
	} else {
	 echo "The connection to the server '$host' has been established\n";
	}
	
	socket_write($socket, $message, strlen($message)) or die("Could not send data to server\n");
	echo "Message to server : $message\n";

	$result = socket_read ($socket, 1024) or die("Could not read server response\n");
	echo $result."\n";

	if($message == "quit") {
		socket_close($socket);
		break;
	}
}

?>