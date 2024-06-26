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

$n = $_POST['n'];
$z = $_POST['z'];
$tab = array();
$opcja = $_POST['wybierz'];
$color = $_POST['kolor'];

if ($n == "" || $z == "") echo "Uzupełnij wszystkie pola w zadaniu 4!";
else {
    if ($n >= $z/2) echo "Ilość liczb (n) musi być mniejsza od połowy górnego zakresu (z)!";
    else {
        for($i=0;$i<$n;$i++){
            do {
                $liczba = rand(0,$z);
            }
            while(in_array($liczba,$tab));
            $tab[$i] = $liczba;                
        }
        for ($i = 0; $i < $n; $i++) {
            if ($opcja == 'parzyste') {
                if (($tab[$i])%2 == 0) echo "<span style='background-color:$color'>".$tab[$i]."</span><br>";
                else echo "<span>".$tab[$i]."</span><br>";
            }
            if ($opcja == 'nieparzyste') {
                if (($tab[$i])%2 == 1) echo "<span style='background-color:$color'>".$tab[$i]."</span><br>";
                else echo "<span>".$tab[$i]."</span><br>";
            }
            if ($opcja == 'podzielne3') {
                if (($tab[$i])%3 == 0) echo "<span style='background-color:$color'>".$tab[$i]."</span><br>";
                else echo "<span>".$tab[$i]."</span><br>";
            }
            if ($opcja == 'podzielne5') {
                if (($tab[$i])%5 == 0) echo "<span style='background-color:$color'>".$tab[$i]."</span><br>";
                else echo "<span>".$tab[$i]."</span><br>";
            }
        }
    }
}
?>
</body>
</html>