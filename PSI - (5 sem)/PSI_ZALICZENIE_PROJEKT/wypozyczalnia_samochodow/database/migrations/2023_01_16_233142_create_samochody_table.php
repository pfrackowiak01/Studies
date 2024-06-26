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
        Schema::create('samochody', function (Blueprint $table) {
            $table->id('id_samochodu');
            $table->string('nazwa');
            $table->string('skrzynia_bieg');
            $table->string('klasa');
            $table->integer('miejsca');
            $table->integer('bagaz');
            $table->integer('stawka_dzienna');
            $table->integer('kaucja');
            $table->integer('id_ubezpieczenia')->unsigned();
            $table->foreign('id_ubezpieczenia')->references('id_ubezpieczenia')->on('ubezpieczenia');
            $table->string('silnik');
            $table->double('spalanie');
            $table->string('obrazek');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('samochody');
    }
};
