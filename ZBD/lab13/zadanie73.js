baza = "ztbd_lab13"
connect("localhost:27017/" + baza)
console.clear();

function pokazDaneUcznia(nazwiskoUcznia){
    var kursor = db.kolekcja1.aggregate([
        {
            $lookup: {
              from: "kolekcja2",
              localField: "nazwisko",
              foreignField: "nazwisko",
              as: "kol12"
            }
        },
        {
            $unwind: "$kol12"
        },
        {
            $lookup: {
              from: "kolekcja3",
              localField: "nazwisko",
              foreignField: "nazwisko",
              as: "kol13"
            }
        },
        {
            $unwind: "$kol13"
        },
        {
            $addFields: {
                ilosc_ocen: {$size: "$kol12.oceny_z_fizyki"},
                najgorsza_ocena: {$min: "$kol12.oceny_z_fizyki"}
            }
        },
        {
            $match: {
                nazwisko: nazwiskoUcznia
            }
        },
        {
            $project: {
                nazwisko: 1,
                imie: 1,
                ilosc_ocen: 1,
                najgorsza_ocena: 1
            }
        }
    ]);
    
    while(kursor.hasNext()) print(kursor.next())
}

pokazDaneUcznia("Kowalewski");