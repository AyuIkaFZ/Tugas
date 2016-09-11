package id.sch.smktelkom_mlg.tugas01.xirpl5006.tugas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etTahun;
    Button bOk;
    RadioButton rbP, rbL;
    Spinner spasal;
    CheckBox rpl, tkj, lain;
    TextView tvHasil, tvhasil2, tvhasil3, tvhasil4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextTahun);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);
        rbL = (RadioButton) findViewById(R.id.radioButtonL);
        spasal = (Spinner) findViewById(R.id.asal);
        rpl = (CheckBox) findViewById(R.id.rpl);
        tkj = (CheckBox) findViewById(R.id.tkj);
        lain = (CheckBox) findViewById(R.id.lain);
        bOk = (Button) findViewById(R.id.button);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvhasil2 = (TextView) findViewById(R.id.textViewhasil2);
        tvhasil3 = (TextView) findViewById(R.id.textViewhasil3);
        tvhasil4 = (TextView) findViewById(R.id.textViewhasil4);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doProcess();
                doClick();

            }
        });

    }

    private void doClick() {
        String hasil2 = null;
        String hasil4 = "Anda memilih jurusan  : ";
        int startln = hasil4.length();

        if (rpl.isChecked()) hasil4 += rpl.getText() + "(√) ";
        if (tkj.isChecked()) hasil4 += tkj.getText() + "(√) ";
        if (lain.isChecked()) hasil4 += lain.getText() + "(√)";


        if (hasil4.length() == startln) hasil4 += "GAGAL  (X)";
        tvhasil4.setText(hasil4);

        if (rbP.isChecked()) {
            hasil2 = rbP.getText().toString();
        } else if (rbL.isChecked()) {
            hasil2 = rbL.getText().toString();
        }
        if (hasil2 == null) {
            tvhasil2.setText("Anda belum memilih gender");
        } else {
            tvhasil2.setText("Gender Anda : " + hasil2);
        }
        tvhasil3.setText("Anda berasal dari :" + spasal.getSelectedItem().toString());
        if (rpl.isChecked()) hasil4 += rpl.getText() + "(√) ";
        if (tkj.isChecked()) hasil4 += tkj.getText() + "(√) ";
        if (lain.isChecked()) hasil4 += lain.getText() + "(√)";


    }


    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (tahun.isEmpty()) {
            etTahun.setError("Tahun Kelahiran Belum diisi");
            valid = false;
        } else if (tahun.length() != 4) {
            etTahun.setError("Format tahun bukan yyyy");
            valid = false;
        } else {
            etTahun.setError(null);
        }
        return valid;
    }


}

