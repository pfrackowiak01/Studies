<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ProfileController;
use App\Http\Controllers\HomeController;
use App\Http\Controllers\KlienciController;
use App\Http\Controllers\RezerwacjeController;
use App\Http\Controllers\SamochodyController;
use App\Http\Controllers\UbezpieczeniaController;
use App\Http\Controllers\WypozyczeniaController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('home');
});

Route::get('/oferty', function () {return view('oferty');});
Route::get('/kontakt', function () {return view('kontakt');});
Route::get('/firma', function () {return view('firma');});
Route::get('/pytania', function () {return view('pytania');});
Route::get('/regulamin', function () {return view('regulamin');});
Route::get('/wynajem', [SamochodyController::class,'index_wynajem']);
Route::get('/wynajem/{id}', [SamochodyController::class,'index_wynajmowanie']);

Route::get('/dashboard', function () {
    return view('home');
})->middleware(['auth', 'verified'])->name('home');

Route::middleware('auth')->group(function () {
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');
});

// Klienci
Route::get('/klienci/list', [KlienciController::class,'index_api']) -> middleware('auth');            // Index API
Route::get('/klienci/add', [KlienciController::class,'create']) -> middleware('auth');
Route::get('/klienci/save', [KlienciController::class,'store']) -> middleware('auth');
Route::post('/klienci/save', [KlienciController::class,'store_api']) -> middleware('auth');            // Store API (post)
Route::get('/klienci/edit/{id}', [KlienciController::class,'edit']) -> middleware('auth');
Route::post('/klienci/update/{id}', [KlienciController::class,'update_api']) -> middleware('auth');    // Update API
Route::get('/klienci/show/{id}', [KlienciController::class,'show']) -> middleware('auth');
Route::post('/klienci/delete/{id}', [KlienciController::class,'destroy_api']) -> middleware('auth');   // Delete API

// Rezerwacje
Route::get('/rezerwacje/list', [RezerwacjeController::class,'index_api']) -> middleware('auth');
Route::get('/rezerwacje/add', [RezerwacjeController::class,'create']) -> middleware('auth');
Route::get('/rezerwacje/save', [RezerwacjeController::class,'store']) -> middleware('auth');
Route::post('/rezerwacje/save', [RezerwacjeController::class,'store_api']) -> middleware('auth');
Route::get('/rezerwacje/edit/{id}', [RezerwacjeController::class,'edit']) -> middleware('auth');
Route::post('/rezerwacje/update/{id}', [RezerwacjeController::class,'update_api']) -> middleware('auth');
Route::get('/rezerwacje/show/{id}', [RezerwacjeController::class,'show']) -> middleware('auth');
Route::post('/rezerwacje/delete/{id}', [RezerwacjeController::class,'destroy_api']) -> middleware('auth');

// Samochody
Route::get('/samochody/list', [SamochodyController::class,'index_api']) -> middleware('auth');
Route::get('/samochody/add', [SamochodyController::class,'create']) -> middleware('auth');
Route::get('/samochody/save', [SamochodyController::class,'store']) -> middleware('auth');
Route::post('/samochody/save', [SamochodyController::class,'store_api']) -> middleware('auth');
Route::get('/samochody/edit/{id}', [SamochodyController::class,'edit']) -> middleware('auth');
Route::post('/samochody/update/{id}', [SamochodyController::class,'update_api']) -> middleware('auth');
Route::get('/samochody/show/{id}', [SamochodyController::class,'show']) -> middleware('auth');
Route::post('/samochody/delete/{id}', [SamochodyController::class,'destroy_api']) -> middleware('auth');

// Ubezpieczenia
Route::get('/ubezpieczenia/list', [UbezpieczeniaController::class,'index_api']) -> middleware('auth');
Route::get('/ubezpieczenia/add', [UbezpieczeniaController::class,'create']) -> middleware('auth');
Route::get('/ubezpieczenia/save', [UbezpieczeniaController::class,'store']) -> middleware('auth');
Route::post('/ubezpieczenia/save', [UbezpieczeniaController::class,'store_api']) -> middleware('auth');
Route::get('/ubezpieczenia/edit/{id}', [UbezpieczeniaController::class,'edit']) -> middleware('auth');
Route::post('/ubezpieczenia/update/{id}', [UbezpieczeniaController::class,'update_api']) -> middleware('auth');
Route::get('/ubezpieczenia/show/{id}', [UbezpieczeniaController::class,'show']) -> middleware('auth');
Route::post('/ubezpieczenia/delete/{id}', [UbezpieczeniaController::class,'destroy_api']) -> middleware('auth');

// Wypozyczenia
Route::get('/wypozyczenia/list', [WypozyczeniaController::class,'index_api']) -> middleware('auth');
Route::get('/wypozyczenia/add', [WypozyczeniaController::class,'create']) -> middleware('auth');
Route::get('/wypozyczenia/save', [WypozyczeniaController::class,'store']) -> middleware('auth');
Route::post('/wypozyczenia/save', [WypozyczeniaController::class,'store_api']) -> middleware('auth');
Route::get('/wypozyczenia/edit/{id}', [WypozyczeniaController::class,'edit']) -> middleware('auth');
Route::post('/wypozyczenia/update/{id}', [WypozyczeniaController::class,'update_api']) -> middleware('auth');
Route::get('/wypozyczenia/show/{id}', [WypozyczeniaController::class,'show']) -> middleware('auth');
Route::post('/wypozyczenia/delete/{id}', [WypozyczeniaController::class,'destroy_api']) -> middleware('auth');

// Service list
//Route::get('/klienci/servicelist/{id}', [KlienciController::class,'servlist']);

// Autoryzacja
Route::get('/loguj', [HomeController::class,'zmienStanUwierzytelnienia']);
Route::get('/wyloguj', [HomeController::class,'zmienStanUwierzytelnienia']);

Route::get('/zalogowano', function () {
    return view('zalogowano');
});

require __DIR__.'/auth.php';
