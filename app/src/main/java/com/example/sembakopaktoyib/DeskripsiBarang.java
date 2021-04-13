package com.example.sembakopaktoyib;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DeskripsiBarang extends AppCompatActivity {

    private TextView tvNamaBarang;
    private ImageView ivIcon;
    private TextView tvDeskripsi;
    private SembakoData sembakoData;

    private static String[] deskripsi = new String[]{"Beras dari petani negeri.",
            "Idaman para anak kost.",
            "Minyak terdabest dapat diminum.",
            "Telur coklat pilihan peternak.",
            "Rokok berat duit Marlboros.",
            "Nyatanya nyegerin buat buka."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi_barang);

        ivIcon = findViewById(R.id.iv_icon);
        tvNamaBarang = findViewById(R.id.tv_namabarang);
        tvDeskripsi = findViewById(R.id.tv_deskripsi);

        int j = getIntent().getIntExtra("position",0);

        sembakoData = new SembakoData();

        ivIcon.setImageResource(sembakoData.getGambar(j));
        tvNamaBarang.setText(sembakoData.getNama(j));
        tvDeskripsi.setText(deskripsi[j]);

    }
}