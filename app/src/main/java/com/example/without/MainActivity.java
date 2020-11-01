package com.example.without;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends Activity {
    ArrayList<Animals> products = new ArrayList<Animals>();
    BoxAdapter boxAdapter;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // создаем адаптер
        fillData();
        boxAdapter = new BoxAdapter(this, products);

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);

    }

    // генерируем данные для адаптера
    void fillData() {
        for (int i = 1; i <= 10; i++) {
            products.add(new Animals("Метис " + i, i * 1000,
                    R.drawable.icondoglist, false));
        }
    }

    // выводим информацию о корзине
    public void showResult(View v) {
        String result = "Товары в корзине:";
        for (Animals p : boxAdapter.getBox()) {
            if (p.box)
                result += "\n" + p.poroda;
        }
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}