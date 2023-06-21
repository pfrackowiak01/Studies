// Łączenie z bazą
baza = "ubezpieczalnia_samochodow"
connect("localhost:27017/"+baza)
console.clear();

use(baza);

// Widok 1

db.widok1_ochrona.drop();
db.widok1_pakiet.drop();

db.createView("widok1_ochrona", "rezerwacje", [
  {$group:{_id:"$dodatki.ochrona",ile_osob_wzielo:{$sum:1}}}
]);

db.createView("widok1_pakiet", "rezerwacje", [
  {$group:{_id:"$dodatki.pakiet",ile_osob_wzielo:{$sum:1}}}
]);

print();
print("Ile osób wzięło poszczególny rodzaj ochrony:");
db.widok1_ochrona.find();
print();
print("Ile osób wzięło poszczególny rodzaj pakietu:");
db.widok1_pakiet.find();


// Widok 2

db.widok2_rezerwacje_info.drop();

db.createView("widok2_rezerwacje_info", "rezerwacje", [
    {$lookup: {from: "klienci", localField: "id_klienta", foreignField: "id_klienta" ,as: "wspolny"}},
    {$unwind: "$wspolny"},  
    {$addFields: {klient: {$concat: ["$wspolny.imie", " ", "$wspolny.nazwisko"]}}},
    {$lookup: {from: "samochody", localField: "id_samochodu", foreignField: "id_samochodu" ,as: "wspolny"}},
    {$unwind: "$wspolny"},
    {$addFields: {samochod: {$concat: ["$wspolny.marka", " ", "$wspolny.model"]}}},
    {$project:{_id:0,klient:1,samochod:1}}
])

db.widok2_rezerwacje_info.find();


// Widok 3

db.widok3_faktury_zalegle_platnosci.drop();

db.createView("widok3_faktury_zalegle_platnosci", "rezerwacje", [
    {$lookup: {from: "klienci", localField: "id_klienta", foreignField: "id_klienta", as: "wspolny"}},
    {$unwind: "$wspolny"},
    {$addFields: {
        klient: {$concat: ["$wspolny.imie", " ", "$wspolny.nazwisko"]},
        mieszka: {$concat: ["$wspolny.adres.miasto", " ", "$wspolny.adres.ulica"]}
    }},
    {$lookup: {from: "faktury", localField: "id_rezerwacji", foreignField: "id_rezerwacji", as: "wspolny2"}},
    {$unwind: "$wspolny2"},
    {$match: {"wspolny2.oplacone": "nie"}},
    {$project: {_id: 0, klient: 1, mieszka: 1, telefon: "$wspolny.telefon", kwota: "$wspolny2.kwota"}}
]);

db.widok3_faktury_zalegle_platnosci.find();



