<!DOCTYPE html>
<html>
@include('partials.head')
<body class="bg-gray-100">
    @include('partials.navi')
    <div class="flex flex-col items-center p-2">
        <h2 class="p-4 text-3xl"><b>Edytuj wypozyczenia:</b></h2>
        <form class="form-inline rounded-md bg-gray-500" action="<?=config('app.url'); ?>/wypozyczenia/update/{{$wypozyczenia->id_wypozyczenia}}" method="post">
        @csrf
        <p class="p-4">
                <label for="id_wypozyczenia">Id wypozyczenia:</label>
                <input id="id_wypozyczenia" name="id_wypozyczenia" type="number" value="{{$wypozyczenia->id_wypozyczenia}}" required>
            </p>
            <p class="p-4">
                <label for="id_rezerwacji">Id rezerwacji:</label>
                <input id="id_rezerwacji" name="id_rezerwacji" type="number" value="{{$wypozyczenia->id_rezerwacji}}" required>
            </p>
            <p class="p-4">
                <label for="stan_zwrotu">Stan przy zwrocie:</label>
                <input type="radio" name="stan_zwrotu" id="stan_zwrotu" value="uszkodzony" @if ($wypozyczenia->stan_zwrotu=="uszkodzony") checked @endif required>
                <label for="stan_zwrotu">Uszkodzony</label>
                <input type="radio" name="stan_zwrotu" id="stan_zwrotu" value="nieuszkodzony" @if ($wypozyczenia->stan_zwrotu=="nieuszkodzony") checked @endif required>
                <label for="stan_zwrotu">Nieuszkodzony</label>
            </p>
            </p>
            <p class="p-4">
                <label for="opis">Opis:</label>
                <textarea id="opis" name="opis" rows="4" cols="40" type="string" value="{{$wypozyczenia->opis}}">{{$wypozyczenia->opis}}</textarea>
            </p>
            <p class="p-4">
                <label for="koszt_uszkodzen">Koszt uszkodzeń:</label>
                <input id="koszt_uszkodzen" name="koszt_uszkodzen" type="number" value="{{$wypozyczenia->koszt_uszkodzen}}" required>
            </p>
            <p class="p-4">
                <label for="czy_wszystko_oplacone">Czy wszystko jest opłacone:</label>
                <input id="czy_wszystko_oplacone" name="czy_wszystko_oplacone" type="string" value="{{$wypozyczenia->czy_wszystko_oplacone}}" required>
            </p>
            <p class="p-4"><button type="submit" class="text-white p-2 rounded-md bg-gray-800 hover:text-gray-800 hover:bg-red-500">Zapisz</button></p>
        </form>
        @include('partials.error')
    </div>
    @include('partials.footer')
</body>
</html>