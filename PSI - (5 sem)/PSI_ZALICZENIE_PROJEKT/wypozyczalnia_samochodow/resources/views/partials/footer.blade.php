<br>
<br>
<footer class="bg-gray-500">
    <div class="flex justify-center" style="flex-wrap:wrap;">
        <div class="py-4 px-6 text-lg font-medium rounded-md hover:bg-gray-700"><a class="flex justify-center flex-col text-center" href="<?=config('app.url'); ?>/kontakt"><img src="{{ URL('images/telefon.png') }}" alt="Telefon" width="100" height="100">667-230-819</a></div>
        <div class="py-4 px-6 text-lg font-medium rounded-md hover:bg-gray-700"><a class="flex justify-center flex-col text-center" href="https://poczta.onet.pl"><img src="{{ URL('images/poczta.png') }}" alt="Poczta" width="100" height="100">Napisz do nas</a></div>
        <div class="py-4 px-6 text-lg font-medium rounded-md hover:bg-gray-700"><a class="flex justify-center flex-col text-center" href="<?=config('app.url'); ?>/kontakt"><img src="{{ URL('images/kontakt.png') }}" alt="Kontakt" width="100" height="100">Pomoc</a></div>
    </div>
    <div>
        @if(Auth::check()) 
        <i>Zalogowano jako: <b>{{auth()->user()->name}}</b></i>
        @endif
    </div>
    <div class="bg-gray-800 text-white">
    <p class="p-4"><i>Copyright © 2023 BudgetExpress<i class="text-red-600">24</i> - author Paweł Frąckowiak</i></p>
    </div>
</footer>