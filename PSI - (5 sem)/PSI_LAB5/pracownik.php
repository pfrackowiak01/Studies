<?php

	class Pracownik {
		
		private $nazwisko;
		private $imie;
		private $wiek;
		private $doswiadczenie;
		private $zainteresowania;
		
		public function __construct() {
			$this->set_field_value("nazwisko",isset($_SESSION['nazwisko'])?$_SESSION['nazwisko']:'Kowalski');
			$this->set_field_value("imie",isset($_SESSION['imie'])?$_SESSION['imie']:'Jan');
			$this->set_field_value("wiek",isset($_SESSION['wiek'])?$_SESSION['wiek']:'21');
			$this->set_field_value("doswiadczenie",isset($_SESSION['doswiadczenie'])?$_SESSION['doswiadczenie']:'Brak doświadczenia');
			$this->set_field_value("zainteresowania",isset($_SESSION['zainteresowania'])?$_SESSION['zainteresowania']:'Brak zainteresowań');
		}
		
		function get_field_name($field_name) {
			switch($field_name) {
				case 'nazwisko': return $this->nazwisko; break;
				case 'imie': return $this->imie; break;
				case 'wiek': return $this->wiek; break;
				case 'doswiadczenie': return $this->doswiadczenie; break;
				case 'zainteresowania': return $this->zainteresowania; break;
				default: return 0; break;
			}
			
		}
		
		function set_field_value($field_name, $val) {
			switch($field_name) {
				case 'nazwisko': $this->nazwisko=$val; break;
				case 'imie': $this->imie=$val; break;
				case 'wiek': $this->wiek=$val; break;
				case 'doswiadczenie': $this->doswiadczenie=$val; break;
				case 'zainteresowania': $this->zainteresowania=$val; break;
			}
		}
		
		function insert_to_pgsql() {
			$base = new DbPgSql();
			$base->connect();
			$sql = "INSERT INTO rekrutacja.pracownicy(nazwisko,imie,wiek,doswiadczenie,zainteresowania) VALUES ('".$this->get_field_name("nazwisko")."','".$this->get_field_name("imie")."',".$this->get_field_name("wiek").",'".$this->get_field_name("doswiadczenie")."','".$this->get_field_name("zainteresowania")."');";
			$base->query($sql);
			$base->disconnect();
		}
		
	}

?>