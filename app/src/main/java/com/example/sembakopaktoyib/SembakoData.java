package com.example.sembakopaktoyib;

import java.util.ArrayList;

public class SembakoData {

    private static String[] nama = new String[]{"Beras | 8500/Kg", "indomie | 2500/Pcs",
            "Minyak | 12000/L", "Telur | 20000/Kg", "Marlboro | 27000/Bks", "Sprite / 10000/Ltr"};
    private static int[] gambar = new int[]{R.drawable.beras, R.drawable.indomie, R.drawable.minyak,
            R.drawable.telur, R.drawable.malboro, R.drawable.sprite};

    public static ArrayList<SembakoModel> getListData(){
        SembakoModel sembakoModel = null;
        ArrayList<SembakoModel> list = new ArrayList<>();

        for (int i = 0; i < nama.length; i++){
            sembakoModel = new SembakoModel();
            sembakoModel.setIcon(gambar[i]);
            sembakoModel.setNamabarang(nama[i]);
            list.add(sembakoModel);
        }
        return list;
    }

    public String getNama(int position) {
        return nama[position];
    }

    public int getGambar(int position) {
        return gambar[position];
    }
}
