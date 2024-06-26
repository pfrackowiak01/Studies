<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\RestApiController;
use App\Http\Controllers\RestApiShipModulesController;
use App\Http\Controllers\RestApiModuleCrewController;
use App\Http\Controllers\RestApiCrewSkillsController;

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

// Lista wszystkich modułów
Route::get('/shipmodules/list', [RestApiShipModulesController::class,'ListShipModules']);
Route::get('/modulecrew/list', [RestApiModuleCrewController::class,'ListModuleCrew']);
Route::get('/crewskills/list', [RestApiCrewSkillsController::class,'ListCrewSkills']);

// Dodanie nowego modułu/rekordu
Route::post('/shipmodules/new', [RestApiShipModulesController::class,'NewShipModule']);
Route::post('/modulecrew/new', [RestApiModuleCrewController::class,'NewModuleCrew']);
Route::post('/crewskills/new', [RestApiCrewSkillsController::class,'NewCrewSkills']);

// Aktualizacja nazwy modułu statku dla wskazanego id    (zamiast patch może być też put)
Route::patch('/shipmodules/update/{id} ', [RestApiShipModulesController::class,'UpdateShipModule']);
Route::patch('/modulecrew/update/{id} ', [RestApiModuleCrewController::class,'UpdateModuleCrew']);
Route::patch('/crewskills/update/{id} ', [RestApiCrewSkillsController::class,'UpdateCrewSkills']);

// Usunięcie wybranego modułu dla wskazanego id
Route::delete('/shipmodules/delete/{id}', [RestApiShipModulesController::class,'DeleteShipModule']);
Route::delete('/modulecrew/delete/{id}', [RestApiModuleCrewController::class,'DeleteModuleCrew']);
Route::delete('/crewskills/delete/{id}', [RestApiCrewSkillsController::class,'DeleteCrewSkills']);

// Znalezienie wybranego modułu dla wskazanego id
Route::get('/shipmodules/find/{id}', [RestApiShipModulesController::class,'FindShipModule']);
Route::get('/modulecrew/find/{id}', [RestApiModuleCrewController::class,'FindModuleCrew']);
Route::get('/crewskills/find/{id}', [RestApiCrewSkillsController::class,'FindCrewSkills']);
