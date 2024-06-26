<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Contracts\Validation\Validator;
use Illuminate\Http\Exceptions\HttpResponseException;

class UbezpieczeniaRequest extends FormRequest
{
    //public function authorize()
    //{
        //return false;
    //}

    public function rules()
    {
        return [
            'id_ubezpieczenia' => 'required|integer',
            'nazwa' => 'required|String',
            'data_wygasniecia' => 'required|String',
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
            'id_ubezpieczenia.required' => 'Pole z id ubezpieczenia jest wymagane',
            'nazwa.required' => 'Pole z nazwą jest wymagane',
            'data_wygasniecia.required' => 'Pole z datą wygaśnięcia jest wymagane',
        ];
    }
}