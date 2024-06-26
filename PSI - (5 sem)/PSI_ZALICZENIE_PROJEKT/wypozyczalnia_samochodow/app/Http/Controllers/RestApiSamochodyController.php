<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Samochody;
use App\Http\Requests\SamochodyRequest;

class RestApiSamochodyController extends Controller
{
    public function ListSamochody()
    {
        $mySamochody = Samochody::all();
        $data = ["data"=> $mySamochody];
        return response()->json($data,200);
    }

    public function NewSamochody(SamochodyRequest $request)
    {
        $data = $request->validated();
        $samochod = new Samochody();
        $samochod->nazwa = $data['nazwa'];
        $samochod->skrzynia_bieg = $data['skrzynia_bieg'];
        $samochod->klasa = $data['klasa'];
        $samochod->miejsca = $data['miejsca'];
        $samochod->bagaz = $data['bagaz'];
        $samochod->stawka_dzienna = $data['stawka_dzienna'];
        $samochod->kaucja = $data['kaucja'];
        $samochod->id_ubezpieczenia = $data['id_ubezpieczenia'];
        $samochod->silnik = $data['silnik'];
        $samochod->spalanie = $data['spalanie'];
        $samochod->obrazek = $data['obrazek'];
        $samochod->save();
        return response()->json(['data'=>$samochod]);
    }

    public function DeleteSamochody($id)
    {
        $samochod = Samochody::find($id);
        if ($samochod != null) {
            $samochod->delete();
            return response()->json(['data'=>$samochod]);
        }
        else return response()->json(['data'=>[]]);
    }

    public function UpdateSamochody($id, SamochodyRequest $request)
    {
        $data = $request->validated();
        $samochod = Samochody::find($id);
        if ($samochod != null) {
            $samochod->nazwa = $data['nazwa'];
            $samochod->skrzynia_bieg = $data['skrzynia_bieg'];
            $samochod->klasa = $data['klasa'];
            $samochod->miejsca = $data['miejsca'];
            $samochod->bagaz = $data['bagaz'];
            $samochod->stawka_dzienna = $data['stawka_dzienna'];
            $samochod->kaucja = $data['kaucja'];
            $samochod->id_ubezpieczenia = $data['id_ubezpieczenia'];
            $samochod->silnik = $data['silnik'];
            $samochod->spalanie = $data['spalanie'];
            $samochod->obrazek = $data['obrazek'];
            $samochod->save();
            return response()->json(['data'=>$samochod]);
        }
        else return response()->json(['data'=>[]]);
    }

    public function FindSamochody($id)
    {
        $samochod = Samochody::find($id);
        if ($samochod != null) return response()->json(['data'=>$samochod]);
        else return response()->json(['data'=>[]]);
    }
}
