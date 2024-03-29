package com.example.apprecyclerview;

//import static androidx.core.graphics.drawable.IconCompat.getResources;

public class MainDataset {
    static Integer[] imageArray = {
            R.drawable.caravelle,
            R.drawable.saint_pierre,
            R.drawable.diamant,
            R.drawable.rhum_clement,
            R.drawable.montagne_pelee
    };
    static String[] nameArray = {
            "Le phare de la caravelle",
            "Saint Pierre",
            "Le rocher du Diamant",
            "L'Habitation Clément",
            "La montagne Pelée"
    };
//    static String[] infoArray = getResources().getStringArray(R.array.info);

//    static String[] infoArray = {
//            getResources().getString(R.string.caravelleInfo),
//            getResources().getString(R.string.saintpierreInfo)
//
//    }
    static String[] infoArray = {
            "1",
        "2",
        "3",
        "4",
        "5"
    };
    static Integer[] detailImageArray = {
            R.drawable.caravelle,
            R.drawable.saint_pierre,
            R.drawable.diamant,
            R.drawable.rhum_clement,
            R.drawable.montagne_pelee
    };
    static String[] detailTextArray = {
            "La Trinite",
            "Saint Pierre",
            "Le Diamant",
            "Le François",
            "Morne Rouge"
    };
    static String[] detailWebLink = {
            "https://fr.wikipedia.org/wiki/Phare_de_La_Caravelle",
            "https://fr.wikipedia.org/wiki/Pitons_du_Carbet",
            "https://fr.wikipedia.org/wiki/Montagne_Pel%C3%A9e",
            "https://fr.wikipedia.org/wiki/Rocher_du_Diamant",
            "https://fr.wikipedia.org/wiki/Le_Marin"
    };
    private static Integer[] caravelle = {
            R.drawable.caravelle1,
            R.drawable.caravelle2

    };
    private static Integer[] saintpierre = {
            R.drawable.caravelle1,
            R.drawable.caravelle2

    };
    private static Integer[] diamant = {
            R.drawable.diamant1,
            R.drawable.diamant2,
            R.drawable.diamant3,
            R.drawable.diamant4

    };
    private static Integer[] clement = {
            R.drawable.caravelle1,
            R.drawable.caravelle2

    };

    private static Integer[] pelee = {
            R.drawable.montagne_pelee1,
            R.drawable.montagne_pelee2,
            R.drawable.montagne_pelee3

    };
    static Integer[][] galleryArray = {
            caravelle,
            saintpierre,
            diamant,
            clement,
            pelee
    };

}
