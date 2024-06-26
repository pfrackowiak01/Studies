<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pawel Frackowiak</title>
</head>
<body>
    <h1>1. Potęgi.</h1>
        <form action="potegi.php" method="get">
        <fieldset>
                <legend> Podaj całkowitoliczbową potegę n </legend>
                <label>n = <input type="number" name="potega"/></label>
            <input type="submit" value="Policz"/>
        </fieldset>
        </form>
    <h1>2. Funkcja PHP, czy pasuje do ZZZ9999.</h1>
        <form action="zadanie2.php" method="post">
        <fieldset>
        <legend> Sprawdzanie poprawności podanego ciągu znaków </legend>
        <label>Podaj ciąg znaków pasujący do ZZZ9999, gdzie Z to duża litera, a 9 to cyfra. <br>Pamiętaj, aby suma cyfr nie była większa od 20:<br><br></label>
        <label>Ciąg znaków: <input type="text" name="liczba" size="7"/></label>
            <input type="submit" value="Sprawdź"/>
        </fieldset>
        </form>
    <h1>3. Tablica z podaną ilością wylosowanych liczb z podanego zakresu.</h1>
        <form action="tablica.php" method="post">
            <fieldset>
                <legend>Wprowadź dane, aby stworzyć tablice</legend>
            <label>Ilość: </label> <input type="number" name="tablica"/><br><br>
            <label>Najmniejsza: </label> <input type="number" name="min"/><br><br>
            <label>Największa: </label> <input type="number" name="max"/><br><br>
            <label><input type="checkbox" name="suma" value="suma">Suma <br><br></label>
            <label><input type="checkbox" name="srednia" value="srednia">Średnia <br><br></label>
            <label><input type="checkbox" name="maksimum" value="maksimum">Maksimum <br><br></label>
            <label><input type="checkbox" name="minimum" value="minimum">Minimum <br><br></label>
            <label><input type="checkbox" name="dodatnie" value="dodatnie">Ilość dodatnich <br><br></label>
            <label><input type="checkbox" name="ujemne" value="ujemne">Ilość ujemnych <br><br></label>
            <label><input type="checkbox" name="zera" value="zera">Ilość zer <br><br></label>
            <label><input type="checkbox" name="kwadraty" value="kwadraty">Suma kwadratów <br><br></label>
            <label><input type="checkbox" name="bezwzgledna" value="bezwzgledna">Suma bezwzględna <br><br></label>
            <input type="submit" value="Stwórz tablice"/>
        </fieldset>
        </form>
    <h1>4. Losowanie różnych liczb całkowicie dodatnich n, od 0 do górnego zakresu z, gdzie n jest mniejsze o połowe od z.</h1>
        <form action="zadanie4.php" method="post">
        <fieldset>
            <legend>Wprowadź dane, aby wylosować liczby</legend>
            <label>Ilość liczb (n): </label> <input type="number" name="n"/><br><br>
            <label>Górny zakres (z): </label> <input type="number" name="z"/><br><br>
            <select name="wybierz">
                <option value="parzyste">Parzyste</option>
                <option value="nieparzyste">Nieparzyste</option>
                <option value="podzielne3">Podzielne przez 3</option>
                <option value="podzielne5">Podzielne przez 5</option>
            </select>
            <input type="color" name="kolor"><br><br>
            <input type="submit" value="Wylosuj liczby"/>
        </fieldset>
        </form> 
        <h1>5. Formularz kontaktowy.</h1>
        <a href="formularz.php"> Kliknij tu, aby wypełnić formularz.</a>
</body>
</html>