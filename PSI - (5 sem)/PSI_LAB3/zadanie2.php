<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pawel Frackowiak</title>
</head>
<body>
<?php

if (isset($_POST['liczba']))
{
$n = $_POST['liczba'];

if ($n == "") echo "Uzupełnij pole w zadaniu 2!";
else {
    $wzor = "/[A-Z]{3}[0-9]{4}/";
    if (strlen($n) == 7) {
    if (preg_match($wzor,$n) == 0) {
        echo "Nieprawidłowe dane w zadaniu 2!";
    }
    else {
        $sum = (int)$n[3] + (int)$n[4] + (int)$n[5] + (int)$n[6];
        if ($sum > 20) echo "Zbyt duża suma cyfr!<br>Suma cyfr wynosi $sum";
        else echo "Prawidłowe dane w zadaniu 2!<br>Suma cyfr wynosi $sum";
        }
    }  
    else echo "Nieprawidłowa ilość znaków w zadaniu 2!";
}
}
?>
</body>
</html>