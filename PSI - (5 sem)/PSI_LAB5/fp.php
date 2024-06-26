<!DOCTYPE html>
<html lang='pl'>
    <head>
        <title>ZADANIE 1</title>
        <meta charset="UTF-8">
		<meta name="author" content="Paweł Frąckowiak">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="fp.css">
    </head>
    <body>
		<h1>Zadanie 1</h1>
        
        <?php
		
			session_start();
			include_once('db_pgsql.php');
			include_once('pracownik.php');
			$p = new Pracownik();
			
			if(!isset($_GET['ST']))
				$page = 1;
			else
				$page = $_GET['ST'];
			$form = ".f".$page.".html";
			include_once($form);
			
			foreach ($_POST as $key => $value)
				$_SESSION[$key] = $value;
			
			if(intval($page)==4) {
				$p->insert_to_pgsql();
				session_destroy();
			}
			
		?>
		
		<hr>
		<p>
			Zawartość $_SESSION<br><br>
			
			<?php
			
				if(session_status()!=2) {
					echo 'Nie istnieje';
				}
				else {
					var_dump($_SESSION);
					echo '<br><br>Session ID:'.session_id();
				}
			
			?>
		</p>
    </body>
</html>