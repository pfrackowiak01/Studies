<?php
function silnia($n) {
$wynik = 1;
if ($n == 0) $wynik = 0;
else for ($y = $n; $y > 1; $y--) $wynik *= $y;
return $wynik;
}
?>