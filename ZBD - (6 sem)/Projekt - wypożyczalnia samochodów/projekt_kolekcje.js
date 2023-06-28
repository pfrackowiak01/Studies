// Łączenie z bazą
baza = "ubezpieczalnia_samochodow"
connect("localhost:27017/"+baza)
console.clear();

// Usuwanie kolekcji o takiej nazwie, jeśli już istnieją
db.ubezpieczenia.drop()
db.samochody.drop()
db.klienci.drop()
db.rezerwacje.drop()
db.faktury.drop()

// Tworzenie kolekcji "ubezpieczenia" i dodanie dokumentów
db.ubezpieczenia.insert(
    [
        {id_ubezpieczenia:1,nazwa_firmy:"AVIVA",rodzaj_ubezpieczenia:"OC",data_wygasniecia:ISODate("2024-01-20")},
        {id_ubezpieczenia:2,nazwa_firmy:"BALCIA",rodzaj_ubezpieczenia:"AC",data_wygasniecia:ISODate("2026-06-22")},
        {id_ubezpieczenia:3,nazwa_firmy:"GENERALI",rodzaj_ubezpieczenia:"OC",data_wygasniecia:ISODate("2028-05-20")},
        {id_ubezpieczenia:4,nazwa_firmy:"PROAMA",rodzaj_ubezpieczenia:"NNW",data_wygasniecia:ISODate("2032-03-14")},
        {id_ubezpieczenia:5,nazwa_firmy:"PZU",rodzaj_ubezpieczenia:"OC i AC",data_wygasniecia:ISODate("2025-02-10")},
        {id_ubezpieczenia:6,nazwa_firmy:"UNIQA",rodzaj_ubezpieczenia:"NNW",data_wygasniecia:ISODate("2024-09-25")},
        {id_ubezpieczenia:7,nazwa_firmy:"TRRASTI",rodzaj_ubezpieczenia:"OC i AC",data_wygasniecia:ISODate("2027-02-10")},
        {id_ubezpieczenia:8,nazwa_firmy:"BEESAFE",rodzaj_ubezpieczenia:"NNW",data_wygasniecia:ISODate("2029-08-16")},
        {id_ubezpieczenia:9,nazwa_firmy:"HDI",rodzaj_ubezpieczenia:"AC",data_wygasniecia:ISODate("2030-07-12")},
        {id_ubezpieczenia:10,nazwa_firmy:"LINK4",rodzaj_ubezpieczenia:"OC i AC",data_wygasniecia:ISODate("2024-05-21")},
    ])

// Wyświetlenie kolekcji "ubezpieczenia"
var kursor=db.ubezpieczenia.find({},{_id:0})
while (kursor.hasNext()) {
    print(kursor.next());
}
print()

// Tworzenie kolekcji "samochody" i dodanie dokumentów
db.samochody.insert(
    [
        {id_samochodu:1,marka:"SEAT",model:"Leon",skrzynia_biegow:"manual",rok_produkcji:2014,cena_wypozyczenia:100,id_ubezpieczen:[1,2,4]},
        {id_samochodu:2,marka:"AUDI",model:"A8",skrzynia_biegow:"manual",rok_produkcji:2010,cena_wypozyczenia:110,id_ubezpieczen:[4,5]},
        {id_samochodu:3,marka:"BMW",model:"220 Cabrio",skrzynia_biegow:"automat",rok_produkcji:2016,cena_wypozyczenia:120,id_ubezpieczen:[1,4,9]},
        {id_samochodu:4,marka:"CHEVROLET",model:"Volt",skrzynia_biegow:"manual",rok_produkcji:2018,cena_wypozyczenia:90,id_ubezpieczen:[8]},
        {id_samochodu:5,marka:"CITROEN",model:"C3 Aircross",skrzynia_biegow:"automat",rok_produkcji:2004,cena_wypozyczenia:95,id_ubezpieczen:[1,2]},
        {id_samochodu:6,marka:"FIAT",model:"Bravo",skrzynia_biegow:"manual",rok_produkcji:2008,cena_wypozyczenia:60,id_ubezpieczen:[4,5]},
        {id_samochodu:7,marka:"FORD",model:"Escape",skrzynia_biegow:"automat",rok_produkcji:2022,cena_wypozyczenia:80,id_ubezpieczen:[5]},
        {id_samochodu:8,marka:"HONDA",model:"Civic",skrzynia_biegow:"manual",rok_produkcji:2012,cena_wypozyczenia:120,id_ubezpieczen:[4,7]},
        {id_samochodu:9,marka:"FERRARI",model:"F12",skrzynia_biegow:"automat",rok_produkcji:2017,cena_wypozyczenia:150,id_ubezpieczen:[1,2]},
        {id_samochodu:10,marka:"ROLLS-ROYCE",model:"Ghost",skrzynia_biegow:"manual",rok_produkcji:2009,cena_wypozyczenia:130,id_ubezpieczen:[1,2]},
        {id_samochodu:11,marka:"NISSAN",model:"Cube",skrzynia_biegow:"manual",rok_produkcji:2002,cena_wypozyczenia:80,id_ubezpieczen:[1,7,9]},
        {id_samochodu:12,marka:"SUZUKI",model:"Alto",skrzynia_biegow:"automat",rok_produkcji:2020,cena_wypozyczenia:75,id_ubezpieczen:[4,10]},
        {id_samochodu:13,marka:"SUBARU",model:"Forester",skrzynia_biegow:"automat",rok_produkcji:2021,cena_wypozyczenia:125,id_ubezpieczen:[8]},
        {id_samochodu:14,marka:"TOYOTA",model:"Yaris",skrzynia_biegow:"manual",rok_produkcji:2015,cena_wypozyczenia:115,id_ubezpieczen:[8,10]}
    ])

