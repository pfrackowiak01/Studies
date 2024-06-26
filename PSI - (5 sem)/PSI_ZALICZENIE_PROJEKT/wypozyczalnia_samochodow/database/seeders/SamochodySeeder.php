<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

use Illuminate\Support\Facades\DB;
use App\Models\Samochody;

class SamochodySeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('samochody')->insert([

            [Samochody::FIELD_ID_SAMOCHODU => '1', 
            Samochody::FIELD_NAZWA => 'Golf 7 GTI', 
            Samochody::FIELD_SKRZYNIA_BIEG => 'automatyczna', 
            Samochody::FIELD_KLASA => 'B+', 
            Samochody::FIELD_MIEJSCA => 5,
            Samochody::FIELD_BAGAZ => 200,
            Samochody::FIELD_STAWKA_DZIENNA => 320,
            Samochody::FIELD_KAUCJA => 2000,
            Samochody::FIELD_ID_UBEZPIECZENIA => 2,
            Samochody::FIELD_SILNIK => 'benzyna',
            Samochody::FIELD_SPALANIE => 5.1,
            Samochody::FIELD_OBRAZEK => 'golf.png'], 

            [Samochody::FIELD_ID_SAMOCHODU => '2', 
            Samochody::FIELD_NAZWA => 'Seat Leon', 
            Samochody::FIELD_SKRZYNIA_BIEG => 'manualna', 
            Samochody::FIELD_KLASA => 'C', 
            Samochody::FIELD_MIEJSCA => 5,
            Samochody::FIELD_BAGAZ => 220,
            Samochody::FIELD_STAWKA_DZIENNA => 210,
            Samochody::FIELD_KAUCJA => 1800,
            Samochody::FIELD_ID_UBEZPIECZENIA => 1,
            Samochody::FIELD_SILNIK => 'diesel',
            Samochody::FIELD_SPALANIE => 6.2,
            Samochody::FIELD_OBRAZEK => 'seat.png'],  

            [Samochody::FIELD_ID_SAMOCHODU => '3', 
            Samochody::FIELD_NAZWA => 'Tesla', 
            Samochody::FIELD_SKRZYNIA_BIEG => 'automatyczna', 
            Samochody::FIELD_KLASA => 'A', 
            Samochody::FIELD_MIEJSCA => 5,
            Samochody::FIELD_BAGAZ => 250,
            Samochody::FIELD_STAWKA_DZIENNA => 460,
            Samochody::FIELD_KAUCJA => 2500,
            Samochody::FIELD_ID_UBEZPIECZENIA => 3,
            Samochody::FIELD_SILNIK => 'elektryczny',
            Samochody::FIELD_SPALANIE => 17, 
            Samochody::FIELD_OBRAZEK => 'tesla.png'], 

            ]);
    }
}
