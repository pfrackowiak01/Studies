<!DOCTYPE html>
<html>
@include('partials.head')
<body class="bg-gray-100">
    @include('partials.navi')
    <div class="flex flex-col items-center p-2">
    <h2 class="p-4 text-3xl"><b>Dodaj nowego klienta:</b></h2>
        <form class="form-inline rounded-md bg-gray-500" action="<?=config('app.url'); ?>/klienci/save" method="post">
            @csrf
            <p class="p-4">
                <label for="imie">Imię:</label>
                <input id="imie" name="imie" type="string" size="15" required>
            </p>
            <p class="p-4">
                <label for="nazwisko">Nazwisko:</label>
                <input id="nazwisko" name="nazwisko" type="string" size="30" required>
            </p>
            <p class="p-4">
                <label for="email">Email:</label>
                <input id="email" name="email" size="40" required>
            </p>
            <p class="p-4">
                <label for="telefon">Nr telefonu:</label>
                <input id="telefon" name="telefon" type="number" size="9" required>
            </p>
            <p class="p-4 items-center"><button type="submit" class="text-white p-2 rounded-md bg-gray-800 hover:text-gray-800 hover:bg-red-500">Zapisz</button></p>
        </form>
        @include('partials.error')
    </div>
    @include('partials.footer')
</body>
</html>