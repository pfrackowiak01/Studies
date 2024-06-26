<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Klienci extends Model
{
    // jeśli nie prowadzimy informacji timestamps
    // to należy zadeklarować to w modelu
    public $timestamps = false;

    // Stałe opisujące dostępne kolumny:
    public const FIELD_ID_KLIENTA = 'id_klienta';
    public const FIELD_IMIE = 'imie';
    public const FIELD_NAZWISKO = 'nazwisko';
    public const FIELD_EMAIL = 'email';
    public const FIELD_TELEFON = 'telefon';

    // Nazwa tabeli powiązanej z modułem
    protected $table = 'klienci';

    //Klucz główny
    protected $primaryKey = self::FIELD_ID_KLIENTA;

    // Pola, które mogą być wypełniane masowo
    protected $fillable = [
    self::FIELD_IMIE,
    self::FIELD_NAZWISKO,
    self::FIELD_EMAIL,
    self::FIELD_TELEFON,
    ];

    // Dodatkowa metoda odczytująca rezerwacje dla danego samochodu
    public function rezerwacja()
    {
        return $this->hasMany(Ubezpieczenia::class);
    }
    
}