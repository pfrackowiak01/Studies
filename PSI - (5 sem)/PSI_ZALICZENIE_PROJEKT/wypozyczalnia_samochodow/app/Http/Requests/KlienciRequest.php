<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Contracts\Validation\Validator;
use Illuminate\Http\Exceptions\HttpResponseException;

class KlienciRequest extends FormRequest
{
    //public function authorize()
    //{
        //return false;
    //}

    public function rules()
    {
        return [
            'imie' => 'required|String|min:2|max:15',
            'nazwisko' => 'required|String|min:2|max:30',
            'email' => 'required|String|regex:/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$/',
            'telefon' => 'required|integer|regex:/^([0-9]{9})$/',
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
            'imie.required' => 'Pole z imieniem jest wymagane',
            'nazwisko.required' => 'Pole z nazwiskiem jest wymagane',
            'email.required' => 'Pole z emailem jest wymagane',
            'telefon.required' => 'Pole z telefonem jest wymagane',
            'email.regex' => 'Podaj prawidłowy email!'
        ];
    }
}