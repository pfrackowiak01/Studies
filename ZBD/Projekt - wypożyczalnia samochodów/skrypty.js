// Łączenie z bazą
baza = "ubezpieczalnia_samochodow"
connect("localhost:27017/"+baza)
console.clear();

use(baza);

// Skrypt 1

function obliczKosztWypozyczenia(id_samochodu, data_poczatkowa, data_koncowa) {
  // Pobierz samochód na podstawie id_samochodu
  var samochod = db.samochody.findOne({ id_samochodu: id_samochodu });

  if (samochod) {
    var cena_wypozyczenia = samochod.cena_wypozyczenia;

    // Oblicz ilość dni pomiędzy datami
    var milisekundy_na_dzien = 24 * 60 * 60 * 1000; // Liczba milisekund w jednym dniu
    var ilosc_dni = Math.round((data_koncowa - data_poczatkowa) / milisekundy_na_dzien) + 1;
    console.log("Wypożyczenie będzie trwać " + ilosc_dni + " dni.");

    // Sprawdź czy ilość dni jest większa od zera
    if (ilosc_dni <= 0) {
      return "Podane daty są nieprawidłowe. Data końcowa musi być późniejsza niż data początkowa.";
    }

    // Oblicz koszt wypożyczenia
    var koszt = cena_wypozyczenia * ilosc_dni;

    return koszt;
  } else {
    return "Nie znaleziono samochodu o podanym id_samochodu.";
  }
}

// Przykładowe użycie funkcji
var id_samochodu = 3;
var data_poczatkowa = new Date("2023-06-01");
var data_koncowa = new Date("2023-06-05");
console.log("Wybrany samochód o nr id: " + id_samochodu);
console.log("Wybrana data początkowa: " + data_poczatkowa);
console.log("Wybrana data końcowa: " + data_koncowa);
console.log("-----------------------------------------");
var koszt_wypozyczenia = obliczKosztWypozyczenia(id_samochodu, data_poczatkowa, data_koncowa);
console.log("Koszt wypożyczenia " + koszt_wypozyczenia + " zł.");
console.log("-----------------------------------------");


console.log("======================================================================");
// Skrypt 2

function dodajSamochod(id_samochodu, marka, model, skrzynia_biegow, rok_produkcji, cena_wypozyczenia, id_ubezpieczen) {
  db.samochody.insert({
    id_samochodu: id_samochodu,
    marka: marka,
    model: model,
    skrzynia_biegow: skrzynia_biegow,
    rok_produkcji: rok_produkcji,
    cena_wypozyczenia: cena_wypozyczenia,
    id_ubezpieczen: id_ubezpieczen
  });
  wyswietlSamochod(id_samochodu);
}

function edytujParametrSamochodu(id_samochodu, parametr, nowa_wartosc) {
  db.samochody.update({ id_samochodu: id_samochodu }, { $set: { [parametr]: nowa_wartosc } });
  wyswietlSamochod(id_samochodu);
}

function usunSamochod(id_samochodu) {
  db.samochody.remove({ id_samochodu: id_samochodu });
  wyswietlSamochod(id_samochodu);
}

function wyswietlSamochod(id_samochodu) {
  const samochod = db.samochody.findOne({ id_samochodu: id_samochodu });
  if (samochod) {
    printjson(samochod);
  } else {
    print("Nie znaleziono samochodu o podanym id.");
  }
}

// Dodanie nowego samochodu
dodajSamochod(15, "MERCEDES", "E-Class", "automat", 2019, 140, [3, 6, 9]);

// Edycja parametru samochodu
edytujParametrSamochodu(15, "cena_wypozyczenia", 150);

// Usunięcie samochodu
usunSamochod(15);


console.log("======================================================================");
// Skrypt 3

function dostepneSamochody(dataPoczatkowa, dataKoncowa) {
  const rezerwacje = db.rezerwacje.find({
    $or: [
      { data_wypozyczenia: { $gte: dataPoczatkowa, $lte: dataKoncowa } },
      { data_zwrotu: { $gte: dataPoczatkowa, $lte: dataKoncowa } },
      { $and: [{ data_wypozyczenia: { $lte: dataPoczatkowa } }, { data_zwrotu: { $gte: dataKoncowa } }] }
    ]
  }).toArray();

  const zajeteSamochody = rezerwacje.map(rezerwacja => rezerwacja.id_samochodu);

  const dostepneSamochody = db.samochody.find({ id_samochodu: { $nin: zajeteSamochody } }).toArray();

  dostepneSamochody.forEach(samochod => {
    const nazwa = samochod.id_samochodu + ' ' + samochod.marka + ' ' + samochod.model;
    console.log(nazwa);
  });
}

const dataPoczatkowa = ISODate("2023-06-01");
const dataKoncowa = ISODate("2023-06-30");

dostepneSamochody(dataPoczatkowa, dataKoncowa);

