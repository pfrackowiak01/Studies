<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Rezerwacje;
use App\Http\Requests\RezerwacjeRequest;

class RestApiRezerwacjeController extends Controller
{
    public function ListRezerwacje()
    {
        $myRezerwacje = Rezerwacje::all();
        $data = ["data"=> $myRezerwacje];
        return response()->json($data,200);
    }

    public function NewRezerwacje(RezerwacjeRequest $request)
    {
        $data = $request->validated();
        $rezerwacja = new Rezerwacje();
        $rezerwacja->id_klienta = $data['id_klienta'];
        $rezerwacja->id_samochodu = $data['id_samochodu'];
        $rezerwacja->data_pocz = $data['data_pocz'];
        $rezerwacja->data_kon = $data['data_kon'];
        $rezerwacja->ochrona = $data['ochrona'];
        $rezerwacja->pakiet = $data['pakiet'];
        $rezerwacja->save();
        return response()->json(['data'=>$rezerwacja]);
    }

    public function DeleteRezerwacje($id)
    {
        $rezerwacja = Rezerwacje::find($id);
        if ($rezerwacja != null) {
            $rezerwacja->delete();
            return response()->json(['data'=>$rezerwacja]);
        }
        else return response()->json(['data'=>[]]);
    }

    public function UpdateRezerwacje($id, RezerwacjeRequest $request)
    {
        $data = $request->validated();
        $rezerwacja = Rezerwacje::find($id);
        if ($rezerwacja != null) {
            $rezerwacja->id_klienta = $data['id_klienta'];
            $rezerwacja->id_samochodu = $data['id_samochodu'];
            $rezerwacja->data_pocz = $data['data_pocz'];
            $rezerwacja->data_kon = $data['data_kon'];
            $rezerwacja->ochrona = $data['ochrona'];
            $rezerwacja->pakiet = $data['pakiet'];
            $rezerwacja->save();
            return response()->json(['data'=>$rezerwacja]);
        }
        else return response()->json(['data'=>[]]);
    }

    public function FindRezerwacje($id)
    {
        $rezerwacja = Rezerwacje::find($id);
        if ($rezerwacja != null) return response()->json(['data'=>$rezerwacja]);
        else return response()->json(['data'=>[]]);
    }
}
