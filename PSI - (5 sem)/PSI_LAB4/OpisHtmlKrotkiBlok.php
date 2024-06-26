<?php
require_once ('Opis.php');

class OpisHtmlKrotkiBlok extends Opis {

    public function setDaneOpisu() {
        parent::setDaneOpisu();
        $this->naglowek3=$this->obiekt->getNaglowek3();
    }
    
    public function generujOpis() {
        $s="<div class='krotki'>";
        $s.="<h2>$this->naglowek2</h2>\n"; //lub $s.=parent::generujOpis();
        $s.="<h3>Rocznik: ".$this->obiekt->getRokRozpProd()." r.<br>";
        if ($this->obiekt->getMoc() >= 200 && $this->obiekt->getMoc() < 400) {
            $s.="Posiada silnik ".$this->obiekt->getSilnik().".<br>";
        }
        else if ($this->obiekt->getMoc() < 200) {
            $s.="Kolor skutera to ".$this->obiekt->getKolor().".<br>";
        }
        else {
            $s.="Skrzydła typu ".$this->obiekt->getSkrzydla().".<br>";
        }
        $s.="</div>";
        return $s;
    }
}
?>