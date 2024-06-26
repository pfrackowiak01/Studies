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
    <title>Lista Pojazdów</title>
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
<h1>To jest nasza lista pojazdów!</h1><br>

<fieldset>
      <legend><h2>Wybierz jakich dokładnie pojazdów szukasz:</h2></legend><br>
      <form method="get">
         <label><input type="radio" name="pojazdy[]" value="auto">Samochody</label><br><br>
         <label><input type="radio" name="pojazdy[]" value="skuter">Skutery</label><br><br>
         <label><input type="radio" name="pojazdy[]" value="helikopter">Helikoptery</label><br><br>
         <input type="submit" value="Wyświetl">
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
    
if (isset($_GET["pojazdy"])) {
    $pojazdy = $_GET["pojazdy"];
    if (in_array("auto", $pojazdy)) {
        GenerujOpisy("auta","dlugi");
    }
    if (in_array("skuter", $pojazdy)) {
        GenerujOpisy("skutery","dlugi");
    }
    if (in_array("helikopter", $pojazdy)) {
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