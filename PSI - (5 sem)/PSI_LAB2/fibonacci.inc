<?php

function fib($n) {
    global $dodawanie;
    if($n == 0) return 0;
    else if ($n == 1) return 1;
    else {
        $dodawanie++;
        return fib($n-1) + fib($n-2);
    }
}

function fib_sum($a,$b) {
    global $dodawanie;
    $wynik = 0;
    for ($x = $a; $x <= $b; $x++) {
        $wynik += fib($x);
        $dodawanie++;
        }
    return $wynik;
}

?>