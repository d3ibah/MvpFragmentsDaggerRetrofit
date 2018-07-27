package by.testmvpfragmentsdaggerretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean flagShowPass = false;
    EditText eTMobKey, eTIdNum;
    ImageView imageView;

    Button button;
    static int i = 1;

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_identification);


        eTMobKey = findViewById(R.id.editText_id_key);
        imageView = findViewById(R.id.iv_show_pass);

        button = findViewById(R.id.button_pass);

        toolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

//        button.setEnabled(false);
//        button.setBackground(getDrawable(R.drawable.button_gray_oval));



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                someDo();
            }
        });
    }



    public void someDo() {
        if (!flagShowPass) {
            imageView.setImageResource(R.drawable.ic_visibility_black_24dp);
            eTMobKey.setTransformationMethod(null);
            eTMobKey.setSelection(eTMobKey.length());
            flagShowPass = !flagShowPass;
        } else {
            imageView.setImageResource(R.drawable.ic_visibility_off_black_24dp);
            flagShowPass = !flagShowPass;
            eTMobKey.setTransformationMethod(new PasswordTransformationMethod());
        }
    }
}
