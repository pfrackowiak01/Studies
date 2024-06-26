<!DOCTYPE html>
<html lang='pl'>
    <head>
        <title>Zadanie 4</title>
        <meta charset="UTF-8">
		<link rel="stylesheet" href="stylesheet.css">
    </head>
    <body>
		<h1>Zadanie 4 - Losowanie n liczb</h1>
		
		<form action="client4.php" method="GET">
			<table>
				<tr>
					<td>
						<label for="n">Podaj liczbę n:</label>
					</td>
					<td>
						<input id="n" name="n" type="number">
					</td>
				</tr>
			</table>
			<br><input type="submit" value="Losuj liczby">
		</form>
        
        <?php

			if(isset($_GET["n"])) {
				$message = $_GET["n"];
				$host = "127.0.0.1";
				$port = 10000; // tutaj port i host muszą być takie same jak zdefiniowano w server.php.
				// No Timeout
				set_time_limit(0);
				
				$socket = socket_create(AF_INET, SOCK_STREAM, 0) or die("Could not create socket\n");

				$result = socket_connect ($socket, $host, $port);
				if ($result < 0) echo "socket_connect() failed.\nReason: ($result) " . socket_strerror($result) . "\n";
				
				socket_write($socket, $message, strlen($message)) or die("Could not send data to server\n");

				$result = socket_read ($socket, 1024) or die("Could not read server response\n");
				echo "<p>Utworzono gniazdo</p>";
				echo "<p>Gniazdo połączone z portem $port na hoście/serwerze $host</p>";
				echo "<p>Przesyłany komunikat do serwera: ".$_GET["n"]."</p>";
				echo "<p>$result</p>";
				socket_close($socket);
			}
        ?>
	</body>
</html>