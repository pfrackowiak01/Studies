<!DOCTYPE html>
<html>
@include('partials.head')
<body class="bg-gray-100">
    @include('partials.navi')
    <div class="flex flex-col items-center p-2">
    <h2 class="p-4 text-3xl"><b>Dodaj nową wypozyczenia:</b></h2>
    <a href="<?=config('app.url'); ?>/wypozyczenia/add" class="text-white p-2 rounded-md bg-red-600 hover:text-gray-400 hover:bg-gray-500">Nowa rezerwacja</a>
    <h2 class="p-4 text-3xl"><b>Lista wypozyczeń:</b></h2>
        <table>
        <thead>
        <tr> <th>Id wypozyczenia</th> <th>Id rezerwacji</th> <th>Stan przy zwrocie</th> <th>Opis</th> <th>Koszt uszkodzeń</th> <th>Czy wszystko jest opłacone</th> <th>Edytuj</th> <th>Usuń</th> </tr>
        </thead>
        <tbody>
        @foreach($wypozyczenia as $el)
        <tr>
            <td>{{$el->id_wypozyczenia}}</td>
            <td>{{$el->id_rezerwacji}}</td>
            <td>{{$el->stan_zwrotu}}</td>
            <td>{{$el->opis}}</td>
            <td>{{$el->koszt_uszkodzen}}</td>
            <td>{{$el->czy_wszystko_oplacone}}</td>
            <td><a href="<?=config('app.url'); ?>/wypozyczenia/edit/{{$el->id_wypozyczenia}}" class="text-red-600 p-2 rounded-md hover:text-gray-800 hover:bg-red-500">Edytuj</a></td>
            <td><a href="<?=config('app.url'); ?>/wypozyczenia/show/{{$el->id_wypozyczenia}}" class="text-red-600 p-2 rounded-md hover:text-gray-800 hover:bg-red-500">Usuń</a></td>
        </tr>
        @endforeach
        </tbody>
        </table>
    </div>
    @include('partials.footer')
</body>
</html>