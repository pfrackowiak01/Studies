<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pawel Frackowiak</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <?php
    //if(isset($_POST["first"],$_POST["last"],$_POST["email"],$_POST["address"],$_POST["contact"],$_POST["note"])){

    $firstName = $_POST["first"];
    $lastName = $_POST["last"];
    $contactEmail = $_POST["email"];
    $IPAddress = $_POST["address"];
    $contactNumber = $_POST["contact"];
    $userText = $_POST["note"];

    $firstwzor = "/[A-ZĘÓĄŚŁŻŹĆŃ]{1}[a-zęóąśłżźćń]{2,}/";
    $lastwzor = "/[A-ZĘÓĄŚŁŻŹĆŃ]{1}[a-zęóąśłżźćń]{2,}/";
    $contactwzor = "/[0-9]{9}/";

    $i = 0;

    if(empty($firstName)) echo "<p style='color: red'>Enter your first name!";
    else {
        if(!preg_match($firstwzor,$firstName)) echo "<p style='color: red'>Incorrect first name!</p>";
        else {echo "<p>First name: $firstName</p>"; $i++;}
    }

    if(empty($lastName)) echo "<p style='color: red'>Enter your last name!</p>";
    else {
        if(!preg_match($lastwzor,$lastName)) echo "<p style='color: red'>Incorrect last name!</p>";
        else {echo "<p> Last name: $lastName</p>"; $i++;}
    }

    if(empty($contactEmail)) echo "<p style='color: red'>Enter your email!</p>";
    else {
        if (!filter_var($contactEmail, FILTER_VALIDATE_EMAIL)) echo "<p style='color: red'>Incorrect email!</p>";
        else {echo "<p>Your e-mail: $contactEmail</p>"; $i++;}
    }

    if(empty($IPAddress)) echo "<p style='color: red'>Enter your IP address</p>";
    else {
        if(!filter_var($IPAddress, FILTER_VALIDATE_IP)) echo "<p style='color: red'>Incorrect IP Address!</p>";
        else {echo "<p>Your IP address: $IPAddress</p>"; $i++;}
    }
    
    if(empty($contactNumber)) echo "<p style='color: red'>Enter your phone number</p>";
    else {
        if(!preg_match($contactwzor,$contactNumber)) echo "<p style='color: red'>Incorrect phone number!</p>";
        else {echo "<p>Your phone number: (+48) $contactNumber</p>"; $i++;}
    }

    if(empty($userText)) echo "<p style='color: red'>Please add your notes, suggestions or questions!</p>";
    else {echo "<p>Your notes: $userText</p>"; $i++;}

    if ($i == 6) echo "<p style='color: green'>Form successfully sent!</p>";
    else echo "<p style='color: red'>The form has not been sent. Correct mistakes first!</p>";
//}
    ?>
</body>
</html>