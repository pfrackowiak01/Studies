<?php

$host = "127.0.0.1";
$port = 10000; // tutaj port i host muszą być takie same jak zdefiniowano w server.php.

// No Timeout
set_time_limit(0);
$message = "Gdynia";

while (true) {

    echo "------------------------------------\n";
    echo "Welcome to server on $host\n";
    echo "Client: The 'shutdown' command terminates server and client\n";
    echo "Client: The 'quit' command terminates the client\n";
    echo "Enter a message / command:\n";

    $message = readline();
    //if ($message == "shutdown") socket_close($socket); //break;
    if ($message == "quit") socket_close($spawn);

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
echo "Reply From Server : ".$result;

}

socket_close($socket);

?>