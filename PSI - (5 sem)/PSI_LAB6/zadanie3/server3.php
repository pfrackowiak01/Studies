<?php

$host = "127.0.0.1"; // twoje lokalne IP w systemie
$port = 10000; // Numer portu może być dowolną dodatnią liczbą całkowitą z przedziału od 1024 do 65535

// No timeout
set_time_limit(0);

// Create socket
$socket = socket_create(AF_INET, SOCK_STREAM, 0) or die("Could not create socket\n");

// Bind socket to port and host
$result = socket_bind($socket, $host, $port) or die("Could not bind to socket\n");
echo "bind socket to port: $port on host: $host\n";

while(true) {

    // Start listening to the port
    $result = socket_listen($socket, 3) or die("Could not set up socket listener\n");
    echo "start listening for connections - socket listen\n";

    // Make it to accept incoming connections
    $spawn = socket_accept($socket) or die("Could not accept incoming connection\n");
    echo "spawn another socket to handle communication\n";

    // Read the message from the client socket
    $input = socket_read($spawn, 1024) or die("Could not read input\n");
    echo "read client input from socket\n";

    // output
    require_once ("losuj.inc");

    //if ($input == "quit") socket_close($spawn);
    if ($input == "shutdown") break;
    $n = intval($input);
    if ($n > 0 && strval($n) == $input) {

        $tablica = losuj($n);
        $output = "Wylosowane liczby: [" . implode(", ",$tablica) . "] dla n = " . $n . "\n";  

    }
    else $output = "Error! Please enter correct number!\n";

    // Send message back to client socket
    socket_write($spawn, $output, strlen ($output)) or die("Could not write output\n");
}

socket_close($spawn); // zamkniecie gniazda komunikacji z klientem
socket_close($socket); // zamkniecie gniazda serwera /koniec nasłuchiwania

?>