package np.com.kendraregmi.neoassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    TextView welcome_mainText, welcome_second_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcome_mainText=findViewById(R.id.welcome_mainText);
        welcome_mainText.animate().scaleX(2).scaleY(2).setDuration(1000);

        welcome_second_text=findViewById(R.id.welcome_second_text);
        welcome_second_text.setAlpha(0f);
        welcome_second_text.setVisibility(View.VISIBLE);
        welcome_second_text.animate().alpha(1f).setDuration(1000);


        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                finish();
            }
        };

        handler.postDelayed(runnable, 2000);
    }
}
