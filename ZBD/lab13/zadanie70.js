baza = "ztbd_lab13"
connect("localhost:27017/" + baza)
console.clear();

db.kolekcja2.updateOne(
    { nazwisko: "Nowak" },
    {
        $push: {
            "oceny_z_fizyki": 4
        }
    }
)

var kursor = db.kolekcja2.find({},{_id: 0});

while(kursor.hasNext()) print(kursor.next());