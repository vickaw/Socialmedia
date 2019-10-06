package kawelenga.packag.com.socialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseInstallation;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {

    private Button loginAppUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(" Sign Up");

        loginAppUser = findViewById(R.id.btnLogin);


      loginAppUser.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

             // Toast.makeText(MainActivity.this,"Click works", Toast.LENGTH_LONG)
              FancyToast.makeText(MainActivity.this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.INFO,true).show();

          }
      });



   }


}
