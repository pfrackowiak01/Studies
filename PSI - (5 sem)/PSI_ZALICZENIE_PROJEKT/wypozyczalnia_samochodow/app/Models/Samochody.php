<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Samochody extends Model
{
    // jeśli nie prowadzimy informacji timestamps
    // to należy zadeklarować to w modelu
    public $timestamps = false;

    // Stałe opisujące dostępne kolumny:
    public const FIELD_ID_SAMOCHODU = 'id_samochodu';
    public const FIELD_NAZWA = 'nazwa';
    public const FIELD_SKRZYNIA_BIEG = 'skrzynia_bieg';
    public const FIELD_KLASA = 'klasa';
    public const FIELD_MIEJSCA = 'miejsca';
    public const FIELD_BAGAZ = 'bagaz';
    public const FIELD_STAWKA_DZIENNA = 'stawka_dzienna';
    public const FIELD_KAUCJA = 'kaucja';
    public const FIELD_ID_UBEZPIECZENIA = 'id_ubezpieczenia';
    public const FIELD_SILNIK = 'silnik';
    public const FIELD_SPALANIE = 'spalanie';
    public const FIELD_OBRAZEK = 'obrazek';

    // Nazwa tabeli powiązanej z modułem
    protected $table = 'samochody';

    //Klucz główny
    protected $primaryKey = self::FIELD_ID_SAMOCHODU;

    // Pola, które mogą być wypełniane masowo
    protected $fillable = [
    self::FIELD_ID_SAMOCHODU,
    self::FIELD_NAZWA,
    self::FIELD_SKRZYNIA_BIEG,
    self::FIELD_KLASA,
    self::FIELD_MIEJSCA,
    self::FIELD_BAGAZ,
    self::FIELD_STAWKA_DZIENNA,
    self::FIELD_KAUCJA,
    self::FIELD_ID_UBEZPIECZENIA,
    self::FIELD_SILNIK,
    self::FIELD_SPALANIE,
    self::FIELD_OBRAZEK,
    ];

    // Dodatkowa metoda odczytująca rezerwacje dla danego samochodu
    public function rezerwacja()
    {
        return $this->hasMany(Ubezpieczenia::class);
    }

    // Dodatkowa metoda odczytująca ubezpieczenia dla danego samochodu
    public function ubezpieczenia()
    {
        return $this->belongsTo(Ubezpieczenia::class, 'id_ubezpieczenia');
    }
}