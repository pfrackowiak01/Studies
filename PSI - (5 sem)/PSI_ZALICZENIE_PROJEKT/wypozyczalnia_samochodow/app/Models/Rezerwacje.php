<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Rezerwacje extends Model
{
    // jeśli nie prowadzimy informacji timestamps
    // to należy zadeklarować to w modelu
    public $timestamps = false;

    // Stałe opisujące dostępne kolumny:
    public const FIELD_ID_REZERWACJI = 'id_rezerwacji';
    public const FIELD_ID_KLIENTA = 'id_klienta';
    public const FIELD_ID_SAMOCHODU = 'id_samochodu';
    public const FIELD_DATA_POCZ = 'data_pocz';
    public const FIELD_DATA_KON = 'data_kon';
    public const FIELD_OCHRONA = 'ochrona';
    public const FIELD_PAKIET = 'pakiet';

    // Nazwa tabeli powiązanej z modułem
    protected $table = 'rezerwacje';

    //Klucz główny
    protected $primaryKey = self::FIELD_ID_REZERWACJI;

    // Pola, które mogą być wypełniane masowo
    protected $fillable = [
    self::FIELD_ID_KLIENTA,
    self::FIELD_ID_SAMOCHODU,
    self::FIELD_DATA_POCZ,
    self::FIELD_DATA_KON,
    self::FIELD_OCHRONA,
    self::FIELD_PAKIET,
    ];

    // Dodatkowa metoda odczytująca wypozyczenie dla danej rezerwacji
    public function wypozyczenie()
    {
        return $this->hasMany(Wypozyczenia::class);
    }

    // Dodatkowa metoda odczytująca samochody dla danej rezerwacji
    public function samochod()
    {
        return $this->belongsTo(Samochody::class, 'id_samochodu');
    }

    // Dodatkowa metoda odczytująca samochody dla danej rezerwacji
    public function klient()
    {
        return $this->belongsTo(Klienci::class, 'id_klienta');
    }
}