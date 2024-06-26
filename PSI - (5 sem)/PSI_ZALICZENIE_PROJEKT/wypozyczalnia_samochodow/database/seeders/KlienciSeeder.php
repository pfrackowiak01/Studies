<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

use Illuminate\Support\Facades\DB;
use App\Models\Klienci;

class KlienciSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('klienci')->insert([

            [Klienci::FIELD_ID_KLIENTA => '1', 
            Klienci::FIELD_IMIE => 'admin', 
            Klienci::FIELD_NAZWISKO => 'admin', 
            Klienci::FIELD_EMAIL => 'admin@gmail.pl', 
            Klienci::FIELD_TELEFON => 111222333 ], 

            [Klienci::FIELD_ID_KLIENTA => '2', 
            Klienci::FIELD_IMIE => 'Pawel', 
            Klienci::FIELD_NAZWISKO => 'Frackowiak', 
            Klienci::FIELD_EMAIL => 'p.frackowiak@gmail.pl', 
            Klienci::FIELD_TELEFON => 510620730 ], 

            [Klienci::FIELD_ID_KLIENTA => '3', 
            Klienci::FIELD_IMIE => 'Michał', 
            Klienci::FIELD_NAZWISKO => 'Kowalski', 
            Klienci::FIELD_EMAIL => 'm.kowal206@gmail.pl', 
            Klienci::FIELD_TELEFON => 999888777 ], 

            ]);
    }
}
