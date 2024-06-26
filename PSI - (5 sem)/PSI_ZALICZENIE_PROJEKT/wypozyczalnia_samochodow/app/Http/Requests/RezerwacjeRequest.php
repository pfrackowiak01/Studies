<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Contracts\Validation\Validator;
use Illuminate\Http\Exceptions\HttpResponseException;

class RezerwacjeRequest extends FormRequest
{
    //public function authorize()
    //{
        //return false;
    //}

    public function rules()
    {
        return [
            'id_klienta' => 'required|integer',
            'id_samochodu' => 'required|integer',
            'data_pocz' => 'required|Data',
            'data_kon' => 'required|Data',
            'ochrona' => 'required|String',
            'pakiet' => 'required|String',
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
            'id_klienta.required' => 'Klient jest wymagany',
            'id_samochodu.required' => 'Samochód jest wymagany',
            'data_pocz.required' => 'Data musi być prawidłowa oraz jest wymagana',
            'data_kon.required' => 'Data musi być prawidłowa oraz jest wymagana',
            'ochrona.required' => 'Uzupełnij rodzaj ochrony',
            'pakiet.required' => 'Uzupełnij rodzaj pakietu',
        ];
    }
}