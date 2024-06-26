<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

use App\Models\ModuleCrew;
use App\Models\ShipModules;

class ModuleCrewController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $MyModuleCrew = ModuleCrew::all();
        return view('modulecrew.list',['module_crew'=>$MyModuleCrew,]);
    }

    public function index_api()
    {
        $myAPI_URL = config('app.url')."/api/modulecrew/list";
        $res=Http::get($myAPI_URL);
        $MyModuleCrew = json_decode(json_encode($res->json()['data']), FALSE);
        return view('modulecrew.list',['module_crew'=>$MyModuleCrew,]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $MyShipModules = ShipModules::all();
        if (auth()->user()->name != "admin")
            return view('modulecrew.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('modulecrew.add',['ship_modules'=>$MyShipModules,]);
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
            'ship_module_id' => 'required',
            'nick' => 'required|min:3|max:10|unique:module_crew',
            'gender' => 'required',
            'age' => 'required|integer|between:18,85',
        ]);

        if ($validated) {
            $mod_crew = new ModuleCrew();
            $mod_crew->ship_module_id = $request->ship_module_id;
            $mod_crew->nick = $request->nick;
            $mod_crew->gender = $request->gender;
            $mod_crew->age = $request->age;
            if (auth()->user()->name != "admin")
                return view('modulecrew.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else {
                $mod_crew->save();
                return redirect('/modulecrew/list');
            }
        }
    }

    public function store_api(Request $request)
    {
        $myAPI_URL = config('app.url')."/api/modulecrew/new";
        $response = Http::post($myAPI_URL,$request);
        return redirect('/modulecrew/list');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $myModuleCrew = ModuleCrew::find($id);
        if ($myModuleCrew==null) {
            $error_message = "Ship module id=".$id." not found";
            return view('modulecrew.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        if ($myModuleCrew->count() > 0) {
            if (auth()->user()->name != "admin")
                return view('modulecrew.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return view('modulecrew.show',['crewmember'=>$myModuleCrew,]);
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
        $MyShipModules = ShipModules::all();
        $myModuleCrew = ModuleCrew::find($id);
        if ($myModuleCrew==null) {
            $error_message = "Crew member id=".$id." not found";
            return view('modulecrew.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        if ($myModuleCrew->count() > 0) {
            if (auth()->user()->name != "admin")
                return view('modulecrew.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return view('modulecrew.edit',['crewmember'=>$myModuleCrew,'ship_modules'=>$MyShipModules,]);
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
            'ship_module_id' => 'required',
            'nick' => 'required|min:3|max:10',
            'gender' => 'required',
            'age' => 'required|integer|between:18,85',
        ]);

        if ($validated) {
            $mod_crew = ModuleCrew::find($id);
            if ($mod_crew!=null) {
                $mod_crew->ship_module_id = $request->ship_module_id;
                $mod_crew->nick = $request->nick;
                $mod_crew->gender = $request->gender;
                $mod_crew->age = $request->age;
                if (auth()->user()->name != "admin")
                    return view('modulecrew.message',['message'=>'Access denied','type_of_message'=>'Error']);
                else {
                    $mod_crew->save();
                    return redirect('/modulecrew/list');
                }
            }
            else {
                $error_message = "Crew member id=".$id." not found";
                return view('modulecrew.message',['message'=>$error_message,'type_of_message'=>'Error']);
            }
        }
    }

    public function update_api(Request $request, $id)
    {
        $myAPI_URL = config('app.url')."/api/modulecrew/update/".$id;
        $response = Http::patch($myAPI_URL,$request);
        return redirect('/modulecrew/list');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $mod_crew = ModuleCrew::find($id);
        if ($mod_crew!=null) {
            if (auth()->user()->name != "admin")
                return view('modulecrew.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else {
                $mod_crew->delete();
                return redirect('/modulecrew/list');
            }
        }
        else {
            $error_message = "Crew member id=".$id." not found";
            return view('modulecrew.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
    }

    public function destroy_api(Request $request, $id)
    {
        $myAPI_URL = config('app.url')."/api/modulecrew/delete/".$id;
        $response = Http::delete($myAPI_URL);
        return redirect('/modulecrew/list');
    }
   
}
