<!DOCTYPE html> 
<html lang="pl"> 
  @include('partials.head') 
  <body class="bg-gray-100"> 
    @include('partials.navi') 
    <div class="p-2 text-center text-xl"> 
      <br>
      <h1 class="text-3xl font-bold underline">Nasze oferty</h1> 
      <br><p>Chwytaj okazje póki jeszcze gorące!</p>
      <br>
      <br>
      <h1 class="text-3xl font-bold underline">Rodzaje ochrony:</h1>
      <br><p><i>Kwota do zapłaty za dzień:</i>
      <br>- Pełna     <i class="text-red-600">+100zł</i>
      <br>- Częściowa <i class="text-red-600">+60zł</i>
      <br>- Brak      <i class="text-red-600">+0zł</i></p> 
      <br>
      <br>
      <h1 class="text-3xl font-bold underline">Rodzaje pakietów:</h1>
      <br><p><i>Kwota do zapłaty za dzień:</i>
      <br>- Premium    <i class="text-red-600">+200zł</i>
      <br>- Comfort    <i class="text-red-600">+140zł</i>
      <br>- Elastyczny <i class="text-red-600">+80zł</i>
      <br>- Brak       <i class="text-red-600">+0zł</i></p> 
      <br>
    </div> 
    @include('partials.footer')
  </body> 
</html>