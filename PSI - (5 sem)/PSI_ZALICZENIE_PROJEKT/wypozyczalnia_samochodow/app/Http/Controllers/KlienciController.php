<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

use App\Models\Klienci;

class KlienciController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $MyKlienci = Klienci::all();
        if (auth()->user()->name != "admin")
            return view('klienci.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('klienci.list',['klienci'=>$MyKlienci]);
    }

    public function index_api()
    {
        $myAPI_URL = config('app.url')."/api/klienci/list";
        $res = Http::get($myAPI_URL);
        $MyKlienci = json_decode(json_encode($res->json()['data']), FALSE);
        if (auth()->user()->name != "admin")
            return view('klienci.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
        return view('klienci.list',['klienci'=>$MyKlienci]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $MyKlient = Klienci::all();
        if (auth()->user()->name != "admin")
            return view('klienci.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('klienci.add');
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
            'imie' => 'required|String|min:2|max:15',
            'nazwisko' => 'required|String|min:2|max:30',
            'email' => 'required|String|regex:/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$/',
            'telefon' => 'required|integer|regex:/^([0-9]{9})$/',
        ]);

        if($validated) {
            $klient = new Klienci();
            $klient->imie = $request->imie;
            $klient->nazwisko = $request->nazwisko;
            $klient->email = $request->email;
            $klient->telefon = $request->telefon;
            if (auth()->user()->name != "admin")
                return view('klienci.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else {
                $klient->save();
                return redirect('/klienci/list');
            }
        }
    }

    public function store_api(Request $request)
    {
        $validated = $request->validate([
            'imie' => 'required|String|min:2|max:15',
            'nazwisko' => 'required|String|min:2|max:30',
            'email' => 'required|String|regex:/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$/',
            'telefon' => 'required|integer|regex:/^([0-9]{9})$/',
        ]);

        $myAPI_URL = config('app.url')."/api/klienci/new";
        $response = Http::post($myAPI_URL, $request);
        return redirect('klienci/list');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $myKlient = Klienci::find($id);
        if ($myKlient==null) {
            $error_message = "Id klienta=".$id." not found";
            return view('klienci.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        if ($myKlient->count() > 0) {
            if(auth()->user()->name != "admin")
                return view('klienci.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return view('klienci.show',['klienci'=>$myKlient,]);
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
        $myKlient = Klienci::find($id);
        if ($myKlient == null) {
            $error_message = "Id klienta=".$id." not found";
            return view('klienci.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        if ($myKlient->count() > 0) {
            if (auth()->user()->name != "admin")
                return view('klienci.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return view('klienci.edit',['klienci'=>$myKlient,]);
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
            'imie' => 'required|String|min:2|max:15',
            'nazwisko' => 'required|String|min:2|max:30',
            'email' => 'required|String|regex:/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$/',
            'telefon' => 'required|integer|regex:/^([0-9]{9})$/',
        ]);

        if ($validated) {
            $klient = Klienci::find($id);
            if ($klient!=null) {
                $klient->imie = $request->imie;
                $klient->nazwisko = $request->nazwisko;
                $klient->email = $request->email;
                $klient->telefon = $request->telefon;
                if (auth()->user()->name != "admin")
                    return view('klienci.message',['message'=>'Access denied','type_of_message'=>'Error']);
                else {
                    $klient->save();
                    return redirect('/klienci/list');
                }
            }
            else {
                $error_message = "Id klienta=".$id." not found";
                return view('klienci.message',['message'=>$error_message,'type_of_message'=>'Error']);
            }
        }
    }

    public function update_api(Request $request, $id)
    {
        $validated = $request->validate([
            'imie' => 'required|String|min:2|max:15',
            'nazwisko' => 'required|String|min:2|max:30',
            'email' => 'required|String|regex:/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$/',
            'telefon' => 'required|integer|regex:/^([0-9]{9})$/',
        ]);
        
        $myAPI_URL = config('app.url')."/api/klienci/update/".$id;
        $response = Http::patch($myAPI_URL,$request);
        return redirect('klienci/list');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $klient = Klienci::find($id);
        if ($klient!=null) {
            if (auth()->user()->name != "admin")
                return view('klienci.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else {
                $klient->delete();
                return redirect('/klienci/list');
            }     
        }
        else {
            $error_message = "Id klienta=".$id." not found";
            return view('klienci.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
    }

    public function destroy_api(Request $request, $id)
    {
        $myAPI_URL = config('app.url')."/api/klienci/delete/".$id;
        $response = Http::delete($myAPI_URL);
        return redirect('klienci/list');
    }

}
