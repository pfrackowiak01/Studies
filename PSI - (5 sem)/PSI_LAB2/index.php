<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>td { border: 1px solid black;} table {border: 3px solid black;}</style>
</head>
<body>
    <h1>1. Losowanie liczb (czy parzyste)</h1>
    <ul>
        <?php 
            include ("script.php")
        ?>
    </ul>
    <h1>2. Losowanie liczb (ile parzystych, zer i nieparzystych)</h1>
        <?php 
            include ("script2.php")
        ?>
    <h1>3. Rosnące wyliczanie silni (funkcja)</h1>
        <?php 
            require_once ("silnia.inc");

            $array = array();

            for ($x = 0; $x < 6; $x++) {
                $liczba = rand(0,20);
                $array[$x] = silnia($liczba);
            }

            sort($array);
            $indeks = 0;
            foreach ($array as $value) {
                if ($indeks % 2 != 0) echo "<p style='background-color: gray'>Silnia wynosi $value\r\n";
                else echo "<p>Silnia wynosi $value\r\n";
                $indeks ++;
            }
        ?>
    <h1>4. Fibonacci</h1>
        <?php 
            require_once ("fibonacci.inc");

            $a = rand(0,20);
            $b = rand(0,20);
            if ( $a > $b ) {
                $pom = $a;
                $a = $b;
                $b = $pom;
            }

            echo "a = $a <br>b = $b";
            echo "<h3>Wersja z funkcją do sumowania ciągów Fibonnaciego:</h3>";
            echo "<table>";
            echo "<tr><td>n     </td> <td>Fn    </td> <td>Fa+...+Fb</td></tr>";

            $dodawanie = 0;
            
            for ($x = $a; $x <= $b; $x++) {
            echo "<tr><td>$x</td> <td>".fib($x)."</td> <td>".fib_sum($a,$x)."</td></tr>";
            }
            
            echo "</table>";
            echo "<p>Ilość operacji dodawania = $dodawanie</p>";

            echo "<h3>Optymalniejsza wersja z dodawaniem sumy już do istniejącej sumy ciągu Fibonacciego:</h3>";
            echo "<table>";
            echo "<tr><td>n     </td> <td>Fn    </td> <td>Fa+...+Fb</td></tr>";

            $dodawanie = 0;

            $fibsum = 0;
            $fib = 0;
            for ($x = $a; $x <= $b; $x++) {
                $fib = fib($x);
                $fibsum += $fib;
                echo "<tr><td>$x</td> <td>$fib</td> <td>$fibsum</td></tr>";
                }
            echo "</table>";
            echo "<p>Ilość operacji dodawania = $dodawanie</p>";
        ?>
    <h1>5. Trzy funkcje matematyczne i kolorowanie największego wyniku.</h1>
        <?php 
            require_once ("script3.inc");

            $t = array();
            $fx = array();
            $gx = array();  
            $hx = array();    

            echo "<table>";
            echo "<tr><td>x</td>";
            for ($x = -3; $x <= 3; $x = $x + 0.5) {
                $t[] = $x;
                $fx[] = f($x);
                $gx[] = g($x);  
                $hx[] = h($x); 
                echo "<td>$x</td>";
                }
            echo "</tr>";
            echo "<tr><td>f(x)</td>";
            for ($i = 0; $i < count($t); $i++) {
                if (czymax($fx[$i],$gx[$i],$hx[$i])) echo "<td style='background-color:#99CC99;'>".$fx[$i]."</td>";
                else echo "<td>".$fx[$i]."</td>";
                }
            echo "</tr>";
            echo "<tr><td>g(x)</td>";
            for ($i = 0; $i < count($t); $i++) {
                if (czymax($gx[$i],$fx[$i],$hx[$i])) echo "<td style='background-color:#99CC99;'>".$gx[$i]."</td>";
                else echo "<td>".$gx[$i]."</td>";
                }
            echo "</tr>";
            echo "<tr><td>h(x)</td>";

            for ($i = 0; $i < count($t); $i++) {
                if (czymax($hx[$i],$gx[$i],$fx[$i])) echo "<td style='background-color:#99CC99;'>".$hx[$i]."</td>";
                else echo "<td>".$hx[$i]."</td>";
                }
            echo "</tr>";
            echo "</table>";
        ?>
    <h1>6. Szyfrowanie tekstu za pomocą md5, sha1, sha256.</h1>
        <?php 
            require_once ("szyfrowanie.inc");

            echo "<table>";
            echo "<tr><td><b>Tekst niezaszyfrowany</b></td> <td><b>Md5</b></td> <td><b>Sha1</b></td> <td><b>Sha256</b></td></tr>";
            $tekst = "Wydział Elektryczny";
            echo "<tr><td><i>$tekst</i></td> <td>".szyfruj($tekst,"md5")."</td> <td>".szyfruj($tekst,"sha1")."</td> <td>".szyfruj($tekst,"sha256")."</td></tr>";
            $tekst = "Kierunek Informatyka";
            echo "<tr><td><i>$tekst</i></td> <td>".szyfruj($tekst,"md5")."</td> <td>".szyfruj($tekst,"sha1")."</td> <td>".szyfruj($tekst,"sha256")."</td></tr>";
            $tekst = "Projektowanie Serwisów Internetowych";
            echo "<tr><td><i>$tekst</i></td> <td>".szyfruj($tekst,"md5")."</td> <td>".szyfruj($tekst,"sha1")."</td> <td>".szyfruj($tekst,"sha256")."</td></tr>";
            echo "</table>";
        ?>
</body>
</html>