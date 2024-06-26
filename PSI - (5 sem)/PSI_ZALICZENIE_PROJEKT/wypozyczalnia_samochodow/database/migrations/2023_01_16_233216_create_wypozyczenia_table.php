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
        Schema::create('wypozyczenia', function (Blueprint $table) {
            $table->id('id_wypozyczenia');
            $table->integer('id_rezerwacji')->unsigned();
            $table->foreign('id_rezerwacji')->references('id_rezerwacji')->on('rezerwacje');
            $table->string('stan_zwrotu');
            $table->string('opis');
            $table->integer('koszt_uszkodzen');
            $table->string('czy_wszystko_oplacone');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('wypozyczenia');
    }
};
