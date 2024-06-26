<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

use App\Models\Samochody;

class SamochodyController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $MySamochody = Samochody::all();
        if (auth()->user()->name != "admin")
            return view('samochody.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('samochody.list',['samochody'=>$MySamochody]);
    }

    public function index_api()
    {
        $myAPI_URL = config('app.url')."/api/samochody/list";
        $res = Http::get($myAPI_URL);
        $MySamochody = json_decode(json_encode($res->json()['data']), FALSE);
        if (auth()->user()->name != "admin")
            return view('samochody.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('samochody.list',['samochody'=>$MySamochody]);
    }

    public function index_wynajem()
    {
        $MySamochody = Samochody::all();
        return view('wynajem',['samochody'=>$MySamochody]);
    }

    public function index_wynajmowanie($id)
    {
        $mySamochod = Samochody::find($id);
        if ($mySamochod==null) {
            $error_message = "Id samochoda=".$id." not found";
            return view('samochody.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        return view('wynajmowanie',['samochody'=>$mySamochod]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $MyKlient = Samochody::all();
        if (auth()->user()->name != "admin")
            return view('samochody.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('samochody.add');
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
            'nazwa' => 'required|integer',
            'skrzynia_bieg' => 'required|integer',
            'klasa' => 'required|String',
            'miejsca' => 'required|integer',
            'bagaz' => 'required|integer',
            'stawka_dzienna' => 'required|integer',
            'kaucja' => 'required|integer',
            'id_ubezpieczenia' => 'required|integer',
            'silnik' => 'required|String',
            'spalanie' => 'required|double',
            'obrazek' => 'required|String',
        ]);

        if($validated) {
            $samochod = new Samochody();
            $samochod->id_klienta = $request->id_klienta;
            $samochod->id_samochodu = $request->id_samochodu;
            $samochod->data_pocz = $request->data_pocz;
            $samochod->data_kon = $request->data_kon;
            $samochod->ochrona = $request->ochrona;
            $samochod->pakiet = $request->pakiet;
            if (auth()->user()->name != "admin")
                return view('samochody.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else {
                $samochod->save();
                return redirect('/samochody/list');
            }
        }
    }

    public function store_api(Request $request)
    {
        $myAPI_URL = config('app.url')."/api/samochody/new";
        $response = Http::post($myAPI_URL, $request);
        return redirect('samochody/list');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $mySamochod = Samochody::find($id);
        if ($mySamochod==null) {
            $error_message = "Id samochoda=".$id." not found";
            return view('samochody.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        if ($mySamochod->count() > 0) {
            if(auth()->user()->name != "admin")
                return view('samochody.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return view('samochody.show',['samochody'=>$mySamochod,]);
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
        $mySamochod = Samochody::find($id);
        if ($mySamochod == null) {
            $error_message = "Id samochoda=".$id." not found";
            return view('samochody.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        if ($mySamochod->count() > 0) {
            if (auth()->user()->name != "admin")
                return view('samochody.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return view('samochody.edit',['samochody'=>$mySamochod,]);
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
            'nazwa' => 'required|integer',
            'skrzynia_bieg' => 'required|integer',
            'klasa' => 'required|String',
            'miejsca' => 'required|integer',
            'bagaz' => 'required|integer',
            'stawka_dzienna' => 'required|integer',
            'kaucja' => 'required|integer',
            'id_ubezpieczenia' => 'required|integer',
            'silnik' => 'required|String',
            'spalanie' => 'required|double',
            'obrazek' => 'required|String',
        ]);

        if ($validated) {
            $samochod = Samochody::find($id);
            if ($samochod!=null) {
                $samochod->imie = $request->imie;
                $samochod->nazwisko = $request->nazwisko;
                $samochod->email = $request->email;
                $samochod->telefon = $request->telefon;
                if (auth()->user()->name != "admin")
                    return view('samochody.message',['message'=>'Access denied','type_of_message'=>'Error']);
                else {
                    $samochod->save();
                    return redirect('/samochody/list');
                }
            }
            else {
                $error_message = "Id samochoda=".$id." not found";
                return view('samochody.message',['message'=>$error_message,'type_of_message'=>'Error']);
            }
        }
    }

    public function update_api(Request $request, $id)
    {
        $myAPI_URL = config('app.url')."/api/samochody/update/".$id;
        $response = Http::patch($myAPI_URL,$request);
        return redirect('samochody/list');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $samochod = Samochody::find($id);
        if ($samochod!=null) {
            if (auth()->user()->name != "admin")
                return view('samochody.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else {
                $samochod->delete();
                return redirect('/samochody/list');
            }     
        }
        else {
            $error_message = "Id samochoda=".$id." not found";
            return view('samochody.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
    }

    public function destroy_api(Request $request, $id)
    {
        $myAPI_URL = config('app.url')."/api/samochody/delete/".$id;
        $response = Http::delete($myAPI_URL);
        return redirect('samochody/list');
    }

}
