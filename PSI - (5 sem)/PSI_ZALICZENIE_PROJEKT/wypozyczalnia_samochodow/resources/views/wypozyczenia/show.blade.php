<!DOCTYPE html>
<html>
@include('partials.head')
<body class="bg-gray-100">
    @include('partials.navi')
    <div class="flex flex-col items-center p-2">
        <h2 class="p-4 text-3xl">Podgląd rezerwacji do usunięcia o id: {{$wypozyczenia->id_wypozyczenia}}</h2>
        <form class="form-inline rounded-md bg-gray-500" action="<?=config('app.url'); ?>/wypozyczenia/delete/{{$wypozyczenia->id_wypozyczenia}}" method="post">
            @csrf
            <p class="p-4">
                <label for="id_wypozyczenia">Id Rezerwacje:</label>
                <input id="id_wypozyczenia" name="id_wypozyczenia" value="{{$wypozyczenia->id_wypozyczenia}}" readonly>
            </p>
            <p class="p-4">
                <label for="imie">Imię:</label>
                <input id="imie" name="imie" value="{{$wypozyczenia->imie}}" readonly required>
            </p>
            <p class="p-4">
                <label for="nazwisko">Nazwisko:</label>
                <input id="nazwisko" name="nazwisko" value="{{$wypozyczenia->nazwisko}}" readonly required>
            </p>
            <p class="p-4">
                <label for="email">Email:</label>
                <input id="email" name="email" value="{{$wypozyczenia->email}}" readonly required>
            </p>
            <p class="p-4">
                <label for="telefon">Nr telefonu:</label>
                <input id="telefon" name="telefon" type="number" value="{{$wypozyczenia->telefon}}" readonly required>
            </p>
            <p class="p-4"><button type="submit" class="text-white p-2 rounded-md bg-gray-800 hover:text-gray-800 hover:bg-red-500">Usuń</button></p>
        </form>
    </div>
    @include('partials.footer')
</body>
</html>