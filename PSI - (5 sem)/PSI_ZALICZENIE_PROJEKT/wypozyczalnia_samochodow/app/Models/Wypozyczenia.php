<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Wypozyczenia extends Model
{
    // jeśli nie prowadzimy informacji timestamps
    // to należy zadeklarować to w modelu
    public $timestamps = false;

    // Stałe opisujące dostępne kolumny:
    public const FIELD_ID_WYPOZYCZENIA = 'id_wypozyczenia';
    public const FIELD_ID_REZERWACJI = 'id_rezerwacji';
    public const FIELD_STAN_ZWROTU = 'stan_zwrotu';
    public const FIELD_OPIS = 'opis';
    public const FIELD_KOSZT_USZKODZEN = 'koszt_uszkodzen';
    public const FIELD_CZY_WSZYSTKO_OPLACONE = 'czy_wszystko_oplacone';

    // Nazwa tabeli powiązanej z modułem
    protected $table = 'wypozyczenia';

    //Klucz główny
    protected $primaryKey = self::FIELD_ID_WYPOZYCZENIA;

    // Pola, które mogą być wypełniane masowo
    protected $fillable = [
    self::FIELD_ID_WYPOZYCZENIA,
    self::FIELD_ID_REZERWACJI,
    self::FIELD_STAN_ZWROTU,
    self::FIELD_OPIS,
    self::FIELD_KOSZT_USZKODZEN,
    self::FIELD_CZY_WSZYSTKO_OPLACONE,
    ];

    // Dodatkowa metoda odczytująca rezerwacje dla danego wypozyczenia
    public function rezerwacja()
    {
        return $this->belongsTo(Rezerwacja::class, 'id_rezerwacji');
    }
}