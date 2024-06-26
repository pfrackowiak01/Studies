<?php
require_once ('Pojazd.php');

class Helikopter extends Pojazd {

    //parametry
    private $skrzydla="4-plachtowe";
    private $wysokosc=2000;       //wysokosc lotu

    //metody
    public function getSkrzydla() {
        return $this->skrzydla;
    }
    public function setSkrzydla($s) {
        $this->skrzydla = $s;
    }

    public function getWysokosc() {
        return $this->wysokosc;
    }
    public function setWysokosc($w) {
        $this->wysokosc = $w;
    }

    //konstruktor
    public function __construct($mod,$moc,$rrp,$z,$o,$s,$w) {
        parent::__construct($mod,$moc,$rrp,$z,$o);
        $this->setSkrzydla($s);
        $this->setWysokosc($w);
    }
}

?>