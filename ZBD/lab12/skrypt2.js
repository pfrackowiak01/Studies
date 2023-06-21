baza = "baza_lab"
connect("localhost:27017/"+baza)
console.clear();

//-------------------------------------- tab1 i tab2: dokumenty
var kursor=db.tab1.find({},{_id:0})
while (kursor.hasNext()) {
    print(kursor.next());
}
print()
var kursor=db.tab2.find({},{_id:0})
while (kursor.hasNext()) {
    print(kursor.next());
}
//-------------------------------------- tab1 i tab2: połączenie
print()
var kursor=db.tab1.aggregate(
    {$lookup: {from: "tab2",localField: "nazwisko",foreignField: "nazwisko",
    as: "tab1-tab2"}},
    {$unwind: "$tab1-tab2"},  
    {$addFields:{miasto:"$tab1-tab2.miasto"}},
    {$project:{_id:0,nazwisko:1,imie:1,miasto:1}}
    )
while (kursor.hasNext()) {
    print(kursor.next());
}
//-------------------------------------- tab1 i tab2: połączenie + funkcja
function Join(kolekcja1,kolekcja2,wspolny_atr){
    print()
    print()

    var kursor=db[kolekcja1].aggregate(
        {$lookup: {from: kolekcja2,localField: wspolny_atr,foreignField: wspolny_atr,
        as: "tab1-tab2"}},
        {$unwind: "$tab1-tab2"},  
        {$addFields:{miasto:"$tab1-tab2.miasto"}},
        {$project:{_id:0,nazwisko:1,imie:1,miasto:1}}
        )

    while (kursor.hasNext()) {
       print(kursor.next());
    }
}
Join("tab1","tab2","nazwisko")