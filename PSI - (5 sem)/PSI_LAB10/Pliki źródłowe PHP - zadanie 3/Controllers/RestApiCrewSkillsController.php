<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\CrewSkills;
use App\Http\Requests\CrewSkillsRequest;

class RestApiCrewSkillsController extends Controller
{
    public function ListCrewSkills()
    {
        // read all Ship Modules
        $myCrewSkills = CrewSkills::all();
        $data = ["data"=> $myCrewSkills];
        // return response in JSON format
        return response()->json($data,200);
    }

    public function NewCrewSkill(CrewSkillsRequest $request)
    {
        $data = $request->validated();

        $mod_ship = new CrewSkills();
        // prepare data from request
        $mod_ship->module_name = $data['module_name'];
        $mod_ship->is_workable = $data['is_workable'];
        // save to database
        $mod_ship->save();
        return response()->json(['data'=>$mod_ship]);
    }

    public function DeleteCrewSkill($id)
    {
        $mod_ship = CrewSkills::find($id);
        if ($mod_ship != null) {
            //delete crewskill
            $mod_ship->delete();
            return response()->json(['data'->$mod_ship]);
        }
        else return response()->json(['data'=>[]]);
    }

    public function UpdateCrewSkill($id, CrewSkillsRequest $request)
    {
        $data = $request->validated();
        $mod_ship = CrewSkills::find($id);
        if ($mod_ship != null) {
            $mod_ship->module_name = $data['module_name'];
            $mod_ship->is_workable = $data['is_workable'];
            // save to database
            $mod_ship->save();
            return response()->json(['data'=>$mod_ship]);
        }
        else return response()->json(['data'=>[]]);
    }

    public function FindCrewSkill($id)
    {
        $mod_ship = CrewSkills::find($id);
        if ($mod_ship != null) return response()->json(['data'=>$mod_ship]);
        else return response()->json(['data'=>[]]);
    }
}
