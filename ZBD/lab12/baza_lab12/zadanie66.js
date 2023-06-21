// Łączenie z bazą
baza = "baza_lab"
connect("localhost:27017/"+baza)
console.clear();

// Usuwanie kolekcji o takiej nazwie, jeśli już istnieją
db.miasta.drop()
db.pensje.drop()
db.wiek.drop()

// Tworzenie kolekcji "miasta" i dodanie dokumentów
db.miasta.insert(
    [
        {nazwisko:"Malinowska",miasto:"Sopot"},
        {nazwisko:"Nowak",miasto:"Gdańsk"},
        {nazwisko:"Kowalski",miasto:"Gdańsk"},
        {nazwisko:"Kowalewski",miasto:"Gdynia"}
    ])
// Wyświetlenie kolekcji "miasta"
var kursor=db.miasta.find({},{_id:0})
while (kursor.hasNext()) {
    print(kursor.next());
}
print()

// Tworzenie kolekcji "pensje" i dodanie dokumentów
db.pensje.insert(
    [
        {nazwisko:"Malinowska",pensja:4500},
        {nazwisko:"Nowak",pensja:5000},
        {nazwisko:"Kowalski",pensja:6000},
        {nazwisko:"Kowalewski",pensja:4200}
    ])
// Wyświetlenie kolekcji "pensje"
var kursor=db.pensje.find({},{_id:0})
while (kursor.hasNext()) {
    print(kursor.next());
}
print()

// Tworzenie kolekcji "wiek" i dodanie dokumentów
db.wiek.insert(
    [
        {nazwisko:"Malinowska",wiek:18},
        {nazwisko:"Nowak",wiek:23},
        {nazwisko:"Kowalski",wiek:32},
        {nazwisko:"Kowalewski",wiek:25}
    ])
// Wyświetlenie kolekcji "wiek"
var kursor=db.wiek.find({},{_id:0})
while (kursor.hasNext()) {
    print(kursor.next());
}
print()

// Funkcja, połącz 3 kolekcje, wyświetl wszystkich poza Sopotem i wiek>=18
function Join(tab1,tab2,tab3,wspolny_atr) {
    var result=db[tab1].aggregate([
        // łączenie miasta-pensje
        {$lookup: {from: tab2,localField: wspolny_atr,foreignField: wspolny_atr,as: "wspolny"}},
        {$unwind: "$wspolny"},  
        {$addFields:{pensja:"$wspolny.pensja"}},
        // łączenie miasta-wiek
        {$lookup: {from: tab3,localField: wspolny_atr,foreignField: wspolny_atr,as: "wspolny2"}},
        {$unwind: "$wspolny2"},  
        {$addFields:{wiek:"$wspolny2.wiek"}},

        {$match:{miasto:{$ne:"Sopot"},wiek:{$gte:18}}},
        {$project:{_id:0,nazwisko:1,miasto:1,pensja:1,wiek:1}}
    ])
    // wyświetla wynik
    while (result.hasNext()) {
        print(result.next());
    }
}

Join("miasta","pensje","wiek","nazwisko")