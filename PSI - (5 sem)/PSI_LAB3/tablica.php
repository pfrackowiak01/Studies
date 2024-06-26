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

$n = $_POST['tablica'];
$min = $_POST['min'] * 10;
$max = $_POST['max'] * 10;
$tab = array();
$suma = 0;
$sumak = 0;
$sumab = 0;
$zera = 0;
$dodatnie = 0;
$ujemne = 0;

if ($n == "" || $min == "" || $max == "") echo "Uzupełnij wszystkie pola w zadaniu 3!";
else {
    for ($i = 0; $i < $n; $i++) {
        $r = rand($min,$max);
        $tab[$i] = $r/10;
    }
    sort($tab);
    for ($i = 0; $i < $n; $i++) {
        echo "<br>$i : ".$tab[$i];
        if ($tab[$i] == 0) $zera++;
        if ($tab[$i] > 0) $dodatnie++;
        if ($tab[$i] < 0) $ujemne++;
        $suma += $tab[$i];
        $sumak += $tab[$i]**2;
        $sumab += abs($tab[$i]);
    }
    if (filter_has_var(INPUT_POST,'suma')) {
        echo "<br>Suma = $suma";
    }
    if (filter_has_var(INPUT_POST,'srednia')) {
        echo "<br>Średnia = ".($suma / $n);
    }
    if (filter_has_var(INPUT_POST,'maksimum')) {
        echo "<br>Maksymalna wartość = ".$tab[$n-1];
    }
    if (filter_has_var(INPUT_POST,'minimum')) {
        echo "<br>Minimalna wartość = ".$tab[0];
    }
    if (filter_has_var(INPUT_POST,'dodatnie')) {
        echo "<br>Ilość dodatnich = ".$dodatnie;
    }
    if (filter_has_var(INPUT_POST,'ujemne')) {
        echo "<br>Ilość ujemnych = ".$ujemne;
    }
    if (filter_has_var(INPUT_POST,'zera')) {
        echo "<br>Ilość zer = ".$zera;
    }
    if (filter_has_var(INPUT_POST,'kwadraty')) {
        echo "<br>Suma kwadratów = $sumak";
    }
    if (filter_has_var(INPUT_POST,'bezwzgledna')) {
        echo "<br>Suma wartości bezwzględnych = $sumab";
    }
}
?>
</body>
</html>