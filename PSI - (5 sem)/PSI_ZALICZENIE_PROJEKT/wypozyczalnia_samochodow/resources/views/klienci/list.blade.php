<!DOCTYPE html>
<html>
@include('partials.head')
<body class="bg-gray-100">
    @include('partials.navi')
    <div class="flex flex-col items-center p-2">
    <h2 class="p-4 text-3xl"><b>Dodaj nowego klienta:</b></h2>
    <a href="<?=config('app.url'); ?>/klienci/add" class="text-white p-2 rounded-md bg-red-600 hover:text-gray-400 hover:bg-gray-500">Nowy klient</a>
    <h2 class="p-4 text-3xl"><b>Lista klientów:</b></h2>
        <table>
        <thead>
        <tr> <th>Id</th> <th>Imię</th> <th>Nazwisko</th> <th>Email</th> <th>Nr telefonu</th> <th>Edytuj</th> <th>Usuń</th> </tr>
        </thead>
        <tbody>
        @foreach($klienci as $el)
        <tr>
            <td>{{$el->id_klienta}}</td>
            <td>{{$el->imie}}</td>
            <td>{{$el->nazwisko}}</td>
            <td>{{$el->email}}</td>
            <td>{{$el->telefon}}</td>
            <td><a href="<?=config('app.url'); ?>/klienci/edit/{{$el->id_klienta}}" class="text-red-600 p-2 rounded-md hover:text-gray-800 hover:bg-red-500">Edytuj</a></td>
            <td><a href="<?=config('app.url'); ?>/klienci/show/{{$el->id_klienta}}" class="text-red-600 p-2 rounded-md hover:text-gray-800 hover:bg-red-500">Usuń</a></td>
        </tr>
        @endforeach
        </tbody>
        </table>
    </div>
    @include('partials.footer')
</body>
</html>