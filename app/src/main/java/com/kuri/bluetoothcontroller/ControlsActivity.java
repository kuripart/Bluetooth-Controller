package com.kuri.bluetoothcontroller;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.io.IOException;
import java.util.UUID;

public class ControlsActivity extends AppCompatActivity {


    // Button btnOn, btnOff, btnDis;
    Button sig_1, sig_2, sig_3, sig_4, sig_5, sig_6, sig_7, sig_8, disconnect_button;
    String address = null;
    private ProgressDialog progress;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket bluetoothSocket = null;
    private boolean isBtConnected = false;
    String bluetoothData;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); //SPP UUID. Look for it
    Miscellaneous miscellaneousDoings = new Miscellaneous();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls);


        Intent obtainedIntent = getIntent();
        address = obtainedIntent.getStringExtra(MainActivity.EXTRA_ADDRESS); //receive the address of the bluetooth device

        //call the button widgets
        sig_1 = (Button)findViewById(R.id.sig_1);
        sig_2 = (Button)findViewById(R.id.sig_2);
        sig_3 = (Button)findViewById(R.id.sig_3);
        sig_4 = (Button)findViewById(R.id.sig_4);
        sig_5 = (Button)findViewById(R.id.sig_5);
        sig_6 = (Button)findViewById(R.id.sig_6);
        sig_7 = (Button)findViewById(R.id.sig_7);
        sig_8 = (Button)findViewById(R.id.sig_8);
        disconnect_button = (Button)findViewById(R.id.disconnect);

        new ConnectBT().execute(); //Call the class to connect

        //commands to be sent to bluetooth
        //set listeners for every button and execute the respective commands
        sig_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                turnOne();     
            }
        });

        sig_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                turnTwo();   //method to turn off
            }
        });

        sig_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                turnTwo();   //method to turn off
            }
        });

        sig_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                turnThree();   //method to turn off
            }
        });

        sig_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                turnFour();   //method to turn off
            }
        });

        sig_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                turnFive();   //method to turn off
            }
        });

        sig_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                turnSix();   //method to turn off
            }
        });


        sig_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                turnSeven();   //method to turn off
            }
        });


        sig_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                turnEight();   //method to turn off
            }
        });

        disconnect_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Disconnect(); //close connection
            }
        });
    }





    private void Disconnect() {
        if (bluetoothSocket!=null) //If the bluetoothSocket is busy
        {
            try {
                bluetoothSocket.close(); //close connection

            } catch (IOException e) {
                miscellaneousDoings.displayErrorToast("Error", getApplicationContext());

            }

        }
        finish(); //return to the first layout

    }

    private void turnOne()
    {
        if (bluetoothSocket!=null)
        {
            try {
                bluetoothData = "1";
                bluetoothSocket.getOutputStream().write(bluetoothData.getBytes());

            } catch (IOException e) {
                miscellaneousDoings.displayErrorToast("Error", getApplicationContext());
            }
        }
    }

    private void turnTwo() {
        if (bluetoothSocket!=null)
        {
            try {
                bluetoothData = "2";
                bluetoothSocket.getOutputStream().write(bluetoothData.getBytes());

            } catch (IOException e) {
                miscellaneousDoings.displayErrorToast("Error", getApplicationContext());
            }
        }
    }


    private void turnThree() {

        if(bluetoothSocket!=null){

            try {
                bluetoothData = "3";
                bluetoothSocket.getOutputStream().write(bluetoothData.getBytes());

            } catch (IOException e) {
                miscellaneousDoings.displayErrorToast("Error", getApplicationContext());
            }
        }
        
        
    }


    private void turnFour() {

        if(bluetoothSocket!=null){

            try {
                bluetoothData = "4";
                bluetoothSocket.getOutputStream().write(bluetoothData.getBytes());

            } catch (IOException e) {
                miscellaneousDoings.displayErrorToast("Error", getApplicationContext());
            }
        }

    }


    private void turnFive() {

        if(bluetoothSocket!=null){

            try {
                bluetoothData = "5";
                bluetoothSocket.getOutputStream().write(bluetoothData.getBytes());

            } catch (IOException e) {
                miscellaneousDoings.displayErrorToast("Error", getApplicationContext());
            }
        }

    }


    private void turnSix() {

        if(bluetoothSocket!=null){

            try {
                bluetoothData = "6";
                bluetoothSocket.getOutputStream().write(bluetoothData.getBytes());

            } catch (IOException e) {
                miscellaneousDoings.displayErrorToast("Error", getApplicationContext());
            }
        }

    }

    private void turnSeven() {

        if(bluetoothSocket!=null){

            try {
                bluetoothData = "7";
                bluetoothSocket.getOutputStream().write(bluetoothData.getBytes());

            } catch (IOException e) {
                miscellaneousDoings.displayErrorToast("Error", getApplicationContext());
            }
        }

    }



    private void turnEight() {

        if(bluetoothSocket!=null){

            try {
                bluetoothData = "8";
                bluetoothSocket.getOutputStream().write(bluetoothData.getBytes());

            } catch (IOException e) {
                miscellaneousDoings.displayErrorToast("Error", getApplicationContext());
            }
        }

    }



    //THIS IS THE MOST IMPORTANT SECTION FOR THE BLUETOOTH CODE
    //REFER THE ONLINE ANDROID MANUAL FOR MORE INFORMATION
    //MOST OF THE CODE STRUCTURE IS TAKEN FROM THE OPEN SOURCE CODE

    private class ConnectBT extends AsyncTask<Void, Void, Void> {  // UI thread
        //NOTE:
        //---------------------------
        //AsyncTask enables proper and easy use of the UI thread.
        //This class allows you to perform background operations and publish
        //results on the UI thread without having to manipulate threads and/or handlers.


        //Once created, a task is executed very simply:
        //new DownloadFilesTask().execute(url1, url2, url3);
        //The above invocation has been done in onCreate()



        //EXTRA NOTES:
        //----------------------------
        //onPreExecute():
        //invoked on the UI thread before the task is executed.
        //This step is normally used to setup the task,
        //for instance by showing a progress bar in the user interface.


        //doInBackground(Params...):
        //invoked on the background thread immediately after onPreExecute() finishes executing.
        //This step is used to perform background computation that can take a long time.
        //The parameters of the asynchronous task are passed to this step.
        //The result of the computation must be returned by this step and will be passed
        //back to the last step. This step can also use publishProgress(Progress...) to
        //publish one or more units of progress. These values are published on the UI thread,
        //in the onProgressUpdate(Progress...) step.


        //onProgressUpdate(Progress...):
        //invoked on the UI thread after a call to publishProgress(Progress...).
        //The timing of the execution is undefined. This method is used to display any
        //form of progress in the user interface while the
        //background computation is still executing. For instance, it can be used to animate a
        //progress bar or show logs in a text field.


        //onPostExecute(Result):
        //invoked on the UI thread after the background computation finishes.
        // The result of the background computation is passed to this step as a parameter.

        private boolean ConnectSuccess = true; //if it's here, it's almost connected

        @Override
        protected void onPreExecute()
        {
            progress = ProgressDialog.show(ControlsActivity.this, "Connecting.......", "Please wait!");  //show a progress dialog
        }

        @Override
        protected Void doInBackground(Void... devices) //while the progress dialog is shown, the connection is done in background
        {
            try
            {
                if (bluetoothSocket == null || !isBtConnected) {
                    //check if bluetooth socket created and bluetooth should be connected if not
                    myBluetooth = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
                    BluetoothDevice bluetoothDevice = myBluetooth.getRemoteDevice(address);//connects to the device's address and checks if it's available
                    bluetoothSocket = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(myUUID);//create a RFCOMM (SPP) connection
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    bluetoothSocket.connect();//start connection
                }
            } catch (IOException e) {
                ConnectSuccess = false;//if the try failed, you can check the exception here
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result) //after the doInBackground, it checks if everything went fine
        {
            super.onPostExecute(result);

            if (!ConnectSuccess) {
                miscellaneousDoings.displayErrorToast("Connection Failed. Is it a SPP Bluetooth? Try again.", getApplicationContext());
                finish();
            }
            else {
                miscellaneousDoings.displaySuccessToast("Connected", getApplicationContext());
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }


    //Currently dummy menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_led_control, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
