<nav>
    <div>
        <!--<div>
            <a href="<?=config('app.url'); ?>/"><u><b>Strona domowa</b></u></a>
            <a href="<?=config('app.url'); ?>/klienci/list">Spis klientów</a>
            <a href="<?=config('app.url'); ?>/klienci/add"><i>Nowy klient</i></a>
            <a href="<?=config('app.url'); ?>/samochody/list">Spis samochodów</a>
            <a href="<?=config('app.url'); ?>/samochody/add"><i>Nowy samochód</i></a>
            <a href="<?=config('app.url'); ?>/rezerwacje/list">Spis rezerwacji</a>
            <a href="<?=config('app.url'); ?>/rezerwacje/add"><i>Nowa rezerwacja</i></a>
            <a href="<?=config('app.url'); ?>/wypozyczenia/list">Spis wypozyczeń</a>
            <a href="<?=config('app.url'); ?>/wypozyczenia/add"><i>Nowe wypozyczenie</i></a>
            <a href="<?=config('app.url'); ?>/ubezpieczenia/list">Spis wypozyczen</a>
            <a href="<?=config('app.url'); ?>/ubezpieczenia/add"><i>Nowe wypozyczenie</i></a>
            @if(Auth::check())
            <a href="<?=config('app.url'); ?>/wyloguj"><u>Wyloguj</u></a>
            @else
            <a href="<?=config('app.url'); ?>/login"><u>Zaloguj się</u></a>
            <a href="<?=config('app.url'); ?>/register"><u>Zarejestruj się</u></a>
            @endif
        </div>-->
        <header class="bg-gray-800 flex justify-between p-4" style="flex-wrap:wrap;">
            <div class="flex"><div><a href="<?=config('app.url'); ?>/"><img src="{{ URL('images/logo.png') }}" alt="Logo" width="40" height="40"></div>
            <div class="p-2"><h1 class="text-lg font-medium text-white">BudgetExpress<i class="text-red-600">24</i></h1></div></div>
            <nav class="flex justify-center items-center" style="flex-wrap:wrap;">
                <a href="<?=config('app.url'); ?>/wynajem" class="p-2 rounded-md text-white hover:bg-gray-700 duration-150">Samochody na wynajem</a>
                <a href="<?=config('app.url'); ?>/oferty" class="p-2 rounded-md text-white hover:bg-gray-700 duration-150">Oferty</a>
                <a href="<?=config('app.url'); ?>/firma" class="p-2 rounded-md text-white hover:bg-gray-700 duration-150">O nas</a>
                <a href="<?=config('app.url'); ?>/pytania" class="p-2 rounded-md text-white hover:bg-gray-700 duration-150">FAQ</a>
                <a href="<?=config('app.url'); ?>/regulamin" class="p-2 rounded-md text-white hover:bg-gray-700 duration-150">Regulamin</a>
                <a href="<?=config('app.url'); ?>/kontakt" class="p-2 rounded-md text-white hover:bg-gray-700 duration-150">Kontakt</a>
                @if(Auth::check())
                <a href="<?=config('app.url'); ?>/wyloguj" class="p-2 rounded-md text-white hover:bg-gray-700 duration-150">Wyloguj się z <i class="text-red-600"><b>{{auth()->user()->name}}</b></i></a>
                @else
                <a href="<?=config('app.url'); ?>/login" class="p-2 rounded-md text-white hover:bg-gray-700 duration-150">Zaloguj się</a>
                @endif
            </nav>
        </header>
        @if(Auth::check())
        @if(auth()->user()->name=="admin")
        <div class="bg-gray-500 flex justify-between p-2" style="flex-wrap:wrap;">
            <div class="p-2"><a href="<?=config('app.url'); ?>/admin" class="text-lg font-medium text-white">Panel<i class="text-red-600">Admina</i></a></div>
            <nav class="flex justify-center items-center" style="flex-wrap:wrap;">
                <a href="<?=config('app.url'); ?>/klienci/list" class="p-2 rounded-md text-white hover:bg-gray-700">Klienci</a>
                <a href="<?=config('app.url'); ?>/rezerwacje/list" class="p-2 rounded-md text-white hover:bg-gray-700">Rezerwacje</a>
                <a href="<?=config('app.url'); ?>/samochody/list" class="p-2 rounded-md text-white hover:bg-gray-700">Samochody</a>
                <a href="<?=config('app.url'); ?>/ubezpieczenia/list" class="p-2 rounded-md text-white hover:bg-gray-700">Ubezpieczenia</a>
                <a href="<?=config('app.url'); ?>/wypozyczenia/list" class="p-2 rounded-md text-white hover:bg-gray-700">Raporty</a>
            </nav>
        </div>
        @endif
        @endif
    </div>
</nav>
@if(!Auth::check())
<div style="
    background-image: url('images/banner2.png'); 
    background-position: center;
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed; 
    width: 100%; 
    height: 400px;
    display: flex;
    align-items: center;
    justify-content: center;
    "></div>
@endif