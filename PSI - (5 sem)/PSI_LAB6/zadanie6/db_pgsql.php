<?php
class DbPgSql {
    private $host;
    private $port;
    private $user;
    private $password;
    private $database;
    private $conn = null;
    private $status;
    private $queryStatus;

    public function __construct()
    {
        require_once("daneDoPostgresa.inc.php");
        $this->host = $host;
        $this->port = $port;
        $this->database = $dbname;
        $this->user = $user;
        $this->password = $pass;
    }

    public function connect() {
        $this->conn = pg_connect("host=$this->host port=$this->port dbname=$this->database user=$this->user password=$this->password");
        if($this->conn){
            $this->status = true;
        }
        else {
            $this->status = false;
        }
        return $this->status;
    }

    public function disconnect() {
        pg_close($this->conn);
    }

    public function query($sql){
        $result = pg_query($this->conn,$sql);
        if(!$result){
            return "Błąd zapytania ".pg_last_error();
        }
        return $result;
        pg_free_result($result);
    }

    public function getStatus() {
        return $this->status;
    }
}