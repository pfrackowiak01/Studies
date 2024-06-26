<?php

function f($x) {
    
    return round($x**2-5, 2);
}

function g($x) {
    return round(3*sin($x)+cos($x), 2);
}

function h($x) {
    return round(0.5*$x+1, 2);
}

function czymax($a,$b,$c) {
    if ($a >= $b && $a >= $c) return true;
    else return false;
}
?>