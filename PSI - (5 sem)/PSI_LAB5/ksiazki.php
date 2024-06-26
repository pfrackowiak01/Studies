<!DOCTYPE html>
<html lang='pl'>
    <head>
        <title>Ćwiczenie 2</title>
        <meta charset="UTF-8">
		<meta name="author" content="Paweł Frąckowiak">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="style.css">
    </head>
    <body>
		<h1>Ćwiczenie 2</h1>

        <?php
		
			// Definicja parametrów połączenia
			$host='localhost';
			$port='5432';
			$database='s47620';
			$user='s47620';
			$password='8Mg7Mh6Um4Ee'; // haslo należy zweryfikować
			
			// Zdefiniowanie połączenia w formie łańcucha
			$conn_string = "host=$host port=$port dbname=$database user=$user password=$password";
			$conn=pg_connect($conn_string) or die ("Nie można podłączyć się do Postgresql\n");
			
			// Zbudowanie zapytania SQL query do tebeli ksiazka w schemacie ksiazki
			$query = 'SELECT * FROM ksiazki.ksiazka';
			$result = pg_query($conn,$query) or die ('Błąd zapytania: ' . pg_last_error());
			
			// wydruk rezultatu w formie tabeli HTML
			echo "<table>\n";
			while($line=pg_fetch_array($result,null,PGSQL_ASSOC)) {
				echo "\t<tr>\n";
				foreach($line as $col_value) {
					echo "\t\t<td>$col_value</td>\n";
				}
				echo "\t</tr>\n";
			}
			echo "</table>\n";
			
			// zwolnienie pamięci
			pg_free_result($result);
			
			// zamknięcie połączenia
			pg_close($conn);
			
		?>
    </body>
</html>