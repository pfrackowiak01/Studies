baza = "ztbd_lab12"
connect("localhost:27017/" + baza)
console.clear();

// db.kolekcja7.insertMany([
//     {
//         "imie": "Tomasz",
//         "nazwisko": "Kowalski",
//         "data_ur": ISODate("1992-09-01")
//     },
//     {
//         "imie": "Maria",
//         "nazwisko": "Malinowska",
//         "data_ur": ISODate("1992-10-09")
//     },
//     {
//         "imie": "Jerzy",
//         "nazwisko": "Nowak",
//         "data_ur": ISODate("1993-05-09")
//     },
//     {
//         "imie": "Jan",
//         "nazwisko": "Kowalewski",
//         "data_ur": ISODate("1993-05-12")
//     }
// ]);

// db.kolekcja8.insertMany([
//     {
//         "nazwisko": "Kowalski",
//         "miasto": "Sopot",
//         "wynagr_netto": 4000
//     },
//     {
//         "nazwisko": "Nowak",
//         "miasto": "Gdańsk",
//         "wynagr_netto": 5000
//     },
//     {
//         "nazwisko": "Malinowska",
//         "miasto": "Gdańsk",
//         "wynagr_netto": 6000
//     },
//     {
//         "nazwisko": "Kowalewski",
//         "miasto": "Gdynia",
//         "wynagr_netto": 7000
//     }
// ]);

// db.kolekcja9.insertMany([
//     {
//         "nazwisko": "Kowalski",
//         "miasto": "Sopot",
//         "zawod": "elektryk"
//     },
//     {
//         "nazwisko": "Nowak",
//         "miasto": "Gdańsk",
//         "zawod": "elektronik"
        
//     },
//     {
//         "nazwisko": "Malinowska",
//         "miasto": "Gdańsk",
//         "zawod": "elektronik"
//     },
//     {
//         "nazwisko": "Kowalewski",
//         "miasto": "Gdynia",
//         "zawod": "elektryk"
//     }
// ]);

function pokazOsobyZGdanska(kol1, kol2, kol3, wspolny_atr) {
    var kursor = db[kol1].aggregate(
        {
            $lookup: {
                from: kol2, localField: "nazwisko", foreignField: "nazwisko",
                as: "tab1-tab2"
            }
        },
        {
            $unwind: "$tab1-tab2"
        },
        {
            $lookup: {
                from: kol3, localField: "nazwisko", foreignField: "nazwisko",
                as: "tab1-tab3"
            }
        },
        {
            $unwind: "$tab1-tab3"
        },
        {
            $addFields: {
                miasto: "$tab1-tab3.miasto",
                zawod: "$tab1-tab3.zawod",
                data_ur: { $dateToString: { format: "%Y-%m-%d", date: "$data_ur" } },
                rok_ur: { $year: "$data_ur" },
                mc_ur: { $month: "$data_ur" },
                dd_ur: { $dayOfMonth: "$data_ur" },
                wiek: { $subtract: [{ $year: ISODate() }, { $year: "$data_ur" }] },
                wynagr_netto: "$tab1-tab2.wynagr_netto",
                wynagr_brutto: { $multiply: ["$tab1-tab2.wynagr_netto", 1.23] }

            }
        },
        {
            $match: {
                miasto: "Gdańsk"
            }
        },
        { 
            $project: { 
                _id: 0, 
                nazwisko: 1, 
                miasto: 1, 
                zawod: 1, 
                data_ur: 1, 
                rok_ur: 1, 
                mc_ur: 1, 
                dd_ur: 1, 
                wiek: 1, 
                wynagr_netto: 1, 
                wynagr_brutto: 1 
            } 
        }
    )
    print("Kursor 1:")
    print()

    while (kursor.hasNext()) {
        print(kursor.next());
    }
}

function pokazZliczOsoby(kol1,kol2,kol3,wspolny_atr){
    var kursor = db[kol1].aggregate([
        {
            $lookup: {
              from: kol2,
              localField: wspolny_atr,
              foreignField: wspolny_atr,
              as: "kol1-kol2"
            }
        },
        {
            $unwind: "$kol1-kol2"
        },
        {
            $lookup: {
              from: kol3,
              localField: wspolny_atr,
              foreignField: wspolny_atr,
              as: "kol1-kol3"
            }
        },
        {
        
            $unwind: "$kol1-kol3"
        },
        {
            $addFields: {
              miasto: "$kol1-kol3.miasto",
              data_ur: {$dateToString: {format: "%Y-%m-%d", date: "$data_ur"}},
              rok_ur: {$year: "$data_ur"},
              wiek: {$subtract: [{$year: ISODate()}, {$year: "$data_ur"}]},
              zawod: "$kol1-kol3.zawod",
            }
        },
        {
            $match: {
                miasto: "Gdańsk"
            }
        },
        {
            $project: {
              _id: 0,
              nazwisko: 1,
              miasto: 1,
              zawod: 1,
              data_ur:1,
              rok_ur: 1,
              wiek: 1
            }
        }
    ]);

    var iloscDokumentow = 0;
    while (kursor.hasNext()) {
        print(kursor.next());
        iloscDokumentow++;
    }

    print("Ilość dokumentów: "+iloscDokumentow);

}

function grupujZlicz(kol1,kol2,kol3,wspolny_atr){
    var kursor = db[kol1].aggregate(
        {
            $lookup: {
              from: kol2,
              localField: wspolny_atr,
              foreignField: wspolny_atr,
              as: "kol1-kol2"
            }
        },
        {
            $unwind: "$kol1-kol2"
        },
        {
            $lookup: {
              from: kol3,
              localField: wspolny_atr,
              foreignField: wspolny_atr,
              as: "kol1-kol3"
            }
        },
        {
            $unwind: "$kol1-kol3"
        },
        {
            $addFields: {
              zawod: "$kol1-kol3.zawod"
            }
        },
        {
          $group: {
            _id: "$kol1-kol3.zawod",
            liczba_pracownikow: {$sum: 1}
          }
        },
        {
            $project: {
              _id: 0,
              zawod: 1,
              liczba_pracownikow: 1
            }
        }
    )
    while (kursor.hasNext()) {
        print(kursor.next());
    }
}

pokazOsobyZGdanska("kolekcja7","kolekcja8","kolekcja9","nazwisko");
print()
pokazZliczOsoby("kolekcja7","kolekcja8","kolekcja9","nazwisko");
print()
grupujZlicz("kolekcja7","kolekcja8","kolekcja9","nazwisko");