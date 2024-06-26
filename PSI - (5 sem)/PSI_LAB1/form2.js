'use strict';

function pokazBiletyUlgowe(){
    let biletyUlgowe = document.getElementById("ulg");
    if(biletyUlgowe.checked == true) {
        document.getElementById("idwyslij").style.display="inline";
        document.getElementById("idilenag").style.display="inline";
        document.getElementById("idileulg").style.display="inline";
    }
    else {
        document.getElementById("idilenag").style.display="none";
        document.getElementById("idwyslij").style.display="none";
        document.getElementById("idileulg").style.display="none";
    }
}

function pokazBiletyNormalne(){
    let biletyNormalne = document.getElementById("nor");
    if(biletyNormalne.checked == true) {
        document.getElementById("idwyslij").style.display="inline";
        document.getElementById("idilenag").style.display="inline";
        document.getElementById("idilenor").style.display="inline";
    }
    else {
        document.getElementById("idilenag").style.display="none";
        document.getElementById("idwyslij").style.display="none";
        document.getElementById("idilenor").style.display="none";
    }
}

function wyslijFormularz(f) {
    let iloscBiletowUlgowych =  document.getElementById("idileulg").value;
    let iloscBiletowNormalnych =  document.getElementById("idilenor").value;

    if(isNaN(iloscBiletowUlgowych) || iloscBiletowUlgowych <= 0 || iloscBiletowUlgowych == "" || iloscBiletowUlgowych != Math.round(iloscBiletowUlgowych)){
        alert("Niepoprawna ilość biletow ulgowych");
        document.getElementById("idilenor").focus();
        return false;
    }
    else if(isNaN(iloscBiletowNormalnych) || iloscBiletowNormalnych <= 0 || iloscBiletowNormalnych == ""  || iloscBiletowNormalnych != Math.round(iloscBiletowNormalnych)){
        alert("Niepoprawna ilość biletow normalnych");
        document.getElementById("idilenor").focus();
        return false;
    }
    else {
        alert("Poprawny formularz!");
        console.log("Ilość biletów ulgowych: "+iloscBiletowUlgowych+"\nIlość biletów normalnych: "+iloscBiletowNormalnych);
        biletyUlgowe.checked = false;
        biletyNormalne.checked = false;
        return true;
    }
}