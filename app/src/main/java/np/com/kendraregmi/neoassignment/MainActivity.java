package np.com.kendraregmi.neoassignment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;
import java.util.List;

import np.com.kendraregmi.neoassignment.Adapter.SpinnerAdapter;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    Toolbar toolbar;
    TextView getdate;
    TextView gettime;
    Button showdate;
    Button showtime;
    ImageView image2;
    Button changeImage;
    Button context_menu, popupMenu, checkSwitch;

    Spinner dynamicSpinner;

    boolean image_change_counter = true;
    ToggleButton toggleButton;
    Switch aSwitch;





    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getdate = findViewById(R.id.getdate);
        gettime = findViewById(R.id.gettime);
        showdate = findViewById(R.id.setdate);
        showtime = findViewById(R.id.settime);
        changeImage = findViewById(R.id.changeImgId);
        image2 = findViewById(R.id.image_2);
        context_menu = findViewById(R.id.context_menu);
        registerForContextMenu(context_menu);
        registerForContextMenu(changeImage);
        dynamicSpinner=findViewById(R.id.spinner1);
        popupMenu= findViewById(R.id.popupMenu);
        toggleButton= findViewById(R.id.toggleBtn);
        aSwitch= findViewById(R.id.switch_fine);
        checkSwitch= findViewById(R.id.check_switch);

        popupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu= new PopupMenu(MainActivity.this, view);
                popupMenu.setOnMenuItemClickListener(MainActivity.this);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.show();
            }
        });

        String[] countryNames= {"Nepal", "India", "Pakistan", "China"};
        int[] flags={R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
        SpinnerAdapter spinnerAdapter= new SpinnerAdapter(this, flags, countryNames);
        dynamicSpinner.setAdapter(spinnerAdapter);


        changeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (image_change_counter) {
                    image2.setImageResource(R.drawable.newimage);
                    image_change_counter = false;
                    System.out.println(image_change_counter);

                } else {
                    image2.setImageResource(R.drawable.images2);
                    image_change_counter = true;
                    System.out.println(image_change_counter);
                }
            }
        });

        showdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                image2 = findViewById(R.id.image_2);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

//                                Toast.makeText(MainActivity.this, "Date:"+i+","+i1+","+i2, Toast.LENGTH_SHORT).show();
                                getdate.setText("Date: " + i + "/" + i1 + "/" + i2);
                            }
                        }, year, month, day);
                datePickerDialog.show();

            }
        });

        showtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                int second = calendar.get(Calendar.SECOND);

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int i, int i1) {

                                gettime.setText("Time: " + i + ":" + i1);

                            }
                        }, hour, minute, false);
                timePickerDialog.show();

            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v== context_menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.activity_main_context_menu, menu);
            menu.setHeaderTitle("Select Action");
        }else if (v== changeImage){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.activity_main_menu, menu);
            menu.setHeaderTitle("Select Action");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id== R.id.action_edit){
            Toast.makeText(this, "Edit selected", Toast.LENGTH_SHORT).show();
        }else if (id==R.id.action_delete){
            Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show();
        }else if (id==R.id.action_save){
            Toast.makeText(this, "Save selected", Toast.LENGTH_SHORT).show();
        }return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.about_menu) {
            Toast.makeText(this, "About Menu Clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setIcon(R.drawable.ic_launcher_background)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                });
        AlertDialog alertDialog= builder.create();
        alertDialog.setTitle("Confirmation");
        alertDialog.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toast.makeText(this, "Selected Item:"+menuItem.getItemId(), Toast.LENGTH_SHORT).show();

        return false;
    }

    public void checkSwitchToggle(View view){
        Boolean toggle= toggleButton.isChecked();
        boolean switchIs= aSwitch.isChecked();
        Toast.makeText(this, "Toggle: "+toggle+" >> "+switchIs, Toast.LENGTH_SHORT).show();

    }
}
