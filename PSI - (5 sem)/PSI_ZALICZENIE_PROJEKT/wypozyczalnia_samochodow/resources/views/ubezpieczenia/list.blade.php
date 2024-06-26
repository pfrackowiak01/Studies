<!DOCTYPE html>
<html>
@include('partials.head')
<body class="bg-gray-100">
    @include('partials.navi')
    <div class="flex flex-col items-center p-2">
    <h2 class="p-4 text-3xl"><b>Dodaj nowe ubezpieczenie:</b></h2>
    <a href="<?=config('app.url'); ?>/ubezpieczenia/add" class="text-white p-2 rounded-md bg-red-600 hover:text-gray-400 hover:bg-gray-500">Nowe ubezpieczenie</a>
    <h2 class="p-4 text-3xl"><b>Lista ubezpieczeń:</b></h2>
        <table>
        <thead>
        <tr> <th>Id ubezpieczenia</th> <th>Nazwa ubezpieczenia</th> <th>Data wygaśnięcia umowy</th> <th>Edytuj</th> <th>Usuń</th> </tr>
        </thead>
        <tbody>
        @foreach($ubezpieczenia as $el)
        <tr>
            <td>{{$el->id_ubezpieczenia}}</td>
            <td>{{$el->nazwa}}</td>
            <td>{{$el->data_wygasniecia}}</td>
            <td><a href="<?=config('app.url'); ?>/ubezpieczenia/edit/{{$el->id_ubezpieczenia}}" class="text-red-600 p-2 rounded-md hover:text-gray-800 hover:bg-red-500">Edytuj</a></td>
            <td><a href="<?=config('app.url'); ?>/ubezpieczenia/show/{{$el->id_ubezpieczenia}}" class="text-red-600 p-2 rounded-md hover:text-gray-800 hover:bg-red-500">Usuń</a></td>
        </tr>
        @endforeach
        </tbody>
        </table>
    </div>
    @include('partials.footer')
</body>
</html>