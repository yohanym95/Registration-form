package test1.pantha.registrationform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   Button button;
   EditText textname,Text_email,Text_password;
   RadioButton female,male;
   RadioGroup radioGroup;




    static int minimumNumber( String password) {
        // Return the minimum number of characters to make the password strong
        String numbers="0123456789";
        String charLower="abcdefghijklmnopqrstuvwxyz";
        String charUpper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChar="!@#$%^&*()-+";
        int minnum=0;
        boolean isNumberContains=false;
        boolean isCharUpperContains=false;
        boolean isCharLowerContains=false;
        boolean isSpecialCharContains=false;

        char[] pass=password.toCharArray(); //

        for(int i=0;i<pass.length;i++){
            CharSequence cs1 =String.valueOf(pass[i]);

            if(numbers.contains(cs1)){
                isNumberContains=true;
                continue;
            }else if(charUpper.contains(cs1)){
                isCharUpperContains=true;
                continue;
            }else if (charLower.contains(cs1)){
                isCharLowerContains=true;
                continue;
            }else if(specialChar.contains(cs1)){
                isSpecialCharContains=true;
                continue;
            }
        }

        minnum += isNumberContains ? 0 : 1;
        minnum += isCharUpperContains ? 0 : 1;
        minnum += isCharLowerContains ? 0 : 1;
        minnum += isSpecialCharContains ? 0 : 1;

        //System.out.println(minnum);

//        if(n<6){
//            if((6-n)>=minnum){
//                minnum=6-n;
//            }
//        }
        int a;
        if(minnum>=4){
            a=minnum;
        }else{
            a = 4-minnum;
        }



        return a;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button) findViewById(R.id.button);
        textname=(EditText) findViewById(R.id.textname);
        Text_email= (EditText)findViewById(R.id.Text_email);
        Text_password =(EditText)findViewById(R.id.Text_password);
        female = (RadioButton) findViewById(R.id.female);
        male = (RadioButton)findViewById(R.id.male);
        radioGroup =(RadioGroup) findViewById(R.id.radioGroup);

       ;


        //Inner class
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = textname.getText().toString();
                String email = Text_email.getText().toString();
                String Password = Text_password.getText().toString();
                String gender ="";
                int answer=minimumNumber(Password);
                if(answer>=4){
                    if(male.isChecked()){
                        gender="Mr";
                        Toast.makeText(MainActivity.this,"Name :"+gender+"."+name +"\n Email :" +email+"\n Password :"+Password,Toast.LENGTH_SHORT).show();

                    }else{
                        gender = "Ms";
                        Toast.makeText(MainActivity.this,"Name :"+gender+"."+name +"\n Email :" +email+"\n Password :"+Password,Toast.LENGTH_SHORT).show();

                    }

                }else{
                    Toast.makeText(MainActivity.this,"password not strong",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
