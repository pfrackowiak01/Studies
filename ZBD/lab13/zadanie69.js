baza = "ztbd_lab13"
connect("localhost:27017/" + baza)
console.clear();

// db.kolekcja1.drop();
// db.kolekcja2.drop();
// db.kolekcja3.drop();

function wprowadzDane(){
    db.kolekcja1.insertMany([
        {
            "nazwisko": "Malinowska",
            "imie": "Maria"
        },
        {
            "nazwisko": "Nowak",
            "imie": "Norbert"
        },
        {
            "nazwisko": "Kowalski",
            "imie": "Krzysztof"
        },
        {
            "nazwisko": "Kowalewski",
            "imie": "Jan"
        },
        {
            "nazwisko": "Malicki",
            "imie": "Jerzy"
        }
    ]);

    db.kolekcja2.insertMany([
        {
            "nazwisko": "Malinowska",
            "oceny_z_fizyki": [4,4,5,6]
        },
        {
            "nazwisko": "Nowak",
            "oceny_z_fizyki": [2,4,3]
        },
        {
            "nazwisko": "Kowalski",
            "oceny_z_fizyki": [3,3,4,3]
        },
        {
            "nazwisko": "Kowalewski",
            "oceny_z_fizyki": [6,2,4,5]
        },
        {
            "nazwisko": "Malicki",
            "oceny_z_fizyki": [3,4,4,5]
        }
    ]);
    
    db.kolekcja3.insertMany([
        {
            "nazwisko": "Malinowska",
            "dane_ucznia": [{"klasa": "4A","wychowawca": "Marian Janik"}]
        },
        {
            "nazwisko": "Nowak",
            "dane_ucznia": [{"klasa": "4B","wychowawca": "Maria Wojda"}]
        },
        {
            "nazwisko": "Kowalski",
            "dane_ucznia": [{"klasa": "4C","wychowawca": "Jan Wójciki"}]
        },
        {
            "nazwisko": "Kowalewski",
            "dane_ucznia": [{"klasa": "4D","wychowawca": "Marian Janik"}]
        },
        {
            "nazwisko": "Malicki",
            "dane_ucznia": [{"klasa": "4E","wychowawca": "Maria Wojda"}]
        }
    ]);
}

wprowadzDane();