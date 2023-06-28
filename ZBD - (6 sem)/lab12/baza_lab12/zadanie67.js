baza = "ztbd_lab12"
connect("localhost:27017/" + baza)
console.clear();

db.kolekcja5.insertMany([
    {
        "id": 1,
        "nazwisko": "Kowalski",
        "wiek": 35,
        "netto": 3600
    },
    {
        "id": 2,
        "nazwisko": "Malinowska",
        "wiek": 56,
        "netto": 2900
    },
    {
        "id": 3,
        "nazwisko": "Nowak",
        "wiek": 41,
        "netto": 4200
    },
    {
        "id": 4,
        "nazwisko": "Kowalewski",
        "wiek": 51,
        "netto": 3800
    },
]);

db.kolekcja6.insertMany([
    {
        "id": 1,
        "nazwisko": "Kowalski",
        "miasto": "Sopot"
    },
    {
        "id": 2,
        "nazwisko": "Nowak",
        "miasto": "Gdańsk"
    },
    {
        "id": 3,
        "nazwisko": "Malinowska",
        "miasto": "Gdańsk"
    },
    {
        "id": 4,
        "nazwisko": "Kowalewski",
        "miasto": "Gdynia"
    }
]);

function pokazOsoby(kol1, kol2, kol3, wspolny_atr) {
    print()
    print("Kursor 1:")
    print()

    var kursor = db[kol1].aggregate(
        {
            $lookup: {
                from: kol2, localField: wspolny_atr, foreignField: wspolny_atr,
                as: "kol1-kol2"
            }
        },
        { $unwind: "$kol1-kol2" },
        {
            $lookup: {
                from: kol3, localField: wspolny_atr, foreignField: wspolny_atr,
                as: "kol1-kol3"
            }
        },
        { $unwind: "$kol1-kol3" },
        {
            $addFields: {
                netto: "$kol1-kol2.pensja",
                rok_ur: {$subtract: [{$year: ISODate()}, "$kol1-kol3.wiek"]},
                brutto: {$multiply: ["$kol1-kol2.pensja", 1.23]}
            }
        },
        { $project: { _id: 0, nazwisko: 1, miasto: 1, rok_ur: 1, netto: 1, brutto: 1 } }
    )

    while (kursor.hasNext()) {
        print(kursor.next());
    }    
}

function pokazOsoby(kol1, kol2, kol3){
    var kursor2 =  db[kol1].aggregate(
        {
            $lookup: {
                from: kol2, localField: "nazwisko", foreignField: "nazwisko",
                as: "kol1-kol2"
            }
        },
        { $unwind: "$kol1-kol2" },
        {
            $lookup: {
                from: kol3, localField: "nazwisko", foreignField: "nazwisko",
                as: "kol1-kol3"
            }
        },
        {
            $match: {
                miasto: "Gdańsk"
            }
        },
        { $project: { _id: 0, nazwisko: 1, miasto: 1, rok_ur: 1, netto: 1, brutto: 1 } }
    )
    print("Kursor 2:")
    print()
    
    while (kursor2.hasNext()) {
        print(kursor2.next());
    }
}

pokazOsoby("kolekcja1", "kolekcja2","kolekcja3", "nazwisko");
pokazOsobyGdansk("kolekcja1", "kolekcja2","kolekcja3", "nazwisko");