<!DOCTYPE html>
<html lang='pl'>
    <head>
        <title>Zadanie 6</title>
        <meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="client6.css">
    </head>
    <body>
		<h1>Zadanie 6 - Baza danych Biblioteka</h1>
		
		<fieldset>
            <legend><h3>Wyszukiwanie książki w bazie danych</h3></legend>
            <form action="client6.php" method="get">
                <label>Podaj informację odnośnie poszukiwanej książki: <input type="text" name="informacja" id="informacja" required></label><br><br>
				<label>Zaznacz czego dokładnie dotyczy podana informacja:</label><br>
                <label><input type="radio" name="kategorieKsiazki[]" value="tytul"> Tytuł</label><br>
                <label><input type="radio" name="kategorieKsiazki[]" value="wydawnictwo"> Wydawnictwo</label><br>
                <label><input type="radio" name="kategorieKsiazki[]" value="kategoria"> Kategoria</label><br>
                <br>
                <input type="submit" value="Wyszukaj"><br>
            </form>
        </fieldset>
		<br>
<?php

if(isset($_GET["informacja"], $_GET["kategorieKsiazki"])) {

	$host = "127.0.0.1";
	$port = 7777; // tutaj port i host muszą być takie same jak zdefiniowano w server.php.
	$message = "";
	set_time_limit(0);

	$informacja = $_GET["informacja"];
	$kategorie = $_GET["kategorieKsiazki"];

	if (empty($informacja) || empty($kategorie)) die("Uzupełnij dane!");
	else {
		if (in_array("tytul", $kategorie)) $kategoria = "tytul";
		else if (in_array("autor", $kategorie)) $kategoria = "autor";
		else if (in_array("wydawnictwo", $kategorie)) $kategoria = "wydawnictwo";
		else if (in_array("kategoria", $kategorie)) $kategoria = "kategoria";
	}

	$message = $kategoria . ":" . $informacja;
	
	$socket = socket_create(AF_INET, SOCK_STREAM, 0) or die("Nie można utworzyć socketa\n");

	$result = socket_connect($socket, $host, $port) or die("Nie można połączyć się z serwerem\n");
	echo "Socket połączony na porcie $port z $host\n <br>";
	socket_write($socket, $message, strlen($message)) or die("Could not send data to server\n");
	echo "Message to server : $message\n <br>";
	$result = socket_read($socket, 1024) or die("Could not read  server response\n");
	$rows = explode("\n", $result);
	echo <<<TABLEHEADER
	<table>\n
	<thead>
	<tr>
		<td>Nazwa książki</td>
		<td>Wydawnictwo</td>
		<td>Kategoria</td>
	</tr>
	</thead>
	<tbody>
	TABLEHEADER;
	for ($i = 0; $i < count($rows)-2; $i++) {
		if(!is_null($rows[$i])) {
			echo "<tr>";
			$values = explode("\t ", $rows[$i]);
			for ($j = 0; $j < count($values); $j++) echo "<td>$values[$j]</td>";
			echo "</tr>";
		}
	}
	echo "</tbody>";
	echo "</table>";
}

?>

</body>
</html>