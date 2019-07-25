package np.com.kendraregmi.neoassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginBtn;
    TextView forgetPW;
    TextView dont_have_account;
    TextView incorrect_message;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPreferences= getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        if(sharedPreferences.getBoolean("isLoggedIn", false)){

            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }
        uiLinking();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login_username=username.getText().toString();
                String login_password=password.getText().toString();

                if (login_password.isEmpty() || login_username.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please enter login and password", Toast.LENGTH_SHORT).show();

                }else {
                    validateLogin(login_username,login_password);}
            }
        });

        forgetPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Forget password clicked", Toast.LENGTH_SHORT).show();
            }
        });

        dont_have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent= new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });



    }

    private void validateLogin(String login_username, String login_password) {

        if (login_username.equals("kendra") && login_password.equals("kendra123")){

            SharedPreferences sharedPreferences1= getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor1= sharedPreferences1.edit();
            editor1.putBoolean("isLoggedIn", true);
            editor1.apply();
            Toast.makeText(LoginActivity.this, "login Successful", Toast.LENGTH_SHORT).show();
            Intent dashboardIntent= new Intent(LoginActivity.this, MainActivity.class);
            startActivity(dashboardIntent);
            finish();

        } else
        {
//            Toast.makeText(LoginActivity.this, "Wrong Password or username", Toast.LENGTH_SHORT).show();
            incorrect_message.setVisibility(View.VISIBLE);
        }

    }

    private void uiLinking() {

        username= findViewById(R.id.username);
        password= findViewById(R.id.password);
        loginBtn=findViewById(R.id.loginBtn);
        forgetPW=findViewById(R.id.forget_password);
        dont_have_account=findViewById(R.id.dont_have_account);
        incorrect_message=findViewById(R.id.incorrect_message);
    }
}
