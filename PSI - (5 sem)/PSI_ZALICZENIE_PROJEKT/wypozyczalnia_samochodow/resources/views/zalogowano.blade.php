<!DOCTYPE html>
<html id="pl">
@include('partials.head')
<body>
 @include('partials.navi')
 <div class="p-2 text-center text-xl"> 
 <br>
 <h1 class="text-3xl font-bold">Jesteś teraz zalogowany jako {{auth()->user()->name}}</h1>
 </div>
        @include('partials.footer')
</body>
</html>