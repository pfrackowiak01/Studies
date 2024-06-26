<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

use Illuminate\Support\Facades\DB;
use App\Models\Ubezpieczenia;

class UbezpieczeniaSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('ubezpieczenia')->insert([

            [Ubezpieczenia::FIELD_ID_UBEZPIECZENIA => '1', 
            Ubezpieczenia::FIELD_NAZWA => 'AutoCasco', 
            Ubezpieczenia::FIELD_DATA_WYGASNIECIA => '2023-12-20'], 

            [Ubezpieczenia::FIELD_ID_UBEZPIECZENIA => '2', 
            Ubezpieczenia::FIELD_NAZWA => 'OC/AC', 
            Ubezpieczenia::FIELD_DATA_WYGASNIECIA => '2025-10-28'], 

            [Ubezpieczenia::FIELD_ID_UBEZPIECZENIA => '3', 
            Ubezpieczenia::FIELD_NAZWA => 'PZU', 
            Ubezpieczenia::FIELD_DATA_WYGASNIECIA => '2024-06-30'], 

            ]);
    }
}
