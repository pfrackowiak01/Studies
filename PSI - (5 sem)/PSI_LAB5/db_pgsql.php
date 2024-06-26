<?php

	class DbPgSql {
		
		private $host='localhost';
		private $port='5432';
		private $user='s47620';
		private $password='8Mg7Mh6Um4Ee';
		private $database='s47620';
		private $conn=null;
		private $status_connection='';
		private $result;
		private $status;
		
		public function get_host() {
			return $this->host;
		}
		
		public function get_port() {
			return $this->port;
		}
		
		public function get_user() {
			return $this->user;
		}
		
		public function get_password() {
			return $this->password;
		}
		
		public function get_database() {
			return $this->database;
		}
		
		public function get_conn() {
			return $this->conn;
		}
		
		public function set_conn($conn) {
			$this->conn=$conn;
		}
		
		public function get_result() {
			return $this->result;
		}
		
		public function set_result($result) {
			$this->result=$result;
		}
		
		public function set_status($status) {
			$this->status=$status;
		}
		
		public function connect() {
			$conn_string = "host=".$this->get_host()." port=".$this->get_port()." dbname=".$this->get_database()." user=".$this->get_user()." password=".$this->get_password();
			$con = pg_connect($conn_string) or die ("Nie można podłączyć się do Postgresql\n");
			$this->set_conn($con);
			$this->set_status(pg_connection_status($con));
		}
		
		public function disconnect() {
			pg_close($this->get_conn());
		}
		
		public function query($sql) {
			$query=pg_query($this->get_conn(),$sql);
			$this->set_result($query);
			return $query!=false;
		}
		
		public function getStatus() {
			return $this->status;
		}
	}

?>