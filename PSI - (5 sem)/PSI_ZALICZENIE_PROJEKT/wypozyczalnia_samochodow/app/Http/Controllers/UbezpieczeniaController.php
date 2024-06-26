<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

use App\Models\Ubezpieczenia;

class UbezpieczeniaController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $MyUbezpieczenia = Ubezpieczenia::all();
        if (auth()->user()->name != "admin")
            return view('ubezpieczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('ubezpieczenia.list',['ubezpieczenia'=>$MyUbezpieczenia]);
    }

    public function index_api()
    {
        $myAPI_URL = config('app.url')."/api/ubezpieczenia/list";
        $res = Http::get($myAPI_URL);
        $MyUbezpieczenia = json_decode(json_encode($res->json()['data']), FALSE);
        if (auth()->user()->name != "admin")
            return view('ubezpieczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
        return view('ubezpieczenia.list',['ubezpieczenia'=>$MyUbezpieczenia]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $MyUbezpieczenie = Ubezpieczenia::all();
        if (auth()->user()->name != "admin")
            return view('ubezpieczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('ubezpieczenia.add');
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
            'id_ubezpieczenia' => 'required|integer',
            'nazwa' => 'required|String',
            'data_wygasniecia' => 'required|String',
        ]);

        if($validated) {
            $ubezpieczenie = new Ubezpieczenia();
            $ubezpieczenie->imie = $request->imie;
            $ubezpieczenie->nazwisko = $request->nazwisko;
            $ubezpieczenie->email = $request->email;
            $ubezpieczenie->telefon = $request->telefon;
            if (auth()->user()->name != "admin")
                return view('ubezpieczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else {
                $ubezpieczenie->save();
                return redirect('/ubezpieczenia/list');
            }
        }
    }

    public function store_api(Request $request)
    {
        $myAPI_URL = config('app.url')."/api/ubezpieczenia/new";
        $response = Http::post($myAPI_URL, $request);
        return redirect('ubezpieczenia/list');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $myUbezpieczenie = Ubezpieczenia::find($id);
        if ($myUbezpieczenie==null) {
            $error_message = "Id ubezpieczeniea=".$id." not found";
            return view('ubezpieczenia.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        if ($myUbezpieczenie->count() > 0) {
            if(auth()->user()->name != "admin")
                return view('ubezpieczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return view('ubezpieczenia.show',['ubezpieczenia'=>$myUbezpieczenie,]);
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
        $myUbezpieczenie = Ubezpieczenia::find($id);
        if ($myUbezpieczenie == null) {
            $error_message = "Id ubezpieczeniea=".$id." not found";
            return view('ubezpieczenia.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        if ($myUbezpieczenie->count() > 0) {
            if (auth()->user()->name != "admin")
                return view('ubezpieczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return view('ubezpieczenia.edit',['ubezpieczenia'=>$myUbezpieczenie,]);
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
            'id_ubezpieczenia' => 'required|integer',
            'nazwa' => 'required|String',
            'data_wygasniecia' => 'required|String',
        ]);

        if ($validated) {
            $ubezpieczenie = Ubezpieczenia::find($id);
            if ($ubezpieczenie!=null) {
                $ubezpieczenie->imie = $request->imie;
                $ubezpieczenie->nazwisko = $request->nazwisko;
                $ubezpieczenie->email = $request->email;
                $ubezpieczenie->telefon = $request->telefon;
                if (auth()->user()->name != "admin")
                    return view('ubezpieczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
                else {
                    $ubezpieczenie->save();
                    return redirect('/ubezpieczenia/list');
                }
            }
            else {
                $error_message = "Id ubezpieczeniea=".$id." not found";
                return view('ubezpieczenia.message',['message'=>$error_message,'type_of_message'=>'Error']);
            }
        }
    }

    public function update_api(Request $request, $id)
    {
        $myAPI_URL = config('app.url')."/api/ubezpieczenia/update/".$id;
        $response = Http::patch($myAPI_URL,$request);
        return redirect('ubezpieczenia/list');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $ubezpieczenie = Ubezpieczenia::find($id);
        if ($ubezpieczenie!=null) {
            if (auth()->user()->name != "admin")
                return view('ubezpieczenia.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else {
                $ubezpieczenie->delete();
                return redirect('/ubezpieczenia/list');
            }     
        }
        else {
            $error_message = "Id ubezpieczeniea=".$id." not found";
            return view('ubezpieczenia.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
    }

    public function destroy_api(Request $request, $id)
    {
        $myAPI_URL = config('app.url')."/api/ubezpieczenia/delete/".$id;
        $response = Http::delete($myAPI_URL);
        return redirect('ubezpieczenia/list');
    }

}
