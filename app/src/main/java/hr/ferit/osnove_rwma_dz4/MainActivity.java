package hr.ferit.osnove_rwma_dz4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hr.ferit.osnove_rwma_dz3.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Call<List<Makeup>> apiCall;
    private Button button;
    private EditText editText;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList <Makeup> makeups=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpRecycler();
        button=findViewById(R.id.btSearch);
        editText=findViewById(R.id.edInput);
        Toast.makeText(this,getString(R.string.hint).toString(),Toast.LENGTH_LONG).show();
        setUpDefaultApiCall();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpNewApiCall(editText.getText().toString());
            }
        });

    }

    private void setUpRecycler() {
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new RecyclerAdapter<Makeup>(this,  makeups);
        recyclerView.setAdapter(adapter);
    }

    private void showUsers(List<Makeup> makeup) {
        if(makeup.isEmpty())
            Toast.makeText(MainActivity.this, getString(R.string.error_message), Toast.LENGTH_SHORT).show();
        adapter.addData((ArrayList<Makeup>) makeup);
    }

    private void setUpNewApiCall(String brand) {
        apiCall = NetworkUtils.getApiInterface().getProducts(brand);
        apiCall.enqueue(new Callback<List<Makeup>>() {
            @Override
            public void onResponse(Call<List<Makeup>> call, Response<List<Makeup>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    showUsers(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Makeup>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpDefaultApiCall() {
        apiCall = NetworkUtils.getApiInterface().getMaybellineElements();
        apiCall.enqueue(new Callback<List<Makeup>>() {
            @Override
            public void onResponse(Call<List<Makeup>> call, Response<List<Makeup>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    showUsers(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Makeup>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (apiCall != null)
            apiCall.cancel();
    }

}