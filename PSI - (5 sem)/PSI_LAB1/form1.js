function validateName() {
    //let x = document.forms["formularz"]["imienazwisko"].value.match(/^[a-zA-ZĄĘĆŚŻŹŃÓŁąęćśżźńół] + [a-zA-ZĄĘĆŚŻŹŃÓŁąęćśżźńół]+$/g);
    let name = document.forms["formularz"]["imienazwisko"].value;
    //var wzor =/^[a-zA-ZĄĘĆŚŻŹŃÓŁąęćśżźńół] + [a-zA-ZĄĘĆŚŻŹŃÓŁąęćśżźńół]+$/g;
    if (name == "") {
        document.forms["formularz"]["imienazwisko"].focus();
        document.getElementById("b_imienazwisko").innerHTML =  "Uzupełnij pole z imieniem i nazwiskiem!";
        return false;
    }
    else {
    wzor = /^[A-ZĄĘĆŚŻŹŃÓŁ][a-ząęćśżźńół]{2,} [A-ZĄĘĆŚŻŹŃÓŁ][a-ząęćśżźńół]{2,}$/;
    if (!name.match(wzor)) {
        document.forms["formularz"]["imienazwisko"].focus();
        document.getElementById("b_imienazwisko").innerHTML = "Podaj poprawne imię i nazwisko!";
        return false;
    }
    else {
        document.getElementById("b_imienazwisko").innerHTML = "";
        return true;
    }
    }
    }

function validateYear() {
    let year = document.forms["formularz"]["rok"].value;
    if (year == "") {
        document.forms["formularz"]["rok"].focus();
        document.getElementById("b_rok").innerHTML = "Uzupełnij pole z rokiem!";
        return false;
    }
    else {
        var data = new Date();
        var rok = data.getFullYear();
        //if (rok < 1000) rok = 2000 + rok - 100;
        if (!year.match(/[0-9]{4}/) || year > rok) {
            document.forms["formularz"]["rok"].focus();
            document.getElementById("b_rok").innerHTML = "Rok rozpoczęcia nie może być większy niż obecny!";
            return false;
        }
        else {
            document.getElementById("b_rok").innerHTML = "";
            return true;
        }
    }
}

function validateIndex() {
    let index = document.forms["formularz"]["nrindeksu"].value;
    if (index == "") {
        document.forms["formularz"]["nrindeksu"].focus();
        document.getElementById("b_nrindeksu").innerHTML = "Uzupełnij pole z numerem indeksu!";
        return false;
    }
    else if (!index.match(/^[A-Z]{1}\/[0-9]{5,6}$/)) {
        document.forms["formularz"]["nrindeksu"].focus();
        document.getElementById("b_nrindeksu").innerHTML = "Niepoprawny numer indeksu!";
        return false;
    }
    else {
        document.getElementById("b_nrindeksu").innerHTML = "";
        validateSum();
        return true;
    }
}

function validateSum() {
    let year = parseInt(document.forms["formularz"]["rok"].value);
    let index = document.forms["formularz"]["nrindeksu"].value;
    sumRok = 0;
    while (year) {
        sumRok += year % 10;
        year = Math.floor(year / 10);
    }
    let sumIndeks = parseInt(index[index.length - 2])*10 + parseInt(index[index.length - 1]);
    if (sumRok == sumIndeks) return true;
    else {
        document.forms["formularz"]["nrindeksu"].focus();
        document.getElementById("b_nrindeksu").innerHTML = "Ostatnie dwie cyfry numeru indexu muszą być sumą cyfr roku!";
        return false;
    }
}

function validateForm() {

    if( validateName() && validateYear() && validateIndex() ) {
        if(validateSum()) {
            alert("Poprawny formularz!");
            return true;
        }
        else {
            alert("Niepoprawny formularz!");
            return false;
        }
    }
}