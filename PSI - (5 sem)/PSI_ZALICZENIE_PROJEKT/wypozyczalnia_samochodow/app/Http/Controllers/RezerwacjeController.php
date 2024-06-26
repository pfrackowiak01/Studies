<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

use App\Models\Rezerwacje;

class RezerwacjeController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $MyRezerwacje = Rezerwacje::all();
        if (auth()->user()->name != "admin")
            return view('rezerwacje.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('rezerwacje.list',['rezerwacje'=>$MyRezerwacje]);
    }

    public function index_api()
    {
        $myAPI_URL = config('app.url')."/api/rezerwacje/list";
        $res = Http::get($myAPI_URL);
        $MyRezerwacje = json_decode(json_encode($res->json()['data']), FALSE);
        if (auth()->user()->name != "admin")
            return view('rezerwacje.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('rezerwacje.list',['rezerwacje'=>$MyRezerwacje]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $MyKlient = Rezerwacje::all();
        if (auth()->user()->name != "admin")
            return view('rezerwacje.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('rezerwacje.add');
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
            'id_klienta' => 'required|integer',
            'id_samochodu' => 'required|integer',
            'data_pocz' => 'required|Data',
            'data_kon' => 'required|Data',
            'ochrona' => 'required|String',
            'pakiet' => 'required|String',
        ]);

        if($validated) {
            $rezerwacja = new Rezerwacje();
            $rezerwacja->id_klienta = $request->id_klienta;
            $rezerwacja->id_samochodu = $request->id_samochodu;
            $rezerwacja->data_pocz = $request->data_pocz;
            $rezerwacja->data_kon = $request->data_kon;
            $rezerwacja->ochrona = $request->ochrona;
            $rezerwacja->pakiet = $request->pakiet;
            if (auth()->user()->name != "admin")
                return view('rezerwacje.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else {
                $rezerwacja->save();
                return redirect('/rezerwacje/list');
            }
        }
    }

    public function store_api(Request $request)
    {
        $myAPI_URL = config('app.url')."/api/rezerwacje/new";
        $response = Http::post($myAPI_URL, $request);
        return redirect('rezerwacje/list');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $myRezerwacja = Rezerwacje::find($id);
        if ($myRezerwacja==null) {
            $error_message = "Id rezerwacjaa=".$id." not found";
            return view('rezerwacje.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        if ($myRezerwacja->count() > 0) {
            if(auth()->user()->name != "admin")
                return view('rezerwacje.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return view('rezerwacje.show',['rezerwacje'=>$myRezerwacja,]);
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
        $myRezerwacja = Rezerwacje::find($id);
        if ($myRezerwacja == null) {
            $error_message = "Id rezerwacjaa=".$id." not found";
            return view('rezerwacje.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        if ($myRezerwacja->count() > 0) {
            if (auth()->user()->name != "admin")
                return view('rezerwacje.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return view('rezerwacje.edit',['rezerwacje'=>$myRezerwacja,]);
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
            'id_klienta' => 'required|integer',
            'id_samochodu' => 'required|integer',
            'data_pocz' => 'required|Data',
            'data_kon' => 'required|Data',
            'ochrona' => 'required|String',
            'pakiet' => 'required|String',
        ]);

        if ($validated) {
            $rezerwacja = Rezerwacje::find($id);
            if ($rezerwacja!=null) {
                $rezerwacja->imie = $request->imie;
                $rezerwacja->nazwisko = $request->nazwisko;
                $rezerwacja->email = $request->email;
                $rezerwacja->telefon = $request->telefon;
                if (auth()->user()->name != "admin")
                    return view('rezerwacje.message',['message'=>'Access denied','type_of_message'=>'Error']);
                else {
                    $rezerwacja->save();
                    return redirect('/rezerwacje/list');
                }
            }
            else {
                $error_message = "Id rezerwacjaa=".$id." not found";
                return view('rezerwacje.message',['message'=>$error_message,'type_of_message'=>'Error']);
            }
        }
    }

    public function update_api(Request $request, $id)
    {
        $myAPI_URL = config('app.url')."/api/rezerwacje/update/".$id;
        $response = Http::patch($myAPI_URL,$request);
        return redirect('rezerwacje/list');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $rezerwacja = Rezerwacje::find($id);
        if ($rezerwacja!=null) {
            if (auth()->user()->name != "admin")
                return view('rezerwacje.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else {
                $rezerwacja->delete();
                return redirect('/rezerwacje/list');
            }     
        }
        else {
            $error_message = "Id rezerwacjaa=".$id." not found";
            return view('rezerwacje.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
    }

    public function destroy_api(Request $request, $id)
    {
        $myAPI_URL = config('app.url')."/api/rezerwacje/delete/".$id;
        $response = Http::delete($myAPI_URL);
        return redirect('rezerwacje/list');
    }

}
