<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Ubezpieczenia;
use App\Http\Requests\UbezpieczeniaRequest;

class RestApiUbezpieczeniaController extends Controller
{
    public function ListUbezpieczenia()
    {
        $myUbezpieczenia = Ubezpieczenia::all();
        $data = ["data"=> $myUbezpieczenia];
        return response()->json($data,200);
    }

    public function NewUbezpieczenia(UbezpieczeniaRequest $request)
    {
        $data = $request->validated();
        $ubezpieczenie = new Ubezpieczenia();
        $ubezpieczenie->nazwa = $data['nazwa'];
        $ubezpieczenie->data_wygasniecia = $data['data_wygasniecia'];
        $ubezpieczenie->save();
        return response()->json(['data'=>$ubezpieczenie]);
    }

    public function DeleteUbezpieczenia($id)
    {
        $ubezpieczenie = Ubezpieczenia::find($id);
        if ($ubezpieczenie != null) {
            $ubezpieczenie->delete();
            return response()->json(['data'=>$ubezpieczenie]);
        }
        else return response()->json(['data'=>[]]);
    }

    public function UpdateUbezpieczenia($id, UbezpieczeniaRequest $request)
    {
        $data = $request->validated();
        $ubezpieczenie = Ubezpieczenia::find($id);
        if ($ubezpieczenie != null) {
            $ubezpieczenie->nazwa = $data['nazwa'];
            $ubezpieczenie->data_wygasniecia = $data['data_wygasniecia'];
            $ubezpieczenie->save();
            return response()->json(['data'=>$ubezpieczenie]);
        }
        else return response()->json(['data'=>[]]);
    }

    public function FindUbezpieczenia($id)
    {
        $ubezpieczenie = Ubezpieczenia::find($id);
        if ($ubezpieczenie != null) return response()->json(['data'=>$ubezpieczenie]);
        else return response()->json(['data'=>[]]);
    }
}
