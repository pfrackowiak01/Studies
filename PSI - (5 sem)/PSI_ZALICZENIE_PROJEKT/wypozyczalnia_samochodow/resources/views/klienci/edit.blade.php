<!DOCTYPE html>
<html>
@include('partials.head')
<body class="bg-gray-100">
    @include('partials.navi')
    <div class="flex flex-col items-center p-2">
    <h2 class="p-4 text-3xl"><b>Edytuj klienta o id: {{$klienci->id_klienta}}</b></h2>
        <form class="form-inline rounded-md bg-gray-500" action="<?=config('app.url'); ?>/klienci/update/{{$klienci->id_klienta}}" method="post">
            @csrf
            <p class="p-4">
                <label for="id_klienta">Id klienta:</label>
                <input id="id_klienta" name="id_klienta" value="{{$klienci->id_klienta}}" readonly>
            </p>
            <p class="p-4">
                <label for="imie">Imię:</label>
                <input id="imie" name="imie" size="15" value="{{$klienci->imie}}" required>
            </p>
            <p class="p-4">
                <label for="nazwisko">Nazwisko:</label>
                <input id="nazwisko" name="nazwisko" size="30" value="{{$klienci->nazwisko}}" required>
            </p>
            <p class="p-4">
                <label for="email">Email:</label>
                <input id="email" name="email" size="40" value="{{$klienci->email}}" required>
            </p>
            <p class="p-4">
                <label for="telefon">Nr telefonu:</label>
                <input id="telefon" name="telefon" type="number" size="9" value="{{$klienci->telefon}}" required>
            </p>
            <p class="p-4"><button type="submit" class="text-white p-2 rounded-md bg-gray-800 hover:text-gray-800 hover:bg-red-500">Zaktualizuj</button></p>
        </form>
        @include('partials.error')
    </div>
    @include('partials.footer')
</body>
</html>