
let englishCheckbox = document.querySelector("#englishLang");
let frenchCheckbox = document.querySelector("#frenchLang");
let germanCheckbox = document.querySelector("#germanLang");
let otherLanguageCheckbox = document.querySelector("#otherLang");

let otherLanguageNameTextBox = document.querySelector("#otherLanguageName");

let englishLangLabels = document.querySelectorAll(".englishLevelsL");
let frenchLangLabels = document.querySelectorAll(".frenchLevelsL");
let germanLangLabels = document.querySelectorAll(".germanLevelsL");
let otherLangLabels = document.querySelectorAll(".otherLangLevelsL");


let englishLangLevels = document.querySelectorAll(".englishLevels");
let frenchLangLevels = document.querySelectorAll(".frenchLevels");
let germanLangLevels = document.querySelectorAll(".germanLevels");
let otherLangLevels = document.querySelectorAll(".otherLangLevels");

englishCheckbox.addEventListener("click", function () {
    if (this.checked) {
        for (i = 0; i < englishLangLabels.length; i++) {
            englishLangLabels[i].style.display = "inline";
        }
    } else {
        for (i = 0; i < englishLangLabels.length; i++) {
            englishLangLabels[i].style.display = "none";
        }
    }
});
frenchCheckbox.addEventListener("click", function () {
    if (this.checked) {
        for (i = 0; i < frenchLangLabels.length; i++) {
            frenchLangLabels[i].style.display = "inline";
        }
    } else {
        for (i = 0; i < frenchLangLabels.length; i++) {
            frenchLangLabels[i].style.display = "none";
        }
    }
});
germanCheckbox.addEventListener("click", function () {
    if (this.checked) {
        for (i = 0; i < germanLangLabels.length; i++) {
            germanLangLabels[i].style.display = "inline";
        }
    } else {
        for (i = 0; i < germanLangLabels.length; i++) {
            germanLangLabels[i].style.display = "none";
        }
    }
});
otherLanguageCheckbox.addEventListener("click", function () {
    if (this.checked) {
        document.getElementById("otherLanguageName").disabled = false;
        for (i = 0; i < otherLangLabels.length; i++) {
            otherLangLabels[i].style.display = "inline";
        }
    } else {
        document.getElementById("otherLanguageName").disabled = true;
        for (i = 0; i < otherLangLabels.length; i++) {
            otherLangLabels[i].style.display = "none";
        }
        otherLanguageNameTextBox.value = "";
    }
});

function checkEnglish() {
    let selectedLevel;
    for (i = 0; i < englishLangLevels.length; i++) {
        if (englishLangLevels[i].checked) {
            selectedLevel = englishLangLevels[i];
            break;
        }
    }
    if (selectedLevel == null) {
        alert("Proszę wybrać poziom znajomości wybranego języka (angielski)!");
        return false;
    } else {
        return true;
    }
}

function checkFrench() {
    let selectedLevel;
    for (i = 0; i < frenchLangLevels.length; i++) {
        if (frenchLangLevels[i].checked) {
            selectedLevel = frenchLangLevels[i];
            break;
        }
    }
    if (selectedLevel == null) {
        alert("Proszę wybrać poziom znajomości wybranego języka (francuski)!");
        return false;
    } else {
        return true;
    }
}

function checkGerman() {
    let selectedLevel;
    for (i = 0; i < germanLangLevels.length; i++) {
        if (germanLangLevels[i].checked) {
            selectedLevel = germanLangLevels[i];
            break;
        }
    }
    if (selectedLevel == null) {
        alert("Proszę wybrać poziom znajomości wybranego języka (niemiecki)!");
        return false;
    } else {
        return true;
    }

}

function checkOtherLanguage() {
    let selectedLevel;
    let otherLanguageRexExp = /^[A-ZĘÓĄŚŁŻŹĆŃa-zęóąśłżźćń]{5,}$/;
    if(otherLanguageCheckbox.checked){
        if (!otherLanguageNameTextBox.value.match(otherLanguageRexExp)) {
            alert("Nazwa języka musi mieć co najmniej 5 liter i nie może mieć cyfr i znaków specjalnych!");
            otherLanguageCheckbox.focus();
            return false;
        }
        else {
            for (i = 0; i < otherLangLevels.length; i++) {
                if (otherLangLevels[i].checked) {
                    selectedLevel = otherLangLevels[i];
                    break;
                }
            }
            if (selectedLevel == null) {
                alert("Proszę wybrać poziom znajomości wybranego języka (" + otherLanguageNameTextBox.value + ")!");
                return false;
            } else {
                return true;
            }
        }
    }
}

function checkForm() {
    debugger
    let correctForm = true;
    if (!englishCheckbox.checked && !frenchCheckbox.checked && !germanCheckbox.checked && !otherLanguageCheckbox.checked) {
        alert("Musi być zaznaczony przynajmniej jeden język!");
        correctForm = false;
    } else {
        let englishCorrect = checkEnglish();
        let frenchCorrect = checkFrench();
        let germanCorrect = checkGerman();
        let otherLanguageCorrect = checkOtherLanguage();

        if (englishCheckbox.checked && !englishCorrect) {
            correctForm = false;
        }
        else if (frenchCheckbox.checked && !frenchCorrect) {
            correctForm = false;
        }
        else if (germanCheckbox.checked && !germanCheckbox) {
            correctForm = false;
        }
        else if (otherLanguageCheckbox.checked && !otherLanguageCorrect) {
            correctForm = false;
        }
        else {
            alert("Poprawny formularz!");
            correctForm = true;
        }
    }
    return correctForm;
}