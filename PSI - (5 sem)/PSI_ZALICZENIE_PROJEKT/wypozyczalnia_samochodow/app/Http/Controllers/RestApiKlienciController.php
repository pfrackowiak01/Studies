<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Klienci;
use App\Http\Requests\KlienciRequest;

class RestApiKlienciController extends Controller
{
    public function ListKlienci()
    {
        $myKlienci = Klienci::all();
        $data = ["data"=> $myKlienci];
        return response()->json($data,200);
    }

    public function NewKlienci(KlienciRequest $request)
    {
        $data = $request->validated();
        $klient = new Klienci();
        $klient->imie = $data['imie'];
        $klient->nazwisko = $data['nazwisko'];
        $klient->email = $data['email'];
        $klient->telefon = $data['telefon'];
        $klient->save();
        return response()->json(['data'=>$klient]);
    }

    public function DeleteKlienci($id)
    {
        $klient = Klienci::find($id);
        if ($klient != null) {
            $klient->delete();
            return response()->json(['data'=>$klient]);
        }
        else return response()->json(['data'=>[]]);
    }

    public function UpdateKlienci($id, KlienciRequest $request)
    {
        $data = $request->validated();
        $klient = Klienci::find($id);
        if ($klient != null) {
            $klient->imie = $data['imie'];
            $klient->nazwisko = $data['nazwisko'];
            $klient->email = $data['email'];
            $klient->telefon = $data['telefon'];
            $klient->save();
            return response()->json(['data'=>$klient]);
        }
        else return response()->json(['data'=>[]]);
    }

    public function FindKlienci($id)
    {
        $klient = Klienci::find($id);
        if ($klient != null) return response()->json(['data'=>$klient]);
        else return response()->json(['data'=>[]]);
    }
}
