<!DOCTYPE html> 
<html lang="pl"> 
  @include('partials.head') 
  <body class="bg-gray-100"> 
    @include('partials.navi') 
    <div class="p-2 text-center text-xl"> 
      <br>
      <h1 class="text-3xl font-bold underline">Witaj na BudgetExpress<i class="text-red-600">24</i></h1> 
      <br>
      <h3>Najtańsze auta do wynajmu w Trójmieście!
      <br>- ekspresowy odbiór
      <br>- bezpłatne odwołanie rezerwacji do 24 godzin przed odbiorem
      <br>- obsługa klienta czynna 24 godziny na dobe
      <br></h3>
      <br>
      <br>
      <br><p>Aby wypożyczyć auto, przejdź na <a href="<?=config('app.url'); ?>/wynajem" class="hover:text-red-600">wynajem Samochodów!</a>
      <!--<br><p class="text-red-600 font-bold underline p-2 rounded-md bg-gray-500 hover:text-gray-400 hover:bg-gray-500 text-3xl">Przykład</p>-->
      <br>
      <br>
    </div> 
    @include('partials.footer')
  </body> 
</html>