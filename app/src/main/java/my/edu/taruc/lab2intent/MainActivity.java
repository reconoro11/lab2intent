package my.edu.taruc.lab2intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_MESSAGE = "my.edu.taruc.lab2intent.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        EditText editTextMessage;
        EditText editTextMessage2;
        editTextMessage = findViewById(R.id.editWeightMessage);
        editTextMessage2 = findViewById(R.id.editHeightMessage);
        if(TextUtils.isEmpty(editTextMessage.getText()))
        {
            editTextMessage.setError(getString(R.string.error_message));
            editTextMessage2.setError(getString(R.string.error_message));
            return;
        }
        String stringMsg,stringMsg2;
        stringMsg =  editTextMessage.getText().toString();
        stringMsg2 = editTextMessage2.getText().toString();
        double weight = Double.parseDouble(stringMsg);
        double height = Double.parseDouble(stringMsg2);

        double Bmi = weight/(height*height);
        String message=Double.toString(Bmi);
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra(TAG_MESSAGE,message);
        startActivity(intent);
    }
}
