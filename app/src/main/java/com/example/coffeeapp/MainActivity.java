package com.example.coffeeapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Coffee coffee = new Coffee();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.orderButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText address = findViewById(R.id.address);
                coffee.setAddress(address.getText().toString());
                RadioGroup rg = findViewById(R.id.radioGroup);
                int choice = rg.getCheckedRadioButtonId();
                switch (choice) {
                    case R.id.coldCoffee:
                        coffee.setHot(false);
                        break;
                    case R.id.hotCoffee:
                        coffee.setHot(true);
                        break;
                    default:
                        coffee.setHot(false);
                }
                CheckBox milkCheckBox = findViewById(R.id.milk);
                coffee.setMilk(milkCheckBox.isChecked());
                CheckBox sugarCheckBox = findViewById(R.id.sugar);
                coffee.setSugar(sugarCheckBox.isChecked());
                openActivity();
            }
        });
    }

    public void openActivity() {
        Intent info = new Intent(this, InfoActivity.class);
        info.putExtra("coffee", coffee);
        startActivity(info);
    }
}