// Wyświetlenie kolekcji "samochody"
var kursor=db.samochody.find({},{_id:0})
while (kursor.hasNext()) {
    print(kursor.next());
}
print()

// Tworzenie kolekcji "klienci" i dodanie dokumentów
db.klienci.insert(
    [
        {id_klienta:1,imie:"Jan",nazwisko:"Kowalski",adres:{miasto:"Gdynia",ulica:"Kwiatkowskiego 14"},telefon:111222333},
        {id_klienta:2,imie:"Maciej",nazwisko:"Brzechwa",adres:{miasto:"Gdańsk",ulica:"Mickiewicza 68"},telefon:264453576},
        {id_klienta:3,imie:"Dominik",nazwisko:"Noga",adres:{miasto:"Sopot",ulica:"Zielona 7"},telefon:999888777},
        {id_klienta:4,imie:"Adam",nazwisko:"Mickiewicz",adres:{miasto:"Gdynia",ulica:"Dębowa 22"},telefon:987987987},
        {id_klienta:5,imie:"Ania",nazwisko:"Nowak",adres:{miasto:"Gdynia",ulica:"Sosnowa 10"},telefon:654864256},
        {id_klienta:6,imie:"Weronika",nazwisko:"Malinowska",adres:{miasto:"Gdańsk",ulica:"Sezamowa 11"},telefon:254876234},
        {id_klienta:7,imie:"Kamila",nazwisko:"Dąbrowska",adres:{miasto:"Gdańsk",ulica:"Piernikowa 34"},telefon:143679630},
        {id_klienta:8,imie:"Marek",nazwisko:"Kwiatkowski",adres:{miasto:"Szczecin",ulica:"Morska 54"},telefon:153754073},
        {id_klienta:9,imie:"Mietek",nazwisko:"Tochowicz",adres:{miasto:"Toruń",ulica:"Czerwona 13"},telefon:123566432},
        {id_klienta:10,imie:"Kacper",nazwisko:"Zieloński",adres:{miasto:"Sopot",ulica:"Wesoła 42"},telefon:264009544}
    ])

// Wyświetlenie kolekcji "klienci"
var kursor=db.klienci.find({},{_id:0})
while (kursor.hasNext()) {
    print(kursor.next());
}
print()

