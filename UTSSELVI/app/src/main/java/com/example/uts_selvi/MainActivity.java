package com.example.uts_selvi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtnama, edtgol;
    Button btnSubmit;
    TextView txtgapok, txttunjangan, txtpajak, txtgajibersih, txttampilnam, txttampilgol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txttampilnam = findViewById(R.id.txtnama);
        txttampilgol = findViewById(R.id.txtgol);

        edtnama = (EditText) findViewById(R.id.edtNama);
        edtgol = (EditText) findViewById(R.id.edtGolongan);

        txtgapok = (TextView) findViewById(R.id.txtgapok);
        txttunjangan = (TextView) findViewById(R.id.txttunjangan);
        txtpajak = (TextView) findViewById(R.id.txtpajak);
        txtgajibersih = (TextView) findViewById(R.id.txtgajibersih);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String NamaKaryawan, golongan;
                double gapok = 0, tunjangan = 0, pajak = 0, gajibersih;

                NamaKaryawan = edtnama.getText().toString();
                golongan = edtgol.getText().toString();

                if (golongan.equals("1")){
                    gapok = 1500000;
                    tunjangan = 1000000;
                    pajak = (gapok + tunjangan)*0.01;
                }else if (golongan.equals("2")){
                    gapok = 2000000;
                    tunjangan = 1500000;
                    pajak = (gapok + tunjangan)*0.02;
                }else if (golongan.equals("3")){
                    gapok = 2500000;
                    tunjangan = 2000000;
                    pajak = (gapok + tunjangan)*0.03;
                }else if (golongan.equals("4")){
                    gapok = 3000000;
                    tunjangan = 2500000;
                    pajak = (gapok + tunjangan)*0.01;
                }
                gajibersih = gapok + tunjangan - pajak;

                String strnama = edtnama.getText().toString();
                String strgol = edtgol.getText().toString();

                txttampilnam.setText("Nama Karyawan : " +strnama);
                txttampilgol.setText("Golongan : " +strgol);
                txtgapok.setText("Gaji Pokok : " +String.valueOf(gapok));
                txttunjangan.setText("Tunjangan : " +String.valueOf(tunjangan));
                txtpajak.setText("Pajak : " +String.valueOf(pajak));
                txtgajibersih.setText("Gaji Bersih : " +String.valueOf(gajibersih));
            }

        });

    }
}