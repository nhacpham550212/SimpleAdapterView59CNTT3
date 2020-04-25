package vn.edu.ntu.phamvuonglamnhac.simpleadapterview59cntt3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lvTinhThanh;
    String[] arrTinhThanh;
    ArrayAdapter<String> adapter;
    AutoCompleteTextView actxtTinhThanh;
    Spinner spnTinhThanh;
    TextView txtTinhThanhChon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }
    private void addViews()
    {
        lvTinhThanh =findViewById(R.id.lvTinhThanh);
        actxtTinhThanh=findViewById(R.id.actxtTinhThanh);
        spnTinhThanh=findViewById(R.id.spnTinhThanh);
        txtTinhThanhChon=findViewById(R.id.txtTinhThanhChon);
        arrTinhThanh = getResources().getStringArray(R.array.tinhThanh);
        adapter= new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                arrTinhThanh);
        lvTinhThanh.setAdapter(adapter);
        //
        actxtTinhThanh.setAdapter(adapter);
        spnTinhThanh.setAdapter(adapter);



    }
    private  void addEvents()
    {
        lvTinhThanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"bạn chọn"+arrTinhThanh[position],
                        Toast.LENGTH_SHORT).show();
            }
            });
        spnTinhThanh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtTinhThanhChon.setText(arrTinhThanh[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this,"không có",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
