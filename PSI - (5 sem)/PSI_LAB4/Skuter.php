<?php
require_once ('Pojazd.php');

class Skuter extends Pojazd {

    //parametry
    private $kolor="czerwony";
    private $szybkosc=230;

    //metody
    public function getKolor() {
        return $this->kolor;
    }
    public function setKolor($k) {
        $this->kolor = $k;
    }

    public function getSzybkosc() {
        return $this->szybkosc;
    }
    public function setSzybkosc($sz) {
        $this->szybkosc = $sz;
    }

    //konstruktor
    public function __construct($mod,$moc,$rrp,$z,$o,$k,$sz) {
        parent::__construct($mod,$moc,$rrp,$z,$o);
        $this->setKolor($k);
        $this->setSzybkosc($sz);
    }
}

?>