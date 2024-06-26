<!DOCTYPE html>
<html>
@include('partials.head')
<body class="bg-gray-100">
    @include('partials.navi')
    <div class="flex flex-col items-center p-2">
    <h2 class="p-4 text-3xl"><b>Dodaj nowy samochód:</b></h2>
    <a href="<?=config('app.url'); ?>/samochody/add" class="text-white p-2 rounded-md bg-red-600 hover:text-gray-400 hover:bg-red-500">Nowa rezerwacja</a>
    <h2 class="p-4 text-3xl"><b>Lista rezerwacji:</b></h2>
        <table>
        <thead>
        <tr> <th>Id samochodu</th> <th>Nazwa</th> <th>Skrzynia biegów</th> <th>Klasa</th> <th>Ilość siedzeń</th> <th>Pojemność bagażnika</th> <th>Stawka dzienna</th> <th>Kaucja</th> <th>Id ubezpieczenia</th> <th>Silnik</th> <th>Spalanie</th> <th>Zdjęcie</th> <th>Edytuj</th> <th>Usuń</th> </tr>
        </thead>
        <tbody>
        @foreach($samochody as $el)
        <tr>
            <td>{{$el->id_samochodu}}</td>
            <td>{{$el->nazwa}}</td>
            <td>{{$el->skrzynia_bieg}}</td>
            <td>{{$el->klasa}}</td>
            <td>{{$el->miejsca}}</td>
            <td>{{$el->bagaz}}</td>
            <td>{{$el->stawka_dzienna}}</td>
            <td>{{$el->kaucja}}</td>
            <td>{{$el->id_ubezpieczenia}}</td>
            <td>{{$el->silnik}}</td>
            <td>{{$el->spalanie}}</td>
            <td>{{$el->obrazek}}</td>
            <td><a href="<?=config('app.url'); ?>/samochody/edit/{{$el->id_samochodu}}" class="text-red-600 p-2 rounded-md hover:text-gray-800 hover:bg-red-500">Edytuj</a></td>
            <td><a href="<?=config('app.url'); ?>/samochody/show/{{$el->id_samochodu}}" class="text-red-600 p-2 rounded-md hover:text-gray-800 hover:bg-red-500">Usuń</a></td>
        </tr>
        @endforeach
        </tbody>
        </table>
    </div>
    @include('partials.footer')
</body>
</html>