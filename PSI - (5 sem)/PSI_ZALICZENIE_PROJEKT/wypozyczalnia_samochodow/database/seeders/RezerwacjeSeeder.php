<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

use Illuminate\Support\Facades\DB;
use App\Models\Rezerwacje;

class RezerwacjeSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('rezerwacje')->insert([

            [Rezerwacje::FIELD_ID_REZERWACJI => '1', 
            Rezerwacje::FIELD_ID_KLIENTA => 3, 
            Rezerwacje::FIELD_ID_SAMOCHODU => 1, 
            Rezerwacje::FIELD_DATA_POCZ => '2022-03-24', 
            Rezerwacje::FIELD_DATA_KON => '2022-03-10',
            Rezerwacje::FIELD_OCHRONA => 'pelna',
            Rezerwacje::FIELD_PAKIET => 'premium' ], 

            [Rezerwacje::FIELD_ID_REZERWACJI => '2', 
            Rezerwacje::FIELD_ID_KLIENTA => 2, 
            Rezerwacje::FIELD_ID_SAMOCHODU => 2, 
            Rezerwacje::FIELD_DATA_POCZ => '2022-04-22', 
            Rezerwacje::FIELD_DATA_KON => '2022-04-26',
            Rezerwacje::FIELD_OCHRONA => 'czesciowa',
            Rezerwacje::FIELD_PAKIET => 'elastyczny' ], 

            [Rezerwacje::FIELD_ID_REZERWACJI => '3', 
            Rezerwacje::FIELD_ID_KLIENTA => 3, 
            Rezerwacje::FIELD_ID_SAMOCHODU => 3, 
            Rezerwacje::FIELD_DATA_POCZ => '2022-06-18', 
            Rezerwacje::FIELD_DATA_KON => '2022-06-20',
            Rezerwacje::FIELD_OCHRONA => 'brak',
            Rezerwacje::FIELD_PAKIET => 'comfort' ], 

            [Rezerwacje::FIELD_ID_REZERWACJI => '4', 
            Rezerwacje::FIELD_ID_KLIENTA => 2, 
            Rezerwacje::FIELD_ID_SAMOCHODU => 3, 
            Rezerwacje::FIELD_DATA_POCZ => '2023-02-14', 
            Rezerwacje::FIELD_DATA_KON => '2023-02-28',
            Rezerwacje::FIELD_OCHRONA => 'pelna',
            Rezerwacje::FIELD_PAKIET => 'brak' ], 

            ]);
    }
}
