<!DOCTYPE html>
<html>
@include('partials.head')
<body class="bg-gray-100">
    @include('partials.navi')
    <div class="flex flex-col items-center p-2">
        <h2 class="p-4 text-3xl"><b>Dodaj nową samochód:</b></h2>
        <form class="form-inline rounded-md bg-gray-500" action="<?=config('app.url'); ?>/samochody/save" method="post">
            @csrf
            <p class="p-4">
                <label for="id_samochodu">Nazwa:</label>
                <input id="id_samochodu" name="id_samochodu" type="string" required>
            </p>
            <p class="p-4">
                <label for="ochrona">Skrzynia biegów:</label>
                <input type="radio" name="ochrona" id="ochrona" value="manualna" checked required>
                <label for="ochrona">manualna</label>
                <input type="radio" name="ochrona" id="ochrona" value="automatyczna" required>
                <label for="ochrona">automatyczna</label>
            </p>
            <p class="p-4">
                <label for="data_pocz">Klasa:</label>
                <input id="data_pocz" name="data_pocz" type="string" required>
            </p>
            <p class="p-4">
                <label for="data_kon">Ilość siedzeń:</label>
                <input id="data_kon" name="data_kon" type="number" required>
            </p>
            <p class="p-4">
                <label for="data_kon">Pojemność bagażnika [l]:</label>
                <input id="data_kon" name="data_kon" type="number" required>
            </p>
            <p class="p-4">
                <label for="data_kon">Stawka dzienna [zł]:</label>
                <input id="data_kon" name="data_kon" type="number" required>
            </p>
            <p class="p-4">
                <label for="data_kon">Kaucja [zł]:</label>
                <input id="data_kon" name="data_kon" type="number" required>
            </p>
            <p class="p-4">
                <label for="data_kon">Id ubezpieczenia:</label>
                <input id="data_kon" name="data_kon" type="number" required>
            </p>
            <p class="p-4">
            <label for="silnik">Rodzaj paliwa:</label>
                <input type="radio" name="silnik" id="silnik" value="benzyna" checked required>
                <label for="silnik">benzyna</label>
                <input type="radio" name="silnik" id="silnik" value="desiel" required>
                <label for="silnik">desiel</label>
                <input type="radio" name="silnik" id="silnik" value="elektryczny" required>
                <label for="silnik">elektryczny</label>
                <input type="radio" name="silnik" id="silnik" value="hybryda" required>
                <label for="silnik">hybryda</label>
            </p>
            <p class="p-4">
                <label for="data_kon">Spalanie [l/100km]:</label>
                <input id="data_kon" name="data_kon" type="number" step="0.01" required>
            </p>
            <p class="p-4">
                <label for="data_kon">Zdjęcie:</label>
                <input id="data_kon" name="data_kon" type="string" required>
            </p>
            <p class="p-4"><button type="submit" class="text-white p-2 rounded-md bg-gray-800 hover:text-gray-800 hover:bg-red-500">Zapisz</button></p>
        </form>
        @include('partials.error')
    </div>
    @include('partials.footer')
</body>
</html>