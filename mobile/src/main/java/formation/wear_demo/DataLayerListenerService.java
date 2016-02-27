package formation.wear_demo;

import android.util.Log;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

public class DataLayerListenerService extends WearableListenerService {

    MainActivity mActivity = new MainActivity();

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        super.onMessageReceived(messageEvent);
        Log.e("RECEIVED FROM WEAR", messageEvent.getPath());
        if ("/MESSAGE".equals(messageEvent.getPath())) {
            // launch some Activity or do anything you like
            mActivity.wearMessage = "Message Received from Wear!";
            mActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // insert UI update code or functions here
                    mActivity.txtReceivedFromWear.setText("Message Received from Wear!");
                }
            });
        }
    }
}
