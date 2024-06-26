<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Auta, Skutery, Helikoptery - Zobacz je wszystkiej i zdecyduj, które bieremy!"/>
    <meta name="keywords" content="auta, auto, samochód, samochod, skuter, skutery, helikopter, helikoptery, fiat, puma, simba"/>
    <meta name="author" content="Paweł Frąckowiak"/>
    <link rel="stylesheet" href="style.css">
    <title>Wszystkie Pojazdy</title>
</head>
<body>
    <div class="navbar">
        <div class="top">
            <div class="menu">
            <a href="index.php">Strona Główna</a>
            <a href="lista.php">Lista pojazdów</a>
            <a href="wszystkie.php">Wszystkie pojazdy</a>
            </div>
        </div>
    </div>
<h1>To są nasze WSZYSTKIE pojazdy!</h1>
<fieldset>
<legend><h3>Przejrzyj je wszystkie:</h3></legend><br>
<form method = "get">
<label></label><input type="radio" name="blok[]" value="dlugie">Długie Opisy<br><br>
<label></label><input type="radio" name="blok[]" value="krotkie">Krótkie Opisy<br><br>
<input type="submit" value="Wyświetl"><br><br>
</form>
</fieldset>
<div class="pojazdy">
    <?php
    require_once("Auto.php");
    require_once("Skuter.php");
    require_once("Helikopter.php");
    require_once("OpisHtmlDlugiBlok.php");
    require_once("OpisHtmlKrotkiBlok.php");
    require_once("GenerujOpisy.inc");
    
    if (isset($_GET["blok"])) {
        $opis = $_GET["blok"];
        if (in_array("krotkie", $opis)) {
            GenerujOpisy("auta","krotki");
            GenerujOpisy("skutery","krotki");
            GenerujOpisy("helikoptery","krotki");
        }
        else {
            GenerujOpisy("auta","dlugi");
            GenerujOpisy("skutery","dlugi");
            GenerujOpisy("helikoptery","dlugi");
        }
    }
 
    ?>
    </div>
    <footer>
        <div class="topper">
            <a href="#top">Kliknij w strzałkę, żeby przejść na górę strony</a>
            <a href="#top"><img  src="images/strzalka.png" alt="Przejdź na górę" width="40" height="35"></a>
        </div>
    </footer>   
</body>
</html>