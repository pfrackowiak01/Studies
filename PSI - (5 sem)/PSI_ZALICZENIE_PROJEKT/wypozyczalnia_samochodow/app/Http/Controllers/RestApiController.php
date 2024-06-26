<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Requests\FullNameRequest;

class RestApiController extends Controller
{
    public function showWelcome()
    {
        return response()->json([
            'data'=> [
                "message"=> "Hello!"
            ],
        ]);
    }

    public function showFullNameFromPath($first_name, $last_name)
    {
        return response()->json([
            'data'=> [
                "full_name"=> $first_name . ' ' . $last_name
            ],
        ]);
    }

    public function showFullNameFromAttributesData(FullNameRequest $request)
    {
        return $this->requestFunction($request);
    }

    public function showFullNameFromQueryParams(FullNameRequest $request)
    {
        return $this->requestFunction($request);
    }

    public function requestFunction(FullNameRequest $request)
    {
        $data = $request->validated();
        return response()->json([
            'data'=> [
                "full_name"=> $data['first_name'] . ' ' . $data['last_name']
            ],
        ]);
    }
}
