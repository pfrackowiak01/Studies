<?php

function losuj($n) {
    $tablica = array();
    for ($i = 0; $i < $n; $i++) $tablica[$i] = rand(1,100);
    asort($tablica);
    return $tablica;
}

?>