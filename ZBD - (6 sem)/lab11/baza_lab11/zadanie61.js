// Łączenie z bazą
baza = "baza_lab10"
connect("localhost:27017/"+baza);
console.clear();

// Dodanie indexu złożonego na "id" i "certificate_number"
db.cities_A.createIndex({id:1,certificate_number:1});

// Sprawdzenie istniejących indexów
db.cities_A.getIndexes();

// Mierzony czas
czas_startu=new Date;
print(czas_startu);

// Wyswietlenie wszystkich dokumentow
var kol=db.cities_A.find({"certificate_number":{$gt:4000},"id":/2015-CMPL/},{_id:1,id:1,certificate_number:1});
while (kol.hasNext()){print(kol.next());}

// Policzenie wszystkich dokumentow
var ile=db.cities_A.find({"certificate_number":{$gt:4000},"id":/2015-CMPL/},{_id:1,id:1,certificate_number:1}).count();
print('ilość dokumentów: '+ile);

// Wyświetenie zmierzonego czasu
czas_konca=new Date;
czas_calk=(czas_konca-czas_startu);
print(czas_konca);
print(czas_calk+'ms');

// Usunięcie indexu na "certificate_number"
db.cities_A.dropIndex({id:1,certificate_number:1});

// Sprawdzenie istniejących indexów
db.cities_A.getIndexes();