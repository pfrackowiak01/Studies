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
        $n = $_GET['potega'];

        if ($n == "") echo "Uzupełnij pole z potęgą n!";
        else {
            if ($n <= 46340) {
            if (filter_var($n, FILTER_VALIDATE_INT) == !FALSE) {
                for ($i = 0; $i <= $n; $i++) {
                    $wynik = 2 ** $i;
                    echo "2<sup>$i</sup> = $wynik<br>";
                    }
                } else echo "Liczba n jest za duża, podaj mniejszą liczbę!";
            } else echo "Podaj poprawną potęgę n (musi być liczbą całkowitoliczbową)!";
        }
    ?>
</body>
</html>