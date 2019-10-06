package kawelenga.packag.com.socialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {

    private Button loginAppUser, signupUser;
    private TextView signupEmail, signupPassword, signupUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(" Sign Up");

        loginAppUser = findViewById(R.id.btnLogin);
        signupUser= findViewById(R.id.btnSignUp);
        signupEmail= findViewById(R.id.edtSignupEmailAddress);
        signupPassword=findViewById(R.id.edtSignUpPassword);

        signupPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN)
                {

                }
                return false;
            }
        });
        signupUsername=findViewById(R.id.edtSignUpUserName);


        signupUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (signupPassword.getText().toString().equals("") || signupPassword.getText().toString().equals("") ||
                        signupUser.getText().toString().equals("")) {

                    FancyToast.makeText(MainActivity.this, " Fields cannot empty !" + signupUsername.getText().toString(),
                            FancyToast.LENGTH_LONG, FancyToast.INFO, true).show();
                } else {

                    ParseUser user = new ParseUser();
                // Set the user's username and password, which can be obtained by a forms
                user.setUsername(signupUsername.getText().toString());
                user.setPassword(signupPassword.getText().toString());
                user.setEmail(signupEmail.getText().toString());
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Signin Up " + signupUsername.getText().toString());
                progressDialog.show();
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            //alertDisplayer("Sucessful Sign Up!","Welcome" + <Insert Username Here> + "!");
                            FancyToast.makeText(MainActivity.this, "Welcome " + signupUsername.getText().toString(),
                                    FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                            transactionToSocialMedia();
                            
                        } else {
                            ParseUser.logOut();
                            //Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.INFO, true).show();

                        }
                        progressDialog.dismiss();
                    }
                });
            }

            }


        });


      loginAppUser.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              ParseUser.logInInBackground(signupUsername.getText().toString(), signupPassword.getText().toString(),
                      new LogInCallback() {
                  @Override
                  public void done(ParseUser parseUser, ParseException e) {
                      if (parseUser != null) {
                         // alertDisplayer("Sucessful Login","Welcome back" + <Insert Username Here> + "!");
                          FancyToast.makeText(MainActivity.this,"Welcome" + signupUsername.getText().toString(),
                                  FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();

                            transactionToSocialMedia();
                      } else {
                          ParseUser.logOut();
                          //Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                          FancyToast.makeText(MainActivity.this,e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.INFO,true).show();

                      }
                  }
              });
          }
      });



   }

   /*
    private void alertDisplayer(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        // don't forget to change the line below with the names of your Activities
                        Intent intent = new Intent(SignUpActivity.this, LogoutActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        AlertDialog ok = builder.create();
        ok.show();
    }

    */

   public void rootlayerTapped (View view) {

       try {

           InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
           inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
       } catch ( Exception e) {
           e.printStackTrace();
       }
   }

   public void transactionToSocialMedia (){

       Intent intent = new Intent(MainActivity.this, startActivity.class);
       startActivity(intent);
   }
}

