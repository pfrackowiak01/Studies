<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\RestApiController;
use App\Http\Controllers\RestApiKlienciController;
use App\Http\Controllers\RestApiRezerwacjeController;
use App\Http\Controllers\RestApiSamochodyController;
use App\Http\Controllers\RestApiUbezpieczeniaController;
use App\Http\Controllers\RestApiWypozyczeniaController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

// ENDP1
Route::get('/welcome', [RestApiController::class,'showWelcome']);

// ENDP2
Route::get('/full-name/first-name/{first_name}/last-name/{last_name}',
[RestApiController::class,'showFullNameFromPath']);

// ENDP3
Route::get('/full-name',
[RestApiController::class,'showFullNameFromQueryParams']);

// ENDP4
Route::post('/full-name',
[RestApiController::class,'showFullNameFromAttributesData']);

// Wyświetlanie listy
Route::get('/klienci/list', [RestApiKlienciController::class,'ListKlienci']);
Route::get('/rezerwacje/list', [RestApiRezerwacjeController::class,'ListRezerwacje']);
Route::get('/Samochody/list', [RestApiSamochodyController::class,'ListSamochody']);
Route::get('/ubezpieczenia/list', [RestApiUbezpieczeniaController::class,'ListUbezpieczenia']);
Route::get('/wypozyczenia/list', [RestApiWypozyczeniaController::class,'ListWypozyczenia']);

// Dodanie nowego
Route::post('/klienci/new', [RestApiKlienciController::class,'NewKlienci']);
Route::post('/rezerwacje/new', [RestApiRezerwacjeController::class,'NewRezerwacje']);
Route::post('/samochody/new', [RestApiSamochodyController::class,'NewSamochody']);
Route::post('/ubezpieczenia/new', [RestApiUbezpieczeniaController::class,'NewUbezpieczenia']);
Route::post('/wypozyczenia/new', [RestApiWypozyczeniaController::class,'NewWypozyczenia']);

// Aktualizacja dla wskazanego id     (zamiast patch może być też put)
Route::patch('/klienci/update/{id} ', [RestApiKlienciController::class,'UpdateKlienci']);
Route::patch('/rezerwacje/update/{id} ', [RestApiRezerwacjeController::class,'UpdateRezerwacje']);
Route::patch('/samochody/update/{id} ', [RestApiSamochodyController::class,'UpdateSamochody']);
Route::patch('/ubezpieczenia/update/{id} ', [RestApiUbezpieczeniaController::class,'UpdateUbezpieczenia']);
Route::patch('/wypozyczenia/update/{id} ', [RestApiWypozyczeniaController::class,'UpdateWypozyczenia']);

// Usunięcie dla wskazanego id
Route::delete('/klienci/delete/{id}', [RestApiKlienciController::class,'DeleteKlienci']);
Route::delete('/rezerwacje/delete/{id}', [RestApiRezerwacjeController::class,'DeleteRezerwacje']);
Route::delete('/samochody/delete/{id}', [RestApiSamochodyController::class,'DeleteSamochody']);
Route::delete('/ubezpieczenia/delete/{id}', [RestApiUbezpieczeniaController::class,'DeleteUbezpieczenia']);
Route::delete('/wypozyczenia/delete/{id}', [RestApiWypozyczeniaController::class,'DeleteWypozyczenia']);

// Znalezienie dla wskazanego id
Route::get('/klienci/find/{id}', [RestApiKlienciController::class,'FindKlienci']);
Route::get('/rezerwacje/find/{id}', [RestApiRezerwacjeController::class,'FindRezerwacje']);
Route::get('/samochody/find/{id}', [RestApiSamochodyController::class,'FindSamochody']);
Route::get('/ubezpieczenia/find/{id}', [RestApiUbezpieczeniaController::class,'FindUbezpieczenia']);
Route::get('/wypozyczenia/find/{id}', [RestApiWypozyczeniaController::class,'FindWypozyczenia']);