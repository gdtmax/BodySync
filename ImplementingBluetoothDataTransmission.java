import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

// Inside your BluetoothService or a similar class

private BluetoothSocket mmSocket;
private OutputStream mmOutStream;

public void connectDevice(BluetoothDevice device) {
        UUID MY_UUID = UUID.fromString("your-unique-uuid-here"); // Replace with your UUID
        try {
        mmSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
        mmSocket.connect();
        mmOutStream = mmSocket.getOutputStream();
        } catch (IOException e) {
        // Handle exception
        }
        }

public void sendData(String data) {
        byte[] bytes = data.getBytes();
        try {
        mmOutStream.write(bytes);
        } catch (IOException e) {
        // Handle exception
        }
        }

// Remember to close the socket and streams in your cleanup code