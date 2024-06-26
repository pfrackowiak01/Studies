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
    session_start();
    $_SESSION["moja_zmienna"] = "Twoję imię i nazwisko";
    echo "<br>Jestem ".$_SESSION["moja_zmienna"];
    echo "<br>ID: ".session_id();
    ?>
</body>
</html>