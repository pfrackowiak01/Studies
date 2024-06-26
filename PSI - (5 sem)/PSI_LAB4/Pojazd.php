<?php
require_once ('PojazdAbstrakcyjny.php');
require_once ('InterfejsOpis.php');

class Pojazd extends PojazdAbstrakcyjny implements InterfejsOpis {

    //parametry
    private $model="";
    private $moc=0;
    private $rokRozpProd=0;
    private $zdjecie="images/";
    private $opis="";

    //metody
    public function getModel(){
        return $this->model;
    }   
    public function setModel($mod) {
        $this->model=$mod;
    }

    public function getMoc() {
        return $this->moc;
    }
    public function setMoc($moc) {
        $this->moc = $moc;
    }

    public function getRokRozpProd() {
        return $this->rokRozpProd;
    }
    public function setRokRozpProd($rrp) {
        $this->rokRozpProd = $rrp;
    }

    public function getZdjecie() {
        return $this->zdjecie;
    }
    public function setZdjecie($z) {
        $this->zdjecie.= $z;
    }

    public function getOpis() {
        return $this->opis;
    }
    public function setOpis($o) {
        $this->opis = $o;
    }

    //konstruktor
    public function __construct($mod,$moc,$rrp,$z,$o) {
        $this->setModel($mod);
        $this->setMoc($moc);
        $this->setRokRozpProd($rrp);
        $this->setZdjecie($z);
        $this->setOpis($o);
    }

    public function getNaglowek2() {
        return $this->model;
    }
    public function getNaglowek3() {
        return "Wyprodukowany w ".$this->rokRozpProd." roku.<br>
                Moc silnika to aż ".$this->moc." KM.<br>"
                .$this->opis;
    }

    public function getDaneOpisu() {
        echo "cos";
    }
    public function generujOpis() {
        echo "cos";
    }
}

?>