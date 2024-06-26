<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

use App\Models\CrewSkills;
use App\Models\ModuleCrew;

class CrewSkillsController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $MyCrewSkills = CrewSkills::all();
        return view('crewskills.list',['crew_skills'=>$MyCrewSkills,]);
    }

    public function index_api()
    {
        $myAPI_URL = config('app.url')."/api/crewskills/list";
        $res=Http::get($myAPI_URL);
        $MyCrewSkills = json_decode(json_encode($res->json()['data']), FALSE);
        return view('crewskills.list',['crew_skills'=>$MyCrewSkills,]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $MyCrewMembers = ModuleCrew::all();
        if (auth()->user()->name != "admin")
            return view('crewskills.message',['message'=>'Access denied','type_of_message'=>'Error']);
        else
            return view('crewskills.add',['crew_members'=>$MyCrewMembers,]);
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
            'module_crew_id' => 'required',
            'name' => 'required|min:3|max:15|unique:crew_skills',
        ]);

        if($validated) {
            $skill = new CrewSkills();
            $skill->module_crew_id = $request->module_crew_id;
            $skill->name = $request->name;
            if (auth()->user()->name != "admin")
                return view('crewskills.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else {
                $skill->save();
                return redirect('/crewskills/list');
            }
        }
    }

    public function store_api(Request $request)
    {
        $myAPI_URL = config('app.url')."/api/crewskills/new";
        $response = Http::post($myAPI_URL,$request);
        return redirect('/crewskills/list');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $myCrewSkill = CrewSkills::find($id);
        if ($myCrewSkill==null) {
            $error_message = "Ship module id=".$id." not found";
            return view('crewskills.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        if ($myCrewSkill->count() > 0) {
            if(auth()->user()->name != "admin")
                return view('crewskills.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return view('crewskills.show',['crewskill'=>$myCrewSkill,]);
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
        $MyCrewMembers = ModuleCrew::all();
        $myCrewSkill = CrewSkills::find($id);
        if ($myCrewSkill==null) {
            $error_message = "Crew skill id=".$id." not found";
            return view('crewskills.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
        if ($myCrewSkill->count() > 0) {
            if (auth()->user()->name != "admin")
                return view('crewskills.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return view('crewskills.edit',['crewskill'=>$myCrewSkill,'crew_members'=>$MyCrewMembers,]);
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
            'module_crew_id' => 'required',
            'name' => 'required|min:3|max:15',
        ]);

        if ($validated) {
            $skill = CrewSkills::find($id);
            if ($skill!=null) {
                $skill->module_crew_id = $request->module_crew_id;
                $skill->name = $request->name;
                if (auth()->user()->name != "admin")
                    return view('crewskills.message',['message'=>'Access denied','type_of_message'=>'Error']);
                else {
                    $skill->save();
                    return redirect('/crewskills/list');
                }
            }
            else {
                $error_message = "Crew skill id=".$id." not found";
                return view('crewskills.message',['message'=>$error_message,'type_of_message'=>'Error']);
            }
        }
    }

    public function update_api(Request $request, $id)
    {
        $myAPI_URL = config('app.url')."/api/crewskills/update/".$id;
        $response = Http::patch($myAPI_URL,$request);
        return redirect('/crewskills/list');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $myCrewSkill = CrewSkills::find($id);
        if ($myCrewSkill!=null) {
            $myCrewSkill->delete();
            if (auth()->user()->name != "admin")
                return view('crewskills.message',['message'=>'Access denied','type_of_message'=>'Error']);
            else
                return redirect('/crewskills/list');
        }
        else {
            $error_message = "Crew skill id=".$id." not found";
            return view('crewskills.message',['message'=>$error_message,'type_of_message'=>'Error']);
        }
    }

    public function destroy_api(Request $request, $id)
    {
        $myAPI_URL = config('app.url')."/api/crewskills/delete/".$id;
        $response = Http::delete($myAPI_URL);
        return redirect('/crewskills/list');
    }

}
