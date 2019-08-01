package np.com.kendraregmi.neoassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class FragmentExmaple extends AppCompatActivity {

    Button button1, button2;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_exmaple);

        button1= findViewById(R.id.btn1);
        button2= findViewById(R.id.btn2);
        frameLayout= findViewById(R.id.frame1);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new Create_frame()).commit();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new Edit_frame()).commit();

            }
        });
    }
}
