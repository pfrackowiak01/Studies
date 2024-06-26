<?php

class Opis implements InterfejsOpis {

    protected $naglowek2="";
    protected $naglowek3="";
    protected $zdjecie="";
    protected $tabak=[]; //tablica akapitów

    public function __construct($ob) {
        $this->obiekt=$ob;
        $this->setDaneOpisu();
    }

    public function getDaneOpisu() {
        return $this->naglowek2;
    }
    public function setDaneOpisu() {
        $this->naglowek2=$this->obiekt->getNaglowek2();
    }
    public function generujOpis() {
        $s="<h2>$this->naglowek2</h2>\n";
        return $s;
    }
}


?>