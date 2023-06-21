baza = "baza_lab"
connect("localhost:27017/"+baza)
console.clear();

//-------------------------------------- INSERT (jeden dokument)
db.test_js.insert({nazwisko:"Nowak",wiek:30})
var kursor=db.test_js.find({},{_id:0})
while (kursor.hasNext()) {
    print(kursor.next());
 }
//-------------------------------------- linijka odstępu
print()
//-------------------------------------- INSERT (kilka dokumentów)
db.test_js.insert(
[
    {nazwisko:"Malinowski",wiek:35},
    {nazwisko:"Kalinowska",wiek:45},
    {nazwisko:"Nowicka",wiek:55}
])
var kursor=db.test_js.find({},{_id:0})
while (kursor.hasNext()) {
    print(kursor.next());
 }
//-------------------------------------- linijka odstępu
print()
//-------------------------------------- INSERT (jeden dokument) + zmienne
var nowe_nazwisko="Kowalewski", nowy_wiek=90

db.test_js.insert({nazwisko:nowe_nazwisko,wiek:nowy_wiek})
var kursor=db.test_js.find({},{_id:0})
while (kursor.hasNext()) {
    print(kursor.next());
 }
//-------------------------------------- linijka odstępu
print()
//-------------------------------------- INSERT (jeden dokument) + funkcja (1)
function DodajOsobe(nowe_nazwisko,nowy_wiek){
    db.test_js.insert({nazwisko:nowe_nazwisko,wiek:nowy_wiek})
    var kursor=db.test_js.find({},{_id:0})
    while (kursor.hasNext()) {
        print(kursor.next());
     }
}
DodajOsobe("Kowalski",80)
//-------------------------------------- linijka odstępu
print()
//-------------------------------------- INSERT (jeden dokument) + funkcja (2)
var DodajOsobe=function(nowe_nazwisko,nowy_wiek){
    db.test_js.insert({nazwisko:nowe_nazwisko,wiek:nowy_wiek})
    var kursor=db.test_js.find({},{_id:0})
    while (kursor.hasNext()) {
       print(kursor.next());
    }
}
DodajOsobe("Nowakowski",70)
//-------------------------------------- linijka odstępu
print()
//-------------------------------------- ILE DOKUMENTÓW + funkcja (1)
function IleDok1(){
    var tab=db.test_js.aggregate([
    {$group:{_id:{},ile:{$sum:1}}},
    {$project:{_id:0,ile:1}}
    ]).toArray();
    print(tab[0])
}
IleDok1()
//-------------------------------------- ILE DOKUMENTÓW + funkcja (2)
function IleDok2(){
    var tab=db.test_js.aggregate([
    {$group:{_id:{},ile:{$sum:1}}},
    {$project:{_id:0,ile:1}}
    ]).toArray();
    return tab[0]
}
print(IleDok2())
//-------------------------------------- ILE DOKUMENTÓW + funkcja (3)
function IleDok3(kolekcja){
    var tab=db[kolekcja].aggregate([
    {$group:{_id:{},ile:{$sum:1}}},
    {$project:{_id:0,ile:1}}
    ]).toArray();
    return tab[0]
}
print(IleDok3("test_js"))
//-------------------------------------- linijka odstępu
print()
//-------------------------------------- DOKUMENTY + funkcja
function Dokumenty(kolekcja){
    var kursor=db[kolekcja].find({},{_id:0})
    while (kursor.hasNext()) {
       print(kursor.next());
    }
}
Dokumenty("test_js")

db.test_js.drop()



