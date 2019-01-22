package my.com.yewchinsheng.yewchinsheng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class InsertActivity extends AppCompatActivity {
    private EditText editTextName,editTextIC,editTextYearsOld;
    private Spinner spinnerStatus;
    private int itemvalue;
    public static final String INSERT_YEAR = "my.edu.tarc.demoroom.YEAR";
    public static final String INSERT_IC = "my.edu.tarc.demoroom.IC";
    public static final String INSERT_NAME = "my.edu.tarc.demoroom.NAME";
    public static final String INSERT_STATUS = "my.edu.tarc.demoroom.STATUS";
    public static final String INSERT_FEE = "my.edu.tarc.demoroom.FEE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);



        editTextName = findViewById(R.id.editTextName);
        editTextIC = findViewById(R.id.editTextIC);
        editTextYearsOld = findViewById(R.id.editText);
        spinnerStatus = findViewById(R.id.spinnerStatus);

        List<String> list = new ArrayList<>();
        list.add("Normal");
        list.add("Student");
        list.add("Disabled");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerStatus.setAdapter(adapter);
        spinnerStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemvalue = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editTextName.getText())){
                    editTextName.setError("Name is empty.");
                    return;
                }
                if(TextUtils.isEmpty(editTextIC.getText())){
                    editTextIC.setError("IC Number is empty.");
                    return;
                }
                if(TextUtils.isEmpty(editTextYearsOld.getText())){
                    editTextYearsOld.setError("Age is empty.");
                    return;
                }
                String name, IC, yearsOld;
                name = editTextName.getText().toString();
                IC = editTextIC.getText().toString();
                yearsOld = editTextYearsOld.getText().toString();

                int years = Integer.parseInt(yearsOld);
                int fee = 0;
                if( itemvalue == 2 )
                {
                    fee = 0;
                }
                else if(itemvalue == 1)
                {
                    fee = 100;
                }
                else if(itemvalue == 0)
                {
                    if(years > 60 || years <12)
                    {
                        fee = 100;
                    }
                    else
                    {
                        fee = 200;
                    }
                }
                String pay = String.valueOf(fee);
                Intent intent = new Intent();
                intent.putExtra(INSERT_IC, IC);
                intent.putExtra(INSERT_NAME, name);
                intent.putExtra(INSERT_YEAR, yearsOld);
                intent.putExtra(INSERT_STATUS,itemvalue);
                intent.putExtra(INSERT_FEE,pay);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
    }
}