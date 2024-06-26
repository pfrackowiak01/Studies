<?php
$w = 0;
$z = 0;
$m = 0;
do {
$i = rand(-10,10);
if ($i > 0) {
    $w += 1;
    echo "<span style='color:green'>Wylosowana liczba z zakresu (od -10 do 10) to $i</span><br>";
}
if ($i == 0) {
    $z += 1;
    echo "<span style='color:yellow'>Wylosowana liczba z zakresu (od -10 do 10) to $i</span><br>";
}
if ($i < 0) {
    $m += 1; 
    echo "<span style='color:red'>Wylosowana liczba z zakresu (od -10 do 10) to $i</span><br>";
}
} while ($i < 10 && $i > -10);
echo "<p>Liczb większych od zera jest $w</p>";
echo "<p>Liczb równych zero jest $z</p>";
echo "<p>Liczb mniejszych od zera jest $m</p>";

?>