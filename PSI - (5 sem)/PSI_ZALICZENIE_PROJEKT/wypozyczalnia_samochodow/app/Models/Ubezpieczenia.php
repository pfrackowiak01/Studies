<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Ubezpieczenia extends Model
{
    // jeśli nie prowadzimy informacji timestamps
    // to należy zadeklarować to w modelu
    public $timestamps = false;

    // Stałe opisujące dostępne kolumny:
    public const FIELD_ID_UBEZPIECZENIA = 'id_ubezpieczenia';
    public const FIELD_NAZWA = 'nazwa';
    public const FIELD_DATA_WYGASNIECIA = 'data_wygasniecia';


    // Nazwa tabeli powiązanej z modułem
    protected $table = 'ubezpieczenia';

    //Klucz główny
    protected $primaryKey = self::FIELD_ID_UBEZPIECZENIA;

    // Pola, które mogą być wypełniane masowo
    protected $fillable = [
    self::FIELD_NAZWA,
    self::FIELD_DATA_WYGASNIECIA,
    ];

    // Dodatkowa metoda odczytująca samochod dla danego ubezpieczenia
    public function samochod()
    {
        return $this->hasMany(Samochody::class);
    }
}