// Łączenie z bazą
baza = "baza_lab10";
connect("localhost:27017/" + baza);
console.clear();

// Dodanie indexu na "certificate_number"
db.cities_A.createIndex({certificate_number:1});

// Sprawdzenie istniejących indexów
db.cities_A.getIndexes();

// Mierzony czas
czas_startu = new Date();
print(czas_startu);

// Łączenie ze sobą dwóch kolekcji cities_A oraz cities_B
var kol = db.cities_A.aggregate(
    { $lookup: { from: "cities_B", localField: "id", foreignField: "id", as: "wspolne_dane" } },
    { $unwind: "$wspolne_dane"},
    { $addFields: { certificate_number:"$wspolne_dane.certificate_number" } },
    { $addFields: { result:"$wspolne_dane.result" } },
    { $project: { _id: 0, certificate_number: 1 , result: 1 } }
  )

// Wyswietlenie wszystkich dokumentow
//while (kol.hasNext()){print(kol.next());}

// Wyświetenie zmierzonego czasu
czas_konca = new Date();
czas_calk = czas_konca - czas_startu;
print(czas_konca);
print(czas_calk + "ms");

// Usunięcie indexu na "certificate_number"
db.cities_A.dropIndex({"certificate_number":1});

// Sprawdzenie istniejących indexów
db.cities_A.getIndexes();