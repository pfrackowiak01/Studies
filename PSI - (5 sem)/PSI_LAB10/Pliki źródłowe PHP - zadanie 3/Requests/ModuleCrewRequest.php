<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Contracts\Validation\Validator;
use Illuminate\Http\Exceptions\HttpResponseException;

class ModuleCrewRequest extends FormRequest
{
    //public function authorize()
    //{
        //return false;
    //}

    public function rules()
    {
        return [
            'ship_module_id' => 'required|integer',
            'nick' => 'required|String|min:3|max:10|unique:module_crew',
            'gender' => 'required|String|regex:/^[MFN]$/',
            'age' => 'required|integer|between:18,85',
        ];
    }

    // validation error handling
    public function failedValidation(Validator $validator) {
        throw new HttpResponseException(response()->json([
            'success' => false,
            'message' => 'Validation errors',
            'data' => $validator->errors()
        ]));
    }

    // customizing messages
    public function messages() {
        return [
            'ship_module_id.required' => 'Field ship_module_id is required',
            'nick.required' => 'Field nick is required',
            'gender.required' => 'Field gender is required',
            'age.required' => 'Field age is required'
        ];
    }
}
