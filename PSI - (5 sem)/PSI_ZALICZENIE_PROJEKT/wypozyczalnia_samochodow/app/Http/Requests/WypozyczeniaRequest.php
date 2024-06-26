<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Contracts\Validation\Validator;
use Illuminate\Http\Exceptions\HttpResponseException;

class WypozyczeniaRequest extends FormRequest
{
    //public function authorize()
    //{
        //return false;
    //}

    public function rules()
    {
        return [
            'id_rezerwacji' => 'required|integer',
            'stan_zwrotu' => 'required|String',
            'opis' => 'required|String',
            'koszt_uszkodzen' => 'required|integer',
            'czy_wszystko_oplacone' => 'required|String',
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
            'id_rezerwacji.required' => 'Pole z id rezerwacji jest wymagane',
            'stan_zwrotu.required' => 'Pole ze stanem zwrotu jest wymagane',
            'opis.required' => 'Pole z opisem jest wymagane',
            'koszt_uszkodzen.required' => 'Pole z kosztem uszkodzeń jest wymagane',
            'czy_wszystko_oplacone.required' => 'Pole z telefonem jest wymagane'
        ];
    }
}