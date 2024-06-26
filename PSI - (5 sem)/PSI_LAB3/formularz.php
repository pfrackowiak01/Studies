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
<div class="container">
    <form action="validator.php" method="post">
    <h1>Contact Us Form</h1>
    <label><span class=point>1.</span> Full Name</label>
        <div class="name">
            <input type="text" id="fname" name="first" placeholder="First Name">
            <input type="text" id="lname" name="last" placeholder="Last Name">
        </div>
    <label><span class=point>2.</span> E-mail*</label>
        <div class="email">
            <input type="text" id="e" name="email" placeholder="✉">
        </div>
    <label><span class=point>3.</span> Address IP: (example: 10.11.23.170)</label>
        <div class="address">
            <input type="text" id="ip" name="address">
        </div>
    <label><span class=point>4.</span> Contact Number* (9 digits)</label>
        <div class="contact">
            <input type="number" max="999999999" id="tel" name="contact" placeholder="✆">
        </div>
    <label><span class=point>5.</span> Notes, Suggestions or Questions*</label>
        <div class="notes">
            <textarea id="note" name="note" placeholder="Write something..." style="height:200px"></textarea>
        </div>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>