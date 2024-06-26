<?php
for ($x = 0; $x < 12; $x++) {
$i = rand(-100,100);
if ($i % 2 == 0) echo "<li><span style='color:green'>Wylosowana liczba z zakresu (od -100 do 100) to $i</span></li>";
if ($i % 2 == 1) echo "<li><span style='color:red'>Wylosowana liczba z zakresu (od -100 do 100) to $i</span></li>";
}

?>