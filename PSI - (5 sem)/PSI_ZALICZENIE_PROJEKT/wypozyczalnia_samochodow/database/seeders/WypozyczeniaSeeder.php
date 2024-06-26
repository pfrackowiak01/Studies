<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

use Illuminate\Support\Facades\DB;
use App\Models\Wypozyczenia;

class WypozyczeniaSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('wypozyczenia')->insert([

            [Wypozyczenia::FIELD_ID_WYPOZYCZENIA => '1', 
            Wypozyczenia::FIELD_ID_REZERWACJI => 1, 
            Wypozyczenia::FIELD_STAN_ZWROTU => 'zwrócony', 
            Wypozyczenia::FIELD_OPIS => 'Poproszę o szybki i punktualny odbiór',
            Wypozyczenia::FIELD_KOSZT_USZKODZEN => 0,
            Wypozyczenia::FIELD_CZY_WSZYSTKO_OPLACONE => 'tak' ], 

            [Wypozyczenia::FIELD_ID_WYPOZYCZENIA => '2', 
            Wypozyczenia::FIELD_ID_REZERWACJI => 2, 
            Wypozyczenia::FIELD_STAN_ZWROTU => 'zwrócony', 
            Wypozyczenia::FIELD_OPIS => 'Poproszę o dodatkowy fotelik dla dziecka',
            Wypozyczenia::FIELD_KOSZT_USZKODZEN => 0,
            Wypozyczenia::FIELD_CZY_WSZYSTKO_OPLACONE => 'tak' ], 

            [Wypozyczenia::FIELD_ID_WYPOZYCZENIA => '3', 
            Wypozyczenia::FIELD_ID_REZERWACJI => 3, 
            Wypozyczenia::FIELD_STAN_ZWROTU => 'uszkodzony', 
            Wypozyczenia::FIELD_OPIS => 'Zadzwonię od razu gdy wyląduję na miejscu (edit: urwane lusterko)',
            Wypozyczenia::FIELD_KOSZT_USZKODZEN => 1000,
            Wypozyczenia::FIELD_CZY_WSZYSTKO_OPLACONE => 'tak' ], 

            [Wypozyczenia::FIELD_ID_WYPOZYCZENIA => '4', 
            Wypozyczenia::FIELD_ID_REZERWACJI => 4, 
            Wypozyczenia::FIELD_STAN_ZWROTU => 'zarezerwowany', 
            Wypozyczenia::FIELD_OPIS => 'O 18:00 będę pod Teatrem Muzycznym',
            Wypozyczenia::FIELD_KOSZT_USZKODZEN => 0,
            Wypozyczenia::FIELD_CZY_WSZYSTKO_OPLACONE => 'nie' ], 

            ]);
    }
}
