<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Contracts\Validation\Validator;
use Illuminate\Http\Exceptions\HttpResponseException;

class SamochodyRequest extends FormRequest
{
    //public function authorize()
    //{
        //return false;
    //}

    public function rules()
    {
        return [
            'nazwa' => 'required|integer',
            'skrzynia_bieg' => 'required|integer',
            'klasa' => 'required|String',
            'miejsca' => 'required|integer',
            'bagaz' => 'required|integer',
            'stawka_dzienna' => 'required|integer',
            'kaucja' => 'required|integer',
            'id_ubezpieczenia' => 'required|integer',
            'silnik' => 'required|String',
            'spalanie' => 'required|double',
            'obrazek' => 'required|String',
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
            'nazwa.required' => 'Pole z nazwą jest wymagane',
            'skrzynia_bieg.required' => 'Pole z skrzynią biegów jest wymagane',
            'klasa.required' => 'Pole z klasą jest wymagane',
            'miejsca.required' => 'Pole z ilością miejsc jest wymagane',
            'bagaz.required' => 'Pole z pojemnością bagażnika jest wymagane',
            'stawka_dzienna.required' => 'Pole ze stawką dzienną jest wymagane',
            'kaucja.required' => 'Pole z kaucją jest wymagane',
            'id_ubezpieczenia.required' => 'Pole z id ubezpieczenia jest wymagane',
            'silnik.required' => 'Pole z rodzajem silnika jest wymagane',
            'spalanie.required' => 'Pole ze spalaniem jest wymagane'
        ];
    }
}