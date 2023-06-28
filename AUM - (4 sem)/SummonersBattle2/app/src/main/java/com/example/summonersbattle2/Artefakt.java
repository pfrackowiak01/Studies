package com.example.summonersbattle2;

public class Artefakt {

    String name;
    int index;
    int wartosc;
    int zaleta;
    int minus;

    public Artefakt(String n, int i, int w, int z, int m) {
        this.name = n;
        this.index = i;
        this.wartosc = w;
        this.zaleta = z;
        this.minus = m;
    }

    public String opiszZalete(Artefakt a) {
        switch (a.zaleta) {
            case 0:
                return "Nie ma żadnych pozytywnych efektów.";
            case 1:
                return "Zwiększa wszystkim bohaterom życie o " + a.wartosc + "% maksymalnego zdrowia.";
            case 2:
                return "Zwiększa wszystkim bohaterom tarcze o " + a.wartosc + "% maksymalnej obrony.";
            case 3:
                return "Zwiększa wszystkim bohaterom szybkość o " + a.wartosc + "% maksymalnej szybkości.";
            case 4:
                return "Zwiększa wszystkim bohaterom siłę o " + a.wartosc + "% maksymalnego ataku.";
            case 5:
                return "Zwiększa wszystkim bohaterom szanse na uderzenie krytyczne o " + a.wartosc + "%.";
            default:
                return "coś";
        }
    }

    public String opiszMinus(Artefakt a) {
        switch (a.minus) {
            case 0:
                return "Nie ma żadnych negatywnych efektów.";
            case 1:
                return "Zmniejsza wszystkim bohaterom życie o " + a.wartosc/2 + "% maksymalnego zdrowia.";
            case 2:
                return "Zmniejsza wszystkim bohaterom tarcze o " + a.wartosc/2 + "% maksymalnej obrony.";
            case 3:
                return "Zmniejsza wszystkim bohaterom szybkość o " + a.wartosc/2 + "% maksymalnej szybkości.";
            case 4:
                return "Zmniejsza wszystkim bohaterom siłę o " + a.wartosc/2 + "% maksymalnego ataku.";
            case 5:
                return "Zmniejsza wszystkim bohaterom szanse na uderzenie krytyczne o " + a.wartosc/2 + "%.";
            default:
                return "coś";
        }
    }

    @Override
    public String toString() {
        return "========" + this.name + "========" +
                "\nLegendarny artefakt, stackuje się." +
                "\n-----------Zaleta-----------" +
                "\n" + opiszZalete(this) +
                "\n------------Wada------------" +
                "\n" + opiszMinus(this);

    }
}
