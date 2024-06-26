<!DOCTYPE html>
<html lang='pl'>
    <head>
        <title>ZADANIE 2</title>
        <meta charset="UTF-8">
        <meta name="author" content="Paweł Frąckowiak">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="fp.css">
    </head>
    <body>
		<h1>Zadanie 2</h1>
		<h1>Lista pracowników</h1>
		<table><tr>
		<th>ID</th><th>Nazwisko</th><th>Imie</th><th>Wiek</th><th>Doświadczenie</th><th>Zainteresowania</th><th>Edytuj/usuń</th>
        <?php
		
			session_start();
			include_once('db_pgsql.php');
			include_once('pracownik.php');
			$db = new DbPgSql();
			$idp = -1;
				
				$db->connect();
				$sql = "SELECT * FROM rekrutacja.pracownicy";
				$db->query($sql);
				$db->disconnect();
				
				while($line=pg_fetch_array($db->get_result(),null,PGSQL_ASSOC)) {
					echo "</tr><tr>";
					foreach($line as $col_value) {
						echo "<td>$col_value</td>";
					}
					echo "<td><a href=\"lista_pracownikow.php?pracownik=".$line["idp"]."\">Edytuj/usuń</a></td>";
					
					if(isset($_GET["pracownik"])) {
						if($line["idp"]==$_GET["pracownik"]) {
							$idp = intval($_GET["pracownik"]);
							$nazwisko = $line["nazwisko"];
							$imie = $line["imie"];
							$wiek = $line["wiek"];
							$doswiadczenie = $line["doswiadczenie"];
							$zainteresowania = $line["zainteresowania"];
						}
					}
				}
				
				echo "</tr></table>";
			
			if(isset($_GET["pracownik"])) {
				
				if($idp > 0) {
					echo<<<END
					<h2>Edytuj $nazwisko $imie</h2>
					<form action="zmien.php" method="POST">
						<label for="nazwisko">Nazwisko<span class="ylli-i-kuq">*</span></label><br>
						<input id="nazwisko" name="nazwisko" placeholder="Podaj nazwisko" value="$nazwisko" required><br>
						<label for="imie">Imię<span class="ylli-i-kuq">*</span></label><br>
						<input id="imie" name="imie" placeholder="Podaj imię" value="$imie" required><br>
						<label for="wiek">Wiek<span class="ylli-i-kuq">*</span></label><br>
						<input id="wiek" name="wiek" placeholder="Podaj wiek" value="$wiek" required><br><br>
						<label for="doswiadczenie">Doświadczenie zawodowe<span class="ylli-i-kuq">*</span></label><br>
						<textarea id="doswiadczenie" name="doswiadczenie" placeholder="Opisz swoje doświadzenie" rows="6" cols="48" required>$doswiadczenie</textarea><br>
						<label for="zainteresowania">Zainteresowania<span class="ylli-i-kuq">*</span></label><br>
						<textarea id="zainteresowania" name="zainteresowania" placeholder="Opisz swoje zainteresowania" rows="6" cols="48" required>$zainteresowania</textarea><br>
						<input type="submit" value="Zapisz">
					</form>
					<br>
					<button onclick="window.location='usun.php?pracownik=$idp';" >Usunąć $nazwisko $imie?</button>
END;
				}
				else {
					echo "<p class='kuq'><i>Wybrany pracownik nie istnieje.</i></p>";
				}
			}
			else {
				echo "<p class='kuq'><i>Najpierw wybierz pracownika.</i></p>";
			}
			
		?>
    </body>
</html>