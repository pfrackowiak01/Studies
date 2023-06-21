baza = "ztbd_lab13"
connect("localhost:27017/" + baza)
console.clear();

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
            oceny_z_fizyki: "$kol12.oceny_z_fizyki",
            dane_ucznia: "$kol13.dane_ucznia"
        }
    },
    {
        $project: {
            nazwisko: 1,
            imie: 1,
            oceny_z_fizyki: 1,
            dane_ucznia: 1
        }
    }
]);

while(kursor.hasNext()) print(kursor.next())