<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('rezerwacje', function (Blueprint $table) {
            $table->id('id_rezerwacji');
            $table->integer('id_klienta')->unsigned();
            $table->foreign('id_klienta')->references('id_klienta')->on('klienci');
            $table->integer('id_samochodu')->unsigned();
            $table->foreign('id_samochodu')->references('id_samochodu')->on('samochody');
            $table->date('data_pocz');
            $table->date('data_kon');
            $table->string('ochrona');
            $table->string('pakiet');
            
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('rezerwacje');
    }
};
