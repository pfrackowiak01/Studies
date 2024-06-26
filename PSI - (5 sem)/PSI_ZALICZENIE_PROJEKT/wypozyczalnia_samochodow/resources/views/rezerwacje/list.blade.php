<!DOCTYPE html>
<html>
@include('partials.head')
<body class="bg-gray-100">
    @include('partials.navi')
    <div class="flex flex-col items-center p-2">
    <h2 class="p-4 text-3xl"><b>Dodaj nową rezerwacje:</b></h2>
    <a href="<?=config('app.url'); ?>/rezerwacje/add" class="text-white p-2 rounded-md bg-red-600 hover:text-gray-400 hover:bg-gray-500">Nowa rezerwacja</a>
    <h2 class="p-4 text-3xl"><b>Lista rezerwacji:</b></h2>
        <table>
        <thead>
        <tr> <th>Id rezerwacji</th> <th>Id klienta</th> <th>Id samochodu</th> <th>Data początkowa</th> <th>Data końcowa</th> <th>Ochrona</th> <th>Pakiet</th> <th>Edytuj</th> <th>Usuń</th> </tr>
        </thead>
        <tbody>
        @foreach($rezerwacje as $el)
        <tr>
            <td>{{$el->id_rezerwacji}}</td>
            <td>{{$el->id_klienta}}</td>
            <td>{{$el->id_samochodu}}</td>
            <td>{{$el->data_pocz}}</td>
            <td>{{$el->data_kon}}</td>
            <td>{{$el->ochrona}}</td>
            <td>{{$el->pakiet}}</td>
            <td><a href="<?=config('app.url'); ?>/rezerwacje/edit/{{$el->id_rezerwacji}}" class="text-red-600 p-2 rounded-md hover:text-gray-800 hover:bg-red-500">Edytuj</a></td>
            <td><a href="<?=config('app.url'); ?>/rezerwacje/show/{{$el->id_rezerwacji}}" class="text-red-600 p-2 rounded-md hover:text-gray-800 hover:bg-red-500">Usuń</a></td>
        </tr>
        @endforeach
        </tbody>
        </table>
    </div>
    @include('partials.footer')
</body>
</html>