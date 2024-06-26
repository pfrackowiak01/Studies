<?php
require_once ('Opis.php');

class OpisHtmlDlugiBlok extends Opis {
    
    public function setDaneOpisu() {
        parent::setDaneOpisu();
        $this->naglowek3=$this->obiekt->getNaglowek3();
    }
    public function generujOpis() {
        $s="<div class='dlugi'>";
        $s.="<h2>$this->naglowek2</h2>"; //lub $s.=parent::generujOpis();
        $s.="<img src='".$this->obiekt->getZdjecie()."' alt='obrazek'  width='300' height='200'>";
        $s.="<h3>$this->naglowek3<br>";
        if ($this->obiekt->getMoc() >= 200 && $this->obiekt->getMoc() < 400) {
            $s.="Posiada silnik ".$this->obiekt->getSilnik().".<br>";
            if ($this->obiekt->getSilnik() == "benzynowy")
            $s.="Zużycie paliwa to ".$this->obiekt->getZuzyciePaliwa()." litrów na 100km.</h3>";
            else $s.="Zużycie prądu to ".$this->obiekt->getZuzyciePaliwa()." kWh na 100km.</h3>";
        }
        else if ($this->obiekt->getMoc() < 200) {
            $s.="Kolor skutera to ".$this->obiekt->getKolor().".<br>";
            $s.="Rozpędza się do ".$this->obiekt->getSzybkosc()." km/h.</h3>";
        }
        else {
            $s.="Skrzydła typu ".$this->obiekt->getSkrzydla().".<br>";
            $s.="Może wzbić się na wysokość ".$this->obiekt->getWysokosc()." metrów.</h3>";
        }
        $s.="</div>";
        return $s;
    }
}
?>