package np.com.kendraregmi.neoassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText register_email, register_username, register_password, register_password_re;
    Button registerBtn;
    TextView already_have_account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_email=findViewById(R.id.register_email);
        register_username= findViewById(R.id.register_username);
        register_password= findViewById(R.id.register_password);
        register_password_re=findViewById(R.id.register_password_re);
        registerBtn= findViewById(R.id.registerBtn);
        already_have_account=findViewById(R.id.account_already);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String register_email_address= register_email.getText().toString();
                if (register_email_address.matches("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
                    Toast.makeText(RegisterActivity.this, "" + register_email_address, Toast.LENGTH_SHORT).show();

                }else {
                    register_email.setError("Invalid email");
                    Toast.makeText(RegisterActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register_password_re.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String pwd=register_password.getText().toString();
                if (pwd.equals(charSequence.toString())){
                    Toast.makeText(RegisterActivity.this, "Password matched", Toast.LENGTH_SHORT).show();

                }else
                {
                    register_password_re.setError("Password not matched");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
