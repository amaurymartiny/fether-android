package com.example.amaurymartiny.fetherjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.parity.ethereum.Parity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);


        Log.d("APP_DIR", getFilesDir().getAbsolutePath());

        // Run parity
        String[] options = {
                "--base-path",
                getFilesDir().getAbsolutePath(),
                "--light",
                "--no-hardware-wallets",
                "--no-ipc",
                "--no-jsonrpc",
                "--no-secretstore",
                "--no-ws"
        };
        Parity parity = new Parity(options);

        Log.d("FETHER", parity.rpcQuery("{\"method\":\"eth_syncing\",\"params\":[],\"id\":1,\"jsonrpc\":\"2.0\"}"));
        String balanceResponse = parity.rpcQuery("{\"method\":\"eth_getBalance\",\"params\":[\"0x407d73d8a49eeb85d32cf465507dd71d507100c1\"],\"id\":2,\"jsonrpc\":\"2.0\"}");

        tv.setText("Balance of my account:" + balanceResponse);
    }
}
