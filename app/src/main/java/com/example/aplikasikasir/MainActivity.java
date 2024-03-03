package com.example.aplikasikasir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6;
    private EditText editText1, editText2, editText3, editText4;
    private Button button1;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton5);
        radioButton6 = findViewById(R.id.radioButton6);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        button1 = findViewById(R.id.button1);

        textView1 = findViewById(R.id.textview1);

        editText1.setVisibility(View.GONE);
        editText2.setVisibility(View.GONE);
        editText3.setVisibility(View.GONE);
        editText4.setVisibility(View.GONE);

        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton1.isChecked()) {
                    editText1.setVisibility(View.VISIBLE);
                    editText2.setVisibility(View.GONE);
                    editText3.setVisibility(View.GONE);
                    editText4.setVisibility(View.GONE);

                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                } else {
                    editText1.setVisibility(View.GONE);
                }
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton2.isChecked()) {
                    editText1.setVisibility(View.GONE);
                    editText2.setVisibility(View.VISIBLE);
                    editText3.setVisibility(View.GONE);
                    editText4.setVisibility(View.GONE);

                    editText1.setText("");
                    editText3.setText("");
                    editText4.setText("");
                } else {
                    editText2.setVisibility(View.GONE);
                }
            }
        });

        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton3.isChecked()) {
                    editText1.setVisibility(View.GONE);
                    editText2.setVisibility(View.GONE);
                    editText3.setVisibility(View.VISIBLE);
                    editText4.setVisibility(View.GONE);

                    editText1.setText("");
                    editText2.setText("");
                    editText4.setText("");
                } else {
                    editText3.setVisibility(View.GONE);
                }
            }
        });

        radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton4.isChecked()) {
                    editText1.setVisibility(View.GONE);
                    editText2.setVisibility(View.GONE);
                    editText3.setVisibility(View.GONE);
                    editText4.setVisibility(View.VISIBLE);

                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                } else {
                    editText4.setVisibility(View.GONE);
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaBarang = "";
                int jumlah = 0;
                int harga = 0;

                if (radioButton1.isChecked()) {
                    namaBarang = "Asus ROG Strix scar 16";
                    if (!editText1.getText().toString().isEmpty()) {
                        jumlah = Integer.parseInt(editText1.getText().toString());
                        harga = 70000000 * jumlah;
                    } else {
                        textView1.setText("Masukkan jumlah barang terlebih dahulu.");
                        return;
                    }
                } else if (radioButton2.isChecked()) {
                    namaBarang = "Apple macbook air";
                    if (!editText2.getText().toString().isEmpty()) {
                        jumlah = Integer.parseInt(editText2.getText().toString());
                        harga = 20000000 * jumlah;
                    } else {
                        textView1.setText("Masukkan jumlah barang terlebih dahulu.");
                        return;
                    }
                } else if (radioButton3.isChecked()) {
                    namaBarang = "Hp elitebook 840 G9";
                    if (!editText3.getText().toString().isEmpty()) {
                        jumlah = Integer.parseInt(editText3.getText().toString());
                        harga = 25800000 * jumlah;
                    } else {
                        textView1.setText("Masukkan jumlah barang terlebih dahulu.");
                        return;
                    }
                } else if (radioButton4.isChecked()) {
                    namaBarang = "Acer Aspire 3 Spin 14";
                    if (!editText4.getText().toString().isEmpty()) {
                        jumlah = Integer.parseInt(editText4.getText().toString());
                        harga = 8000000 * jumlah;
                    } else {
                        textView1.setText("Masukkan jumlah barang terlebih dahulu.");
                        return;
                    }
                }

                boolean isMember = radioButton5.isChecked();

                int totalHargaBeforeDiscount = harga;

                int diskon = 0;
                if (isMember) {
                    diskon = (int) (harga * 0.05); // Diskon 5%
                    harga -= diskon;
                }
                harga += 10000;

                NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));

                String hasilPembelian = "Nama Barang: " + namaBarang + "\n" +
                        "Harga Barang sebelum diskon: " + formatRupiah.format(totalHargaBeforeDiscount) + "\n" +
                        "Jumlah: " + jumlah + "\n";

                if (isMember) {
                    hasilPembelian += "Diskon (5%): " + formatRupiah.format(diskon) + "\n";
                } else {
                    hasilPembelian += "Tidak ada diskon\n";
                }

                hasilPembelian += "Biaya Admin: " + formatRupiah.format(10000) + "\n";

                String hargaFormatted = formatRupiah.format(harga);

                hasilPembelian += "Total Harga setelah diskon dan biaya admin: " + hargaFormatted;

                textView1.setText(hasilPembelian);
            }
        });









    }
}