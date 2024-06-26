<?php
function szyfruj($tekst_do_zaszyfrowania,$algorytm_szyfrowania) {
    switch ($algorytm_szyfrowania) {
        case "md5":
            return hash('md5',$tekst_do_zaszyfrowania);
        case "sha1":
            return hash('sha1',$tekst_do_zaszyfrowania);
        case "sha256":
            return hash('sha256',$tekst_do_zaszyfrowania);
    }
}
?>