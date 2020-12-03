package hr.ferit.osnove_rwma_dz3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Call<List<User>> apiCall;
    private Button button;
    private EditText editText;
    private Call<User> newApiCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        button=findViewById(R.id.btGet);
        editText=findViewById(R.id.edInput);
        setUpApiCall();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpNewApiCall(editText.getText().toString());
            }
        });

    }

    private void setUpNewApiCall(String userId) {
        newApiCall=NetworkUtils.getApiInterface().getUser(userId);
        newApiCall.enqueue(new Callback <User>() {
            @Override
            public void onResponse(Call<User> call, Response <User> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    List<User> userList=new ArrayList<>();
                    userList.add(response.body());
                    showUsers(userList);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showUsers(List<User> users) {
        //tu ce biti recycler view
        ArrayAdapter<User> adapter = new ArrayAdapter<User>(
                this,
                android.R.layout.simple_list_item_1,
                users
        );
        listView.setAdapter(adapter);
    }

    private void setUpApiCall() {
        apiCall = NetworkUtils.getApiInterface().getUsers();
        apiCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    showUsers(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}