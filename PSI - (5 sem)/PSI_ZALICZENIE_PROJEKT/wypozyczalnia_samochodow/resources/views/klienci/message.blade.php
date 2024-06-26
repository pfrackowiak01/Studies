<!DOCTYPE html>
<html>
@include('partials.head')
<body class="bg-gray-100">
    @include('partials.navi')
    <div class="flex flex-col items-center p-2">
    <br>
    <h1 class="text-red-600 p-4 text-3xl"><b>Błąd!</b></h1>
        <h2 class="text-red-600 p-4 text-3xl">{{$type_of_message}}: {{$message}}</h2>
    </div>
    @include('partials.footer')
</body>
</html>