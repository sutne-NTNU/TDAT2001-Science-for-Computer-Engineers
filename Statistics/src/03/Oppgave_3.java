package øving_3;

import java.util.ArrayList;

class Oppgave_3
{
    private static ArrayList<X> verdier = new ArrayList<>();

    static void fyll_inn_verdier()
    {
        verdier.add(new X(0.0, 1.0 / 28));
        verdier.add(new X(0.3, 2.0 / 28));
        verdier.add(new X(0.5, 5.0 / 28));
        verdier.add(new X(0.6, 8.0 / 28));
        verdier.add(new X(0.7, 5.0 / 28));
        verdier.add(new X(0.8, 3.0 / 28));
        verdier.add(new X(1.0, 2.0 / 28));
        verdier.add(new X(1.2, 3.0 / 56));
        verdier.add(new X(1.6, 1.0 / 56));
    }

    static double finn_forventningen()
    {
        double forventning = 0;
        for(X x : verdier)
        {
            forventning += (x.verdi * x.sannsynligheten_for_verdien);
        }
        return Math.round(forventning * 100.0) / 100.0;
    }

    static double finn_variansen()
    {
        double variansen = 0;
        for(X x : verdier)
        {
            variansen += ((x.verdi * x.verdi) * x.sannsynligheten_for_verdien);
        }
        double forventningen = finn_forventningen();
        variansen -= (forventningen * forventningen);

        return Math.round(variansen * 100.0) / 100.0;
    }

    static double finn_standardavviket()
    {
        double variansen = finn_variansen();
        double avvik = Math.sqrt(variansen);
        return Math.round(avvik * 100.0) / 100.0;
    }

    static double fordelingsfunksjonen(double X)
    {
        double svar = 0.0;
        for(X x : verdier)
        {
            if(x.verdi > X) break;
            svar += x.sannsynligheten_for_verdien;
        }
        return Math.round(svar * 100.0) / 100.0;
    }

    static double fordelingsfunksjonen_fra_til(double fra_og_med, double til_og_med)
    {
        int fra_indeks = -1;
        for(int i = 0; i < verdier.size(); i++)   //vil finne indeksen til verdien som komme før verdien vi vil starte fra
        {
            if(verdier.get(i).verdi >= fra_og_med)
            {
                fra_indeks = i - 1;
                break;
            }
        }
        double mellom = fordelingsfunksjonen(til_og_med) - fordelingsfunksjonen(verdier.get(fra_indeks).verdi);
        return Math.round(mellom * 100.0) / 100.0;
    }

    public static void main(String[] args)
    {
        fyll_inn_verdier();

        System.out.println("\nforventningen:       " + finn_forventningen());

        System.out.println("variansen:           " + finn_variansen());

        System.out.println("standardavvik:       " + finn_standardavviket());

        System.out.println("P(0.7 <= X <= 1.2) = " + (fordelingsfunksjonen_fra_til(0.7,1.2)));
    }
}
