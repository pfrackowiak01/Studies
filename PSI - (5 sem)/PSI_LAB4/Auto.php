<?php
require_once ('Pojazd.php');

class Auto extends Pojazd {

    //parametry
    private $silnik="benzynowy";
    private $zuzyciePaliwa=0;

    //metody
    public function getSilnik() {
        return $this->silnik;
    }
    public function setSilnik($s) {
        $this->silnik = $s;
    }

    public function getZuzyciePaliwa() {
        return $this->zuzyciePaliwa;
    }
    public function setZuzyciePaliwa($zp) {
        $this->zuzyciePaliwa = $zp;
    }

    //konstruktor
    public function __construct($mod,$moc,$rrp,$z,$o,$s,$zp) {
        parent::__construct($mod,$moc,$rrp,$z,$o);
        $this->setSilnik($s);
        $this->setZuzyciePaliwa($zp);
    }
}

?>