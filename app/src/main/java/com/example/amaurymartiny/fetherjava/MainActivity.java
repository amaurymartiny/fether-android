package com.example.amaurymartiny.fetherjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText("HELLO THERE");

        Log.d("APP_DIR", getFilesDir().getAbsolutePath());

        // Run parity
        String[] options = {
                "--base-path=/data/user/0/com.example.amaurymartiny.fetherjava/cache",
                "--light",
                "--no-hardware-wallets",
                "--no-ipc",
                "--no-jsonrpc",
                "--no-secretstore",
                "--no-ws"
        };
        Parity parity = new Parity(options);

        Log.d("FETHER", parity.rpcQuery("eth_coinbase"));
    }
}
