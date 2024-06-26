<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Paweł Frąckowiak"/>
    <title>Id sesji - ćw 1</title>
</head>
<body>
<?php

    //echo "<br>Jestem ".session_id();

    $ts = array();
    for($i=0;$i<10;$i++) {
        $liczba = rand(-100,100);
        $ts[$i] = $liczba;           
    }
    echo "Losowana tablica: ";
    echo "<table>";
    for($i=0;$i<10;$i++) {
        echo "<tr><td>".$ts[$i]."</td></tr>";  
    } 
    echo "</table>";
    echo "<br>";

    session_start();

    //$_SESSION["tablica"] = $ts;
/*
    stworz_tablice();
    $_SESSION["tablica1"] = $ts;
    stworz_tablice();
    $_SESSION["tablica2"] = $ts;
    stworz_tablice();
    $_SESSION["tablica"] = $ts;

    $ts = $_SESSION["tablica"];
    wypisz_tablice();
*/

    if (!isset($_SESSION["tablica"])) {
        $_SESSION["tablica"] = $ts;
    } 
    echo "Tablica w sesji: ";
    echo "<table>";
    for($i=0;$i<10;$i++) echo "<tr><td>".$_SESSION["tablica"][$i]."</td></tr>";
    echo "</table>";
    echo "<br>";

    $_SESSION["tablica2"] = array();
    echo "Druga tablica w sesji: ";
    echo "<table>";
    for ($i=0;$i<10;$i++) { 
    $_SESSION["tablica2"][$i] = rand(-100,100);
    echo "<tr><td>".$_SESSION["tablica2"][$i]."</td></tr>"; 
    }
    echo "</table>";
    /*
    function stworz_tablice() {
        global $ts;
        for($i=0;$i<10;$i++) {
            $liczba = rand(-100,100);
            $ts[$i] = $liczba;           
        }
    }

    function wypisz_tablice() {
        global $ts;
        for($i=0;$i<10;$i++) { echo "<tr><td>".$ts[$i]."</td></tr>"; }
    }
    */
?>
</body>
</html>