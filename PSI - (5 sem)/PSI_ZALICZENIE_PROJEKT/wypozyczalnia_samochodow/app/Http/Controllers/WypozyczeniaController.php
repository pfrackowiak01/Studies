<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

use App\Models\Wypozyczenia;

class WypozyczeniaController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $MyWypozyczenia = Wypozyczenia::all();
        if (auth()->user()->name != "admin")
            return view('wypozyczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('wypozyczenia.list',['wypozyczenia'=>$MyWypozyczenia]);
    }

    public function index_api()
    {
        $myAPI_URL = config('app.url')."/api/wypozyczenia/list";
        $res = Http::get($myAPI_URL);
        $MyWypozyczenia = json_decode(json_encode($res->json()['data']), FALSE);
        if (auth()->user()->name != "admin")
            return view('wypozyczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('wypozyczenia.list',['wypozyczenia'=>$MyWypozyczenia]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $MyKlient = Wypozyczenia::all();
        if (auth()->user()->name != "admin")
            return view('wypozyczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('wypozyczenia.add');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $validated = $request->validate([
            'id_rezerwacji' => 'required|integer',
            'stan_zwrotu' => 'required|String',
            'opis' => 'required|String',
            'koszt_uszkodzen' => 'required|integer',
            'czy_wszystko_oplacone' => 'required|String',
        ]);

        if($validated) {
            $wypozyczenie = new Wypozyczenia();
            $wypozyczenie->id_klienta = $request->id_klienta;
            $wypozyczenie->id_samochodu = $request->id_samochodu;
            $wypozyczenie->data_pocz = $request->data_pocz;
            $wypozyczenie->data_kon = $request->data_kon;
            $wypozyczenie->ochrona = $request->ochrona;
            $wypozyczenie->pakiet = $request->pakiet;
            if (auth()->user()->name != "admin")
                return view('wypozyczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else {
                $wypozyczenie->save();
                return redirect('/wypozyczenia/list');
            }
        }
    }

    public function store_api(Request $request)
    {
        $myAPI_URL = config('app.url')."/api/wypozyczenia/new";
        $response = Http::post($myAPI_URL, $request);
        return redirect('wypozyczenia/list');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $myWypozyczenie = Wypozyczenia::find($id);
        if ($myWypozyczenie==null) {
            $error_message = "Id wypozyczeniea=".$id." not found";
            return view('wypozyczenia.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        if ($myWypozyczenie->count() > 0) {
            if(auth()->user()->name != "admin")
                return view('wypozyczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return view('wypozyczenia.show',['wypozyczenia'=>$myWypozyczenie,]);
        }
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $myWypozyczenie = Wypozyczenia::find($id);
        if ($myWypozyczenie == null) {
            $error_message = "Id wypozyczeniea=".$id." not found";
            return view('wypozyczenia.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        if ($myWypozyczenie->count() > 0) {
            if (auth()->user()->name != "admin")
                return view('wypozyczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return view('wypozyczenia.edit',['wypozyczenia'=>$myWypozyczenie,]);
        }
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $validated = $request->validate([
            'id_rezerwacji' => 'required|integer',
            'stan_zwrotu' => 'required|String',
            'opis' => 'required|String',
            'koszt_uszkodzen' => 'required|integer',
            'czy_wszystko_oplacone' => 'required|String',
        ]);

        if ($validated) {
            $wypozyczenie = Wypozyczenia::find($id);
            if ($wypozyczenie!=null) {
                $wypozyczenie->imie = $request->imie;
                $wypozyczenie->nazwisko = $request->nazwisko;
                $wypozyczenie->email = $request->email;
                $wypozyczenie->telefon = $request->telefon;
                if (auth()->user()->name != "admin")
                    return view('wypozyczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
                else {
                    $wypozyczenie->save();
                    return redirect('/wypozyczenia/list');
                }
            }
            else {
                $error_message = "Id wypozyczeniea=".$id." not found";
                return view('wypozyczenia.message',['message'=>$error_message,'type_of_message'=>'Error']);
            }
        }
    }

    public function update_api(Request $request, $id)
    {
        $myAPI_URL = config('app.url')."/api/wypozyczenia/update/".$id;
        $response = Http::patch($myAPI_URL,$request);
        return redirect('wypozyczenia/list');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $wypozyczenie = Wypozyczenia::find($id);
        if ($wypozyczenie!=null) {
            if (auth()->user()->name != "admin")
                return view('wypozyczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else {
                $wypozyczenie->delete();
                return redirect('/wypozyczenia/list');
            }     
        }
        else {
            $error_message = "Id wypozyczeniea=".$id." not found";
            return view('wypozyczenia.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
    }

    public function destroy_api(Request $request, $id)
    {
        $myAPI_URL = config('app.url')."/api/wypozyczenia/delete/".$id;
        $response = Http::delete($myAPI_URL);
        return redirect('wypozyczenia/list');
    }

}
