<!DOCTYPE html>
<html>
@include('partials.head')
<body class="bg-gray-100">
    @include('partials.navi')
    <div class="flex flex-col items-center p-2">
        <h2 class="p-4 text-3xl"><b>Edytuj ubezpieczenia:</b></h2>
        <form class="form-inline rounded-md bg-gray-500" action="<?=config('app.url'); ?>/ubezpieczenia/update/{{$ubezpieczenia->id_ubezpieczenia}}" method="post">
            @csrf
            <p class="p-4">
                <label for="id_ubezpieczenia">Nazwa ubezpieczalni:</label>
                <input id="id_ubezpieczenia" name="id_ubezpieczenia" type="string" value="{{$ubezpieczenia->id_ubezpieczenia}}" required>
            </p>
            <p class="p-4">
                <label for="nazwa">Nazwa ubezpieczenia:</label>
                <input id="nazwa" name="nazwa" type="string" value="{{$ubezpieczenia->nazwa}}" required>
            </p>
            <p class="p-4">
                <label for="data_wygasniecia">Data wygaśnięcia umowy:</label>
                <input id="data_wygasniecia" name="data_wygasniecia" type="date" value="{{$ubezpieczenia->data_wygasniecia}}" required>
            </p>
            <p class="p-4"><button type="submit" class="text-white p-2 rounded-md bg-gray-800 hover:text-gray-800 hover:bg-red-500">Zaktualizuj</button></p>
        </form>
        @include('partials.error')
    </div>
    @include('partials.footer')
</body>
</html>