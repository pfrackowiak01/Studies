<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\ModuleCrew;
use App\Http\Requests\ModuleCrewRequest;

class RestApiModuleCrewController extends Controller
{
    public function ListModuleCrew()
    {
        // read all Ship Modules
        $myModuleCrew = ModuleCrew::all();
        $data = ["data"=> $myModuleCrew];
        // return response in JSON format
        return response()->json($data,200);
    }

    public function NewModuleCrew(ModuleCrewRequest $request)
    {
        $data = $request->validated();

        $mod_ship = new ModuleCrew();
        // prepare data from request
        $mod_ship->ship_module_id = $data['ship_module_id'];
        $mod_ship->nick = $data['gender'];
        $mod_ship->age = $data['age'];
        // save to database
        $mod_ship->save();
        return response()->json(['data'=>$mod_ship]);
    }

    public function DeleteModuleCrew($id)
    {
        $mod_ship = ModuleCrew::find($id);
        if ($mod_ship != null) {
            //delete modulecrew
            $mod_ship->delete();
            return response()->json(['data'->$mod_ship]);
        }
        else return response()->json(['data'=>[]]);
    }

    public function UpdateModuleCrew($id, ModuleCrewRequest $request)
    {
        $data = $request->validated();
        $mod_ship = ModuleCrew::find($id);
        if ($mod_ship != null) {
            $mod_ship->module_name = $data['module_name'];
            $mod_ship->is_workable = $data['is_workable'];
            // save to database
            $mod_ship->save();
            return response()->json(['data'=>$mod_ship]);
        }
        else return response()->json(['data'=>[]]);
    }

    public function FindModuleCrew($id)
    {
        $mod_ship = ModuleCrew::find($id);
        if ($mod_ship != null) return response()->json(['data'=>$mod_ship]);
        else return response()->json(['data'=>[]]);
    }
}