// Tworzenie kolekcji "rezerwacje" i dodanie dokumentów
db.rezerwacje.insert(
    [
        {id_rezerwacji:1,id_klienta:1,id_samochodu:6,data_wypozyczenia:ISODate("2023-05-01"),data_zwrotu:ISODate("2023-05-12"),dodatki:{ochrona:"pełna",pakiet:"comfort"}},
        {id_rezerwacji:2,id_klienta:2,id_samochodu:2,data_wypozyczenia:ISODate("2023-06-01"),data_zwrotu:ISODate("2023-06-06"),dodatki:{ochrona:"czesciowa",pakiet:"elastyczny"}},
        {id_rezerwacji:3,id_klienta:3,id_samochodu:8,data_wypozyczenia:ISODate("2023-05-20"),data_zwrotu:ISODate("2023-05-30"),dodatki:{ochrona:"brak",pakiet:"premium"}},
        {id_rezerwacji:4,id_klienta:3,id_samochodu:5,data_wypozyczenia:ISODate("2023-05-11"),data_zwrotu:ISODate("2023-05-20"),dodatki:{ochrona:"brak",pakiet:"brak"}},
        {id_rezerwacji:5,id_klienta:4,id_samochodu:9,data_wypozyczenia:ISODate("2023-05-20"),data_zwrotu:ISODate("2023-05-28"),dodatki:{ochrona:"pełna",pakiet:"elastyczny"}},
        {id_rezerwacji:6,id_klienta:5,id_samochodu:1,data_wypozyczenia:ISODate("2023-05-20"),data_zwrotu:ISODate("2023-05-25"),dodatki:{ochrona:"pełna",pakiet:"comfort"}},
        {id_rezerwacji:7,id_klienta:6,id_samochodu:3,data_wypozyczenia:ISODate("2023-06-05"),data_zwrotu:ISODate("2023-06-14"),dodatki:{ochrona:"czesciowa",pakiet:"premium"}},
        {id_rezerwacji:8,id_klienta:6,id_samochodu:7,data_wypozyczenia:ISODate("2023-06-14"),data_zwrotu:ISODate("2023-06-20"),dodatki:{ochrona:"pełna",pakiet:"comfort"}},
        {id_rezerwacji:9,id_klienta:7,id_samochodu:4,data_wypozyczenia:ISODate("2023-06-22"),data_zwrotu:ISODate("2023-06-29"),dodatki:{ochrona:"czesciowa",pakiet:"brak"}},
        {id_rezerwacji:10,id_klienta:8,id_samochodu:10,data_wypozyczenia:ISODate("2023-07-08"),data_zwrotu:ISODate("2023-07-15"),dodatki:{ochrona:"brak",pakiet:"elastyczny"}},
        {id_rezerwacji:11,id_klienta:9,id_samochodu:12,data_wypozyczenia:ISODate("2023-07-18"),data_zwrotu:ISODate("2023-07-26"),dodatki:{ochrona:"brak",pakiet:"comfort"}},
        {id_rezerwacji:12,id_klienta:10,id_samochodu:14,data_wypozyczenia:ISODate("2023-07-24"),data_zwrotu:ISODate("2023-07-30"),dodatki:{ochrona:"pełna",pakiet:"premium"}}
    ])

// Wyświetlenie kolekcji "rezerwacje"
var kursor=db.rezerwacje.find({},{_id:0})
while (kursor.hasNext()) {
    print(kursor.next());
}
print()

// Tworzenie kolekcji "faktury" i dodanie dokumentów
db.faktury.insert(
    [
        {id_faktury:1,id_rezerwacji:1,uszkodzenia:"brak",kwota:3000,oplacone:"tak"},
        {id_faktury:2,id_rezerwacji:2,uszkodzenia:{opis:"Zniszczone lewe lusterko",koszt:800},kwota:4000,oplacone:"nie"},
        {id_faktury:3,id_rezerwacji:3,uszkodzenia:"brak",kwota:3200,oplacone:"tak"},
        {id_faktury:4,id_rezerwacji:4,uszkodzenia:"brak",kwota:2800,oplacone:"tak"},
        {id_faktury:5,id_rezerwacji:5,uszkodzenia:{opis:"Przebita prawa tylnia opona",koszt:300},kwota:3000,oplacone:"nie"},
        {id_faktury:6,id_rezerwacji:6,uszkodzenia:{opis:"Zarysowanie po lewej",koszt:200},kwota:3000,oplacone:"tak"},
        {id_faktury:7,id_rezerwacji:7,uszkodzenia:"brak",kwota:4200,oplacone:"nie"}
    ])

// Wyświetlenie kolekcji "faktury"
var kursor=db.faktury.find({},{_id:0})
while (kursor.hasNext()) {
    print(kursor.next());
}
print()

/*
// Funkcja, połącz 3 kolekcje, wyświetl wszystkich
function Join(tab1,tab2,tab3,wspolny_atr){
    var result=db[tab1].aggregate([
        // łączenie klienci-pensje
        {$lookup: {from: tab2,localField: wspolny_atr,foreignField: wspolny_atr,as: "wspolny"}},
        {$unwind: "$wspolny"},  
        {$addFields:{oceny:"$wspolny.oceny"}},
     S   // łączenie klienci-wiek
        {$lookup: {from: tab3,localField: wspolny_atr,foreignField: wspolny_atr,as: "wspolny2"}},
        {$unwind: "$wspolny2"},  
        {$addFields:{dane:"$wspolny2.dane"}},

        //{$match:{miasto:{$ne:"Sopot"},wiek:{$gte:18}}},
        {$project:{_id:0,nazwisko:1,imie:1,oceny:1,dane:1}}
    ])
    // wyświetla wynik
    while (result.hasNext()) {
        print(result.next());
    }
}

Join("samochody","oceny","dane","nazwisko")
*/