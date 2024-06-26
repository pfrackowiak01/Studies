<?php



function GenerujOpisy($pojazd,$opis) {

    $fiat=new Auto("Fiat 225p",200,2008,"fiat.jpg","Bardzo szybka bestia!","benzynowy",5);
    $porsche=new Auto("Porsche 911",340,2022,"porsche.jpg","Wrrrrrrrrrrrum!","benzynowy",6);
    $tesla=new Auto("Tesla Cybertruck",300,2020,"tesla.jpg","Bzzt Bzzzt","elektryczny",12);
    $seat=new Auto("Seat Leon FR",260,2014,"seat.jpg","Istny Dzikus!","benzynowy",7);
    $nio=new Auto("NIO EP9",280,2021,"nio.jpg","Elektryzująca przejażdżka!","elektryczny",11);

    $puma=new Skuter("Puma X 9000",180,2019,"puma.jpg","Brum brum, jest elektryczny!","czarny",280);
    $tencza=new Skuter("Tencza Mutant",160,2022,"tencza.png","Oślepia Cię ten blask? >.>","tęczowy",169);
    $ariel=new Skuter("Ariel NB 34",120,2013,"ariel.png","Czy to Syrenka? Uff jak dobrze, że nie czarna","niebieski",234);
    $pantera=new Skuter("Pantera Y 690",145,2018,"pantera.png","Różowa pantera nie powstydziła by się tego cacka","różowy",255);

    $simba=new Helikopter("Simba",600,2022,"simba.jpg","To strażak Sam!","3-płachtowy",2000);
    $helikopter=new Helikopter("Helikopter po prostu",800,2016,"helikopter.png","Zobacz! Jest żółty!","4-płachtowy",3400);
    $bodzio=new Helikopter("Bodzio MiniMini",900,2019,"bodzio.png","Czy on ma ludzką twarz? O.o;","2-płachtowy",1800);





    if ($opis == "dlugi") {
        //auta
        $opisFiata=new OpisHtmlDlugiBlok($fiat);
        $opisPorsche=new OpisHtmlDlugiBlok($porsche);
        $opisTesli=new OpisHtmlDlugiBlok($tesla);
        $opisSeata=new OpisHtmlDlugiBlok($seat);
        $opisNio=new OpisHtmlDlugiBlok($nio);

        //skutery
        $opisPumy=new OpisHtmlDlugiBlok($puma);
        $opisTenczy=new OpisHtmlDlugiBlok($tencza);
        $opisAriel=new OpisHtmlDlugiBlok($ariel);
        $opisPantery=new OpisHtmlDlugiBlok($pantera);
    
        //helikoptery
        $opisSimby=new OpisHtmlDlugiBlok($simba);
        $opisHelikoptera=new OpisHtmlDlugiBlok($helikopter);
        $opisBodzia=new OpisHtmlDlugiBlok($bodzio);

        switch ($pojazd) {
            case "auta":
                echo $opisFiata->generujOpis();
                echo $opisPorsche->generujOpis();
                echo $opisTesli->generujOpis();
                echo $opisSeata->generujOpis();
                echo $opisNio->generujOpis();
                break;
            case "skutery":
                echo $opisPumy->generujOpis();
                echo $opisTenczy->generujOpis();
                echo $opisAriel->generujOpis();
                echo $opisPantery->generujOpis();
                break;
            case "helikoptery":
                echo $opisSimby->generujOpis();
                echo $opisHelikoptera->generujOpis();
                echo $opisBodzia->generujOpis();
                break;
        }
    }
    else if ($opis == "krotki") {

        //auta
        $opisFiata=new OpisHtmlKrotkiBlok($fiat);
        $opisPorsche=new OpisHtmlKrotkiBlok($porsche);
        $opisTesli=new OpisHtmlKrotkiBlok($tesla);
        $opisSeata=new OpisHtmlKrotkiBlok($seat);
        $opisNio=new OpisHtmlKrotkiBlok($nio);

        //skutery
        $opisPumy=new OpisHtmlKrotkiBlok($puma);
        $opisTenczy=new OpisHtmlKrotkiBlok($tencza);
        $opisAriel=new OpisHtmlKrotkiBlok($ariel);
        $opisPantery=new OpisHtmlKrotkiBlok($pantera);
    
        //helikoptery
        $opisSimby=new OpisHtmlKrotkiBlok($simba);
        $opisHelikoptera=new OpisHtmlKrotkiBlok($helikopter);
        $opisBodzia=new OpisHtmlKrotkiBlok($bodzio);

        switch ($pojazd) {
            case "auta":
                echo $opisFiata->generujOpis();
                echo $opisPorsche->generujOpis();
                echo $opisTesli->generujOpis();
                echo $opisSeata->generujOpis();
                echo $opisNio->generujOpis();
                break;
            case "skutery":
                echo $opisPumy->generujOpis();
                echo $opisTenczy->generujOpis();
                echo $opisAriel->generujOpis();
                echo $opisPantery->generujOpis();
                break;
            case "helikoptery":
                echo $opisSimby->generujOpis();
                echo $opisHelikoptera->generujOpis();
                echo $opisBodzia->generujOpis();
                break;
        }
    }
    else {

    }
}
?>