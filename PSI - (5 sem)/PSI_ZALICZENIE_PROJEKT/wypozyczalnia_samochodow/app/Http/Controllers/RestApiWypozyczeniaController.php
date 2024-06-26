<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Wypozyczenia;
use App\Http\Requests\WypozyczeniaRequest;

class RestApiWypozyczeniaController extends Controller
{
    public function ListWypozyczenia()
    {
        $myWypozyczenia = Wypozyczenia::all();
        $data = ["data"=> $myWypozyczenia];
        return response()->json($data,200);
    }

    public function NewWypozyczenia(WypozyczeniaRequest $request)
    {
        $data = $request->validated();
        $wypozyczenie = new Wypozyczenia();
        $wypozyczenie->id_rezerwacji = $data['id_rezerwacji'];
        $wypozyczenie->stan_zwrotu = $data['stan_zwrotu'];
        $wypozyczenie->opis = $data['opis'];
        $wypozyczenie->koszt_uszkodzen = $data['koszt_uszkodzen'];
        $wypozyczenie->czy_wszystko_oplacone = $data['czy_wszystko_oplacone'];
        $wypozyczenie->save();
        return response()->json(['data'=>$wypozyczenie]);
    }

    public function DeleteWypozyczenia($id)
    {
        $wypozyczenie = Wypozyczenia::find($id);
        if ($wypozyczenie != null) {
            $wypozyczenie->delete();
            return response()->json(['data'=>$wypozyczenie]);
        }
        else return response()->json(['data'=>[]]);
    }

    public function UpdateWypozyczenia($id, WypozyczeniaRequest $request)
    {
        $data = $request->validated();
        $wypozyczenie = Wypozyczenia::find($id);
        if ($wypozyczenie != null) {
            $wypozyczenie->id_rezerwacji = $data['id_rezerwacji'];
            $wypozyczenie->stan_zwrotu = $data['stan_zwrotu'];
            $wypozyczenie->opis = $data['opis'];
            $wypozyczenie->koszt_uszkodzen = $data['koszt_uszkodzen'];
            $wypozyczenie->czy_wszystko_oplacone = $data['czy_wszystko_oplacone'];
            $wypozyczenie->save();
            return response()->json(['data'=>$wypozyczenie]);
        }
        else return response()->json(['data'=>[]]);
    }

    public function FindWypozyczenia($id)
    {
        $wypozyczenie = Wypozyczenia::find($id);
        if ($wypozyczenie != null) return response()->json(['data'=>$wypozyczenie]);
        else return response()->json(['data'=>[]]);
    }
}
